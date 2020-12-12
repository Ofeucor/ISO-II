package interfaz;

import java.util.Scanner;

import dominio.*;

public class Main {
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String dni, password;


		System.out.println("Dime tu DNI:");
		dni = sc.next();

		System.out.println("Dime tu contraseña:");
		password = sc.next();

		Persona p1 = new Persona(dni);		
		p1.autenticarPersona(dni, password);

		System.out.println(p1.toString());

	}
}
