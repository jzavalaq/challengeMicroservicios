package com.globant.microservicio.repository;

import com.globant.microservicio.entity.MovimientoEntity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

//	@Query(value = "SELECT * FROM movimiento WHERE fecha >= :desde AND fecha <= :hasta" , 
//			nativeQuery = true)
//	List<MovimientoEntity> findMovimientosEntreFechas(LocalDate desde, LocalDate hasta);

	List<MovimientoEntity> findByFechaBetween(LocalDate desde, LocalDate hasta);

}
