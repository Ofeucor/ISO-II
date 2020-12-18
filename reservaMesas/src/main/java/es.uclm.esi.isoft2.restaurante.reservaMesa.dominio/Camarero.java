package es.uclm.esi.isoft2.restaurante.reservaMesa.dominio;

public class Camarero extends Persona {

	public Camarero(String dni, String nombre, String apellidos, int idRestaurante) {
		super(dni, nombre, apellidos, idRestaurante);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Camarero [getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getIdRestaurante()=" + getIdRestaurante() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}