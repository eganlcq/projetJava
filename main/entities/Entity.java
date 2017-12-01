package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import model.Game;

/**
 * Cette classe repr�sente une entit�
 * @author Octikoros
 *
 */
public abstract class Entity {

	protected Game game;
	// La position horizontale de l'entit�
	protected float x;
	// La position verticale de l'entit�
	protected float y;
	// La largeur de l'entit�
	protected int width;
	// La hauteur de l'entit�
	protected int height;
	protected Rectangle hitbox;
	
	/**
	 * Initialisation d'une nouvelle entit�
	 * @param x : l'absisse
	 * @param y : l'ordonn�e
	 * @param width : la largeur
	 * @param height : la hauteur
	 */
	public Entity(Game game, float x, float y, int width, int height) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitbox = new Rectangle(0, 0, width, height);
	}
	
	
	public Rectangle getHitbox() {
		return new Rectangle((int) (x + hitbox.x), (int) (y + hitbox.y), hitbox.width, hitbox.height);
	}
	
	/**
	 * Affiche les �l�ments mis � jour
	 * @param g : espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void render(Graphics g);

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
	
	
}
