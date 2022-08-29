package com.backendorganisation.service;


import com.backendorganisation.entities.Tache;
import com.backendorganisation.repository.TacheRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TacheServiceImpl implements TacheService {
    @Autowired
    TacheRepository tacheRepository;

    @Transactional
    @Override
    public MessageResponse save(Tache tache) {
        tacheRepository.save(tache);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Tache tache) {
        boolean exist = tacheRepository.existsById(tache.getId());
        if (!exist) {
            return new MessageResponse(false, "Echec !", "Cette tache n'existe pas ! ");
        }
        tacheRepository.save(tache);
        return new MessageResponse(true, "Succès", "Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(long id) {
        Tache tache = findById(id);
        if (tache==null){
            return new MessageResponse(false,"Echec","Cette tache n'existe pas !");
        }
        tacheRepository.delete(tache);
        return new MessageResponse(true,"Succès", "la tache à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Tache> findAll() {
        return tacheRepository.findAll();
    }

    @Transactional
    @Override
    public Tache findById(long id) {
        Tache tache = tacheRepository.findById(id);
        return tache;
    }
}
