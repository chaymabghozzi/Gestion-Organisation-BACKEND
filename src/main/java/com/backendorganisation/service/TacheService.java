package com.backendorganisation.service;

import com.backendorganisation.entities.Tache;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface TacheService {
    public MessageResponse save(Tache tache);
    public MessageResponse update(Tache tache);
    public MessageResponse delete(long id);
    public List<Tache> findAll();
    public Tache findById(long id);
}