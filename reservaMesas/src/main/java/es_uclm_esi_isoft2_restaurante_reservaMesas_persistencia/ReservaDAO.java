package es_uclm_esi_isoft2_restaurante_reservaMesas_persistencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import es_uclm_esi_isoft2_restaurante_reservaMesas_dominio.*;

/**
 * lase encargada de hacer las peticiones a la base de datos correspondientes a la Reserva
 *
 */
public class ReservaDAO {
	
	/**
	 * Método para insertar una reserva en la base de datos
	 * @param reserva
	 * @param idRestaurante
	 * @throws IOException
	 */
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
	 * Método para eliminar una reserva en la base de datos
	 * @param idReserva
	 */
	public void deleteReserva(int idReserva) {
		// TODO - implement ReservaDAO.deleteReserva
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Método para pasar la información de la base de datos a un objeto del tipo Reserva
	 * @param r
	 * @return
	 */
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
	
	/**
	 * Método para obtener las reservar de un determinado restaurante
	 * @param idRestaurante
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Reserva> getReservas(int idRestaurante) throws IOException{
			URL obj = new URL("https://isoft2-2021-b03.000webhostapp.com/phpGetReservas.php");
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
			ArrayList <Reserva> reservas = new ArrayList <Reserva> ();
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
						reservas.add(stringToReserva(st.nextToken().replace("[", "").replace(",", " ")));
					}
				
			} else {
				System.out.println("Fallo al insertar reserva.");
			}

		return reservas;
	}

}