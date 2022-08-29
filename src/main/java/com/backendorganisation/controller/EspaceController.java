package com.backendorganisation.controller;


import com.backendorganisation.entities.Espace;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.EspaceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/espace")
public class EspaceController {

    private  final Logger logger = LoggerFactory.getLogger(EspaceController.class);
    @Autowired
    EspaceServiceImpl espaceService;

    @GetMapping
    @Cacheable(value="espaces")
    public List<Espace> findAll(){
        logger.debug("This is debug Calling service to get Products data...");
        return espaceService.findAll();}


    @PutMapping
    @CachePut(value = "espaces", key = "#espace.id")
    public MessageResponse update(@RequestBody Espace espace){return espaceService.update(espace);}

    @PostMapping
    public MessageResponse save(@RequestBody Espace espace){return  espaceService.save(espace);}

    @DeleteMapping("/{id}")
    @CacheEvict(value = "espaces", allEntries=true)
    public MessageResponse delete(@PathVariable("id") Long id){

        logger.debug("deleting espace with id {}", id);
        return espaceService.delete(id);}

    @GetMapping("/{id}")
    @Cacheable(value = "espaces",key = "#id")
    public Espace findById(@PathVariable("id") Long id) {
        logger.debug(" >> EspaceController : /espace/{} call : ",id);
        return espaceService.findById(id);}
}
