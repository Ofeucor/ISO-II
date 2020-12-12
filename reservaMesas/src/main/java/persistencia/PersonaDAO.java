package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import dominio.*;

public class PersonaDAO {

	/**
	 * 
	 * @param dni
	 * @param password
	 */
	
	public static ArrayList<Camarero> getCamareros(int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetCamareros.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Restaurante=" + idRestaurante).getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		ArrayList<Camarero> camareros = new ArrayList<Camarero>();
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
				while (st.hasMoreTokens()) {
					camareros.add((Camarero) stringToPersona(st.nextToken().replace("[", "").replace(",", " ")));
				}
		} else {
			System.out.println("Fallo al insertar persona.");
		}
		return camareros;
	}
	
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
				while (st.hasMoreTokens()) {
					return stringToPersona(st.nextToken().replace("[", "").replace(",", " "));
				}
		} else {
			System.out.println("Fallo al insertar persona.");
		}
		return null;
	}

	/**
	 * 
	 * @param persona
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
	 * 
	 * @param dni
	 */
	public void deletePersona(int dni) {
		
	}

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}

}