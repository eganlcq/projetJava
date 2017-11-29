package main.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Cette classe regroupe diverse fonctionnalités facilitant le codage d'autre classes
 * @author Octikoros
 *
 */
public class Utils {

	/**
	 * @param path : le chemin d'accès vers le fichier
	 * @return le contenu d'un fichier sous forme de string
	 */
	public static String loadFileAsString(String path) {
		// Permet de construire des chaînes de caractère
		StringBuilder builder = new StringBuilder();
		
		try {
			// Génère un flux consacré à la lecture d'un fichier
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			// Tant que la ligne n'est pas terminée
			while((line = br.readLine()) != null) {
				//aggrégation de la variable line avec le contenu du fichier
				builder.append(line + "\n");
			}
			// Fermeture du flux consacré à la lecture
			br.close();
		}catch(IOException e) {
			// Vérifie si il n'y a pas eu d'erreur de lecture
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	/**
	 * @param number : le numéro "string" à mettre sous forme integer
	 * @return un string sous forme d'integer
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			// Vérifie si le format est bien celui d'un numéro
			e.printStackTrace();
			return 0;
		}
	}
	
}