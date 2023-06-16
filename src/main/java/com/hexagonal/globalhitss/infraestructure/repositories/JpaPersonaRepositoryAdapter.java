package com.hexagonal.globalhitss.infraestructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hexagonal.globalhitss.domain.models.Persona;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;
import com.hexagonal.globalhitss.infraestructure.entities.PersonaEntity;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JpaPersonaRepositoryAdapter implements PersonaRepositoryPort {

	private final JpaPersonaRepository jpaPersonaRepository;
	
	@Override
	public Persona save(Persona persona) {
		PersonaEntity saved = jpaPersonaRepository.save(PersonaEntity.fromDomainModel(persona));
		return saved.toDomainModel();
	}
	
	@Override
	public Optional<Persona> getFindById(Long id) {
		return jpaPersonaRepository.findById(id).map(PersonaEntity::toDomainModel);
	}
	
	@Override
	public List<Persona> getFindAll() {
		return jpaPersonaRepository.findAll().
				stream().
				map(PersonaEntity::toDomainModel).
				collect(Collectors.toList());
	}
	
	@Override
	public Optional<Persona> update(Long id, Persona persona) {
		if (jpaPersonaRepository.existsById(id)) {
			PersonaEntity updated = jpaPersonaRepository.save(PersonaEntity.fromDomainModel(persona));
			return Optional.of(updated.toDomainModel());
		}
		return Optional.empty();
	}
	
	@Override
	public boolean delete(Long id) {
		if (jpaPersonaRepository.existsById(id)) {
			jpaPersonaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}