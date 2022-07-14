package com.globant.microservicio.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.globant.microservicio.commons.GenericServiceImpl;
import com.globant.microservicio.dto.EstadoCuentaDto;
import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.MovimientoEntity;
import com.globant.microservicio.repository.ClienteRepository;
import com.globant.microservicio.repository.CuentaRepository;
import com.globant.microservicio.repository.MovimientoRepository;
import com.globant.microservicio.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, Long> implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Override
	public CrudRepository<ClienteEntity, Long> getDao() {
		return clienteRepository;
	}

	@Override
	public List<EstadoCuentaDto> findReporteEntreFechas(LocalDate desde, LocalDate hasta) {
		List<EstadoCuentaDto> respuesta = new ArrayList<EstadoCuentaDto>();
		List<MovimientoEntity> movimientoEntities= movimientoRepository.findByFechaBetween(desde, hasta);
		for (MovimientoEntity movimientoEntity : movimientoEntities) {
			System.out.println("movimientoEntity:"+movimientoEntity);
		}
		
		return null;
	}



}
