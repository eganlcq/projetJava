package main.entities;

import model.Game;

/**
 * Cette classe représente une entité mobile
 * @author Octikoros
 *
 */
public  abstract class MobileEntity extends Entity{
	
	// La vitesse par défaut de l'entité
	public static final float DEFAULT_SPEED = 25;
	// La largeur par défaut de l'entité
	public static final int DEFAULT_WIDTH = 17;
	// La hauteur par défaut de l'entité
	public static final int DEFAULT_HEIGHT = 17;
	
	// La vitesse de l'entité
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	protected int speedCon;
	protected int xMoveCon;
	protected int yMoveCon;

	/**
	 * Initialisation d'une nouvelle entité mobile
	 * @param x : abscisse
	 * @param y : ordonnée
	 * @param width : largeur
	 * @param height : hauteur
	 */
	public MobileEntity(Game game, int positionX, int positionY, int width, int height) {
		super(game, positionX, positionY, width, height);
		speed = DEFAULT_SPEED;
		speedCon = 1;
		xMove = 0;
		yMove = 0;
		xMoveCon = 0;
		yMoveCon = 0;
	}
	
	/**
	 * Vérifie si la prochaine case est solide ou non
	 * @param x : la position horizontale de la prochaine case
	 * @param y : la position verticale de la prochaine case
	 * @return true si la prochaine case est solide, false si non
	 */
	public boolean collisionTile(int x, int y) {
		return game.getWorld().getTile(x, y).isSolid();
	}
	
	/**
	 * Vérifie les collisions avec un mur
	 * @return true si oui, false si non
	 */
	public boolean collisionTileCon() {
		return (game.getWorld().getGridCon()[xCon][yCon].equals("[x]"));
	}
	
	/**
	 * Vérifie si il y a une collision entre le joueur et un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionEntity() {
		return getHitbox().intersects(game.getMob().getHitbox());
	}
	
	/**
	 * Vérifie les collisions avec un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionEntityCon() {
		return (game.getWorld().getGridCon()[xCon][yCon].equals("[O]"));
	}
	
	public boolean collisionPlayerCon() {
		return(game.getWorld().getGridCon()[xCon][yCon].equals("[P]"));
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
	
	public int getSpeedCon() {
		return speedCon;
	}
	
	public void setSpeedCon(int speedCon) {
		this.speedCon = speedCon;
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
	
	/**
	 * @return le déplacement horizontal de l'entité
	 */
	public int getxMoveCon() {
		return xMoveCon;
	}

	/**
	 * Change la valeur de xMove
	 * @param xMove : le déplacement horizontal de l'entité
	 */
	public void setxMoveCon(int xMoveCon) {
		this.xMoveCon = xMoveCon;
	}

	/**
	 * @return le déplacement vertical de l'entité
	 */
	public int getyMoveCon() {
		return yMoveCon;
	}

	/**
	 * Change la valeur de yMove
	 * @param yMove : le déplacement vertical de l'entité
	 */
	public void setyMoveCon(int yMoveCon) {
		this.yMoveCon = yMoveCon;
	}
	
	
	
}
