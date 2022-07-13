package com.globant.microservicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.CuentaEntity;
import com.globant.microservicio.entity.PersonaEntity;
import com.globant.microservicio.service.CuentaService;
import com.globant.microservicio.service.PersonaService;

@Controller
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		model.addAttribute("list", personaServiceAPI.getAll());
//		return "index";
//	}
	@GetMapping("/cuentas")
	public List<CuentaEntity> getAll() {
		
		return cuentaService.getAll();
	}
	
	@GetMapping("/cuentas/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("cuenta", cuentaService.get(id));
		}else {
			model.addAttribute("cuenta", new CuentaEntity());
		}
		return "save";
	}
	
	@PostMapping("/cuentas/save")
	public ResponseEntity<CuentaEntity> save(CuentaEntity cuenta, Model model) {
		CuentaEntity obj=cuentaService.save(cuenta);
		
		return new ResponseEntity<CuentaEntity>(obj, HttpStatus.OK);
	}
	
	
	@GetMapping("/cuentas/delete/{id}")
	public ResponseEntity<CuentaEntity> delete(@PathVariable Long id) {
		CuentaEntity cuenta = cuentaService.get(id);
		cuentaService.delete(id);
		
		if (cuenta != null) {
			cuentaService.delete(id);
		}else {
			return new ResponseEntity<CuentaEntity>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<CuentaEntity>(cuenta, HttpStatus.OK);
	}
	

}
