package com.hexagonal.globalhitss.application.usecases;

import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Persona;
import com.hexagonal.globalhitss.domain.ports.input.IUpdatePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePersonaUseCaseImpl implements IUpdatePersonaUseCase {

	private final PersonaRepositoryPort personaRepositoryPort;
	
	@Override
	public Optional<Persona> update(Long id, Persona persona) {
		return personaRepositoryPort.update(id, persona);
	}
	
}