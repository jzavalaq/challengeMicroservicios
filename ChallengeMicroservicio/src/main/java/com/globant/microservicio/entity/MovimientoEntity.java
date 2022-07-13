package com.globant.microservicio.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Movimiento")
public class MovimientoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	
	@Column
	private LocalDate fecha;
	
	@Column
	private String tipoMovimiento;
	
	@Column
	private double valor;
	
	@Column
	private double saldo;
	
	@ManyToOne(optional=false, cascade=CascadeType.PERSIST)
	@JoinColumn(name="id_cuenta")
	CuentaEntity cuentaEntity;

	public Long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public CuentaEntity getCuentaEntity() {
		return cuentaEntity;
	}

	public void setCuentaEntity(CuentaEntity cuentaEntity) {
		this.cuentaEntity = cuentaEntity;
	}

	@Override
	public String toString() {
		return "MovimientoEntity [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", tipoMovimiento="
				+ tipoMovimiento + ", valor=" + valor + ", saldo=" + saldo + ", cuentaEntity=" + cuentaEntity + "]";
	}
	
	
}
