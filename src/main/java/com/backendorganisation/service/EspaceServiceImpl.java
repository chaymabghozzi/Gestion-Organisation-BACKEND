package com.backendorganisation.service;


import com.backendorganisation.entities.Espace;
import com.backendorganisation.repository.EspaceRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EspaceServiceImpl implements EspaceService{

    @Autowired
    EspaceRepository espaceRepository;

    @Transactional
    @Override
    public MessageResponse save(Espace espace) {
        boolean existe = espaceRepository.existsByLibelle(espace.getLibelle());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette espace existe déja !");
        } else {
            espaceRepository.save(espace);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional
    @Override
    public MessageResponse update(Espace espace) {
        boolean exist= espaceRepository.existsByLibelle(espace.getLibelle());
        if(!exist){
            return new MessageResponse(false,"Echec !","Cette espace n'existe pas ! ");
        }
        espaceRepository.save(espace);
        return new MessageResponse(true,"succes !","Espace mise a jour ");
    }
    @Transactional
    @Override
    public MessageResponse delete(long id) {
        Espace espace = findById(id);
        if (espace == null){
            return new MessageResponse(false,"Echec !","Cette espace n'existe pas !");
        } else {
            espaceRepository.delete(espace);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Override
    public List<Espace> findAll() {
        return espaceRepository.findAll();
    }
    @Override
    public Espace findById(long id) {
        Espace espace = espaceRepository.findById(id).orElse(null);
        return espace;
    }
}
