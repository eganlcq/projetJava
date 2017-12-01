package main.worlds;

import java.awt.Graphics;

import main.tiles.Tile;
import main.utils.Utils;

/**
 * Cette classe représente la map
 * @author Octikoros
 *
 */
public class WorldGUI{
	
	// La largeur de la map
	private int width;
	// La hauteur de la map
	private int height;
	// La grille comportant toutes les cases de la map
	private int[][] grid;

	public WorldGUI(String path) {
		loadWorld(path);
	}

	/**
	 * Affiche les éléments mis à jour
	 * @param g : l'espace graphique dans lequel la map va être dessinée
	 */
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
	
	/**
	 * @param x : la position horizontale de la case dans la grille
	 * @param y : la position verticale de la case dans la grille
	 * @return la case choisie dans la grille
	 */
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[grid[x][y]];
		if(t == null) {
			return Tile.backgroundTile;
		}
		return t;
	}
	
	/**
	 * Charge le monde en mémoire
	 * @param path : le chemin permettant d'accéder au fichier texte de la map
	 */
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] num = file.split("\\s+");
		width = Utils.parseInt(num[0]);
		height = Utils.parseInt(num[1]);
		
		grid = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				grid[x][y] = Utils.parseInt(num[(x + y * width) + 2]);
			}
		}
	}
	
}
