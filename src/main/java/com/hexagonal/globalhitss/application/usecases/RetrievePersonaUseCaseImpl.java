package com.hexagonal.globalhitss.application.usecases;

import java.util.List;
import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Persona;
import com.hexagonal.globalhitss.domain.ports.input.IRetrievePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrievePersonaUseCaseImpl implements IRetrievePersonaUseCase {

	private final PersonaRepositoryPort personaRepositoryPort;
	
	@Override
	public Optional<Persona> getById(Long id) {
		return personaRepositoryPort.getFindById(id);
	}
	@Override
	public List<Persona> getAll() {
		return personaRepositoryPort.getFindAll();
	}
	
}