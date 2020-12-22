package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

public abstract class AbstractPersonaManager {

	/**
	 * Metodo que nos permite autenticar a un empleado del restaurante y una vez se
	 * autentique podrá acceder al sistema para realizar las funcionalidades correspondientes
	 * @param user
	 * @param password
	 */
	public Persona autenticar(String user, String password) {
		// TODO - implement AbstractPersonaManager.autenticar
		throw new UnsupportedOperationException();
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
