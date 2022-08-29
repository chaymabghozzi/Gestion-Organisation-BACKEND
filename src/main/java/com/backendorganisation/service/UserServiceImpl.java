package com.backendorganisation.service;

import com.backendorganisation.entities.User;
import com.backendorganisation.repository.UserRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public MessageResponse save(User user) {
        boolean existe = userRepository.existsByUsername(user.getUsername());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette utilisateur existe déja !");
        }
        userRepository.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(User user) {
        boolean existe = userRepository.existsById(user.getId());
        if (!existe){
            boolean existe1 = userRepository.existsByUsername(user.getUsername());
            return new MessageResponse(false,"Echec !","Cette utilisateur existe déja !");
        }
        userRepository.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        User user = findById(id);
        if (user==null){
            return new MessageResponse(false,"Echec","Utilisteur n'existe pas !");
        }
        userRepository.delete(user);
        return new MessageResponse(true,"Succès", "Utilisateur à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userRepository.findAll();    }

    @Transactional
    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
}
