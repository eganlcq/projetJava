package main.worlds;

import java.awt.Graphics;

import main.tiles.Tile;
import main.utils.Utils;
import model.Game;

/**
 * Cette classe représente le monde du jeu
 * @author Octikoros
 *
 */
public class World{
  
	// Le jeu comportant les données du monde
	private Game game;
	// La largeur du monde
	private int width;
	// La hauteur du monde
	private int height;
	// La grille comportant les cases du monde
	private int[][] grid;
	// La grille comportant les cases du monde en console
	private String[][] gridCon;
	// Variable permettant le sysout du monde en console
	private String mapCon = "";
  
	// L'id du monde
	private static int id = 0;
  
	/**
	 * Initialise un nouveau monde
	 * @param game : les données du monde
	 * @param path : le chemin d'accès au fichier texte
	 */
	public World(Game game, String path){
		this.game = game;  
		loadWorld(path);
		this.game.setWidth(width * Tile.TILEWIDTH);
		this.game.setHeight(height * Tile.TILEHEIGHT);
		
		game.setResult(game.getResult() + game.getScore());
		game.setScore(500);
    
		id++;
	}
  
	/**
	 * @param x : position horizontale dans la grille
	 * @param y : position verticale dans la grille
	 * @return la case correspondante à la position dans la grille
	 */
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[grid[x][y]];
		if(t == null) {
			return Tile.backgroundTile;
		}
		return t;
	}
  
	/**
	 * Affiche les éléments mis à jour
	 * @param g : espace graphique dans lequel on peut afficher du contenu
	 */
	public void renderGUI(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
  
	/**
	 * Affiche les éléments mis à jour en console
	 */
	public void renderCon(){
		mapCon = "";
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				mapCon = mapCon.concat(gridCon[x][y]);
			}
		}
		mapCon = mapCon.concat("\n\n");
		System.out.println(mapCon);
	}
  
	/**
	 * Charge les données du monde en mémoire
	 * @param path : le chemin d'accès au fichier texte
	 */
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] num = file.split("\\s+");
		width = Utils.parseInt(num[0]);
		height = Utils.parseInt(num[1]);
		
		grid = new int[width][height];
		gridCon = new String[width][height];
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				grid[x][y] = Utils.parseInt(num[(x + y * width) + 2]);
				if(num[(x + y * width) + 2].equals("0")) gridCon[x][y] = "[x]";
				else if(num[(x + y * width) + 2].equals("1") ||
						num[(x + y * width) + 2].equals("2")) gridCon[x][y] = "[_]";
				else if(num[(x + y * width) + 2].equals("3")) gridCon[x][y] = "[F]";
				if(x == width - 1) gridCon[x][y] = gridCon[x][y].concat("\n");
			}
		}
	}
  
	/**
	 * @return la grille comportant les cases en console
	 */
	public String[][] getGridCon(){
		return gridCon;	
	}
	
	/**
	 * @return l'id du monde
	 */
	public int getId() {
		return id;
	}
  
}
