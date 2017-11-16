package main.entities;

/**
 * Cette classe représente une entitée mobile
 * @author Octikoros
 *
 */
public  abstract class MobileEntity extends Entity{
	
	// la vitesse par défaut de l'entitée
	public static final float DEFAULT_SPEED = 17;
	// la largeur par défaut de l'entitée
	public static final int DEFAULT_WIDTH = 17;
	//la hauteur par défaut de l'entitée
	public static final int DEFAULT_HEIGHT = 17;
	// la vitesse de l'entitée
	protected float speed;

	/**
	 * Initialisation d'une nouvelle entitée mobile
	 * @param x = abscisse
	 * @param y = ordonnée
	 * @param width = largeur
	 * @param height = hauteur
	 */
	public MobileEntity(float x, float y, int width, int height) {
		super(x, y, width, height);
		speed = DEFAULT_SPEED;
	}

	/**
	 * 
	 * @return la vitesse de l'entitée
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Change la vitesse de l'entitée mobile
	 * @param speed = la vitesse de l'entitée
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
