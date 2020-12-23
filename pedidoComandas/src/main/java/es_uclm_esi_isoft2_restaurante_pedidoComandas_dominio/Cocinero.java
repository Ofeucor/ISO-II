package es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Persona;

public class Cocinero extends Persona {
	
	
	/**
	 * Constructor para construir un objeto del tipo Cocinero, el cual hereda de Persona
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param idRestaurante
	 */
	public Cocinero(String dni, String nombre, String apellidos, int idRestaurante) {
		super(dni, nombre, apellidos, idRestaurante);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor para construir un objeto del tipo Cocinero a partir del Dni, Cocinero
	 * hereda de Persona
	 * @param dni
	 */
	public Cocinero(String dni) {
		super(dni);
		// TODO Auto-generated constructor stub
	}

}