package es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio;

import java.util.Arrays;
import java.util.List;

public class Alimento implements Comparable<Alimento>{

	private int idAlimento;
	private String nombre;
	private double precio;
	private String tipo;
	
	/**
	 * Constructor del objeto alimento solo con idProducto podemos obtener la demas
	 * informacióndel alimento obteniendola de la base de datos
	 * @param idAlimento
	 */

	public Alimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	/**
	 * Constructor que nos permite crear un Alimento con toda la información
	 * @param nombre
	 * @param precio
	 * @param tipo
	 */
	public Alimento(String nombre, double precio, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	/**
	 * Constructor que nos permite crear un Alimento con toda la informacion
	 * @param idAlimento
	 * @param nombre
	 * @param precio
	 * @param tipo
	 */
	
	public Alimento(int idAlimento, String nombre, double precio, String tipo) {
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	
	/**
	 * Devuelve el identificador del alimento
	 * @return int
	 */
	public int getIdAlimento() {
		return this.idAlimento;
	}

	/**
	 * Devuelve el nombre del alimento
	 * @return String
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Devuelve el precio del alimento
	 * @return double
	 */
	public double getPrecio() {
		return this.precio;
	}

	/**
	 * Devuelve el tipo del alimento puede ser un plato o una bebida
	 * @return String
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo de alimento
	 * @param tipo
	 * @return void
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Modifica el identificador de alimento
	 * @param idAlimento
	 * @return void
	 */
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}
	
	/**
	 * Modifica el nombre del alimento
	 * @param nombre
	 * @return void
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Modifica el precio del alimento
	 * @param precio
	 * @return void
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	@Override
	/**
	 * Devuelve toda la información que contiene el Alimento en una cadena de texto
	 * @return String
	 */
	public String toString() {
		return "Alimento [idAlimento=" + idAlimento + ", nombre=" + nombre + ", precio=" + String.format("%.2f", precio) + "€ , tipo=" + tipo
				+ "]";
	}
	
	

	@Override
	/**
	 * Devuelve si 2 objetos del tipo Alimento son iguales
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		Alimento a = (Alimento)obj;
		// TODO Auto-generated method stub
		return ((a.getIdAlimento() == this.getIdAlimento()));
	}

	/**
	 * Es en lo que nos basamos para saber si 2 alimentos son iguales
	 * @param o
	 * @return int
	 */
	public int compareTo(Alimento o) {
		List<String> list = Arrays.asList(new String[] {"Bebida","Entrante","Primero","Segundo","Postre"});
		int posthis = list.indexOf(this.getTipo());
		int posObjt = list.indexOf(o.getTipo());
		if(posthis < posObjt)
			return -1;
		else if(posthis > posObjt)
			return 1;
		else 
			return 0;
	}
	
	
	

}