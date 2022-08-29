package com.backendorganisation.service;

import com.backendorganisation.entities.Role;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface RoleService {
    public MessageResponse save(Role role);
    public MessageResponse update(Role role);
    public MessageResponse delete(Integer id);
    public List<Role> findAll();
    public Role findById(Integer id);
}
