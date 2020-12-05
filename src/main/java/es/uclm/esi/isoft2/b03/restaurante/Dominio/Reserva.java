package es.uclm.esi.isoft2.b03.restaurante.Dominio;
public class Reserva {

	private String fecha;
	private String hora;
	private String datosCliente;

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDatosCliente() {
		return this.datosCliente;
	}

	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}

}