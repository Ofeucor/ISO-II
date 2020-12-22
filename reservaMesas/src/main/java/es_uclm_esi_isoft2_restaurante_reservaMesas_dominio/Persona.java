package es_uclm_esi_isoft2_restaurante_reservaMesas_dominio;

import java.io.IOException;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int idRestaurante;

	public Persona(String dni, String nombre, String apellidos, int idRestaurante) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idRestaurante = idRestaurante;
	}
	
	public Persona(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idRestaurante="
				+ idRestaurante + "]";
	}

}