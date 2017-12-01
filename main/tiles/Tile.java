package main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Cette classe représente une case
 * @author Octikoros
 *
 */
public class Tile {
	
	// Tableau comportant tout les types de case
	public static Tile[] tiles = new Tile[4];
	
	// Initialisation de toutes les cases
	public static Tile backgroundTile = new BackGroundTile(0);
	public static Tile floorTile1 = new FloorTile1(1);
	public static Tile floorTile2 = new FloorTile2(2);
	public static Tile flagTile = new FlagTile(3);
	
	// Largeur d'une case
	public static final int TILEWIDTH = 25;
	// Hauteur d'une case
	public static final int TILEHEIGHT = 25;

	// La texture des cases
	protected BufferedImage texture;
	// L'id des cases
	protected final int id;
	
	/**
	 * Initialisation d'une nouvelle case
	 * @param texture : la texture de la case
	 * @param id : l'id de la case
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	/**
	 * Affiche les éléments mis à jour
	 * @param g : L'espace graphique sur lequel va être dessinée l'image
	 * @param x : la position horizontale de la case
	 * @param y : la postion verticale de la case
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	/**
	 * Vérifie si une case est solide ou non
	 * @return true si oui, false si non
	 */
	public boolean isSolid() {
		return false;
	}
	
	/**
	 * @return la valeur de l'id de la case
	 */
	public int getId() {
		return id;
	}
	
}
