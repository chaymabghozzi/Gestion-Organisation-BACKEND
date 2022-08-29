package com.backendorganisation.controller;

import com.backendorganisation.entities.Proposition;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.PropositionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/proposition")
public class PropositionController {
    private  final Logger logger = LoggerFactory.getLogger(EvenementController.class);
    @Autowired
    PropositionServiceImpl propositionService;
    @GetMapping
    public List<Proposition> findAll(){return propositionService.findAll();}

    @PutMapping
    @CachePut(value = "propositions",key = "#proposition.id")
    public MessageResponse update(@RequestBody Proposition proposition){return propositionService.update(proposition);}
    @PostMapping
    public MessageResponse save(@RequestBody Proposition proposition){return  propositionService.save(proposition);}
    @DeleteMapping("/{id}")
    @CacheEvict(value = "propositions", allEntries=true)
    public MessageResponse delete(@PathVariable("id") Long id){
        logger.debug(" >>delete PropositionController : /proposition/{} call : ",id);
        return propositionService.delete(id);}
    @GetMapping("/{id}")
    @Cacheable(value = "propositions",key = "#id")
    public Proposition findById(@PathVariable("id") Long id) {
        logger.debug(" >> PropositionController : /proposition/{} call : ",id);
        return propositionService.findById(id);}
}
