package es_uclm_esi_isoft2_restaurante_pedidoComandas_persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import es_uclm_esi_isoft2_restaurante_pedidoComandas_dominio.*;
import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.Reserva;

public class ComandaDAO {

	/**
	 * 
	 * @param comanda
	 * @throws IOException 
	 */
	public static void insertComanda(int id_Comanda, int id_Mesa, int id_Restaurante, int id_Plato, int cantidad) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertComandaId.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();
		
		directConnection.write(("Id_Comanda=" + id_Comanda + "&Id_Mesa=" + id_Mesa + "&Id_Restaurante=" + id_Restaurante +
				"&Id_Plato=" + id_Plato + "&Cantidad=" + cantidad)
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
			System.out.println("Fallo al insertar reserva.");
		}
	}
	
	public static int insertComanda(int id_Mesa, int id_Restaurante, int id_Plato, int cantidad) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertComanda.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();
		
		directConnection.write(("Id_Mesa=" + id_Mesa + "&Id_Restaurante=" + id_Restaurante +
				"&Id_Plato=" + id_Plato + "&Cantidad=" + cantidad)
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
			
			return Integer.parseInt(response.toString().split(":")[1]);
		} else {
			System.out.println("Fallo al insertar reserva.");
		}
		return -1;
	}

	/**
	 * 
	 * @param idComanda
	 */
	public Comanda getComanda(int idComanda) {
		throw new UnsupportedOperationException();
	}
	
	

	/**
	 * 
	 * @param idComanda
	 */
	public void deleteComanda(int idComanda) {
		// TODO - implement ComandaDAO.deleteComanda
		throw new UnsupportedOperationException();
	}

}