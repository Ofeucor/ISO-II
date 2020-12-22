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
	
	public static void main(String[] args) {
		String dni, password;		

		
		System.out.println("------AUTENTIFICAR------");
		System.out.println("Dime tu DNI:");
		dni = sc.next();

		System.out.println("Dime tu contraseña:");
		password = sc.next();
		
		Object o;
		try {
			
			//[["Manuel","LopezMartin","00000001A","JefeSala","LopezMartin00000001A","1"]]
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
			}else {
				System.out.println("??");

			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JefeSala js1 = (JefeSala)p1.autenticarPersona(dni, password);

	}
	
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
					//SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
					//Date f = formatter.parse("31-Dec-2021 11:37:50");
					j.realizarReserva(new Date(),"Cliente19");
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
	
	public static void camareroActions(CamareroManager c) {
		do {
			System.out.println("1.TomarComanda\n2.VerMenu");
			switch(sc.nextInt()) {
			case 0:
				
				break;
			case 1:
				try {
				//int registroid = MesaDAO.atender(c.getMesaAntendida(), 5/*Comensales*/, c.getCamarero().getIdRestaurante(), c.getCamarero().getDni());
				List<Alimento> alimentos = new LinkedList<Alimento>();
				int opt;
				boolean ingredientesSuficientes;
				ArrayList<Ingrediente> ingredientesComandas, ingredientes;
				
				do {
					System.out.println("Indica Plato");
					while((opt=sc.nextInt()) != -1){
						alimentos.add(new Alimento(opt));
						System.out.println("Indica Plato...");
					}
					
					Comanda comanda = new Comanda("2020/12/26", "1:56:23", new ArrayList<Alimento>(alimentos));
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
				

				//c.cogerComanda(comanda);
				//registroid = MesaDAO.finalizarAtender(c.getMesaAntendida(), 5/*Comensales*/, c.getCamarero().getIdRestaurante(), c.getCamarero().getDni(), registroid);
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

}
