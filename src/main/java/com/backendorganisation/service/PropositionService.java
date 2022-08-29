package com.backendorganisation.service;

import com.backendorganisation.entities.Proposition;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface  PropositionService {

    public MessageResponse save(Proposition proposition);
    public MessageResponse update(Proposition proposition);
    public MessageResponse delete(Long id);
    public List<Proposition> findAll();
    public Proposition findById(Long id);
}
