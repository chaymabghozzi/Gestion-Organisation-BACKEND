package com.backendorganisation.service;



import com.backendorganisation.entities.Espace;
import com.backendorganisation.response.MessageResponse;

import java.util.List;

public interface EspaceService {
    public MessageResponse save(Espace espace);
    public MessageResponse update(Espace espace);
    public MessageResponse delete(long id);
    public List<Espace> findAll();
    public Espace findById(long id);
}
