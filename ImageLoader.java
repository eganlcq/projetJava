package main.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Cette classe permet de charger une image
 * @author Octikoros
 *
 */
public class ImageLoader {

	/**
	 * Charge une image
	 * @param path : le chemin menant à l'image
	 * @return l'image
	 */
	public static BufferedImage loadImage(String path) {
		try {
			// Trouve la ressource demandée grâce au chemin indiqué
			// Décode la ressource grâce à un ImageReader et renvoie l'image décodée
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			// Ferme le programme en indiquant une erreur
			System.exit(1);
		}
		// Ne renvoie rien si il y a eu une erreur
		return null;
	}
}
