package com.hexagonal.globalhitss.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Address {

	//Principio de inmutabilidad
	//Se crean constantes y no privadas dabo que nunca lo voy a llenar debido a que se llena con un servicio externo
	private final String street;
	private final String suite;
	private final String city;
	private final String zipcode;
	
}