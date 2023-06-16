package com.hexagonal.globalhitss.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.globalhitss.infraestructure.entities.PersonaEntity;

@Repository
public interface JpaPersonaRepository extends JpaRepository<PersonaEntity, Long> {

}