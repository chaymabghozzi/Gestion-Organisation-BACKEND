package com.backendorganisation.repository;

import com.backendorganisation.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TacheRepository extends JpaRepository<Tache, Long> {
    public Tache findById(long id);

    boolean existsById(Long id);
}