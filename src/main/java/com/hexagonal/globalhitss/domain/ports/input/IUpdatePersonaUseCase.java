package com.hexagonal.globalhitss.domain.ports.input;

import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Persona;

public interface IUpdatePersonaUseCase {

	Optional<Persona> update(Long id, Persona persona);
	
}