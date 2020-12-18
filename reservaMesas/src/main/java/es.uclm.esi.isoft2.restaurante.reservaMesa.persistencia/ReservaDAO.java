package es.uclm.esi.isoft2.restaurante.reservaMesa.persistencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import dominio.*;

public class ReservaDAO {

	/**
	 * 
	 * @param reserva
	 * @param idRestaurante
	 * @throws IOException 
	 */
	//public ReservaDAO() {};
	public static void insertReserva(Reserva reserva, int idRestaurante) throws IOException {
		URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpInsertReserva.php");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setDoOutput(true);

		OutputStream directConnection = con.getOutputStream();
		
		String fecha= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(reserva.getFecha());

		System.out.println("Fecha: " + fecha );

		directConnection.write(("Fecha=" + fecha + "&Cliente=" + reserva.getDatosCliente() + "&idRestaurante=" + idRestaurante)
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

	/**
	 * 
	 * @param idReserva
	 */
	public void deleteReserva(int idReserva) {
		// TODO - implement ReservaDAO.deleteReserva
		throw new UnsupportedOperationException();
	}
	
	private static Reserva stringToReserva(String r) {
		Reserva reserva =null;
		
		StringTokenizer st = new StringTokenizer(r, " ");

		try {
			int idReserva = Integer.parseInt(st.nextToken().replace("\"", ""));
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse((st.nextToken().replace("\"", "")
					+  " " + st.nextToken().replace("\"", "")));
			String Cliente = st.nextToken().replace("\"", "");
			int idRestaurante = Integer.parseInt(st.nextToken().replace("\"", ""));
			
			reserva = new Reserva(idReserva, date, Cliente);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reserva;
	}

}