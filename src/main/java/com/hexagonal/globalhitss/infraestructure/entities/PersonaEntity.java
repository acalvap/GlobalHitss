package com.hexagonal.globalhitss.infraestructure.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hexagonal.globalhitss.domain.models.Persona;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
	
	// Se puede suplantar por algun mapper pero dado que es un proyecto pequeno
	// del Modelo del Dominio a Entidad
	public static PersonaEntity fromDomainModel(Persona persona) {
		return new PersonaEntity(persona.getId(), persona.getNombres(), persona.getApellidos(), persona.getEmail(), persona.getTelefono());
	}
	
	// de la Entidad al Dominio de Modelo
	public Persona toDomainModel() {
		return new Persona(id, nombres, apellidos, email, telefono);
	}
	
}