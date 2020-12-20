package es_uclm_esi_isoft2_b03_restaurante_pedidoComandas_dominio;
import java.util.ArrayList;



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

	public Ingrediente(int idIngrediente, String nombre, float cantidad) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
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