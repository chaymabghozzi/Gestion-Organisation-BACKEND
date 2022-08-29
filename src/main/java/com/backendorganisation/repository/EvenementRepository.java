package com.backendorganisation.repository;


import com.backendorganisation.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    public  Evenement  findById(long id);

    boolean existsById(Long id);

}
