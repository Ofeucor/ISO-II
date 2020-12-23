package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.*;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.*;

public class CamareroManager extends AbstractPersonaManager {

	Camarero camarero;
	Mesa mesaAntendida;
	ArrayList<Mesa> asignadas = new ArrayList<Mesa>();
	ArrayList<Comanda> comandas = new ArrayList<Comanda>();

	/**
	 * Constructor del objeto CamareroManager
	 * 
	 * @param camarero
	 */
	public CamareroManager(Camarero camarero) {
		this.camarero = camarero;
	}

	/**
	 * get que nos devuelve el objeto Camarero que pertenece a CamareroManager
	 * 
	 * @return Camarero
	 */
	public Camarero getCamarero() {
		return camarero;
	}

	/**
	 * Metodo que nos permite modificar el atributop camarero una vez
	 * CamareroManager ha sido creado
	 * 
	 * @param camarero
	 */
	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	/**
	 * Metodo que devuelve la mesa que esta siendo atendida por el camarero
	 * 
	 * @return Mesa
	 */
	public Mesa getMesaAntendida() {
		return mesaAntendida;
	}

	/**
	 * Metodo que nos permite cambiar la mesa que esta atendiendo el camarero por
	 * otra diferente dejando de atender a la anterior
	 * 
	 * @param mesaAtendida
	 */
	/**
	 * Metodo que devuelve la mesa que esta siendo atendida por el camarero
	 */
	public void setMesaAntendida(Mesa mesaAntendida) {
		this.mesaAntendida = mesaAntendida;
	}

	/**
	 * Metodo que devuelve la lista de mesas asignadas
	 * 
	 * @return ArrayList()
	 */
	public ArrayList<Mesa> getAsignadas() {
		return asignadas;
	}

	public void setAsignadas(ArrayList<Mesa> asignadas) {
		this.asignadas = asignadas;
	}

	/**
	 * Metodo que nos permite comprobar si las cantidades de ingredientes que
	 * contiene cada plato, que forma la comanda esta disponible en el alamacén para
	 * poder realizar los platos
	 * 
	 * @return boolean
	 */
	public static boolean consultarDisponibilidadComanda(ArrayList<Ingrediente> ingredientesComanda)
			throws IOException {
		ArrayList<Ingrediente> almacen = new ArrayList<Ingrediente>();

		for (Ingrediente i : ingredientesComanda) {
			almacen.add(IngredienteDAO.getIngrediente(i.getIdIngrediente(), 1));
		}

		System.out.println("Los ingredientes requeridos para la comanda son\n");
		for (int i = 0; i < ingredientesComanda.size(); i++) {
			System.out.println("\t" + ingredientesComanda.get(i).getNombre() + " "
					+ ingredientesComanda.get(i).getCantidad() + "- " + almacen.get(i).getCantidad());
			if (ingredientesComanda.get(i).getCantidad() > almacen.get(i).getCantidad())
				return false;
		}

		return true;
	}

	/**
	 * Metodo que nos recoge todos los alimentos que hay en la base de dato, con el
	 * fin de decirle al cliente que puede pedir, para ello nos ayudamos de la clase
	 * AlimentoDAO que es la clase que se conecta con la base de datos
	 * 
	 * @return ArrayList()
	 */
	public static ArrayList<Alimento> getMenu() {
		System.out.println("------MENU------");
		ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
		try {
			for (Alimento a : AlimentoDAO.getMenu()) {
				System.out.println(a.toString());
				alimentos.add(a);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alimentos;
	}

	/**
	 * Metodo que nos permite obtener de la base de datos una lista con las mesas ya
	 * asignadas, se hace uso de MesaDAO para obtener las mesas.
	 */
	public void mesasAsignadas() {
		System.out.println("------MESAS ASIGNADAS------");
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		try {
			for (Mesa a : MesaDAO.getMesasAsignadas(getCamarero().getIdRestaurante(), getCamarero().getDni())) {
				System.out.println(a.toString());
				mesas.add(a);
			}
			setAsignadas(mesas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para coger comandas consiste basicamente en una vez ya tienes cogida
	 * la comanda de la mesa, lo que haces es insertarla en la base de datos si no
	 * es vacia; para la inserción de la comanda a la base de datos haremos uso de
	 * la clase ComandaDAO
	 * 
	 * @param c
	 */
	public void cogerComanda(Comanda c) {
		try {

			int a_num = 0;
			Alimento aux;

			List<Alimento> alimentos = new ArrayList<Alimento>();
			alimentos.addAll(c.getAlimentos());

			if (!alimentos.isEmpty()) {
				a_num = Collections.frequency(alimentos, alimentos.get(0));
				// System.out.println(alimentos.get(0).toString() + "\t" + a_num);
				c.setIdComanda(ComandaDAO.insertComanda(mesaAntendida.getIdMesa(), camarero.getIdRestaurante(),
						alimentos.get(0).getIdAlimento(), a_num));
				aux = alimentos.get(0);
				while (alimentos.contains(aux))
					alimentos.remove(aux);

				while (!alimentos.isEmpty()) {
					a_num = Collections.frequency(alimentos, alimentos.get(0));
					System.out.println(alimentos.get(0).toString() + "\t" + a_num);
					ComandaDAO.insertComanda(c.getIdComanda(), mesaAntendida.getIdMesa(), camarero.getIdRestaurante(),
							alimentos.get(0).getIdAlimento(), a_num);
					aux = alimentos.get(0);
					while (alimentos.contains(aux))
						alimentos.remove(aux);

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que nos inserta todos los ingredientes de todos los platos de una
	 * comanda para posteriormente consultar la disponibilidad
	 * 
	 * @param ingredientes
	 * @return ArrayList()
	 */
	public ArrayList<Ingrediente> getIngredientesComanda(ArrayList<Ingrediente> ingredientes) {
		ArrayList<Ingrediente> ingredientesComandas = new ArrayList<Ingrediente>();
		Collections.sort(ingredientes);

		while (!ingredientes.isEmpty()) {
			int rep = Collections.frequency(ingredientes, ingredientes.get(0));
			for (int i = 1; i < rep; i++) {
				ingredientes.get(0).setCantidad(ingredientes.get(0).getCantidad() + ingredientes.get(1).getCantidad());
				ingredientes.remove(1);
			}
			ingredientesComandas.add(new Ingrediente(ingredientes.get(0).getIdIngrediente(),
					ingredientes.get(0).getNombre(), ingredientes.get(0).getCantidad()));
			ingredientes.remove(0);
		}

		return ingredientesComandas;
	}

	/**
	 * Notifica al cocinero cuando se cierra la comanda
	 */
	public void notifyCocinero() {
		System.out.println("AVISANDO A COCINEROS Y CAMAREROS DE BARRA");
	}
	
	public void cambiarEstadoComanda() {
		// TODO - implement CocineroManager.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}

	public void cocinar() {
		// TODO - implement CocineroManager.cocinar
		throw new UnsupportedOperationException();
	}

}
