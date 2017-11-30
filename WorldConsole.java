package main.worlds;

import main.console.MobConsole;
import main.utils.Utils;
import model.Game;

/**
 * Cette classe représente la map générée en console
 * @author Octikoros
 *
 */
public class WorldConsole{
	
	// La largeur de la map
	private int width;
	// La hauteur de la map
	private int height;
	// Tableau comportant toutes les cases de la map
	private String[][] grid;
	// Le jeu dans lequel la map va se générer
	private Game game;
	
	private static int id = 0;
	
	/**
	 * Initialisation d'une nouvelle map
	 * @param game : le jeu dans lequel la map va se générer
	 * @param path : le chemin permettant d'accéder au fichier texte de la map
	 */
	public WorldConsole(Game game, String path) {
		this.game = game;
		loadWorld(path);
		
		id++;
	}
	
	/**
	 * Affiche les éléments mis à jour
	 */
	public void render() {
		System.out.println(generateWorld());
	}
	
	/**
	 * Charge le monde en mémoire
	 * @param path : le chemin permettant d'accéder au fichier texte de la map
	 */
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] num = file.split(" ");
		width = Utils.parseInt(num[0]);
		height = Utils.parseInt(num[1]);
		
		grid = new String[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				grid[x][y] = num[(x + y * width) + 2];
			}
		}
		
		grid[game.getPlayerCon().getX()][game.getPlayerCon().getY()] = "P";
		for(MobConsole mob : game.getArrayList()) {
			grid[mob.getX()][mob.getY()] = "O";
		}
	}
	
	/**
	 * @return la map générée
	 */
	public String generateWorld() {
		String map = "";
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				map = map.concat(grid[x][y]);
			}
		}
		return map;
	}
	
	/**
	 * Vérifie les collisions avec un mur
	 * @return true si oui, false si non
	 */
	public boolean notWalkable() {
		return (grid[game.getPlayerCon().getX()][game.getPlayerCon().getY()].equals("x"));
	}
	
	/**
	 * Vérifie la collision avec la case d'arrivée
	 * @return true si oui, false si non
	 */
	public boolean flagged() {
		return (grid[game.getPlayerCon().getX()][game.getPlayerCon().getY()].equals("F"));
	}
	
	/**
	 * @return la valeur de la largeur de la map
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return la valeur de la largeur de la map
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return la grille comportant toute les cases de la map
	 */
	public String[][] getGrid(){
		return grid;
	}
	
	public int getId() {
		return id;
	}
	
}

