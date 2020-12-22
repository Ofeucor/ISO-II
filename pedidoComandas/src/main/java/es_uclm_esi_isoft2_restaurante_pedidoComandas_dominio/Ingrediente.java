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
	 * Devuelve el identificador de ingrediente
	 * @return int
	 */
	public int getIdIngrediente() {
		return this.idIngrediente;
	}

	/**
	 * Devuelve el nombre de ingrediente
	 * @return String
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Devuelve la cantidad de un ingrdiente
	 * @return float
	 */
	public float getCantidad() {
		return cantidad;
	}

	@Override
	/**
	 * Devuelve en forma de cadena toda la informacion de ingrediente
	 * @return String
	 */
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nombre=" + ((nombre == null) ? "null" : nombre)
				+ ", cantidad=" + cantidad + "]";
	}

	/**
	 * Modifica el identificador de ingrdiente
	 * @param idIngrediente
	 */
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	/**
	 * Modifica el nombre de ingrediente
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Modifica la cantidad de ingrediente
	 * @param cantidad
	 */
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	/**
	 * Compara si 2 objetos ingrediente son iguales
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		return(this.getIdIngrediente() == ((Ingrediente) obj).getIdIngrediente());
	}

	/**
	 * Nos permite compara si 2 ingredientes son iguales
	 * @param o
	 * @return int
	 */
	public int compareTo(Ingrediente o) {
		if(this.getIdIngrediente() < o.getIdIngrediente())
			return -1;
		else if(this.getIdIngrediente() > o.getIdIngrediente())
			return 1;
		else 
			return 0;
	}
}