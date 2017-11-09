package main.worlds;

import java.awt.Graphics;

import main.Handler;
import main.tiles.Tile;
import main.utils.Utils;

/**
 * Cette classe représente le monde dans lequel le joueur avancera
 * @author Octikoros
 *
 */
public class World {

	// Handler comportante les données de jeu 
	// Permet d'entrer dans le fil d'exéction courant du jeu
	private Handler handler;
	// La largeur du monde
	private int width;
	// La hauteur du monde
	private int height;
	// La position horizontale où va démarrer le joueur
	private int spawnX;
	// La position verticale où va démarrer le joueur
	private int spawnY;
	// Représente la grille sur laquelle les cases vont être placées
	private int [][] grid;
	
	/**
	 * Initialise le monde dans lequel le joueur avancera
	 * @param path : le chemin où se trouve le monde dans les fichiers
	 */
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	 /**
	  * Met à jour divers éléments
	  */
	public void update() {
		
	}
	
	/**
	 * Affiche à l'écran les éléments mis à jour
	 * @param g : l'espace graphique dans lequel l'élément va être affiché
	 */
	public void render(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x, y);
			}
		}
	}
	
	/**
	 * @param x : la position horizontale demandée dans la grille
	 * @param y : la position verticale demandée dans la grille
	 * @return une case spécifique
	 */
	public Tile getTile(int x, int y) {
		// La variable t contiendra la case se trouvant à la position demandée
		Tile t = Tile.tiles[grid[x][y]];
		// Si la case n'existe pas à cet endroit, t vaudra une case d'herbe
		if(t == null) return Tile.backgroundTile;
		return t;
	}
	
	/**
	 * Charge le monde en mémoire
	 * @param path : le chemin où se trouve le monde dans les fichiers
	 */
	public void loadWorld(String path) {
		// Initialise la variable file avec le contenu d'un fichier
		String file = Utils.loadFileAsString(path);
		// Place chaque élément séparés d'un espace dans une case du tableau
		String[] tokens = file.split("\\s+");
		// La largeur vaut le premier élément du tableau
		width = Utils.parseInt(tokens[0]);
		// La hauteur vaut le deuxième élément du tableau
		height = Utils.parseInt(tokens[1]);
		// Le spawn horizontal du joueur vaut le 3ème élément du tableau
		spawnX = Utils.parseInt(tokens[2]);
		// Le spawn vertical du joueur vaut le 4ème élément du tableau
		spawnY = Utils.parseInt(tokens[3]);
		
		// Initialisation de la grille représentant le niveau
		grid = new int[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++){
				grid[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
}
