package es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio;

import java.util.ArrayList;
/**
 * 
 *
 */

public class Comanda {

	private int idComanda;
	private String fecha;
	private String hora;
	private ArrayList<Alimento> alimentos;
	private boolean estaPreparada = false;

	
	/**
	 * Constructor para construir un objeto del tipo Comanda sin alimentos
	 * @param idComanda
	 * @param fecha
	 * @param hora
	 */
	public Comanda(int idComanda, String fecha, String hora) {
		super();
		this.idComanda = idComanda;
		this.fecha = fecha;
		this.hora = hora;
	}

	/**
	 * Constructor para construir un objeto del tipo Comanda con alimentos, hora y fecha
	 * @param fecha
	 * @param hora
	 * @param alimentos
	 */
	public Comanda(String fecha, String hora, ArrayList<Alimento> alimentos) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.alimentos = alimentos;
		this.estaPreparada = false;
	}
	
	/**
	 * Constructor para construir un objeto del tipo Comanda con hora y fecha
	 * @param fecha
	 * @param hora
	 */
	public Comanda(String fecha, String hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estaPreparada = false;
	}

	/**
	 * Devuelve el identificador de la comanda
	 * @return int
	 */
	public int getIdComanda() {
		return this.idComanda;
	}

	/**
	 * Devuelve la fecha en la que se toma la comanda
	 * @return String
	 */
	public String getFecha() {
		return this.fecha;
	}

	/**
	 * Devuelve la hora en la que se toma la comanda
	 * @return String
	 */
	public String getHora() {
		return this.hora;
	}

	/**
	 * Devuelve la lista de alimentos que contiene la comanda
	 * @return ArrayList
	 */
	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	/**
	 * Modifica los alimentos que tiene una comanda
	 * @param alimentos
	 */
	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	/**
	 * Devuelve si la comanda esta preparada
	 * @return boolean
	 */
	public boolean isEstaPreparada() {
		return estaPreparada;
	}

	/**
	 * Modifica el estado de la comanda
	 * @param estaPreparada
	 */
	public void setEstaPreparada(boolean estaPreparada) {
		this.estaPreparada = estaPreparada;
	}

	/**
	 * Modifica el identificador de comanda
	 * @param idComanda
	 */
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	/**
	 * Modifica la fecha de la comanda
	 * @param fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Modifica la fecha de la comanda
	 * @param hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

}