package com.hexagonal.globalhitss.application.usecases;

import com.hexagonal.globalhitss.domain.models.Persona;
import com.hexagonal.globalhitss.domain.ports.input.ICreatePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreatePersonaUseCaseImpl implements ICreatePersonaUseCase {
	
	private final PersonaRepositoryPort personaRepositoryPort;
	
	@Override
	public Persona create(Persona persona) {
		return personaRepositoryPort.save(persona);
	}
	
}