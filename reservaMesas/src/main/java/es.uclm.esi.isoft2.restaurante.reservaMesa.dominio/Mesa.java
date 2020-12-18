package es.uclm.esi.isoft2.restaurante.reservaMesa.dominio;

public class Mesa {

	private int idMesa;
	private int estado = 0;
	private int numSillas;
	//private float precio;
	
	public Mesa(int idMesa, int estado,  int numSillas) {
		this.idMesa = idMesa;
		this.estado = estado;
		this.numSillas = numSillas;
	}
	
	public Mesa() {};

	public int getIdMesa() {
		return this.idMesa;
	}

	public int getNumSillas() {
		return this.numSillas;
	}

	public int getEstado() {
		return this.estado;
	}
	
//	public float getPrecio() {
//		return this.precio;
//	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", estado=" + estado + ", numSillas=" + numSillas + "]";
	}

	
	
}