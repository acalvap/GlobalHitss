package com.hexagonal.globalhitss.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Persona {

	private Long id;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
	
}