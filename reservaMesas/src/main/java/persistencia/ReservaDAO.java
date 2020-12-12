package persistencia;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

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
		
		System.out.println(reserva.getFecha());
		Date fecha = reserva.getFecha();
		String cliente = reserva.getDatosCliente();
		int mesa = 2;

		directConnection.write(("Fecha=" + fecha + "&Cliente=" + cliente + "&idRestaurante=" + idRestaurante + "&idMesa=" +mesa)
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

}