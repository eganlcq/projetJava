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
	public Player(Game game, float x, float y) {
		super(game, x, y, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
	}

	@Override
	/**
	 * Affiche les éléments mis à jour
	 */
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
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
		if(xMove > 0) {
			if(!collisionTile(tileXRight, tileYUp) && !collisionTile(tileXRight, tileYDown)) {
				x += xMove;
			}
			else {
				x = tileXRight * Tile.TILEWIDTH - hitbox.x - hitbox.width -1;
			}
		}
		// Mouvement à gauche
		else if(xMove < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXLeft, tileYDown)) {
				x += xMove;
			}
			else {
				x = tileXLeft * Tile.TILEWIDTH + Tile.TILEWIDTH - hitbox.x +1;
			}
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
		if(yMove > 0) {
			if(!collisionTile(tileXLeft, tileYDown) && !collisionTile(tileXRight, tileYDown)) {
				y += yMove;
			}
			else {
				y = tileYDown * Tile.TILEHEIGHT - hitbox.y - hitbox.height -1;
			}
		}
		// Mouvement vers le haut
		else if(yMove < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXRight, tileYUp)) {
				y += yMove;
			}
			else {
				y = tileYUp * Tile.TILEHEIGHT + Tile.TILEHEIGHT - hitbox.y +1;
			}
		}
	}

}
