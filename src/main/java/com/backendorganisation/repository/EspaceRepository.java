package com.backendorganisation.repository;

import com.backendorganisation.entities.Espace;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EspaceRepository extends JpaRepository<Espace, Long> {
    boolean existsByLibelle(String libelle);
}
