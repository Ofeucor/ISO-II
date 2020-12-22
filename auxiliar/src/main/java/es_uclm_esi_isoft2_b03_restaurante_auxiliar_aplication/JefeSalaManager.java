package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.*;

public class JefeSalaManager extends AbstractPersonaManager{


	JefeSala jefeSala;
	
	
	public JefeSalaManager(JefeSala jefeSala) {

		this.jefeSala = jefeSala;
	}

	public void realizarReserva(Date fecha, String datosCliente) {
		// TODO - implement JefeSalaManager.realizarReserva
		try {
			Reserva reserva1 = new Reserva(fecha, datosCliente);
			ReservaDAO.insertReserva(reserva1, jefeSala.getIdRestaurante());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void asignarMesa(int idMesa, String idCamarero) {
		try {
			MesaDAO.asignarMesa(idMesa, idCamarero, jefeSala.getIdRestaurante());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Mesa> getMesasLibres() {
		// TODO - implement JefeSalaManager.getMesas
		ArrayList<Mesa> mesasLibresRestaurante = new ArrayList<Mesa>();
		try {
			for(Mesa m : MesaDAO.getMesasLibres(jefeSala.getIdRestaurante())) {
				mesasLibresRestaurante.add(m);
				System.out.println(m.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mesasLibresRestaurante;
	}
	
	public ArrayList<Mesa> getMesas() {
		// TODO - implement JefeSalaManager.getMesas
		ArrayList<Mesa> mesasRestaurante = new ArrayList<Mesa>();
		try {
			for(Mesa m : MesaDAO.getMesas(jefeSala.getIdRestaurante())) {
				mesasRestaurante.add(m);
				System.out.println(m.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mesasRestaurante;
	}

	public ArrayList<Camarero> getCamareros() {
		ArrayList<Camarero> camarerosRestaurante = new ArrayList<Camarero>();
	
		try {
			for(Camarero c : PersonaDAO.getCamareros(jefeSala.getIdRestaurante())) {
				camarerosRestaurante.add(c);
				System.out.println(c.toString());
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return camarerosRestaurante;
	}

	/**
	 * Metodo para obtener una reserva
	 * @return reserva
	 */
	public ArrayList<Reserva> getReservas(){
		ArrayList<Reserva> reservas = null;
		try {
			reservas = ReservaDAO.getReservas(jefeSala.getIdRestaurante());
			for(Reserva m : reservas)
				System.out.println(m.toString());
		}catch(Exception e){
			
		}
		return reservas;
	}
}
