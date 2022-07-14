package com.globant.microservicio.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.globant.microservicio.entity.ClienteEntity;
import com.globant.microservicio.entity.CuentaEntity;
import com.globant.microservicio.entity.MovimientoEntity;


@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MovimientoServiceTest {

	@Autowired private MovimientoService movimientoService;

	@Test
	void testSave() {
		CuentaEntity cuentaEntity = new CuentaEntity();
		//
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setContrasena("pass123");
		clienteEntity.setDireccion("Calle elm street 666");
		clienteEntity.setEdad(24);
		clienteEntity.setEstado(true);
		clienteEntity.setGenero(null);
		clienteEntity.setIdentificacion("12345678");
		clienteEntity.setNombre("Pablito");
		clienteEntity.setTelefono("997852824");
		//
		cuentaEntity.setClienteEntity(clienteEntity);
		cuentaEntity.setEstado(true);
		cuentaEntity.setNumeroCuenta("585545");
		cuentaEntity.setSaldoInicial("1000");
		cuentaEntity.setTipoCuenta("Corriente");
		//
		MovimientoEntity movimientoEntity = new MovimientoEntity();
		movimientoEntity.setCuentaEntity(cuentaEntity);
		movimientoEntity.setFecha(LocalDate.now());
		movimientoEntity.setSaldo(1100);
		movimientoEntity.setTipoMovimiento("credito");
		movimientoEntity.setValor(1000);
		assertNotNull(movimientoService.save(movimientoEntity));
	}
	
	@Test
	void testFindAll() {
		assertNotNull(movimientoService.getAll());
	}

	@Test
	void testGetById() {
		List<MovimientoEntity> list = movimientoService.getAll();
		assertEquals(movimientoService.get(list.get(0).getIdMovimiento()).getIdMovimiento() , list.get(0).getIdMovimiento());
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
