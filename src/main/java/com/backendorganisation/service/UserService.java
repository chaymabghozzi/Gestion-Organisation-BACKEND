package com.backendorganisation.service;

import com.backendorganisation.entities.User;
import com.backendorganisation.response.MessageResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    public MessageResponse save(User user);
    public MessageResponse update(User user);
    public MessageResponse delete(Long id);
    public List<User> findAll();
    public User findById(Long id);


}
