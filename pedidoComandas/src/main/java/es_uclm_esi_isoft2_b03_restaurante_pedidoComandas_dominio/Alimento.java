package es_uclm_esi_isoft2_b03_restaurante_pedidoComandas_dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Alimento implements Comparable<Alimento> {

	private int idAlimento;
	private String nombre;
	private double precio;
	private String tipo;
	
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
	public boolean equals(Object obj) {
		boolean flag=false;
		try {
			Alimento a2 = (Alimento)obj;
			if(a2.getNombre().equals(this.getNombre()) && a2.getPrecio() == this.getPrecio()) flag = true;
		}catch(Exception e) {
			
		}
		return flag;
	}

	public int compareTo(Alimento o) {
		ArrayList<String> list = (ArrayList<String>) Arrays.asList(new String[]{"Bebida","Entrante", "PrimerPlato","Segundo Plato", "Postre"});
		if(o.getTipo() == this.getTipo())
			return 0;
		else
			return 1;
	}
	
	
	
	
	

}