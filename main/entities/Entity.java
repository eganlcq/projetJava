package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.tiles.Tile;
import model.Game;

/**
 * Cette classe repr�sente une entit�
 * @author Octikoros
 *
 */
public abstract class Entity {

	// Le jeu faisant tourner l'entit�
	protected Game game;
	// La position horizontale de l'entit�
	protected float x;
	// La position verticale de l'entit�
	protected float y;
	// La largeur de l'entit�
	protected int width;
	// La hauteur de l'entit�
	protected int height;
	// La hitbox de l'entit�
	protected Rectangle hitbox;
	// La position horizontale de d�part de l'entit�
	protected int startX;
	// La postion verticale de d�part de l'entit�
	protected int startY;
	
	// La postion horizontale en console de l'entit�
	public int xCon;
	// La postion verticale en console de l'entit�
	public int yCon;
	// La position horizontale de d�part en console de l'entit�
	protected int startXCon;
	// La postion verticale de d�part en console de l'entit�
	protected int startYCon;
	
	/**
	 * Initialisation d'une nouvelle entit�
	 * @param x : l'abscisse
	 * @param y : l'ordonn�e
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
	 * renvoie la hitbox de l'entit�
	 */
	public Rectangle getHitbox() {
		return new Rectangle((int) (x + hitbox.x), (int) (y + hitbox.y), hitbox.width, hitbox.height);
	}
	
	/**
	 * Affiche les �l�ments mis � jour
	 * @param g : espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void renderGUI(Graphics g);
	
	/*
	 * Affiche les �l�ments mis � jour en console
	 */
	public abstract void renderCon();

	/**
	 * @return la valeur de la position horizontale de l'entit�
	 */
	public float getX() {
		return x;
	}

	/**
	 * Change la valeur de x
	 * @param x : position horizontale de l'entit�
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return la valeur de la position verticale de l'entit�
	 */
	public float getY() {
		return y;
	}

	/**
	 * Change la valeur de y
	 * @param y : position verticale de l'entit�
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
