package es.uclm.esi.isoft2.b03.restaurante.Dominio;
public class Comanda {

	private int idComanda;
	private String fecha;
	private String hora;
	private boolean estaPreparada = false;

	public int getIdComanda() {
		return this.idComanda;
	}

	public String getFecha() {
		return this.fecha;
	}

	public String getHora() {
		return this.hora;
	}

}