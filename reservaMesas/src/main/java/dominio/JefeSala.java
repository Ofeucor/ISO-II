package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import persistencia.MesaDAO;
import persistencia.PersonaDAO;
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
	
	public Reserva realizarReserva(Date fecha, String datosCliente, int idRestaurante) throws IOException {
		Reserva reserva1 = new Reserva(fecha, datosCliente);
		ReservaDAO.insertReserva(reserva1, idRestaurante);
		return null;
	}

	public void asignarMesa(int idCamarero, int idMesa) {
		try {
			MesaDAO.asignarMesa(idCamarero, this.getIdRestaurante(), idMesa);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void getMesas() {
		try {
			for(Mesa m : MesaDAO.getMesas(getIdRestaurante()))
				System.out.println(m.toString());;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getMesasLibres() {
		try {
			for(Mesa m : MesaDAO.getMesasLibres(getIdRestaurante()))
				System.out.println(m.toString());;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getCamareros() {
		try {
			for(Camarero c : PersonaDAO.getCamareros(getIdRestaurante()))
				System.out.println(c.toString());;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param date
	 */
	public ArrayList<Reserva> getReservas() {
		ArrayList<Reserva> reservas = null;
		try {
			reservas = ReservaDAO.getReservas(getIdRestaurante());
			for(Reserva m : reservas)
				System.out.println(m.toString());;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public ArrayList<Reserva> getReservasFromDate(String date) {
		throw new UnsupportedOperationException();
	}

}