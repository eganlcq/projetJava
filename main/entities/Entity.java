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

	// Le jeu faisant tourner l'entité
	protected Game game;
	// La position horizontale de l'entité
	protected float x;
	// La position verticale de l'entité
	protected float y;
	// La largeur de l'entité
	protected int width;
	// La hauteur de l'entité
	protected int height;
	// La hitbox de l'entité
	protected Rectangle hitbox;
	// La position horizontale de départ de l'entité
	protected int startX;
	// La postion verticale de départ de l'entité
	protected int startY;
	
	// La postion horizontale en console de l'entité
	public int xCon;
	// La postion verticale en console de l'entité
	public int yCon;
	// La position horizontale de départ en console de l'entité
	protected int startXCon;
	// La postion verticale de départ en console de l'entité
	protected int startYCon;
	
	/**
	 * Initialisation d'une nouvelle entité
	 * @param x : l'abscisse
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
	
	/*
	 * renvoie la hitbox de l'entité
	 */
	public Rectangle getHitbox() {
		return new Rectangle((int) (x + hitbox.x), (int) (y + hitbox.y), hitbox.width, hitbox.height);
	}
	
	/**
	 * Affiche les éléments mis à jour
	 * @param g : espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void renderGUI(Graphics g);
	
	/*
	 * Affiche les éléments mis à jour en console
	 */
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

	/**
	 * @return la valeur de la position horizontale en console
	 */
	public int getxCon() {
		return xCon;
	}

	/**
	 * @return la valeur de la position verticale en console
	 */
	public int getyCon() {
		return yCon;
	}

	
}
