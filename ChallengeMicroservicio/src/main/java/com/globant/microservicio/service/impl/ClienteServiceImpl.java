package com.globant.microservicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.globant.microservicio.commons.GenericServiceImpl;
import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.repository.ClienteRepository;
import com.globant.microservicio.service.ClienteService;
@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, Long> implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public CrudRepository<ClienteEntity, Long> getDao() {
		return clienteRepository;
	}

}
