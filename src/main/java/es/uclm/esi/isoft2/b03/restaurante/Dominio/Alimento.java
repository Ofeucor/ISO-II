package es.uclm.esi.isoft2.b03.restaurante.Dominio;

public class Alimento {

	private int idAlimento;
	private String nombre;
	private double precio;
	
	/**
	 * @param idAlimento
	 * @param nombre
	 * @param precio
	 */

	public Alimento(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Alimento(int idAlimento, String nombre, double precio) {
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdAlimento() {
		return this.idAlimento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

}