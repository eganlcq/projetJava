package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.tiles.Tile;
import model.Game;

/**
 * Cette classe représente une entité
 * @author Octikoros
 *
 */
public abstract class Entity {

	protected Game game;
	// La position horizontale de l'entité
	protected float x;
	// La position verticale de l'entité
	protected float y;
	// La largeur de l'entité
	protected int width;
	// La hauteur de l'entité
	protected int height;
	protected Rectangle hitbox;
	protected final int startX;
	protected final int startY;
	
	public int xCon;
	public int yCon;
	protected final int startXCon;
	protected final int startYCon;
	
	/**
	 * Initialisation d'une nouvelle entité
	 * @param x : l'absisse
	 * @param y : l'ordonnée
	 * @param width : la largeur
	 * @param height : la hauteur
	 */
	public Entity(Game game, int startX, int startY, int width, int height) {
		hitbox = new Rectangle(0, 0, width, height);
		
		this.game = game;
		this.startX = startX * Tile.TILEWIDTH + (Tile.TILEWIDTH / 2) - (hitbox.width / 2);
		this.startY = startY * Tile.TILEHEIGHT + (Tile.TILEHEIGHT / 2) - (hitbox.height / 2);
		this.x = this.startX;
		this.y = this.startY;
		this.width = width;
		this.height = height;
		
		this.startXCon = startX;
		this.startYCon = startY;
		this.xCon = this.startXCon;
		this.yCon = this.startYCon;
	}
	
	public Rectangle getHitbox() {
		return new Rectangle((int) (x + hitbox.x), (int) (y + hitbox.y), hitbox.width, hitbox.height);
	}
	
	/**
	 * Affiche les éléments mis à jour
	 * @param g : espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void renderGUI(Graphics g);
	
	public abstract void renderCon();

	/**
	 * @return la valeur de la position horizontale de l'entité
	 */
	public float getX() {
		return x;
	}

	/**
	 * Change la valeur de x
	 * @param x : position horizontale de l'entité
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return la valeur de la position verticale de l'entité
	 */
	public float getY() {
		return y;
	}

	/**
	 * Change la valeur de y
	 * @param y : position verticale de l'entité
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	public int getxCon() {
		return xCon;
	}

	public void setxCon(int xCon) {
		this.xCon = xCon;
	}

	public int getyCon() {
		return yCon;
	}

	public void setyCon(int yCon) {
		this.yCon = yCon;
	}

	public int getStartX() {
		return startX;
	}
	
	public int getStartY() {
		return startY;
	}
	
	public int getStartXCon() {
		return startXCon;
	}
	
	public int getStartYCon() {
		return startYCon;
	}
}
