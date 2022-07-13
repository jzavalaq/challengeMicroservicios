package com.globant.microservicio.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cuenta")
public class CuentaEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuenta;

	@Column
	private String numeroCuenta;

	@Column
	private String tipoCuenta;

	@Column
	private String saldoInicial;
	@Column
	private String estado;
	
	@ManyToOne(optional=false, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_persona")
	private PersonaEntity personaEntity;

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(String saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PersonaEntity getPersonaEntity() {
		return personaEntity;
	}

	public void setPersonaEntity(PersonaEntity personaEntity) {
		this.personaEntity = personaEntity;
	}
	
}
