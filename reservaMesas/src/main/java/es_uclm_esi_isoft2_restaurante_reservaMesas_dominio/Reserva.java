package es_uclm_esi_isoft2_restaurante_reservaMesas_dominio;

import java.util.Date;

/**
 * Clase para generar una reserva en el restaurante
 *
 */

public class Reserva {

	private int id;
	private Date fecha;
	private String datosCliente;
	
	/**
	 * Constructor para generar una Reserva
	 * @param fecha
	 * @param datosCliente
	 */
	public Reserva(Date fecha, String datosCliente) {
		this.fecha = fecha;
		this.datosCliente = datosCliente;
	}

	/**
	 * Constructor para generar una Reserva
	 * @param id
	 * @param fecha
	 * @param datosCliente
	 */
	public Reserva(int id, Date fecha, String datosCliente) {
		this.id = id;
		this.fecha = fecha;
		this.datosCliente = datosCliente;
	}

	/**
	 * Método para obtener la fecha de la reserva
	 * @return fecha de la reserva
	 */
	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * Método para cambiar la fecha de la reserva
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Método para obtener los datos del cliente que ha hecho la reserva
	 * @return datos del cliente
	 */
	public String getDatosCliente() {
		return this.datosCliente;
	}

	/**
	 * Método para cambiar los datos del cliente que hace la reserva
	 * @param datosCliente
	 */
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

	/**
	 * Método toString para obtener los datos de una reserva
	 */
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", datosCliente=" + datosCliente + "]";
	}
	
	

}