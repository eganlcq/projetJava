package main.gfx;

import java.awt.image.BufferedImage;

/**
 * Cette classe permet de créer des sprite à partir d'une sprite sheet
 * @author Octikoros
 *
 */
public class SpriteSheet {

	// Contient tout ce qui est images
	private BufferedImage sheet;
	
	/**
	 * Initialise une nouvelle image
	 * @param sheet : l'image
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	/**
	 * @param x : l'axe des abscisse (de gauche à droite)
	 * @param y : l'axe des ordonnées (de haut en bas)
	 * @param width : la largeur de l'image découpée
	 * @param height : la hauteur de l'image découpée
	 * @return une partie de l'image utilisée
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		// Renvoie une partie de l'image de base
		return sheet.getSubimage(x, y, width, height);
	}
}
