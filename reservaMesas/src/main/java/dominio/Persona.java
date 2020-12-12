package dominio;

public class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int idRestaurante;

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

	/**
	 * 
	 * @param Mesa
	 * @param Estado
	 */
	public void cambiarEstadoMesa(Mesa Mesa, String Estado) {
		// TODO - implement Persona.cambiarEstadoMesa
		throw new UnsupportedOperationException();
	}

}