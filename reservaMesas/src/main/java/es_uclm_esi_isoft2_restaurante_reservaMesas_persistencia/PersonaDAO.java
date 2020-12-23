package es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

/**
 * Clase encargada de hacer las peticiones a la base de datos correspondientes a la Persona
 *
 */
public class PersonaDAO {
	
	/**
	 * Método para autenticarse en la base de datos y tener acceso a los casos de uso correspondientes a la
	 * persona que se autentica
	 * @param dni
	 * @param password
	 * @return
	 * @throws IOException
	 */
	public static Object autenticarse(String dni, String password) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phplogin.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("usuario=" + dni + "&password=" + password).getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				
				return stringToPersona(st.nextToken().replace("[", "").replace(",", " "));
				
		} else {
			System.out.println("Fallo al insertar persona.");
		}
		return null;
	}

	/**
	 * Método para insertar una persona en la base de datos
	 * @param persona
	 * @throws IOException
	 */
	public static void insertPersona(Persona persona) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertEmpleado.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		String rol = persona.getClass().getName().toString().split("\\.")[1];
		String pass = (persona.getApellidos() + persona.getDni());

		directConnection.write(
				("nombre=" + persona.getNombre() + "&apellidos=" + persona.getApellidos() + "&DNI=" + persona.getDni()
						+ "&Rol=" + rol + "&Password=" + pass + "&idRestaurante=" + persona.getIdRestaurante())
								.getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} else {
			System.out.println("Fallo al insertar persona.");
		}
	}

	/**
	 * Método para eliminar una perosna de la base de datos
	 * @param dni
	 */
	public void deletePersona(int dni) {
		
	}

	/**
	 * Método para pasar la información de la base de datos a un objeto del tipo Persona
	 * @param r
	 * @return
	 */
	public static Object stringToPersona(String r) {
		StringTokenizer st = new StringTokenizer(r, " ");
		Persona persona = null;

		try {
			String nombre = st.nextToken().replace("\"", "");
			String apellidos = st.nextToken().replace("\"", "");
			String dni = st.nextToken().replace("\"", "");
			String rol = st.nextToken().replace("\"", "");
			String password = st.nextToken().replace("\"", "");
			int idRestaurante = Integer.parseInt(st.nextToken().replace("\"", ""));

			switch (rol) {
			case "JefeSala":
				persona = new JefeSala(dni, nombre, apellidos, idRestaurante);
				break;
			case "Camarero":
				persona = new Camarero(dni, nombre, apellidos, idRestaurante);
				break;
			case "Cocinero":
				break;
			case "Administrador":
				break;
			}
			//System.out.println(persona.getClass().getName().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}
	
	/**
	 * Método para obtener todos los camaremos de un determinado restaurante
	 * @param idRestaurante
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Camarero> getCamareros(int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetCamareros.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Restaurante=" + idRestaurante ).getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
		ArrayList <Camarero> camareros = new ArrayList <Camarero> ();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while(st.hasMoreElements())
					camareros.add((Camarero)(stringToPersona(st.nextToken().replace("[", "").replace(",", " "))));
				
		} else {
			System.out.println("Fallo al insertar persona.");
		}
		return camareros;
	}

}