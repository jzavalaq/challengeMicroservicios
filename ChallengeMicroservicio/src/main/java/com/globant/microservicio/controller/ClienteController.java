package com.globant.microservicio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.PersonaEntity;
import com.globant.microservicio.service.ClienteService;
import com.globant.microservicio.service.PersonaService;

@RestController
//@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/clientes")
	public List<ClienteEntity> getAll() {
		return clienteService.getAll();
	}
	
	@GetMapping(value = "/clientes/{id}")
	public PersonaEntity find(@PathVariable Long id) {
		return clienteService.get(id);
	}

	@PostMapping(value = "/clientes/save")
	public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity persona) {
		ClienteEntity obj = clienteService.save(persona);
		return new ResponseEntity<ClienteEntity>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/clientes/delete/{id}")
	public ResponseEntity<ClienteEntity> delete(@PathVariable Long id) {
		ClienteEntity cliente = clienteService.get(id);
		if (cliente != null) {
			clienteService.delete(id);
		}else {
			return new ResponseEntity<ClienteEntity>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<ClienteEntity>(cliente, HttpStatus.OK);
	}
	
	@GetMapping(value = "/clientes/estadoCuenta/{id}")
	public ResponseEntity<?>  getEstadocuenta(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta
			) {
		 try {
	            return ResponseEntity.status(HttpStatus.OK).body(clienteService.findReporteEntreFechas(desde, hasta));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Error. Reporte no encontrado.\"}");
	        }
	}

}
