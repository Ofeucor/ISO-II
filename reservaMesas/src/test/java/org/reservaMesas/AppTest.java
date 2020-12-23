package org.reservaMesas;

import java.io.IOException;
import java.sql.Date;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Camarero;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.JefeSala;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Mesa;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Persona;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Reserva;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.MesaDAO;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.PersonaDAO;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.ReservaDAO;
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
	@SuppressWarnings("deprecation")
	public void testApp() throws IOException {
		/**
		 * DOMINIO
		 */
		// MESA
		Mesa mesaprueba = MesaDAO.getMesa(1, 1);
		mesaprueba.getEstado();
		mesaprueba.getIdMesa();
		mesaprueba.getNumSillas();
		mesaprueba.setEstado(1);
		Mesa mesaprueba2 = new Mesa(10, 0, 5);
		mesaprueba2.toString();
		// PERSONA
		Persona p1 = new Persona("00000004B", "Lucia", "Diaz", 1);
		p1.setApellidos("Manuela");
		p1.setDni("00000014B");
		p1.setIdRestaurante(2);
		p1.setNombre("Lucio");
		// CAMARERO
		Camarero c1 = new Camarero("00000008B", "Sergio", "Molino", 2);
		c1.getApellidos();
		c1.getDni();
		c1.getIdRestaurante();
		c1.getNombre();
		c1.toString();
		// JEFE SALA
		JefeSala jf1 = new JefeSala("00000001A", "Manuel", "LopezMartin", 1);
		jf1.toString();
		// RESERVA
		Reserva r1 = new Reserva(2, new Date(2020, 12, 4), "Julio5Personas");
		r1.getFecha();
		r1.getDatosCliente();
		r1.setDatosCliente("Julio4Personas");
		r1.setFecha(new Date(2020, 10, 4));
		r1.toString();
		/**
		 * PERSISTENCIA
		 */
		// PESONADAO
		PersonaDAO.insertPersona(new Camarero("00000008B", "Sergio", "Molina", 2));
		PersonaDAO.autenticarse("00000008B", "abcd");
		PersonaDAO.getCamareros(1);
		
		// MESADAO
		MesaDAO.getMesas(1);
		MesaDAO.getMesasLibres(1);
		MesaDAO.asignarMesa(1, "00000001B", 1);
		MesaDAO.atender(mesaprueba, 5, 1, "00000003B");
		MesaDAO.finalizarAtender(mesaprueba, 5, 1, "00000005B", 1);
		MesaDAO.getMesasAsignadas(1, "00000003B");
		
		// RESERVADAO
		ReservaDAO.insertReserva(r1,1);
		ReservaDAO.getReservas(1);
	}
}
