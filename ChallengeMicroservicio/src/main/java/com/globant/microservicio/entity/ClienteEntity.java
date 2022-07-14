package com.globant.microservicio.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class ClienteEntity extends PersonaEntity {

//	@Id //	@GeneratedValue(strategy = GenerationType.IDENTITY) //	private Long idCliente;

	@Column
	private String contrasena;

	@Column
	private boolean estado;


	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
