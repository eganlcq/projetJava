package main.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Cette classe regroupe diverse fonctionnalit�s facilitant le codage d'autre classes
 * @author Octikoros
 *
 */
public class Utils {

	/**
	 * @param path : le chemin d'acc�s vers le fichier
	 * @return le contenu d'un fichier sous forme de string
	 */
	public static String loadFileAsString(String path) {
		// Permet de construire des cha�nes de caract�re
		StringBuilder builder = new StringBuilder();
		
		try {
			// G�n�re un flux consacr� � la lecture d'un fichier
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			// Tant que la ligne n'est pas termin�e
			while((line = br.readLine()) != null) {
				//aggr�gation de la variable line avec le contenu du fichier
				builder.append(line + "\n");
			}
			// Fermeture du flux consacr� � la lecture
			br.close();
		}catch(IOException e) {
			// V�rifie si il n'y a pas eu d'erreur de lecture
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	/**
	 * @param number : le num�ro "string" � mettre sous forme integer
	 * @return un string sous forme d'integer
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			// V�rifie si le format est bien celui d'un num�ro
			e.printStackTrace();
			return 0;
		}
	}
	
}