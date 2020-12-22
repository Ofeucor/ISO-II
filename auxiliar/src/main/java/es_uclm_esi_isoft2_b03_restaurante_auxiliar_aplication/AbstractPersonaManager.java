package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

/**
 * Clase abstarta con los métodos de una persona
 *
 */

public abstract class AbstractPersonaManager {

	/**
	 * Método abstracto para autenticar a una persona
	 * @param user
	 * @param password
	 * @return
	 */
	public Persona autenticar(String user, String password) {
		// TODO - implement AbstractPersonaManager.autenticar
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Método abstracto para cambiar el estado de una mesa
	 * @param Mesa
	 * @param Estado
	 */
	public void cambiarEstadoMesa(Mesa Mesa, String Estado) {
		// TODO - implement AbstractPersonaManager.cambiarEstadoMesa
		throw new UnsupportedOperationException();
	}
}
