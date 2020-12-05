package es.uclm.esi.isoft2.b03.restaurante.Dominio;

public class Mesa {

	private int idMesa;
	private int numSillas;
	private int estado = 0;
	private float precio;

	public int getIdMesa() {
		return this.idMesa;
	}

	public int getNumSillas() {
		return this.numSillas;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}