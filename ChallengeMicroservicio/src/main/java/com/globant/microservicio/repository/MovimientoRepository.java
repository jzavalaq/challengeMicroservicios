package com.globant.microservicio.repository;

import com.globant.microservicio.entity.MovimientoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

}
