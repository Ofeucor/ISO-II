package es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

/**
 * Clase encargada de hacer las peticiones a la base de datos correspondientes a
 * la Mesa
 * 
 */
public class MesaDAO {
	/**
	 * Método para obtener todas las mesas de un restaurante
	 * 
	 * @param idRestaurante
	 * @throws IOException
	 */
	public static ArrayList<Mesa> getMesas(int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesas.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("IdRestaurante=" + idRestaurante).getBytes());
		directConnection.flush();
		directConnection.close();
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			// System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					mesas.add(stringToMesa(st.nextToken().replace("[", "").replace(",", " ")));
				}

		} else {
			System.out.println("Fallo al obtener las mesas.");
		}

		return mesas;
	}

	/**
	 * Método para obtener una mesa concreta
	 * 
	 * @param idMesa
	 * @param idRestaurante
	 * @return
	 * @throws IOException
	 */
	public static Mesa getMesa(int idMesa, int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesa.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("IdRestaurante=" + idRestaurante + "&Id=" + idMesa).getBytes());
		directConnection.flush();
		directConnection.close();
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		Mesa mesa = null;
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			// System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					mesa = stringToMesa(st.nextToken().replace("[", "").replace(",", " "));
				}

		} else {
			System.out.println("Fallo al obtener la mesa con id: " + idMesa);
		}

		return mesa;
	}

	/**
	 * Método para asignar una mesa
	 * 
	 * @param idMesa
	 * @param idCamarero
	 * @param idRestaurante
	 * @throws IOException
	 */
	public static void asignarMesa(int idMesa, String idCamarero, int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpAsignarMesa.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(
				("Id_Mesa=" + idMesa + "&Id_Restaurante=" + idRestaurante + "&Id_Camarero=" + idCamarero).getBytes());
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
			//System.out.println(response.toString());

		} else {
			System.out.println("Fallo al obtener la mesa con id: " + idMesa);
		}

	}

	/*
	 * public ArrayList<Mesa> getMesasReservadas(int idRestaurante) throws
	 * IOException{ URL obj = new
	 * URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesasReservadas.php");
	 * HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 * con.setRequestMethod("POST"); con.setRequestProperty("User-Agent",
	 * "Mozilla/5.0"); con.setDoOutput(true);
	 * 
	 * OutputStream directConnection = con.getOutputStream();
	 * 
	 * directConnection.write(("Id_Restaurante=" + idRestaurante).getBytes());
	 * directConnection.flush(); directConnection.close(); int responseCode =
	 * con.getResponseCode(); System.out.println("POST Response Code :: " +
	 * responseCode); ArrayList <Mesa> mesas = new ArrayList <Mesa> (); if
	 * (responseCode == HttpURLConnection.HTTP_OK) { // success BufferedReader in =
	 * new BufferedReader(new InputStreamReader(con.getInputStream())); String
	 * inputLine; StringBuffer response = new StringBuffer();
	 * 
	 * while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	 * 
	 * in.close(); //System.out.println(response.toString()); StringTokenizer st =
	 * new StringTokenizer(response.toString(), "]");
	 * 
	 * if (!response.toString().equals("[]")) while (st.hasMoreTokens()) {
	 * mesas.add(stringToMesa(st.nextToken().replace("[", "").replace(",", " "))); }
	 * 
	 * } else { System.out.println("Fallo al insertar reserva."); }
	 * 
	 * return null; }
	 */

	/**
	 * Metodo que devuelve las mesas asignadas
	 * @param idRestaurante
	 * @param idCamarero
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Mesa> getMesasAsignadas(int idRestaurante, String idCamarero) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesasAsignadas.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Restaurante=" + idRestaurante + "&Id_Camarero=" + idCamarero).getBytes());
		directConnection.flush();
		directConnection.close();
		int responseCode = con.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			//System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					mesas.add(stringToMesa(st.nextToken().replace("[", "").replace(",", " ")));
				}

		} else {
			System.out.println("Fallo al insertar reserva.");
		}

		return mesas;
	}

	/**
	 * Método para obtener las mesas libres de un restaurante determinado
	 * 
	 * @param idRestaurante
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Mesa> getMesasLibres(int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesasLibres.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Restaurante=" + idRestaurante).getBytes());
		directConnection.flush();
		directConnection.close();
		int responseCode = con.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
		ArrayList<Mesa> mesas = new ArrayList<Mesa>();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
			// System.out.println(response.toString());
			StringTokenizer st = new StringTokenizer(response.toString(), "]");

			if (!response.toString().equals("[]"))
				while (st.hasMoreTokens()) {
					mesas.add(stringToMesa(st.nextToken().replace("[", "").replace(",", " ")));
				}

		} else {
			System.out.println("Fallo al insertar reserva.");
		}

		return mesas;
	}

	/**
	 * Método para pasar la información de la base de datos a un objeto del tipo
	 * Mesa
	 * 
	 * @param r
	 * @return
	 */
	private static Mesa stringToMesa(String r) {
		Mesa mesa = null;

		StringTokenizer st = new StringTokenizer(r, " ");

		try {
			int estado = -1;
			int idMesa = Integer.parseInt(st.nextToken().replace("\"", ""));
			String estadoString = st.nextToken().replace("\"", "");
			int numSillas = Integer.parseInt(st.nextToken().replace("\"", ""));
			int idRestaurante = Integer.parseInt(st.nextToken().replace("\"", ""));

			switch (estadoString) {
			case "Libre":
				estado = 0;
				break;
			case "Reservada":
				estado = 1;
				break;
			case "Ocupada":
				estado = 2;
				break;
			case "Pidiendo":
				estado = 3;
				break;
			case "EsperandoComida":
				estado = 4;
				break;
			case "Servidos":
				estado = 5;
				break;
			case "EsperandoCuenta":
				estado = 6;
				break;
			case "Pagando":
				estado = 7;
				break;
			case "Preparando":
				estado = 8;
				break;

			}

			mesa = new Mesa(idMesa, estado, numSillas);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mesa;
	}

	public static int atender(Mesa mesa, int comensales, int id_Restaurante, String id_Camarero) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpAtender.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		String fecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());

		directConnection.write(("Id_Mesa=" + mesa.getIdMesa() + "&Id_Restaurante=" + id_Restaurante + "&Id_Camarero="
				+ id_Camarero + "&Comensales=" + comensales + "&Fecha=" + fecha).getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
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

			return Integer.parseInt(response.toString().split(":")[1]);
		} else {
			System.out.println("NO FUNCIONÃ“");
			return -1;
		}
	}

	public static int finalizarAtender(Mesa mesa, int comensales, int id_Restaurante, String id_Camarero,
			int id_Registro) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpAtenderFin.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		String fecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());

		directConnection.write(
				("Id_Mesa=" + mesa.getIdMesa() + "&Id_Restaurante=" + id_Restaurante + "&Id_Camarero=" + id_Camarero
						+ "&Comensales=" + comensales + "&Fecha=" + fecha + "&Id_Registro=" + id_Registro).getBytes());
		directConnection.flush();
		directConnection.close();

		int responseCode = con.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
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

			return Integer.parseInt(response.toString().split(":")[1]);
		} else {
			System.out.println("NO FUNCIONÃ“");
			return -1;
		}
	}

}