package com.backendorganisation.repository;

import com.backendorganisation.entities.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SondageRepository extends JpaRepository<Sondage, Long> {
    public Sondage findById(long id);

    boolean existsById(Long id);
}
