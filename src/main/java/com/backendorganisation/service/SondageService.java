package com.backendorganisation.service;

import com.backendorganisation.entities.Sondage;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface SondageService {
    public MessageResponse save(Sondage sondage);
    public MessageResponse update(Sondage sondage);
    public MessageResponse delete(long id);
    public List<Sondage> findAll();
    public Sondage findById(long id);
}
