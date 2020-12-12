package interfaz;

import java.io.IOException;

import dominio.*;
import persistencia.*;

public abstract class Tools {
	
	public static void insertMesa(Mesa m, int idRestaurante) {
		try {
			MesaDAO.insertMesa(m, idRestaurante);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
