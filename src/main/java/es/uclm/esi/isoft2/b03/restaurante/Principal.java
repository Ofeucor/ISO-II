package es.uclm.esi.isoft2.b03.restaurante;

import java.io.IOException;

import es.uclm.esi.isoft2.b03.restaurante.Persistencia.PlatoDAO;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		PlatoDAO.getMenu();
	}

}
