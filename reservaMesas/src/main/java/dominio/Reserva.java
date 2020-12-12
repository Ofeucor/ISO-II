package dominio;

import java.util.Date;

public class Reserva {

	private int id;
	private Date fecha;
	private String datosCliente;

	/**
	 * @param fecha
	 * @param datosCliente
	 * @param idRestaurante 
	 */
	
	
	public Reserva(Date fecha, String datosCliente) {
		this.fecha = fecha;
		this.datosCliente = datosCliente;
	}

	public Reserva(int id, Date fecha, String datosCliente) {
		this.id = id;
		this.fecha = fecha;
		this.datosCliente = datosCliente;
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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", datosCliente=" + datosCliente + "]";
	}
	
	

}