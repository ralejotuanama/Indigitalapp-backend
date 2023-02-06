package com.retail.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información del cliente")
@Entity
@Table(name = "cliente") // , schema = ""
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Schema(description = "nombre del cliente")
	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombre;

	@Size(min = 3, message = "Apellido debe tener minimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 70)
	private String apellido;

	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;

	@Size(min = 8, max = 8, message = "DNI debe tener 8 caracteres")
	@Column(name = "dni", nullable = false, length = 8) // unique = true
	private String dni;

	@Column(name = "fechacreacion", nullable = false)
	private LocalDate fechacreacion;

	@Column(name = "fechanacimiento", nullable = false)
	private LocalDate fechanacimiento;

}
