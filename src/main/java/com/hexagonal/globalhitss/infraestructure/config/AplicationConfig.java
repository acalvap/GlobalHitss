package com.hexagonal.globalhitss.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.globalhitss.application.services.PersonaService;
import com.hexagonal.globalhitss.application.usecases.CreatePersonaUseCaseImpl;
import com.hexagonal.globalhitss.application.usecases.DeletePersonaUseCaseImpl;
import com.hexagonal.globalhitss.application.usecases.GetAddressUseCaseImpl;
import com.hexagonal.globalhitss.application.usecases.RetrievePersonaUseCaseImpl;
import com.hexagonal.globalhitss.application.usecases.UpdatePersonaUseCaseImpl;
import com.hexagonal.globalhitss.domain.ports.input.IGetAddressUseCase;
import com.hexagonal.globalhitss.domain.ports.output.ExternalServicePort;
import com.hexagonal.globalhitss.domain.ports.output.PersonaRepositoryPort;
import com.hexagonal.globalhitss.infraestructure.adapters.ExternalServiceAdapter;
import com.hexagonal.globalhitss.infraestructure.repositories.JpaPersonaRepositoryAdapter;

@Configuration
public class AplicationConfig {

	// Instancia de Service
	@Bean
	public PersonaService personaService(PersonaRepositoryPort personaRepositoryPort, ExternalServicePort externalServicePort) {
		return new PersonaService(new CreatePersonaUseCaseImpl(personaRepositoryPort),
				new RetrievePersonaUseCaseImpl(personaRepositoryPort),
				new UpdatePersonaUseCaseImpl(personaRepositoryPort),
				new DeletePersonaUseCaseImpl(personaRepositoryPort),
				new GetAddressUseCaseImpl(externalServicePort));
	}
	
	// Beans requeridos para el Service
	@Bean
	public PersonaRepositoryPort personaRepositoryPort(JpaPersonaRepositoryAdapter jpaPersonaRepositoryAdapter) {
		return jpaPersonaRepositoryAdapter;
	}
	
	@Bean
	public ExternalServicePort externalServicePort() {
		return new ExternalServiceAdapter();
	}
	
	// Bean requerido para la implementacion del caso de uso Servicio Externo Address
	@Bean
	public IGetAddressUseCase getAddressUseCase(ExternalServicePort externalServicePort) {
		return new GetAddressUseCaseImpl(externalServicePort);
	}
	
}