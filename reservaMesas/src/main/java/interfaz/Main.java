package interfaz;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


import dominio.*;
import persistencia.PersonaDAO;

public class Main {
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String dni, password;

		System.out.println(new Date());
		System.out.println("Dime tu DNI:");
		dni = sc.next();

		System.out.println("Dime tu contraseña:");
		password = sc.next();

		
		Object o;
		try {
			o = PersonaDAO.autenticarse(dni, password);
			JefeSala p1 = (JefeSala) o;
			Mesa m1 = new Mesa();
			Date fecha1 = new Date();
			p1.realizarReserva(fecha1,"Julio5Personas", m1, 1);
			System.out.println("Aqui");
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
