package com.hexagonal.globalhitss.application.usecases;

import com.hexagonal.globalhitss.domain.models.Address;
import com.hexagonal.globalhitss.domain.ports.input.IGetAddressUseCase;
import com.hexagonal.globalhitss.domain.ports.output.ExternalServicePort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAddressUseCaseImpl implements IGetAddressUseCase {
	
	private final ExternalServicePort externalServicePort;
	
	@Override
	public Address getAddress(Long id) {
		return externalServicePort.getAddress(id);
	}
	
}