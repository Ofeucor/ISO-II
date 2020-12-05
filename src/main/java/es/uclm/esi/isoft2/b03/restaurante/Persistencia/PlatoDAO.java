package es.uclm.esi.isoft2.b03.restaurante.Persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import es.uclm.esi.isoft2.b03.restaurante.Dominio.*;

public class PlatoDAO {

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
			System.out.println("NO FUSIONO");
		}
	}

	public void insertPlato(Plato plato) {
		// TODO - implement PlatoDAO.insertPlato
		throw new UnsupportedOperationException();
	}

	public Plato deletePlato(int idPlato) {
		// TODO - implement PlatoDAO.deletePlato
		throw new UnsupportedOperationException();
	}

	public Ingrediente[] getIngredientes(Plato plato) {
		// TODO - implement PlatoDAO.getIngredientes
		throw new UnsupportedOperationException();
	}

}