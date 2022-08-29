package com.backendorganisation.service;

import com.backendorganisation.entities.Sondage;
import com.backendorganisation.repository.SondageRepository;
import com.backendorganisation.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SondageServiceImpl implements SondageService {
    @Autowired
    SondageRepository sondageRepository;

    @Transactional
    @Override
    public MessageResponse save(Sondage sondage) {
        sondageRepository.save(sondage);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse update(Sondage sondage) {
        boolean existe = sondageRepository.existsById(sondage.getId());
        sondageRepository.save(sondage);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
    }

    @Transactional
    @Override
    public MessageResponse delete(long id) {
        Sondage sondage = findById(id);
        if (sondage==null){
            return new MessageResponse(false,"Echec","Ce sondage n'existe pas !");
        }
        sondageRepository.delete(sondage);
        return new MessageResponse(true,"Succès", "le sondage à été supprimé avec succès.");
    }

    @Transactional
    @Override
    public List<Sondage> findAll() {
        return sondageRepository.findAll();
    }

    @Transactional
    @Override
    public Sondage findById(long id) {
        Sondage sondage = sondageRepository.findById(id);
        return sondage;
    }
}
