package main.entities;

import main.Handler
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
	public MobileEntity(Handler handler, float x, float y, int width, int height) {
		super(game, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	* Permet d'effectuer le déplacement des entité
	*/
	public void move() {
		moveX();
		moveY();
	}
	
	/**
	* Permet d'effectuer le déplacement horizontal
	*/
	public void moveX() {
		// Déplacement vers la droite
		if(xMove > 0) {
			// Renvoie la postion de la case vers laquelle on veut se diriger
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			// Vérifie si il n'y a pas de collision avec le côté droit de la hitbox
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}
			
		}
		// Déplacement vers la gauche
		else if(xMove < 0) {
			// Renvoie la postion de la case vers laquelle on veut se diriger
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			// Vérifie si il n'y a pas de collision avec le côté gauche de la hitbox
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
				x += xMove;
			}
		}
	}
	
	/**
	* Permet d'effectuer le déplacement vertical
	*/
	public void moveY() {
		// Déplacement vers le bas
		if(yMove > 0) {
			// Renvoie la postion de la case vers laquelle on veut se diriger
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			// Vérifie si il n'y a pas de collision avec le côté bas de la hitbox
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			}
					
		}
		// Déplacement vers le haut
		else if(yMove < 0) {
			// Renvoie la postion de la case vers laquelle on veut se diriger
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			// Vérifie si il n'y a pas de collision avec le côté haut de la hitbox
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			}
		}
	}
	
	/**
	 * Permet de déterminer si une case précise est traversable où non
	 * @param x : la postion horizontale de la case
	 * @param y : la postition verticale de la case
	 * @return true si la case est solide, false sinon
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
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
