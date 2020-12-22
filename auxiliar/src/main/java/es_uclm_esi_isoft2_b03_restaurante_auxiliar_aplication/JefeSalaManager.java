package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.*;

public class JefeSalaManager extends AbstractPersonaManager{


	JefeSala jefeSala;
	
	/**
	 * Constructor para la clase JefeSalaManager este tendra como atributo un JefeSala
	 * 
	 * @param jefeSala
	 */
	public JefeSalaManager(JefeSala jefeSala) {

		this.jefeSala = jefeSala;
	}

	/**
	 * Método para realizar una reserva, se insertara a la base de datos la reserva realizada por el cliente,
	 * para conectar con la base de datos haremos uso de ReservaDAO
	
	 * @param datosCliente
	 * @param fecha
	 */
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

	/**
	 * Método para asignar mesa al cliente una vez llega el cliente al restaurante, se le asigna una mesa libre
	 * esa asiganación se verá reflejada en la base de datos; se hace uso de la clase MesaDAO para la conexión con la base de datos
	 * 
	 * @param idMesa
	 * @param idCamarero
	 */
	public void asignarMesa(int idMesa, String idCamarero) {
		try {
			MesaDAO.asignarMesa(idMesa, idCamarero, jefeSala.getIdRestaurante());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que nos devuelve las mesas que se encuentran en estado "libre " en el restaurante; 
	 * se hace uso de MesaDAO que es la que conecta con la base de datos
	 * @return ArrayList()
	 */
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
	
	/**
	 * Método que nos devuelve las mesas que se encuentran en cualquier estado en el restaurante; 
	 * se hace uso de MesaDAO que es la que conecta con la base de datos
	 * @return ArrayList()
	 */
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

	/**
	 * Método que nos devuelve los camareros que estan trabajando en el restaurante
	 * @return ArrayList()
	 */
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
	 * Metodo para obtener las reservas que tiene un restaurante
	 * @return ArrayList()
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
