package com.hexagonal.globalhitss.domain.ports.input;

import java.util.List;
import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Persona;

public interface IRetrievePersonaUseCase {

	Optional<Persona> getById(Long id);
	
	List<Persona> getAll();
	
}