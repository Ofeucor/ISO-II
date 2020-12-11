package es.uclm.esi.isoft2.b03.restaurante;

import java.io.IOException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.b03.restaurante.Dominio.Alimento;
import es.uclm.esi.isoft2.b03.restaurante.Dominio.Camarero;
import es.uclm.esi.isoft2.b03.restaurante.Dominio.Ingrediente;
import es.uclm.esi.isoft2.b03.restaurante.Dominio.Plato;
import es.uclm.esi.isoft2.b03.restaurante.Persistencia.IngredienteDAO;
import es.uclm.esi.isoft2.b03.restaurante.Persistencia.PlatoDAO;

public class Principal {

	public static void main(String[] args) throws IOException {
		Plato dish = new Plato("pollo", 32.5, "Segundo");
		PlatoDAO.insertPlato(dish);
		PlatoDAO.getMenu();
		Camarero camarero = new Camarero();
		Plato dish1 = new Plato(3, "burguer", 12.50, "Segundo");
		System.out.println(Camarero.consultarDisponibilidad(dish1));
	}
}
