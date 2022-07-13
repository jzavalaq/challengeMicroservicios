package com.globant.microservicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.globant.microservicio.commons.GenericServiceImpl;
import com.globant.microservicio.entity.MovimientoEntity;
import com.globant.microservicio.repository.MovimientoRepository;
import com.globant.microservicio.service.MovimientoService;

@Service
public class MovimientoServiceImpl extends GenericServiceImpl<MovimientoEntity, Long> implements MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Override
	public CrudRepository<MovimientoEntity, Long> getDao() {
		return movimientoRepository;
	}

}
