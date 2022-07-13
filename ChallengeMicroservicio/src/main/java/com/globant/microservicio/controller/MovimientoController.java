package com.globant.microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.MovimientoEntity;
import com.globant.microservicio.entity.PersonaEntity;
import com.globant.microservicio.service.ClienteService;
import com.globant.microservicio.service.MovimientoService;
import com.globant.microservicio.service.PersonaService;

@RestController
@CrossOrigin("*")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;

	@GetMapping(value = "/movimientos")
	public List<MovimientoEntity> getAll() {
		return movimientoService.getAll();
	}
	
	@GetMapping(value = "/movimientos/{id}")
	public MovimientoEntity find(@PathVariable Long id) {
		return movimientoService.get(id);
	}

	@PostMapping(value = "/movimientos/save")
	public ResponseEntity<MovimientoEntity> save(@RequestBody MovimientoEntity movimiento) {
		MovimientoEntity obj = movimientoService.save(movimiento);
		return new ResponseEntity<MovimientoEntity>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/movimientos/delete/{id}")
	public ResponseEntity<MovimientoEntity> delete(@PathVariable Long id) {
		MovimientoEntity movimiento = movimientoService.get(id);
		if (movimiento != null) {
			movimientoService.delete(id);
		}else {
			return new ResponseEntity<MovimientoEntity>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<MovimientoEntity>(movimiento, HttpStatus.OK);
	}

}
