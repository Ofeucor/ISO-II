package dominio;

import java.io.IOException;
import java.util.Date;

import persistencia.ReservaDAO;

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
	 * @throws IOException 
	 */
	
	public Reserva realizarReserva(Date fecha, String datosCliente, Mesa mesa, int idRestaurante) throws IOException {
		Reserva reserva1 = new Reserva(fecha, "Julio6Personas", mesa);
		ReservaDAO.insertReserva(reserva1, idRestaurante);
		return null;
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