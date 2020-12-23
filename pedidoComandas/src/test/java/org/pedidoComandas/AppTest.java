package org.pedidoComandas;

import java.io.IOException;
import java.util.ArrayList;

import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Alimento;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Cocinero;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Comanda;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.Ingrediente;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia.AlimentoDAO;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia.ComandaDAO;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia.IngredienteDAO;
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
	 * @throws IOException 
	 */
	public void testApp() throws IOException {
		/**
		 * DOMINIO
		 */
		// ALIMENTO
		Alimento a1 = new Alimento(1);
		Alimento a2 = new Alimento("tarta hojaldre", 1.5, "Postre");
		Alimento a3 = new Alimento(3, "burguer", 12.5, "Primero");
		a1.getIdAlimento();
		a2.getNombre();
		a3.getPrecio();

		a1.setNombre("Pasta");
		a1.setIdAlimento(17);
		a1.setTipo("Primero");
		a1.setPrecio(5.5);

		a1.getTipo(); // DARA ERROR
		a2.toString();
		a3.equals(a2);
		a3.compareTo(a2);
		
		ArrayList<Alimento> array1 = new ArrayList();
		array1.add(a1);
		array1.add(a2);
		
		// COCINERO
		Cocinero c1 = new Cocinero("00000001B", "Sergio", "Gonzalez", 1);
		Cocinero c2 = new Cocinero("00000002B");
		
		// COMANDA
		Comanda com1 = new Comanda(11, "22-12-2020", "14:35:42");
		Comanda com2 = new Comanda("23-12-2020", "21:25:36", array1);
		Comanda com3 = new Comanda("24-12-2020", "13:57:37");
		
		com1.getIdComanda();
		com2.getFecha();
		com3.getHora();
		com2.getAlimentos();
		
		com1.setAlimentos(array1);
		com2.setEstaPreparada(true);
		com3.setFecha("26-12-2020");
		com1.setHora("14:00:00");
		
		com2.isEstaPreparada();
		
		// INGREDIENTE
		Ingrediente i1 = new Ingrediente(1, 12);
		Ingrediente i2 = new Ingrediente(3, "arroz", 5);
		
		i1.getIdIngrediente();
		i2.getNombre();
		i1.getCantidad();
		i2.toString();
		
		i1.setIdIngrediente(2);
		i1.setCantidad(11);
		
		i1.equals(i2);
		i1.compareTo(i2);
		
		/**
		 * PERSISTENCIA
		 */
		// ALIMENTODAO
		AlimentoDAO.getMenu();
		AlimentoDAO.insertPlato(a2);
		
		// COMANDADAO
		ComandaDAO.insertComanda(1, 1, 1, 3, 3);
		ComandaDAO.insertComanda(1, 1, 5, 1);
				
		// INGREDIENTEDAO
		IngredienteDAO.getIngrediente(4, 1);
		IngredienteDAO.getIngredientes(3);
		
	}
}
