package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.util.ArrayList;

import es_uclm_esi_isoft2_b03_restaurante_pedidoComandas_dominio.*;
import es_uclm_esi_isoft2_b03_restaurante_pedidoComandas_persistencia.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

public class CamareroManager extends AbstractPersonaManager{

	Camarero camarero;
	
	
	public CamareroManager(Camarero camarero) {
		this.camarero = camarero;
	}
	
	public static boolean consultarDisponibilidad(Alimento alimento) throws IOException {
		ArrayList<Ingrediente> ingredientePlato = AlimentoDAO.getIngredientes((Alimento) alimento);
		ArrayList<Ingrediente> almacen = new ArrayList<Ingrediente>();

		for (Ingrediente i : ingredientePlato) {
			almacen.add(IngredienteDAO.getIngrediente(i.getIdIngrediente(), 1));
		}

		System.out.println("Los ingredientes requeridos para " + alimento.getNombre() + " son\n");
		for (int i = 0; i < ingredientePlato.size(); i++) {
			System.out.println("\t" + ingredientePlato.get(i).getNombre() + " " +
					ingredientePlato.get(i).getCantidad() + "- " + almacen.get(i).getCantidad());
			if (ingredientePlato.get(i).getCantidad() > almacen.get(i).getCantidad())
				return false;
		}

		return true;
	}

	public void cambiarEstadoComanda() {
		// TODO - implement Camarero.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}

	public ArrayList<Alimento> getMenu() {
		
		throw new UnsupportedOperationException();
	}
	
	public void consultarDisponibilidad() {
		// TODO - implement Camarero.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}
	
	public void pedircuenta() {
		// TODO - implement Camarero.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}
	
	public void cogerComanda() {
		// TODO - implement Camarero.cambiarEstadoComanda
		throw new UnsupportedOperationException();
	}
}
