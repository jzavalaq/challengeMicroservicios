package com.globant.microservicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.globant.microservicio.commons.GenericServiceImpl;
import com.globant.microservicio.entity.CuentaEntity;
import com.globant.microservicio.repository.CuentaRepository;
import com.globant.microservicio.service.CuentaService;

@Service
public class CuentaServiceImpl extends GenericServiceImpl<CuentaEntity, Long> implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public CrudRepository<CuentaEntity, Long> getDao() {
		return cuentaRepository;
	}

}
