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

import com.globant.microservicio.entity.PersonaEntity;
import com.globant.microservicio.service.PersonaService;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class PersonaRestController {

	@Autowired
	private PersonaService personaServiceAPI;

	@GetMapping(value = "/all")
	public List<PersonaEntity> getAll() {
		return personaServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public PersonaEntity find(@PathVariable Long id) {
		return personaServiceAPI.get(id);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<PersonaEntity> save(@RequestBody PersonaEntity persona) {
		PersonaEntity obj = personaServiceAPI.save(persona);
		return new ResponseEntity<PersonaEntity>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<PersonaEntity> delete(@PathVariable Long id) {
		PersonaEntity persona = personaServiceAPI.get(id);
		if (persona != null) {
			personaServiceAPI.delete(id);
		}else {
			return new ResponseEntity<PersonaEntity>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<PersonaEntity>(persona, HttpStatus.OK);
	}

}
