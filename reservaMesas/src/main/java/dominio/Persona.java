package dominio;

import java.io.IOException;

import persistencia.*;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int idRestaurante;

	/**
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

	public void insertarPersona(Persona persona) {
		try {
			PersonaDAO.insertPersona(persona);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public Persona autenticarPersona(String dni, String password) {
		Persona p1 = null;
		try {
			//p1 = PersonaDAO.autenticarse(dni, password);
			
			this.dni = dni;
			this.nombre = p1.getNombre();
			this.apellidos = p1.getApellidos();
			this.idRestaurante = p1.getIdRestaurante();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p1;
	}*/

	/**
	 * 
	 * @param Mesa
	 * @param Estado
	 */
	public void cambiarEstadoMesa(Mesa Mesa, String Estado) {
		// TODO - implement Persona.cambiarEstadoMesa
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idRestaurante="
				+ idRestaurante + "]";
	}

}