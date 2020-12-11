package es.uclm.esi.isoft2.b03.restaurante.Dominio;

import java.io.IOException;
import java.util.ArrayList;

import es.uclm.esi.isoft2.b03.restaurante.Persistencia.IngredienteDAO;
import es.uclm.esi.isoft2.b03.restaurante.Persistencia.PlatoDAO;

public class Camarero extends Persona {

	/**
	 * 
	 * @param mesa
	 */
	public Comanda cogerComanda(Mesa mesa) {
		// TODO - implement Camarero.cogerComanda
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param alimento
	 * @throws IOException
	 */
	public static boolean consultarDisponibilidad(Alimento alimento) throws IOException {
		ArrayList<Ingrediente> ingredientePlato = PlatoDAO.getIngredientes((Plato) alimento);
		ArrayList<Ingrediente> almacen = new ArrayList<Ingrediente>();

		for (Ingrediente i : ingredientePlato) {
			almacen.add(IngredienteDAO.getIngrediente(i.getIdIngrediente(), 1));
		}

		for (int i = 0; i < ingredientePlato.size(); i++)
			if (ingredientePlato.get(i).getCantidad() > almacen.get(i).getCantidad())
				return false;

		return true;
	}

	public void cambiarEstadoComanda() {
		// TODO - implement Camarero.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}

	public Alimento[] getMenu() {
		// TODO - implement Camarero.getMenu
		throw new UnsupportedOperationException();
	}

}