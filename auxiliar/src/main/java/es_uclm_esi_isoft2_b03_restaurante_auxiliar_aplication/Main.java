package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.*;
import es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia.IngredienteDAO;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.*;

public class Main {

	public final static Scanner sc = new Scanner(System.in);
	
	/**
	 * Metodo principal del programa en el que la persona se autentica
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		System.out.println("\r\n"
				+ " _______                         __                                                         __               \r\n"
				+ "/       \\                       /  |                                                       /  |              \r\n"
				+ "$$$$$$$  |  ______    _______  _$$ |_     ______   __    __   ______   ______   _______   _$$ |_     ______  \r\n"
				+ "$$ |__$$ | /      \\  /       |/ $$   |   /      \\ /  |  /  | /      \\ /      \\ /       \\ / $$   |   /      \\ \r\n"
				+ "$$    $$< /$$$$$$  |/$$$$$$$/ $$$$$$/    $$$$$$  |$$ |  $$ |/$$$$$$  |$$$$$$  |$$$$$$$  |$$$$$$/   /$$$$$$  |\r\n"
				+ "$$$$$$$  |$$    $$ |$$      \\   $$ | __  /    $$ |$$ |  $$ |$$ |  $$/ /    $$ |$$ |  $$ |  $$ | __ $$    $$ |\r\n"
				+ "$$ |  $$ |$$$$$$$$/  $$$$$$  |  $$ |/  |/$$$$$$$ |$$ \\__$$ |$$ |     /$$$$$$$ |$$ |  $$ |  $$ |/  |$$$$$$$$/ \r\n"
				+ "$$ |  $$ |$$       |/     $$/   $$  $$/ $$    $$ |$$    $$/ $$ |     $$    $$ |$$ |  $$ |  $$  $$/ $$       |\r\n"
				+ "$$/   $$/  $$$$$$$/ $$$$$$$/     $$$$/   $$$$$$$/  $$$$$$/  $$/       $$$$$$$/ $$/   $$/    $$$$/   $$$$$$$/ \r\n"
				+ "                                                                                                             \r\n"
				+ "                                                                                                             \r\n"
				+ "                                                                                                             \r\n"
				+ "");
		
		System.out.println("\r\n"
				+ "                  _                _    _                   \r\n"
				+ "     /\\          | |              | |  (_)                  \r\n"
				+ "    /  \\   _   _ | |_  ___  _ __  | |_  _   ___  __ _  _ __ \r\n"
				+ "   / /\\ \\ | | | || __|/ _ \\| '_ \\ | __|| | / __|/ _` || '__|\r\n"
				+ "  / ____ \\| |_| || |_|  __/| | | || |_ | || (__| (_| || |   \r\n"
				+ " /_/    \\_\\\\__,_| \\__|\\___||_| |_| \\__||_| \\___|\\__,_||_|   \r\n"
				+ "                                                            \r\n"
				+ "                                                            \r\n"
				+ "");

		
		Object o;
		try {
			
			String dni, password;		
			System.out.println("Dime tu DNI:");
			dni = sc.next();

			System.out.println("Dime tu contraseña:");
			password = sc.next();
			
			o = PersonaDAO.autenticarse(dni, password);
	
			if(o.getClass().getName().equals("es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.JefeSala")) {
				System.out.println("Jefe");
				JefeSala p1 = (JefeSala) o;
				jefeSalaActions(new JefeSalaManager(p1));
			}else if(o.getClass().getName().equals("es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Camarero")){
				System.out.println("Camarero");
				Camarero p1 = (Camarero) o;
				CamareroManager manager = new CamareroManager(p1);
				manager.mesasAsignadas();
				camareroInicio(manager);
				
			}else {
				System.out.println("??");

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Acciones que tiene disponible la persona autenticada como JefeSala
	 * @param j
	 */
	public static void jefeSalaActions(JefeSalaManager j) {
		
		do {
			System.out.println("0.Mesas\n1.Libres\n2.Camareros\n3.Reservas\n4.realizarReserva\n5.asignar");
			switch(sc.nextInt()) {
			case -1:
				continue;
			case 0:
				j.getMesas();
				break;
			case 1:
				j.getMesasLibres();
				break;
			case 2:
				j.getCamareros();
				break;
			case 3:
				j.getReservas();
				break;
			case 4:
				try {
					String dni;		
					System.out.println("Dime tu Nombre y el numero de comensales:");
					dni = sc.next();

					System.out.println("Dime fecha y hora con el siguiente formato yyyy-MM-dd HH:mm:ss");

					j.realizarReserva(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sc.next()),dni);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 5:
				j.asignarMesa(2, "00000002B");
				break;
			}
		}while(true);
	}
	/**
	 * Acciones que tiene disponible la persona autenticada como JefeSala
	 * @param c
	 */
	public static void camareroActions(CamareroManager c) {
		do {
			System.out.println("1.TomarComanda\n2.VerMenu");
			switch(sc.nextInt()) {
			case 0:
				
				break;
			case 1:
				try {
				int registroid = MesaDAO.atender(c.getMesaAntendida(), 5/*Comensales*/, c.getCamarero().getIdRestaurante(), c.getCamarero().getDni());
				List<Alimento> alimentos = new LinkedList<Alimento>();
				int opt;
				boolean ingredientesSuficientes;
				ArrayList<Ingrediente> ingredientesComandas, ingredientes;
				Comanda comanda;
				
				do {
					System.out.println("Indica Plato");
					while((opt=sc.nextInt()) != -1){
						alimentos.add(new Alimento(opt));
						System.out.println("Indica Plato...");
					}
					
					comanda = new Comanda("2020/12/26", "1:56:23", new ArrayList<Alimento>(alimentos));
					ingredientes = new ArrayList<Ingrediente>();
					for(Alimento a : comanda.getAlimentos())
						ingredientes.addAll(IngredienteDAO.getIngredientes(a.getIdAlimento()));
					
					ingredientesComandas = c.getIngredientesComanda(ingredientes);
					
					ingredientesSuficientes = CamareroManager.consultarDisponibilidadComanda(ingredientesComandas);
					
						if(!ingredientesSuficientes) {
							System.out.println("Parece que nos falta algun ingrediente para poder realizar todos los platos");
							ingredientesComandas.clear();
							alimentos.clear();
						}
				
				}while(!ingredientesSuficientes);
				

				c.cogerComanda(comanda);
				registroid = MesaDAO.finalizarAtender(c.getMesaAntendida(), 5/*Comensales*/, c.getCamarero().getIdRestaurante(), c.getCamarero().getDni(), registroid);
				c.notifyCocinero();
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				c.getMenu();
				break;
			}
		}while(true);
	}

	/**
	 * Acciones que tiene disponible la persona autenticada como JefeSala
	 * @param manager
	 */
	public static void camareroInicio(CamareroManager manager) {
		int opt = -1;
		do {
			System.out.println("1.Selecionar Mesa\n2.Ver Mesas Asignadas\n0.Cerrrarxexion");
			opt = sc.nextInt();
			switch(opt) {
				case 0:
					break;
				case 1:
					System.out.print("Indica Id Mesa:");
					manager.setMesaAntendida(manager.getAsignadas().get(manager.getAsignadas().indexOf(new Mesa(sc.nextInt()))));
					camareroActions(manager);
					break;
				case 2:
					manager.mesasAsignadas();
					break;
			}
			camareroActions(manager);
		}while(opt != 0);
	}
	
}
