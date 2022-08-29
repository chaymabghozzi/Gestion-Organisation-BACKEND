package com.backendorganisation.service;



import com.backendorganisation.entities.Evenement;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface EvenementService {

    public MessageResponse save(Evenement evenement);
    public MessageResponse update(Evenement evenement);
    public MessageResponse delete(long id);
    public List<Evenement> findAll();
    public Evenement findById(long id);
}
