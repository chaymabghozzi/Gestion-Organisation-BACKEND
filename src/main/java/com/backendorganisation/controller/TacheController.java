package com.backendorganisation.controller;

import com.backendorganisation.entities.Evenement;
import com.backendorganisation.entities.Tache;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.EvenementServiceImpl;
import com.backendorganisation.service.TacheServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/tache")
public class TacheController {
    private  final Logger logger = LoggerFactory.getLogger(EspaceController.class);
    @Autowired
    private TacheServiceImpl tacheService;

    @PostMapping
    public MessageResponse save(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    @GetMapping
    public List<Tache> findAll() {
        return tacheService.findAll();
    }

    @PutMapping
    public MessageResponse update(@RequestBody Tache tache) {
        return tacheService.update(tache);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "taches",key = "#id")
    public Tache findById(@PathVariable("id") Long id) {
        logger.debug(" >> TacheController : /tache/{} call : ",id);
        return tacheService.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "taches", allEntries=true)
    public MessageResponse delete(@PathVariable Long id) {
        logger.debug(" >>delete TacheController : /tache/{} call : ",id);
        return tacheService.delete(id);
    }
}
