package com.backendorganisation.controller;

import com.backendorganisation.entities.Role;
import com.backendorganisation.entities.User;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping
    public List<Role> findAll(){return roleService.findAll();}

    @PostMapping
    public MessageResponse save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable("id") Integer id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Integer id) {
        return roleService.delete(id);
    }

}
