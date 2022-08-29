package com.backendorganisation.controller;

import com.backendorganisation.entities.Espace;
import com.backendorganisation.entities.User;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UserController {
    private  final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public List<User> findAll(){return userServiceImpl.findAll();}

    @PutMapping
    public MessageResponse update(@RequestBody User user) {
        return userServiceImpl.update(user);
    }
    @PostMapping
    @CachePut(value = "users",key = "#user.id")
    public MessageResponse save(@RequestBody User user){
        logger.debug(" >> UserController : /update : ",user.toString());
        return  userServiceImpl.save(user);}

    @DeleteMapping("/{id}")
    @CacheEvict(value = "users",allEntries = false,key = "#id")
    public MessageResponse delete(@PathVariable("id") Long id){
        logger.debug(" >> UserController : /delete : ",id);
        return userServiceImpl.delete(id);}

    @GetMapping("/{id}")
    @Cacheable(value = "users",key = "#id")
    public User findById(@PathVariable("id") Long id) {
        logger.debug(" >> UserController : /utilisateur/{} call : ",id);
        return userServiceImpl.findById(id);}

}
