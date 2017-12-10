package main.gfx;

import java.awt.image.BufferedImage;

/**
 * Permet d'effectuer des op�rations sur les images et les musiques
 * @author Octikoros
 *
 */
public class Assets {
	
	// La largeur des sprites � d�couper
	private static final int width = 64;
	// La hauteur des sprites � d�couper
	private static final int height = 64;
	
	// Repr�sente les sprite � utiliser
	public static BufferedImage player;
	public static BufferedImage tile1;
	public static BufferedImage tile2;
	public static BufferedImage background;
	public static BufferedImage mob;
	public static BufferedImage flag;
	
	public static BufferedImage end;

	/**
	 * Permet de ne charger le contenu qu'une seule fois
	 * Permet d'�viter � la machine d'effectuer du travail inutile
	 */
	public static void init() {
		// Initialisation de nouvelles sprite sheet contenant une image
		SpriteSheet texture = new SpriteSheet(ImageLoader.loadImage("/textures/texture.png"));
		
		// Cr�ation de sprites
		player = texture.crop(0, 0, width, height);
		tile1 = texture.crop(width, 0, width, height);
		tile2 = texture.crop(width * 2, 0, width, height);
		background = texture.crop(width * 3, 0, width, height);
		mob = texture.crop(width * 4, 0, width, height);
		flag = texture.crop(width * 5, 0, width, height);
	}
}
