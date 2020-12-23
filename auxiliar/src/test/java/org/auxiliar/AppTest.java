package org.auxiliar;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication.CamareroManager;
import es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication.JefeSalaManager;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Alimento;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Comanda;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Ingrediente;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Camarero;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.JefeSala;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Mesa;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Reserva;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings({ "unused", "deprecation" })
	public void testApp() throws IOException {
		/**
		 * DOMINIO
		 */
		// CAMAMERO MANAGER
		Camarero c1 = new Camarero("00000001B", "Sergio", "Gonzalez", 1);
		Camarero c2 = new Camarero("00000002B", "Juan", "Gonzalez", 1);

		Mesa mesa1 = new Mesa(1, 0, 5);
		Mesa mesa2 = new Mesa(2, 0, 2);
		Mesa mesa3 = new Mesa(3, 0, 4);

		ArrayList<Mesa> arrayMesas = new ArrayList<Mesa>();
		arrayMesas.add(mesa1);
		arrayMesas.add(mesa2);
		arrayMesas.add(mesa3);

		Ingrediente i1 = new Ingrediente(6, 20);
		Ingrediente i2 = new Ingrediente(9, 10);
		Ingrediente i3 = new Ingrediente(12, 50);

		ArrayList<Ingrediente> arrayIngredientes = new ArrayList<Ingrediente>();
		arrayIngredientes.add(i1);
		arrayIngredientes.add(i2);
		arrayIngredientes.add(i3);

		CamareroManager cm1 = new CamareroManager(c1);
		CamareroManager cm2 = new CamareroManager(c2);

		cm1.getCamarero();
		cm1.setCamarero(c2);
		cm1.getMesaAntendida();
		cm1.setMesaAntendida(mesa1);
		cm1.getAsignadas();
		cm1.setAsignadas(arrayMesas);

		CamareroManager.consultarDisponibilidadComanda(arrayIngredientes);
		cm1.mesasAsignadas();

		ArrayList<Alimento> arrayAlimentos = new ArrayList<Alimento>();
		arrayAlimentos = CamareroManager.getMenu();

		Alimento alimento1 = new Alimento(6);
		Alimento alimento2 = new Alimento(3);

		ArrayList<Alimento> arrayAlimentos2 = new ArrayList<Alimento>();
		arrayAlimentos2.add(alimento1);
		arrayAlimentos2.add(alimento2);

		Comanda comanda1 = new Comanda("24/12/2020", "23:59:59", arrayAlimentos2);
		cm1.cogerComanda(comanda1);

		ArrayList<Ingrediente> arrayIngredientes2 = new ArrayList<Ingrediente>();
		arrayIngredientes2 = cm1.getIngredientesComanda(arrayIngredientes);

		cm2.notifyCocinero();

		// JEFE SALA MANAGER
		JefeSala js1 = new JefeSala("00000001A", "Manuel", "LopezMartin", 1);
		JefeSala js2 = new JefeSala("00000002A", "Javier", "MuñozMolina", 2);

		JefeSalaManager jsm1 = new JefeSalaManager(js1);
		JefeSalaManager jsm2 = new JefeSalaManager(js2);

		jsm1.realizarReserva(new Date(23, 12, 2020), "SergioMartin");

		jsm2.asignarMesa(1, "00000002B");

		ArrayList<Mesa> arrayMesas2 = new ArrayList<Mesa>();
		arrayMesas2 = jsm1.getMesasLibres();

		ArrayList<Mesa> arrayMesas3 = new ArrayList<Mesa>();
		arrayMesas2 = jsm2.getMesas();

		ArrayList<Camarero> arrayCamareros = new ArrayList<Camarero>();
		arrayCamareros = jsm2.getCamareros();

		ArrayList<Reserva> arrayReservas = new ArrayList<Reserva>();
		arrayReservas = jsm2.getReservas();

	}
}
