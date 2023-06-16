package com.hexagonal.globalhitss.domain.ports.input;

import com.hexagonal.globalhitss.domain.models.Persona;

public interface ICreatePersonaUseCase {

	Persona create(Persona persona);
	
}