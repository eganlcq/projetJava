package main.worlds;

import java.awt.Graphics;

import main.tiles.Tile;
import main.utils.Utils;
import model.Game;

public class World{
  
  private int width;
  private int height;
  private int[][] grid;
  private String[][] gridCon;
  private String mapCon = "";
  private Game game;
  
  public World(Game game, String path){
    this.game = game;
    loadWorld(path);
  }
  
  public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[grid[x][y]];
		if(t == null) {
			return Tile.backgroundTile;
		}
		return t;
	}
  
  public void renderGUI(Graphics g) {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
  
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
  
  /*public boolean flagged() {
		return (grid[game.getPlayerCon().getX()][game.getPlayerCon().getY()].equals("F"));
	}*/
  
  public String[][] getGridCon(){
		return gridCon;	
	}
	
	public String getMapCon(){
		return mapCon;
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
	public int[][] getGrid(){
		return grid;
	}
  
}
