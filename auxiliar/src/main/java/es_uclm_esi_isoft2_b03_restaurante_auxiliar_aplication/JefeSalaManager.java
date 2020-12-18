package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.*;

public class JefeSalaManager extends AbstractPersonaManager{

	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param datosCliente
	 * @param mesa
	 * @throws IOException 
	 */
	public Reserva realizarReserva(Date fecha, String hora, String datosCliente, Mesa mesa, int idRestaurante) throws IOException {
		// TODO - implement JefeSalaManager.realizarReserva
		Reserva reserva1 = new Reserva(fecha, datosCliente);
		ReservaDAO.insertReserva(reserva1, idRestaurante);
		return null;
	}

	public void asignarMesa() {
		// TODO - implement JefeSalaManager.asignarMesa
		throw new UnsupportedOperationException();
	}

	public void asignarCamarero() {
		// TODO - implement JefeSalaManager.asignarCamarero
		throw new UnsupportedOperationException();
	}
	
	public ArrayList<Mesa> getMesasLibres(int idRestaurante) {
		// TODO - implement JefeSalaManager.getMesas
		ArrayList<Mesa> mesasLibresRestaurante = new ArrayList<Mesa>();
		try {
			for(Mesa m : MesaDAO.getMesasLibres(idRestaurante)) {
				mesasLibresRestaurante.add(m);
				System.out.println(m.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mesasLibresRestaurante;
	}
	
	public ArrayList<Mesa> getMesas(int idRestaurante) {
		// TODO - implement JefeSalaManager.getMesas
		ArrayList<Mesa> mesasRestaurante = new ArrayList<Mesa>();
		try {
			for(Mesa m : MesaDAO.getMesas(idRestaurante)) {
				mesasRestaurante.add(m);
				System.out.println(m.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mesasRestaurante;
	}

	public ArrayList<Camarero> getCamareros(int idRestaurante) throws IOException {
		ArrayList<Camarero> camarerosRestaurante = new ArrayList<Camarero>();
		for(Camarero c : PersonaDAO.getCamareros(idRestaurante)) {
			camarerosRestaurante.add(c);
			System.out.println(c.toString());
		}
		return camarerosRestaurante;
	}

	/**
	 * 
	 * @param date
	 */
	public ArrayList<Reserva> getReservas(int idRestaurante) throws IOException {
		ArrayList<Reserva> reservas = null;
		reservas = ReservaDAO.getReservas(idRestaurante);
		for(Reserva m : reservas)
			System.out.println(m.toString());
		return reservas;
	}
}
