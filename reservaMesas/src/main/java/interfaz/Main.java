package interfaz;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.lang.Math;

import dominio.*;
import persistencia.PersonaDAO;
import interfaz.*;

public class Main {
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String dni, password;

		System.out.println("Dime tu DNI:");
		dni = sc.next();

		System.out.println("Dime tu contraseña:");
		password = sc.next();

		/*//Para tener mesas
		 * for (int j=0; j < 2;j ++)
			for(int i = 1; i < 10; i++)
			Tools.insertMesa(new Mesa(i, ((int)(Math.random()*9)),  (((int)(Math.random()*3))*2)+1), j+1);*/
		
		Object o;
		try {
			
			//[["Manuel","LopezMartin","00000001A","JefeSala","LopezMartin00000001A","1"]]
			o = PersonaDAO.autenticarse(dni, password);
			JefeSala p1 = (JefeSala) o;
			//p1.asignarMesa();
			p1.getReservas();
			p1.getMesas();
			p1.getMesasLibres();
			
			/*Date fecha1 = new Date();
			p1.realizarReserva(fecha1,"Julio5Personas", 1);*/

			

			if(o.getClass().getName().equals(JefeSala.class.getClass().getName())) {
				//JefeSala p1 = (JefeSala) o;
				//p1.realizarReserva(new Date(), "Julio5Personas", null, 1);
				//System.out.println("Aqui");
			}else if(o.getClass().getName().equals(Camarero.class.getClass().getName())){
				//Camarero p1 = (Camarero) o;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JefeSala js1 = (JefeSala)p1.autenticarPersona(dni, password);
		
		

	}
}
