package es.uclm.esi.isoft2.b03.restaurante.Dominio;

import java.util.ArrayList;

import es.uclm.esi.isoft2.b03.restaurante.Persistencia.IngredienteDAO;
import es.uclm.esi.isoft2.b03.restaurante.Persistencia.PlatoDAO;

public class Ingrediente {

	private int idIngrediente;
	private String nombre;
	private float cantidad;

	/**
	 * @param idIngrediente
	 * @param cantidad
	 */

	public Ingrediente(int idIngrediente, float cantidad) {
		this.idIngrediente = idIngrediente;
		this.cantidad = cantidad;
	}

	public int getIdIngrediente() {
		return this.idIngrediente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public float getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nombre=" + ((nombre == null) ? "null" : nombre)
				+ ", cantidad=" + cantidad + "]";
	}
}