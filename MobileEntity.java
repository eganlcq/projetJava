package main.entities;

import main.Game;
import main.entities.Entity;

/**
 * Cette classe représente une créature
 * @author Octikoros
 *
 */
public abstract class MobileEntity extends Entity {

	// La vitesse par défaut des entités
	protected static final float DEFAULT_SPEED = 2.0f;
	// La largeur par défaut des entités
	protected static final int DEFAULT_WIDTH = 17;
	// La longueur par défaut des entités
	protected static final int DEFAULT_HEIGHT = 17;
	
	// La vitesse de l'entité
	protected float speed;
	// Le mouvement horizontal de l'entité
	protected float xMove;
	// Le mouvement vertical de l'entité
	protected float yMove;
	
	/**
	 * Initialisation d'une nouvelle entité mobile
	 * @param x : l'abscisse de l'entité
	 * @param y : l'ordonnée de l'entité
	 */
	public MobileEntity(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 * Permet d'effectuer le déplacement des entité
	 */
	public void move() {
		// Déplacements horizontals de l'entité
		x += xMove;
		// Déplacement verticals de l'entité
		y += yMove;
	}

	/**
	 * @return la valeur de la vitesse de l'entité
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Change la valeur de la vitesse de l'entité
	 * @param speed : la vitesse de l'entité
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return la valeur du mouvement vertical de l'entité
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * Change la valeur du mouvement horizontal de l'entité
	 * @param xMove : le mouvement horizontal de l'entité
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return la valeur du mouvement vertical de l'entité
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * Change la valeur du mouvement vertical de l'entité
	 * @param yMove : le mouvement vertical de l'entité
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
