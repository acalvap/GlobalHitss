package com.hexagonal.globalhitss.domain.ports.output;

import com.hexagonal.globalhitss.domain.models.Address;

public interface ExternalServicePort {

	Address getAddress(Long id);
	
}