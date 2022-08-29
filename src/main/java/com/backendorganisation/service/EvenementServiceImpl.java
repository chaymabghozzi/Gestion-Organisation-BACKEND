package com.backendorganisation.service;


import com.backendorganisation.entities.Espace;
import com.backendorganisation.entities.Evenement;
import com.backendorganisation.repository.EvenementRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {
    @Autowired
    EvenementRepository evenementRepository;

    @Transactional
    @Override
    public MessageResponse save(Evenement evenement) {
        evenementRepository.save(evenement);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Override
    public MessageResponse update(Evenement evenement) {
        boolean exist = evenementRepository.existsById(evenement.getId());
        if (!exist) {
            return new MessageResponse(false, "Echec !", "Cette evenement  n'existe pas ! ");
        }
        evenementRepository.save(evenement);
        return new MessageResponse(true, "Succès", "Opération réalisée avec succès.");

    }

    @Transactional
    @Override
    public MessageResponse delete(long id) {
        Evenement evenement = findById(id);
        if (evenement==null){
            return new MessageResponse(false,"Echec","Cette evenement n'existe pas !");
        }
        evenementRepository.delete(evenement);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement findById(long id) {
        Evenement evenement = evenementRepository.findById(id);
        return evenement;
    }
}