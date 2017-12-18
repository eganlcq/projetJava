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
	// Le déplacement horizontal de l'ennemi
	protected float xMove;
	// Le déplacement vertical de l'ennemi
	protected float yMove;
	
	// La vitesse de l'entité en console
	protected int speedCon;
	// Le déplacement horizontal de l'ennemi en console
	protected int xMoveCon;
	// Le déplacement vertical de l'ennemi en console
	protected int yMoveCon;
	
	// Le centre horizontal de l'entité GUI défini en pixel
	protected int centerX;
	// Le centre vertical de l'entité GUI défini en pixel
	protected int centerY;

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
		centerX = 0;
		centerY = 0;
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
	 * Vérifie si le joueur se trouve sur la case d'arrivée en GUI
	 * @param x : position horizontale de la case courante
	 * @param y : position verticale de la case courante
	 * @return true si la case courante est la case d'arrivée, false sinon
	 */
	public boolean isFlagged(int x, int y) {
		return (game.getWorld().getTile(x, y).isFlag());
	}
	
	/**
	 * Vérifie si le joueur se trouve sur la case d'arrivée en console
	 * @return true si la case courante est la case d'arrivée, false sinon
	 */
	public boolean isFlaggedCon() {
		return (game.getWorld().getGridCon()[xCon][yCon].equals("[F]"));
	}
	
	/**
	 * Vérifie si il y a une collision entre le joueur et un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionEntity(Mob mob) {
		return getHitbox().intersects(mob.getHitbox());
	}
	
	/**
	 * Vérifie si il y a une collision entre le joueur et un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionPlayer() {
		return getHitbox().intersects(game.getPlayer().getHitbox());
	}
	
	/**
	 * Vérifie les collisions avec un ennemi en console
	 * @return true si oui, false si non
	 */
	public boolean collisionEntityCon() {
		return (game.getWorld().getGridCon()[xCon][yCon].equals("[O]"));
	}
	
	/**
	 * Vérifie les collisions avec un ennemi en console
	 * @return true si oui, false si non
	 */
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
	 * @return la vitesse de l'entité en console
	 */
	public int getSpeedCon() {
		return speedCon;
	}
	
	/**
	 * Change la valeur de xMove
	 * @param xMove : le déplacement horizontal de l'entité
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	/**
	 * Change la valeur de yMove
	 * @param yMove : le déplacement vertical de l'entité
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	/**
	 * @return la valeur du déplacement horizontal
	 */
	public float getxMove() {
		return xMove;
	}

	/**
	 * @return la valeur du déplacement vertical
	 */
	public float getyMove() {
		return yMove;
	}

	/**
	 * Change la valeur de xMove
	 * @param xMove : le déplacement horizontal de l'entité
	 */
	public void setxMoveCon(int xMoveCon) {
		this.xMoveCon = xMoveCon;
	}

	/**
	 * Change la valeur de yMove
	 * @param yMove : le déplacement vertical de l'entité
	 */
	public void setyMoveCon(int yMoveCon) {
		this.yMoveCon = yMoveCon;
	}
	
	
	
}
