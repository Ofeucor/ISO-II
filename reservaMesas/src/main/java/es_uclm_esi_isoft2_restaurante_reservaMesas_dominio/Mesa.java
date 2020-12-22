package es_uclm_esi_isoft2_restaurante_reservaMesas_dominio;

/**
 * Clase Mesa
 *
 */
public class Mesa {

	private int idMesa;
	private int estado = 0;
	private int numSillas;
	
	/**
	 * Constructor de mesa
	 * @param idMesa
	 * @param estado
	 * @param numSillas
	 */
	public Mesa(int idMesa, int estado,  int numSillas) {
		this.idMesa = idMesa;
		this.estado = estado;
		this.numSillas = numSillas;
	}

	public Mesa() {};

	/**
	 * Mñetodo para obtener el identificador de la mesa
	 * @return id de la mesa
	 */
	public int getIdMesa() {
		return this.idMesa;
	}

	/**
	 * Método para obtener el número de sillas que tiene una mesa
	 * @return número de sillas
	 */
	public int getNumSillas() {
		return this.numSillas;
	}

	/**
	 * Método para obtener el estado en el que se encuentra una mesa
	 * @return estadoMesa
	 */
	public int getEstado() {
		return this.estado;
	}

	/**
	 * Método para cambiar el estado en el que se encuentra usa mesa
	 * @param estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * Método toStrign para obtener la información de una mesa
	 */
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", estado=" + estado + ", numSillas=" + numSillas + "]";
	
	}	
}