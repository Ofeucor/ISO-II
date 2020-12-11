package es.uclm.esi.isoft2.b03.restaurante.Persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import es.uclm.esi.isoft2.b03.restaurante.Dominio.*;

public class PlatoDAO {

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 05/12/2020
	 * @author David Gutiérrez
	 *************************************************************************************/
	public static void getMenu() throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetPlatos.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());

		} else {
			System.out.println("NO FUNCIONO");
		}
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 05/12/2020
	 * @author Andrés González
	 *************************************************************************************/
	public static void insertPlato(Plato plato) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertPlato.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection
				.write(("nombre=" + plato.getNombre() + "&precio=" + plato.getPrecio() + "&tipo=" + plato.getTipo())
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

			// print result
			System.out.println(response.toString());

		} else {
			System.out.println("NO FUNCIONÓ");
		}
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 11/12/2020
	 * @author Julio Molina
	 *************************************************************************************/
	public Plato deletePlato(int idPlato) {
		// TODO - implement PlatoDAO.deletePlato
		throw new UnsupportedOperationException();
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 11/12/2020
	 * @author Javier Álvarez
	 *************************************************************************************/
	public static ArrayList<Ingrediente> getIngredientes(Plato plato) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetIngredientes.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_plato=" + plato.getIdAlimento()).getBytes());
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

			// print result
			System.out.println(response.toString());

			ArrayList<Ingrediente> array = new ArrayList<Ingrediente>();
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					array.add(stringToIngrediente(st.nextToken().replace("[", "").replace(",", " ")));
				}
			for (Ingrediente f : array)
				System.out.println(f.toString());
			return array;
		} else {
			System.out.println("NO FUNCIONÓ");
			return null;
		}
	}

	/*************************************************************************************
	 * A partir de un String, que es un ingrediete devuelto por la consulta a la
	 * BBDD, parseamos y lo convertimos en un objeto Ingrediente con el que poder
	 * trabajar. Todos los ingredientes del plato los metemos en un ArrayList
	 * 
	 * @date 11/12/2020
	 * @author Javier Álvarez
	 *************************************************************************************/
	public static Ingrediente stringToIngrediente(String r) {
		StringTokenizer st = new StringTokenizer(r, " ");
		Ingrediente ingrediente = null;

		try {
			int idPlato = Integer.parseInt(st.nextToken().replace("\"", ""));
			int idIngrediente = Integer.parseInt(st.nextToken().replace("\"", ""));
			float cantidadIngrediente = Float.parseFloat(st.nextToken().replace("\"", ""));

			ingrediente = new Ingrediente(idIngrediente, cantidadIngrediente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediente;
	}
}