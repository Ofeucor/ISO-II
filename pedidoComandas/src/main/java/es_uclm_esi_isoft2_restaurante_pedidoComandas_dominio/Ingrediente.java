package es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio;
import java.util.ArrayList;



public class Ingrediente implements Comparable<Ingrediente>{

	private int idIngrediente;
	private String nombre;
	private float cantidad;

	/**
	 * Constructor para la creacin de ingrediente sin identificador 
	 * @param idIngrediente
	 * @param cantidad
	 */
	public Ingrediente(int idIngrediente, float cantidad) {
		this.idIngrediente = idIngrediente;
		this.cantidad = cantidad;
	}

	/**
	 * Constructor para la creacin de ingrediente con identificador(obtenido de la base de datos)
	 * @param idIngrediente
	 * @param idIngrediente
	 * @param cantidad
	 */
	public Ingrediente(int idIngrediente, String nombre, float cantidad) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	/**
	 * Devuel
	 * @param idIngrediente
	 * @param idIngrediente
	 * @param cantidad
	 */
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

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public boolean equals(Object obj) {
		return(this.getIdIngrediente() == ((Ingrediente) obj).getIdIngrediente());
	}

	public int compareTo(Ingrediente o) {
		if(this.getIdIngrediente() < o.getIdIngrediente())
			return -1;
		else if(this.getIdIngrediente() > o.getIdIngrediente())
			return 1;
		else 
			return 0;
	}
}