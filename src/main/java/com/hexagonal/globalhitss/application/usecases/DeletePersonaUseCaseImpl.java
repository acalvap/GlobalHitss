package com.hexagonal.globalhitss.application.usecases;

import com.hexagonal.globalhitss.domain.ports.input.IDeletePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePersonaUseCaseImpl implements IDeletePersonaUseCase {
	
	private final PersonaRepositoryPort personaRepositoryPort;
	
	@Override
	public boolean delete(Long id) {
		return personaRepositoryPort.delete(id);
	}
	
}
