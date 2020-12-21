package es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Mesa;

public class AlimentoDAO {

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 05/12/2020
	 * @author David GutiÃ©rrez
	 *************************************************************************************/
	public static ArrayList <Alimento> getMenu() throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetAlimento.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		ArrayList <Alimento> alimentos = new ArrayList <Alimento> ();
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
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					alimentos.add(stringToAlimento(st.nextToken().replace("[", "")));
				}
			
			Collections.sort(alimentos);

		} else {
			System.out.println("NO FUNCIONO");
		}
		return alimentos;
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 05/12/2020
	 * @author AndrÃ©s GonzÃ¡lez
	 *************************************************************************************/
	public static void insertPlato(Alimento alimento) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertAlimento.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection
				.write(("nombre=" + alimento.getNombre() + "&precio=" + alimento.getPrecio() + "&tipo=" + alimento.getTipo())
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
			//System.out.println(response.toString());

		} else {
			System.out.println("NO FUNCIONÃ“");
		}
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 11/12/2020
	 * @author Julio Molina
	 *************************************************************************************/
	public Alimento deletePlato(int idPlato) {
		// TODO - implement PlatoDAO.deletePlato
		throw new UnsupportedOperationException();
	}

	/*************************************************************************************
	 * Con esta consulta
	 * 
	 * @date 11/12/2020
	 * @author Javier Ã�lvarez
	 *************************************************************************************/
	public static ArrayList<Ingrediente> getIngredientes(Alimento plato) throws IOException {
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
			/*for (Ingrediente f : array)
				System.out.println(f.toString());*/
			
			return array;
		} else {
			System.out.println("NO FUNCIONÃ“");
			return null;
		}
	}

	/*************************************************************************************
	 * A partir de un String, que es un ingrediete devuelto por la consulta a la
	 * BBDD, parseamos y lo convertimos en un objeto Ingrediente con el que poder
	 * trabajar. Todos los ingredientes del plato los metemos en un ArrayList
	 * 
	 * @date 11/12/2020
	 * @author Javier Ã�lvarez
	 *************************************************************************************/
	public static Ingrediente stringToIngrediente(String r) {
		StringTokenizer st = new StringTokenizer(r, " ");
		Ingrediente ingrediente = null;

		try {
			int idPlato = Integer.parseInt(st.nextToken().replace("\"", ""));
			int idIngrediente = Integer.parseInt(st.nextToken().replace("\"", ""));
			float cantidadIngrediente = Float.parseFloat(st.nextToken().replace("\"", ""));
			st.nextToken().replace("\"", "");
			String nombre = st.nextToken().replace("\"", "");

			ingrediente = new Ingrediente(idIngrediente, nombre, cantidadIngrediente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ingrediente;
	}
	
	
	public static Alimento stringToAlimento(String r) {
		StringTokenizer st = new StringTokenizer(r, ",");
		Alimento alimento = null;

		try {
			//System.out.println(r);
			int idPlato = Integer.parseInt(st.nextToken().replace("\"", ""));
			String nombre = st.nextToken().replace("\"", "");
			float precio = Float.parseFloat(st.nextToken().replace("\"", ""));
			String tipo = st.nextToken().replace("\"", "");


			alimento = new Alimento(idPlato, nombre, precio, tipo );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alimento;
	}



}