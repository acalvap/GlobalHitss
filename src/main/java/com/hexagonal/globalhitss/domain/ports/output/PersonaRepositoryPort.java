package com.hexagonal.globalhitss.domain.ports.output;

import java.util.List;
import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Persona;

public interface PersonaRepositoryPort {

	//C
	Persona save(Persona persona);
	
	//R
	Optional<Persona> getFindById(Long id);
	List<Persona> getFindAll();
	
	//U
	Optional<Persona> update(Long id, Persona persona);
	
	//D
	boolean delete(Long id);
	
}