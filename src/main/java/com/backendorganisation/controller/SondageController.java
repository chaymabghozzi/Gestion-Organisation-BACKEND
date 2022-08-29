package com.backendorganisation.controller;

import com.backendorganisation.entities.Sondage;
import com.backendorganisation.response.MessageResponse;
import com.backendorganisation.service.SondageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sondage")
public class SondageController {
    private  final Logger logger = LoggerFactory.getLogger(EspaceController.class);

    @Autowired
    private SondageServiceImpl sondageService;

    @PostMapping
    public MessageResponse save(@RequestBody Sondage sondage) {
        return sondageService.save(sondage);
    }
    @GetMapping
    public List<Sondage> findAll() {
        return sondageService.findAll();
    }
    @PutMapping
    public MessageResponse update(@RequestBody Sondage sondage) {
        return sondageService.update(sondage);
    }

    @GetMapping("/{id}")
    @Cacheable(value = "sondages",key = "#id")
    public Sondage findById(@PathVariable("id") Long id) {
        logger.debug(" >> SondageController : /sondage/{} call : ",id);
        return sondageService.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "sondages", allEntries=true)
    public MessageResponse delete(@PathVariable Long id) {
        logger.debug(" >>delete SondageController : /sondage/{} call : ",id);
        return sondageService.delete(id);
    }
}
