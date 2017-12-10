package main.entities;

import java.awt.Graphics;

import main.gfx.Assets;
import main.tiles.Tile;
import model.Game;

/**
 * Cette classe repr�sente un joueur
 * @author Octikoros
 *
 */
public class Player extends MobileEntity{
	
	/**
	 * Initialisation d'un nouveau joueur
	 * @param x : abscisse
	 * @param y : ordonn�e
	 */
	public Player(Game game, int positionX, int positionY) {
		super(game, positionX, positionY, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
		game.getWorld().getGridCon()[startXCon][startYCon] = "[P]";
	}

	@Override
	/**
	 * Affiche les �l�ments mis � jour
	 */
	public void renderGUI(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}
  
	/**
	 * Affiche les �l�ments mis � jour en console
	 */
	public void renderCon(){
		game.getWorld().getGridCon()[xCon][yCon] = "[P]";
	}
  
	/**
	 * Permet de changer la position du joueur
	 */
	public void move(){
		moveX();
		moveY();
		for(Mob mob : game.getList().getArrayMob()) {
			if(collisionEntity(mob)) restart();
		}
	}
	
	/**
	 * G�re le d�placement horizontal du joueur
	 */
	public void moveX() {
		centerX = (int) (x + xMove + (hitbox.x / 2) + (hitbox.y / 2)) / Tile.TILEWIDTH;
		centerY = (int) (y + (hitbox.x / 2) + (hitbox.y / 2)) / Tile.TILEHEIGHT;
		// Mouvement � droite
		if(xMove > 0 || xMoveCon > 0) {
			if(!collisionTile(centerX, centerY)) {
				x += xMove;
			}
			movexCon();
		}
		// Mouvement � gauche
		else if(xMove < 0 || xMoveCon < 0) {
			if(!collisionTile(centerX, centerY)) {
				x += xMove;
			}
			movexCon();
		}
	}
	
	/**
	 * G�re le d�placement vertical du joueur
	 */
	public void moveY() {
		centerX = (int) (x +(hitbox.x / 2) + (hitbox.y / 2)) / Tile.TILEWIDTH;
		centerY = (int) (y + yMove + (hitbox.x / 2) + (hitbox.y / 2)) / Tile.TILEHEIGHT;
		// Mouvement vers le bas
		if(yMove > 0 || yMoveCon > 0) {
			if(!collisionTile(centerX, centerY)) {
				y += yMove;
			}
			moveyCon();
		}
		// Mouvement vers le haut
		else if(yMove < 0 || yMoveCon < 0) {
			if(!collisionTile(centerX, centerY)) {
				y += yMove;
			}
			moveyCon();
		}
	}
  
	/**
	 * G�re le d�placement horizontal du joueur en console
	 */
	public void movexCon(){
		game.getWorld().getGridCon()[xCon][yCon] = "[_]";
		xCon += xMoveCon;
		if(collisionTileCon()) xCon -= xMoveCon;
		if(collisionEntityCon()) restart();
	}
  
	/**
	 * G�re le d�placement vertical du joueur en console 
	 */
	public void moveyCon(){
		game.getWorld().getGridCon()[xCon][yCon] = "[_]";
		yCon += yMoveCon;
		if(collisionTileCon()) yCon -= yMoveCon;
		if(collisionEntityCon()) restart();
	}
  
	/**
	 * R�initialise la postion du joueur
	 */
	public void restart(){
		x = startX;
		y = startY;
		game.getWorld().getGridCon()[xCon][yCon] = "[_]";
		xCon = startXCon;
		yCon = startYCon;
	}

	/**
	 * @return la valeur du centre horizontal du joueur
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @return la valeur du centre vertical du joueur
	 */
	public int getCenterY() {
		return centerY;
	}
}
