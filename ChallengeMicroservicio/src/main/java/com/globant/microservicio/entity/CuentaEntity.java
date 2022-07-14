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
	private boolean estado;
	
	@ManyToOne(optional=false, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_persona")
	private ClienteEntity clienteEntity;

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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	
}
