package Dominio;

public class Persona {

	private string dni;
	private string nombre;
	private string apellidos;
	private int idRestaurante;

	public string getDni() {
		return this.dni;
	}

	public void setDni(string dni) {
		this.dni = dni;
	}

	public string getNombre() {
		return this.nombre;
	}

	public void setNombre(string nombre) {
		this.nombre = nombre;
	}

	public string getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(string apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @param Mesa
	 * @param Estado
	 */
	public void cambiarEstadoMesa(Mesa Mesa, string Estado) {
		// TODO - implement Persona.cambiarEstadoMesa
		throw new UnsupportedOperationException();
	}

}