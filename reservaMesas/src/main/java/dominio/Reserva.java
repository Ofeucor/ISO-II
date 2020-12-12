package dominio;

import java.util.Date;

public class Reserva {

	private Date fecha;
	private String datosCliente;
	private Mesa mesa;

	/**
	 * @param fecha
	 * @param datosCliente
	 * @param idRestaurante 
	 */
	public Reserva(Date fecha, String datosCliente, Mesa mesa) {
		this.fecha = fecha;
		this.datosCliente = datosCliente;
		this.mesa = mesa;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDatosCliente() {
		return this.datosCliente;
	}

	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

}