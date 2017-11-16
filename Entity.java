package main.entities;

import java.awt.Graphics;

/**
 * Cette classe représente une entitée
 * @author Octikoros
 *
 */
public abstract class Entity {

	// position horizontale de l'entitée
	public float x;
	// position verticale de l'entitée
	public float y;
	// la largeur de l'entitée
	public int width;
	// la largeur de l'entitée
	public int height;
	
	/**
	 * Initialisation d'une nouvelle entitée
	 * @param x = l'abscisse
	 * @param y = l'ordonnée
	 * @param width = la largeur
	 * @param height = la hauteur
	 */
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Affiche les éléments mis à jour
	 * @param g = L'espace graphique dans lequel on peut afficher du contenu
	 */
	public abstract void render(Graphics g);
}
