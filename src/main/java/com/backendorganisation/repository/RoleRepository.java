package com.backendorganisation.repository;

import com.backendorganisation.entities.Role;
import com.backendorganisation.entities.Roles;

import com.backendorganisation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(Roles role);
    boolean existsByRoleName(Roles roleName);
}