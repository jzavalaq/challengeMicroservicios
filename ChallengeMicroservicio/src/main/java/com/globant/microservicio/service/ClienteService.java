package com.globant.microservicio.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.globant.microservicio.commons.GenericServiceAPI;
import com.globant.microservicio.dto.EstadoCuentaDto;
import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.MovimientoEntity;

@Service
public interface ClienteService extends GenericServiceAPI<ClienteEntity, Long>  {

//	List<ClienteEntity> getEstadocuenta(List<Date> dates);

	//List<ClienteEntity> buscarFecha(LocalDate desde, LocalDate hasta);

	List<EstadoCuentaDto> findReporteEntreFechas(LocalDate desde, LocalDate hasta);
	
}
