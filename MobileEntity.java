package main.entities;

import model.Game;

/**
 * Cette classe représente une entité mobile
 * @author Octikoros
 *
 */
public  abstract class MobileEntity extends Entity{
	
	// La vitesse par défaut de l'entité
	public static final float DEFAULT_SPEED = 17;
	// La largeur par défaut de l'entité
	public static final int DEFAULT_WIDTH = 17;
	// La hauteur par défaut de l'entité
	public static final int DEFAULT_HEIGHT = 17;
	
	// La vitesse de l'entité
	protected float speed;
	protected float xMove;
	protected float yMove;

	/**
	 * Initialisation d'une nouvelle entité mobile
	 * @param x : abscisse
	 * @param y : ordonnée
	 * @param width : largeur
	 * @param height : hauteur
	 */
	public MobileEntity(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 * Vérifie si la prochaine case est solide ou non
	 * @param x : la position horizontale de la prochaine case
	 * @param y : la position verticale de la prochaine case
	 * @return true si la prochaine case est solide, false si non
	 */
	public boolean collisionTile(int x, int y) {
		return game.getWorldGUI().getTile(x, y).isSolid();
	}
	
	/**
	 * Vérifie si il y a une collision entre le joueur et un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionEntity() {
		return getHitbox().intersects(game.getMob().getHitbox());
	}

	/**
	 * @return la vitesse de l'entité
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Change la vitesse de l'entité mobile
	 * @param speed : la vitesse
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @return le déplacement horizontal de l'entité
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * Change la valeur de xMove
	 * @param xMove : le déplacement horizontal de l'entité
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return le déplacement vertical de l'entité
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * Change la valeur de yMove
	 * @param yMove : le déplacement vertical de l'entité
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	
	
}
