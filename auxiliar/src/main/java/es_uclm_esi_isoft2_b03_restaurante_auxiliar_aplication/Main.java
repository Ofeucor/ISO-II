package es_uclm_esi_isoft2_b03_restaurante_auxiliar_aplication;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Camarero;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.JefeSala;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Mesa;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.MesaDAO;
import es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia.PersonaDAO;

public class Main {

	public final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String dni, password;		

		System.out.println("Dime tu DNI:");
		dni = sc.next();

		System.out.println("Dime tu contraseña:");
		password = sc.next();

		/*try {
			PersonaDAO.insertPersona(new Camarero("00000003B", "Pablo", "Peco", 1));
			PersonaDAO.insertPersona(new Camarero("00000004B", "Lucia", "Diaz", 1));
			PersonaDAO.insertPersona(new Camarero("00000005B", "Ana", "Parras", 2));
			PersonaDAO.insertPersona(new Camarero("00000006B", "losif", "Stalin", 1));
			PersonaDAO.insertPersona(new Camarero("00000007B", "Juan", "Smith", 2));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		/*//Para tener mesas
		 * for (int j=0; j < 2;j ++)
			for(int i = 1; i < 10; i++)
			Tools.insertMesa(new Mesa(i, ((int)(Math.random()*9)),  (((int)(Math.random()*3))*2)+1), j+1);*/
		
		//Devuelve una mesa dado un idMesa e idRestaurante
		/*try {
			Mesa mesaprueba = MesaDAO.getMesa(1, 1);
			System.out.println(mesaprueba.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}*/
		
		Object o;
		try {
			
			//[["Manuel","LopezMartin","00000001A","JefeSala","LopezMartin00000001A","1"]]
			o = PersonaDAO.autenticarse(dni, password);
			
			//p1.getCamareros();
			//p1.asignarMesa(1,2);
			//p1.getReservas();
			//p1.getMesas();
			//p1.getMesasLibres();
			
			/*Date fecha1 = new Date();
			p1.realizarReserva(fecha1,"Julio5Personas", 1);*/

			

			if(o.getClass().getName().equals("es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.JefeSala")) {
				System.out.println("Jefe");
				JefeSala p1 = (JefeSala) o;
				jefeSalaActions(new JefeSalaManager(p1));
				//p1.realizarReserva(new Date(), "Julio5Personas", null, 1);
				//System.out.println("Aqui");
			}else if(o.getClass().getName().equals(Camarero.class.getClass().getName())){
				System.out.println("Cama");

				Camarero p1 = (Camarero) o;
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
	
	public void camareroActions() {
		System.out.println("1.TomarComanda\n2.VerMenu");
		switch(sc.nextInt()) {
		case 0:
			
			break;
		}
	}

}
