package com.hexagonal.globalhitss.domain.ports.input;

import com.hexagonal.globalhitss.domain.models.Address;

public interface IGetAddressUseCase {

	Address getAddress(Long id);
	
}