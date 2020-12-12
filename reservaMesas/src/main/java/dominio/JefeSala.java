package dominio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import persistencia.MesaDAO;
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

	public void asignarMesa() {
		ArrayList <Mesa> mesas = new ArrayList <Mesa>();

		try {
			mesas=MesaDAO.getMesasLibres(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Mesa mesa;
		if(!mesas.isEmpty()) {
			mesa = mesas.get(0);
			mesa.setEstado(1);
			//MesaDAO.modificar(mesa);
		}
			
		/*while(!mesas.isEmpty()) {
			int index=mesas.size()-1;
			Mesa mesa=mesas.remove(index);

			System.out.println("ID Mesa: " + mesa.getIdMesa() + ". Estado: " + mesa.getEstado());
		}*/

	}

	public void asignarCamarero() {
		// TODO - implement JefeSala.asignarCamarero
		throw new UnsupportedOperationException();
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

	public Camarero[] getCamareros() {
		// TODO - implement JefeSala.getCamareros
		throw new UnsupportedOperationException();
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
	
	/*public ArrayList<Reserva> getReservasFromDate(String date) {
		ArrayList<Reserva> reservas = null;
		try {
			reservas = ReservaDAO.getReservasDate(getIdRestaurante());
			for(Reserva m : reservas)
				System.out.println(m.toString());;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservas;
	}*/

}