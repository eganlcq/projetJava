package main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Cette classe représente une case du jeu
 * @author Octikoros
 *
 */
public class Tile {
	
	// Représente un tableau de toute les case que contiendra le jeu
	public static Tile[] tiles = new Tile[256];
	// Initialisation de nouvelles cases
	public static Tile backgroundTile = new BackgroundTile(0);
	public static Tile floorTile1 = new FloorTile1(1);
	public static Tile florrTile2 = new FloorTile2(2);
	
	// La largeur de base de chaque case
	public static final int TILEWIDTH = 25;
	// La hauteur de base de chaque case
	public static final int TILEHEIGHT = 25;

	// Déclaration d'une image
	protected BufferedImage texture;
	// Id de la case créée, permet de l'identifier
	protected final int id;
	
	/**
	 * Initialise une nouvelle case du jeu
	 * @param texture : l'image utilisée
	 * @param id : l'id de la case nouvellement créée
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	/**
	 * Met à jour divers éléments
	 */
	public void update() {
		
	}
	
	/**
	 * Affiche les éléments mis à jour
	 * @param g : l'espace graphique dans lequel le contenu va être affiché
	 * @param x : la position où la case va être affichée horizontalement
	 * @param y : la position où la case va être affichée verticalement
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x * TILEWIDTH, y * TILEHEIGHT, TILEWIDTH, TILEHEIGHT, null);
	}
	
	/**
	 * Détermine si la case est traversable ou non
	 * Une case est traversable de base
	 * @return
	 */
	public boolean isSolid() {
		return false;
	}
	
	/**
	 * @return l'id de la case
	 */
	public int getId() {
		return id;
	}
	
}
