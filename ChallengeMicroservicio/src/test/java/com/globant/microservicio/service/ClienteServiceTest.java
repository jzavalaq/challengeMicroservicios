package com.globant.microservicio.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.service.ClienteService;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClienteServiceTest {

	@Autowired private ClienteService clienteService;

	@Test
	void testSave() {
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setContrasena("pass123");
		clienteEntity.setDireccion("Calle elm street 666");
		clienteEntity.setEdad(24);
		clienteEntity.setEstado(true);
		clienteEntity.setGenero(null);
//		clienteEntity.setIdPersona(null);
		clienteEntity.setIdentificacion("12345678");
//		clienteEntity.setIdPersona(null);
		clienteEntity.setNombre("Pablito");
		clienteEntity.setTelefono("997852824");
		assertNotNull(clienteService.save(clienteEntity));
	}
	
	@Test
	void testFindAll() {
		assertNotNull(clienteService.getAll());
	}

	@Test
	void testGetById() {
		List<ClienteEntity> list = clienteService.getAll();
		assertEquals(clienteService.get(list.get(0).getIdPersona()).getIdPersona() , list.get(0).getIdPersona());
	}

//
//	@Test
//	void testFindById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteById() {
//		fail("Not yet implemented");
//	}

}
