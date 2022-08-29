package com.backendorganisation.service;

import com.backendorganisation.entities.Proposition;
import com.backendorganisation.repository.PropositionRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PropositionServiceImpl implements PropositionService{
    @Autowired
    PropositionRepository propositionRepository;

    @Transactional
    @Override
    public MessageResponse save(Proposition proposition) {
        boolean existe = propositionRepository.existsByName(proposition.getName());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette proposition existe déja !");
        }
        propositionRepository.save(proposition);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Proposition proposition) {
        boolean existe = propositionRepository.existsById(proposition.getId());
        if (!existe){
            boolean existe1 = propositionRepository.existsByName(proposition.getName());
            return new MessageResponse(false,"Echec !","Cette proposition existe déja !");

        }
        propositionRepository.save(proposition);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Proposition proposition = findById(id);
        if (proposition==null){
            return new MessageResponse(false,"Echec","Cette proposition n'existe pas !");
        }
        propositionRepository.delete(proposition);
        return new MessageResponse(true,"Succès", "La proposition à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Proposition> findAll() {
        return propositionRepository.findAll();
    }

    @Transactional
    @Override
    public Proposition findById(Long id) {
        Proposition proposition = propositionRepository.findById(id).orElse(null);
        return proposition;
    }


}
