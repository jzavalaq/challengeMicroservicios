package com.globant.microservicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.globant.microservicio.commons.GenericServiceImpl;
import com.globant.microservicio.entity.PersonaEntity;
import com.globant.microservicio.repository.PersonaRepository;
import com.globant.microservicio.service.PersonaService;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<PersonaEntity, Long> implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public CrudRepository<PersonaEntity, Long> getDao() {
		return personaRepository;
	}

}
