package main.console;

import model.Game;

/**
 * Cette classe repr�sente un ennemi impl�ment� en console
 * @author Octikoros
 *
 */
public class MobConsole implements Runnable{

	// V�rifie si le thread de l'ennemi est en train de tourner ou non
	private boolean running = false;
	// Le fil d'ex�cution de l'ennemi
	private Thread thread;
	// Repr�sente la direction du d�placement de l'ennemi
	private String direction;
	// La position horizontale de l'ennemi
	public int x;
	// La position verticale de l'ennemi
	public int y;
	// Le d�placement horizontal
	private int xMove;
	// Le d�placement vertical
	private int yMove;
	// Le jeu dans lequel l'ennemi va bouger
	private Game game;
	
	/**
	 * Initialisation d'un nouvel ennemi en console
	 * @param game : le jeu dans lequel il se d�placera
	 * @param x : position horizontale
	 * @param y : position verticale
	 * @param direction : la direction du d�placement
	 */
	public MobConsole(Game game, int x, int y, String direction) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.direction = direction;
		start();
	}
	
	/**
	 * Initialisation des donn�es de d�placement de l'ennemi
	 */
	public void init() {
		if(direction == "up") yMove = -1;
		else if(direction == "right") xMove = 3;
		else if(direction == "down") yMove = 1;
		else if(direction == "left") xMove = -3;
	}
	
	/**
	 * V�rifie si il y a une collision avec le joueur
	 * @return true si oui, false si non
	 */
	public boolean collisionPlayer() {
		return (game.getWorldConsole().getGrid()[x][y].equals("P"));
	}
	
	/**
	 * Permet � l'ennemi de s'ex�cuter
	 */
	@Override
	public void run() {
		init();
		// Le nombre de frames auxquelles le jeu tournera par seconde
		int fps = 3;
		// L'intervalle de temps qu'il y a entre chaque updates
		// Utilis� en nanosecondes
		double timeUpdate = 1000000000 / fps;
		// Contiendra le temps restant avant d'effectuer de nouveau une update
		double delta = 0.0;
		// Contiendra le current time de la machine
		long now;
		// Enregistre la derni�re fois que l'on a demand� le current time de la machine
		long lastTime = System.nanoTime();
				
		while(running) {
			// Enregistrer le current time dans la variable "now"
			now = System.nanoTime();
			// Ajoute le temps restant avant de rappeler update() et render()
			delta += (now - lastTime) / timeUpdate;
			// Met � jour la derni�re fois que l'on a demand� le current time de la machine
			lastTime = now;
					
			// V�rifie si update() et render() peuvent se lancer ou non
			// Cela permet de respecter les 60 updates par secondes convenus
			if(delta >= 1) {
				move();
				// Remet la variable "delta" en dessous de 1
				delta --;
			}
		}
		stop();
	}
	
	/**
	 * Change les donn�es de d�placement de l'ennemi
	 */
	public void move() {
		game.getWorldConsole().getGrid()[x][y] = "_";
		if(yMove < 0) {
			y -= 1;
			if(notWalkable()) {
				y += 1;
				yMove = 1;
			}
			else if(collisionPlayer()) game.getPlayerCon().restart();
		}
		if(yMove > 0) {
			y += 1;
			if(notWalkable()) {
				y -= 1;
				yMove = -1;
			}
			else if(collisionPlayer()) game.getPlayerCon().restart();
		}
		if(xMove < 0) {
			x -= 3;
			if(notWalkable()) {
				x += 3;
				xMove = 3;
			}
			else if(collisionPlayer()) game.getPlayerCon().restart();
		}
		if(xMove > 0) {
			x += 3;
			if(notWalkable()) {
				x -= 3;
				xMove = -3;
			}
			else if(collisionPlayer()) game.getPlayerCon().restart();
		}
		game.getWorldConsole().getGrid()[x][y] = "O";
		game.generateCon();
	}
	
	/**
	 * V�rifie les collisions avec un mur
	 * @return true si oui, false si non
	 */
	public boolean notWalkable() {
		return (game.getWorldConsole().getGrid()[x][y].equals("x"));
	}
	
	/**
	 * D�marre le fil d'ex�cution de l'ennemi
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Arr�te le fil d'ex�cution de l'ennemi
	 */
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return la position horizontale de l'ennemi
	 */
	public int getX() {
		return x;
	}

	/**
	 * Change la valeur de x
	 * @param x : position horizontale de l'ennemi
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return la position verticale de l'ennemi
	 */
	public int getY() {
		return y;
	}

	/**
	 * Change la valeur de y
	 * @param y : position verticale de l'ennemi
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return la valeur du d�placement horizontal de l'ennemi
	 */
	public int getxMove() {
		return xMove;
	}

	/**
	 * Change la valeur de xMove
	 * @param xMove : le d�placement horizontal de l'ennemi
	 */
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return la valeur du d�placement vertical de l'ennemi
	 */
	public int getyMove() {
		return yMove;
	}
	/**
	 * Change la valeur de yMove
	 * @param yMove : le d�placement vertical de l'ennemi
	 */
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
	
	

}
