package com.backendorganisation.repository;

import com.backendorganisation.entities.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {
    boolean existsByName(String name);
}
