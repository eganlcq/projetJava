package main.entities;

import java.awt.Graphics;

import main.gfx.Assets;
import main.tiles.Tile;
import model.Game;

/**
 * Cette classe représente un joueur
 * @author Octikoros
 *
 */
public class Player extends MobileEntity{

	/**
	 * Initialisation d'un nouveau joueur
	 * @param x : abscisse
	 * @param y : ordonnée
	 */
	public Player(Game game, int positionX, int positionY) {
		super(game, positionX, positionY, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
		game.getWorld().getGridCon()[startXCon][startYCon] = "[P]";
	}

	@Override
	/**
	 * Affiche les éléments mis à jour
	 */
	public void renderGUI(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}
  
  public void renderCon(){
    game.getWorld().getGridCon()[xCon][yCon] = "[P]";
  }
  
  public void move(){
    moveX();
    moveY();
  }
	
	/**
	 * Gère le déplacement horizontal du joueur
	 */
	public void moveX() {
		int tileXLeft = (int) (x + xMove + hitbox.x) / Tile.TILEWIDTH;
		int tileXRight = (int) (x + xMove + hitbox.x + hitbox.width) / Tile.TILEWIDTH;
		int tileYUp = (int) (y + hitbox.y) / Tile.TILEHEIGHT;
		int tileYDown = (int) (y + hitbox.y + hitbox.width) / Tile.TILEHEIGHT;
		// Mouvement à droite
		if(xMove > 0 && xMoveCon > 0) {
			if(!collisionTile(tileXRight, tileYUp) && !collisionTile(tileXRight, tileYDown)) {
				x += xMove;
			}
			movexCon();
		}
		// Mouvement à gauche
		else if(xMove < 0 && xMoveCon < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXLeft, tileYDown)) {
				x += xMove;
			}
			movexCon();
		}
	}
	
	/**
	 * Gère le déplacement vertical du joueur
	 */
	public void moveY() {
		int tileXLeft = (int) (x + hitbox.x -1) / Tile.TILEWIDTH;
		int tileXRight = (int) (x + hitbox.x + hitbox.width -1) / Tile.TILEWIDTH;
		int tileYUp = (int) (y + yMove + hitbox.y -1) / Tile.TILEHEIGHT;
		int tileYDown = (int) (y + yMove + hitbox.y + hitbox.width -1) / Tile.TILEHEIGHT;
		// Mouvement vers le bas
		if(yMove > 0 && yMoveCon > 0) {
			if(!collisionTile(tileXLeft, tileYDown) && !collisionTile(tileXRight, tileYDown)) {
				y += yMove;
			}
			moveyCon();
		}
		// Mouvement vers le haut
		else if(yMove < 0 && yMoveCon < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXRight, tileYUp)) {
				y += yMove;
			}
			moveyCon();
		}
	}
  
  public void movexCon(){
    game.getWorld().getGridCon()[xCon][yCon] = "[_]";
	xCon += xMoveCon;
	if(collisionTileCon()) xCon -= xMoveCon;
	game.getWorld().getGridCon()[xCon][yCon] = "[P]";
  }
  
  public void moveyCon(){
    game.getWorld().getGridCon()[xCon][yCon] = "[_]";
	yCon += yMoveCon;
	if(collisionTileCon()) yCon -= yMoveCon;
	game.getWorld().getGridCon()[xCon][yCon] = "[P]";
  }
  
  public void restart(){
    x = startX;
	y = startY;
	game.getWorld().getGridCon()[xCon][yCon] = "[_]";
	xCon = startXCon;
	yCon = startYCon;
  }

}
