package com.backendorganisation.controller;


import com.backendorganisation.entities.Evenement;

import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.EvenementServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/evenement")
public class EvenementController {

    private  final Logger logger = LoggerFactory.getLogger(EvenementController.class);
    @Autowired
    private EvenementServiceImpl evenementService;


    /*@PostMapping("/{userId}")
    public ResponseEntity<Evenement> add(@PathVariable(value = "userId") Long userId,
                                         @RequestBody Evenement evenementRequest) {
        Evenement evenement = userRepository.findById(userId).map(user -> {
            long evenementId = evenementRequest.getId();
            if (evenementId != 0L) {
                Evenement _evenement = evenementRepository.findById(evenementId);
                user.getEvenements().add(_evenement);
                userRepository.save(user);
                return _evenement;
            }
            return null;
        }).orElseThrow(() -> new IllegalStateException("Not found user with id = " + userId));

        return new ResponseEntity<>(evenement, HttpStatus.CREATED);

    }*/

    @PostMapping
    @CachePut(value = "evenements",key = "#evenement.id")
    public MessageResponse save(@RequestBody Evenement evenement) {
        return evenementService.save(evenement);
    }

    @GetMapping
    public List<Evenement> findAll() {
        return evenementService.findAll();
    }

    @PutMapping
    public MessageResponse update(@RequestBody Evenement evenement) {
        return evenementService.update(evenement);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "evenements",key = "#id")
    public Evenement findById(@PathVariable("id") Long id) {
        logger.debug(" >> EvenementController : /evenement/{} call : ",id);
        return evenementService.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "evenements", allEntries=true)
    public MessageResponse delete(@PathVariable Long id) {
        logger.debug(" >>delete EvenementController : /evenement/{} call : ",id);
        return evenementService.delete(id);
    }

}
