package com.hexagonal.globalhitss.application.services;

import java.util.List;
import java.util.Optional;

import com.hexagonal.globalhitss.domain.models.Address;
import com.hexagonal.globalhitss.domain.models.Persona;
import com.hexagonal.globalhitss.domain.ports.input.ICreatePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.input.IDeletePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.input.IGetAddressUseCase;
import com.hexagonal.globalhitss.domain.ports.input.IRetrievePersonaUseCase;
import com.hexagonal.globalhitss.domain.ports.input.IUpdatePersonaUseCase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonaService implements ICreatePersonaUseCase, IRetrievePersonaUseCase, IUpdatePersonaUseCase, IDeletePersonaUseCase, IGetAddressUseCase {
	
	//Logica de Negocio por realizar
	
	private final ICreatePersonaUseCase createPersonaUseCase;
	private final IRetrievePersonaUseCase retrievePersonaUseCase;
	private final IUpdatePersonaUseCase updatePersonaUseCase;
	private final IDeletePersonaUseCase deletePersonaUseCase;
	private final IGetAddressUseCase getAddressUseCase;
	
	@Override
	public Address getAddress(Long id) {
		return getAddressUseCase.getAddress(id);
	}
	
	@Override
	public boolean delete(Long id) {
		return deletePersonaUseCase.delete(id);
	}
	
	@Override
	public Optional<Persona> update(Long id, Persona persona) {
		return updatePersonaUseCase.update(id, persona);
	}
	
	@Override
	public Optional<Persona> getById(Long id) {
		return retrievePersonaUseCase.getById(id);
	}
	
	@Override
	public List<Persona> getAll() {
		return retrievePersonaUseCase.getAll();
	}
	
	@Override
	public Persona create(Persona persona) {
		return createPersonaUseCase.create(persona);
	}
	
}