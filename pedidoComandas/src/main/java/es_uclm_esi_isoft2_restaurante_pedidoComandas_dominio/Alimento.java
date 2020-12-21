package es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio;

import java.util.Arrays;
import java.util.List;

public class Alimento implements Comparable<Alimento>{

	private int idAlimento;
	private String nombre;
	private double precio;
	private String tipo;
	
	/**
	 * @param idAlimento
	 * @param nombre
	 * @param precio
	 */

	public Alimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public Alimento(String nombre, double precio, String tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Alimento(int idAlimento, String nombre, double precio, String tipo) {
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	@Override
	public String toString() {
		return "Alimento [idAlimento=" + idAlimento + ", nombre=" + nombre + ", precio=" + String.format("%.2f", precio) + "€ , tipo=" + tipo
				+ "]";
	}
	
	

	@Override
	public boolean equals(Object obj) {
		Alimento a = (Alimento)obj;
		// TODO Auto-generated method stub
		return ((a.getIdAlimento() == this.getIdAlimento()));
	}

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