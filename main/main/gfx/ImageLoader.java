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
	 * @param path : le chemin menant � l'image
	 * @return l'image
	 */
	public static BufferedImage loadImage(String path) {
		try {
			// Trouve la ressource demand�e gr�ce au chemin indiqu�
			// D�code la ressource gr�ce � un ImageReader et renvoie l'image d�cod�e
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
