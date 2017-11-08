package main.entities;

import java.awt.Graphics;

import main.Game;

/**
 * Cette classe représente une entité
 * @author Octikoros
 *
 */
public abstract class Entity {

	// Les données de jeu (permet d'entrer dans le fil d'exécution courant du jeu)
	protected Game game;
	// L'abscisse de l'entité
	protected float x;
	// L'ordonnée de l'entité
	protected float y;
	// La largeur de l'entité
	protected int width;
	// La hauteur de l'entité
	protected int height;
	
	/**
	 * Initialise une nouvelle entité
	 * @param x : l'abscisse de l'entité
	 * @param y : l'ordonnée de l'entité
	 */
	public Entity(Game game, float x, float y, int width, int height) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Met à jour divers éléments
	 */
	public abstract void update();
	
	/**
	 * Affiche à l'écran les éléments mis à jour
	 * @param g : L'espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void render(Graphics g);

	/**
	 * @return la valeur de l'abscisse de l'entité
	 */
	public float getX() {
		return x;
	}

	/**
	 * Change la valeur de l'abscisse de l'entité
	 * @param x : l'abscisse de l'entité
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return la valeur de l'ordonnée de l'entité
	 */
	public float getY() {
		return y;
	}

	/**
	 * Change la valeur de l'ordonnée de l'entité
	 * @param y : l'ordonnée de l'entité
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return la valeur de la largeur de l'entité
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Change la valeur de la largeur de l'entité
	 * @param width : la largeur de l'entité
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return la valeur de la hauteur de l'entité
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Change la valeur de la hauteur de l'entité
	 * @param height : la hauteur de l'entité
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
