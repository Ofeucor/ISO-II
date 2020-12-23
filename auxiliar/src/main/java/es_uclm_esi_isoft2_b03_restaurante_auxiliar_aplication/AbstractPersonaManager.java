package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.PersonaDAO;

public class AbstractPersonaManager {

	/**
	 * Metodo que nos permite autenticar a un empleado del restaurante y una vez se
	 * autentique podrá acceder al sistema para realizar las funcionalidades correspondientes
	 * @param user
	 * @param password
	 */
	public Object autenticar(String user, String password) {
		try {
			return PersonaDAO.autenticarse(user, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param Mesa
	 * @param Estado
	 */
//	public void cambiarEstadoMesa(Mesa Mesa, String Estado) {
//		// TODO - implement AbstractPersonaManager.cambiarEstadoMesa
//		throw new UnsupportedOperationException();
//	}
}
