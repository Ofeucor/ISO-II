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
import java.util.Date;
import java.util.StringTokenizer;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

public class MesaDAO {

	/**
	 * 
	 * @param idRestaurante
	 */
	public static ArrayList<Mesa> getMesas(int idRestaurante) throws IOException{
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
		ArrayList <Mesa> mesas = new ArrayList <Mesa> ();
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
			System.out.println("Fallo al obtener las mesas.");
		}

		return mesas;
	}
	
	public static Mesa getMesa(int idMesa, int idRestaurante) throws IOException{		
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
		
		Mesa mesa=null;
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
					mesa = stringToMesa(st.nextToken().replace("[", "").replace(",", " "));
				}
			
		} else {
			System.out.println("Fallo al obtener la mesa con id: " + idMesa);
		}

		return mesa;
	}
	
	public static void asignarMesa(int idMesa, String idCamarero, int idRestaurante) throws IOException{		
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpAsignarMesa.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Mesa=" + idMesa + "&Id_Restaurante=" + idRestaurante + "&Id_Camarero=" + idCamarero).getBytes());
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
			System.out.println("Fallo al obtener la mesa con id: " + idMesa);
		}

	}
	
	

	/**
	 * @throws IOException 
	 * @throws  
	 * 
	 * @param idRestaurante
	 * @throws  
	 */
	/*public ArrayList<Mesa> getMesasReservadas(int idRestaurante) throws IOException{
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetMesasReservadas.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();

		directConnection.write(("Id_Restaurante=" + idRestaurante).getBytes());
		directConnection.flush();
		directConnection.close();
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);
		ArrayList <Mesa> mesas = new ArrayList <Mesa> ();
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

		return null;
	}*/
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
		System.out.println("POST Response Code :: " + responseCode);
		ArrayList <Mesa> mesas = new ArrayList <Mesa> ();
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

	private static Mesa stringToMesa(String r) {
		Mesa mesa=null;
		
		StringTokenizer st = new StringTokenizer(r, " ");

		try {
			int estado=-1;
			int idMesa = Integer.parseInt(st.nextToken().replace("\"", ""));
			String estadoString = st.nextToken().replace("\"", "");
			int numSillas = Integer.parseInt(st.nextToken().replace("\"", ""));
			int idRestaurante = Integer.parseInt(st.nextToken().replace("\"", ""));
			
			switch(estadoString) {
				case "Libre": estado=0; break;
				case "Reservada": estado=1; break;
				case "Ocupada": estado=2; break;
				case "Pidiendo": estado=3; break;
				case "EsperandoComida": estado=4; break;
				case "Servidos": estado=5; break;
				case "EsperandoCuenta": estado=6; break;
				case "Pagando": estado=7; break;
				case "Preparando": estado=8; break;
			
			}

			mesa = new Mesa(idMesa, estado, numSillas);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mesa;
	}

}