package Game;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Pattern;


public class GrilleStore {
	
	private static String requestUrl = "http://www.sudoku-api.appspot.com/";
	
	public static int[][] choixGrille(Difficulte dif){
		String request = null;
		switch (dif) {
			case FACILE: request = "req=facile"; break;
			case MOYEN: request = "req=moyen"; break;
			case DIFFICILE: request = "req=difficile"; break;
		}
		
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestUrl);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			connection.setRequestProperty("Content-Length", Integer.toString(request.getBytes().length));
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			// Send
			DataOutputStream dos = new DataOutputStream(
					connection.getOutputStream());
			dos.writeBytes(request);
			dos.close();
			
			// Receive
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String response = new String();
			String line;
			
			while((line = br.readLine()) != null) {
				response += line;
				response += '\r';
			}
			br.close();
			return stringToGrille(response);
		} catch (Exception e) {
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		
		return null;
		
	}
	
	private static int[][] stringToGrille(String response) {
		int[][] grille = new int[9][9];
		String formatResponse = response.replaceAll(" ", "")
				.replaceAll(",", "")
				.replaceAll("]", " ")
				.replaceAll(Pattern.quote("["), "")
				.substring(0, 89);
		String[] lignes = formatResponse.split(" ");
		
		for (int i=0; i<lignes.length; i++) {
			String ligne = lignes[i];
			String[] colonnes = Arrays.copyOfRange(ligne.split(""), 1, ligne.split("").length);
			
			for (int j=0; j<colonnes.length; j++) {
				int colonne = Integer.parseInt(colonnes[j]);
				grille[i][j] = colonne;
			}
		}
		return grille;
	}	
	
}