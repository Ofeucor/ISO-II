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

	
	
	public Comanda(int idComanda, String fecha, String hora) {
		super();
		this.idComanda = idComanda;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Comanda(String fecha, String hora, ArrayList<Alimento> alimentos) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.alimentos = alimentos;
		this.estaPreparada = false;
	}
	
	public Comanda(String fecha, String hora) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estaPreparada = false;
	}

	public int getIdComanda() {
		return this.idComanda;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public boolean isEstaPreparada() {
		return estaPreparada;
	}

	public void setEstaPreparada(boolean estaPreparada) {
		this.estaPreparada = estaPreparada;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}