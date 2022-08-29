package com.backendorganisation.service;

import com.backendorganisation.entities.Role;
import com.backendorganisation.repository.RoleRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    @Override
    public MessageResponse save(Role role) {
        boolean existe = roleRepository.existsByRoleName(role.getRoleName());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette nom existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Role role) {
        boolean existe = roleRepository.existsById(role.getId());
        if (!existe){
            boolean existe1 = roleRepository.existsByRoleName(role.getRoleName());
            return new MessageResponse(false,"Echec !","Cette role existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Integer id) {
        Role role = findById(id);
        if (role==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        roleRepository.delete(role);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès");
    }

    @Transactional
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role findById(Integer id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role;
    }
}
