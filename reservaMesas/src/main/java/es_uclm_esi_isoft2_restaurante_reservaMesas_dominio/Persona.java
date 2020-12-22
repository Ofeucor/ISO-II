package es_uclm_esi_isoft2_restaurante_reservaMesas_dominio;

import java.io.IOException;

/**
 * Clase para obtener/crear una Persona
 *
 */

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int idRestaurante;
	
	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param idRestaurante
	 */
	public Persona(String dni, String nombre, String apellidos, int idRestaurante) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idRestaurante = idRestaurante;
	}
	
	/**
	 * Constructor de Persona
	 * @param dni
	 */
	public Persona(String dni) {
		this.dni = dni;
	}

	/**
	 * Método para obtener el DNI de una persona
	 * @return DNI
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * Método para cambiar el DNi de una Persona
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método para obtener el nombre de una persona
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Método para cambiar el nombre de una persona
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método para obtener los apellidos de una persona
	 * @return apellidos
	 */
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * Método para cambiar los apellidos de una persona
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Método para obtener el idRestaurante en el que trabaja la persona
	 * @return
	 */
	public int getIdRestaurante() {
		return idRestaurante;
	}

	/**
	 * Método para cambiar el idRestaurante de una persona
	 * @param idRestaurante
	 */
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	/**
	 * Método toString para obtener la información de una persona
	 */
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idRestaurante="
				+ idRestaurante + "]";
	}

}