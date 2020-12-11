package es.uclm.esi.isoft2.b03.restaurante.Dominio;


public class Plato extends Alimento {
	
	private String tipo;

	/**
	 * @param nombre
	 * @param precio
	 * @param tipo
	 */
	public Plato(String nombre, double precio, String tipo) {
		super(nombre, precio);
		this.tipo = tipo;
	}
	
	public Plato(int idPlato, String nombre, double precio, String tipo) {
		super(idPlato, nombre, precio);
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}

}