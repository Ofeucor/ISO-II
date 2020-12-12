package dominio;

import java.util.Date;

public class JefeSala extends Persona {
	
	public JefeSala(String dni, String nombre, String apellidos, int idRestaurante) {
		super(dni, nombre, apellidos, idRestaurante);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param fecha (tipo date())
	 * @param datosCliente
	 * @param mesa
	 */
	
	public Reserva realizarReserva(Date fecha, String datosCliente, Mesa mesa) {
		// TODO - implement JefeSala.realizarReserva
		throw new UnsupportedOperationException();
	}

	public void asignarMesa() {
		// TODO - implement JefeSala.asignarMesa
		throw new UnsupportedOperationException();
	}

	public void asignarCamarero() {
		// TODO - implement JefeSala.asignarCamarero
		throw new UnsupportedOperationException();
	}

	public Mesa[] getMesas() {
		// TODO - implement JefeSala.getMesas
		throw new UnsupportedOperationException();
	}

	public Camarero[] getCamareros() {
		// TODO - implement JefeSala.getCamareros
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date
	 */
	public Reserva[] getReservas(String date) {
		// TODO - implement JefeSala.getReservas
		throw new UnsupportedOperationException();
	}

}