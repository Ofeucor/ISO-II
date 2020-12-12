package dominio;

public class Mesa {

	private int idMesa;
	private int numSillas;
	private int estado = 0;
	private float precio;
	
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
	
	public float getPrecio() {
		return this.precio;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}