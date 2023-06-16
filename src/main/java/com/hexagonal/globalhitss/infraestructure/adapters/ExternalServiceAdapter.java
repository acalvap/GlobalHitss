package com.hexagonal.globalhitss.infraestructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexagonal.globalhitss.domain.models.Address;
import com.hexagonal.globalhitss.domain.ports.output.ExternalServicePort;

import lombok.Data;

public class ExternalServiceAdapter implements ExternalServicePort {

	private final RestTemplate restTemplate;
	
	public ExternalServiceAdapter() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public Address getAddress(Long id) {
		String apiUrl = "https://jsonplaceholder.typicode.com/users/" + id;
		ResponseEntity<JsonPlaceHolderUserData> todoResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUserData.class);
		JsonPlaceHolderUserData todo = todoResponse.getBody();
		if (todo==null) {
			return null;
		}
		
		return new Address(todo.getAddress().getStreet(),
				todo.getAddress().getSuite(),
				todo.getAddress().getCity(),
				todo.getAddress().getZipcode());
	}
	
	@Data
	private static class JsonPlaceHolderUserData {
		
		JsonPlaceHolderAddress address;
		
	}
	
	@Data
	private static class JsonPlaceHolderAddress {
		
		private String street;
		private String suite;
		private String city;
		private String zipcode;
		
	}
	
}