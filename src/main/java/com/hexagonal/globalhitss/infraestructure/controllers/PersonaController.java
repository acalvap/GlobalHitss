package com.hexagonal.globalhitss.infraestructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.globalhitss.application.services.PersonaService;
import com.hexagonal.globalhitss.domain.models.Address;
import com.hexagonal.globalhitss.domain.models.Persona;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	private PersonaService personaService;
	
	public PersonaController(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	@PostMapping
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
		Persona personaCreada = personaService.create(persona);
		return new ResponseEntity<>(personaCreada, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> getTaskById(@PathVariable Long id) {
		return personaService.getById(id).map(task -> new ResponseEntity<>(task, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping
	public ResponseEntity<List<Persona>> getAllPersonas() {
		List<Persona> tasks = personaService.getAll();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona updatePersona) {
		return personaService.update(id, updatePersona).map(task -> new ResponseEntity<>(task, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePersonaById(@PathVariable Long id) {
		if (personaService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/address")
	public ResponseEntity<Address> getAdditionalTaskInfo(@PathVariable Long id) {
		Address address = personaService.getAddress(id);
		return new ResponseEntity<>(address, HttpStatus.OK);
	}
	
}