package main.console;

import model.Game;

/**
 * Cette classe repr�sente le joueur impl�ment� en console
 * @author Octikoros
 *
 */
public class PlayerConsole {
	
	// La position horizontale de d�part du joueur
	private int startX;
	// La position verticale de d�part du joueur
	private int startY;
	// La position horizontale du joueur
	public int x;
	// La position verticale du joueur
	public int y;
	// Le d�placement horizontal du joueur
	private int xMove;
	// Le d�placement vertical du joueur
	private int yMove;
	// Le jeu dans lequel le joueur se d�placera
	private Game game;
	
	/**
	 * Initialise un nouveau joueur
	 * @param game : le jeu dans lequel le joueur se d�placera
	 * @param x : la position horizontale du joueur
	 * @param y : la position verticale du joueur
	 */
	public PlayerConsole(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;
	}
	
	/**
	 * V�rifie les collisions avec un ennemi
	 * @return true si oui, false si non
	 */
	public boolean collisionMob() {
		return (game.getWorldConsole().getGrid()[x][y].equals("O"));
	}
	
	/**
	 * Ram�ne le joueur � sa position initiale
	 */
	public void restart() {
		x = startX;
		y = startY;
	}

	/**
	 * @return la position horizontale du joueur
	 */
	public int getX() {
		return x;
	}

	/**
	 * Change la valeur de x
	 * @param x : position horizontale du joueur
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return la position verticale du joueur
	 */
	public int getY() {
		return y;
	}

	/**
	 * Change la valeur de y
	 * @param y : position verticale du joueur
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return la valeur du d�placement horizontal du joueur
	 */
	public int getxMove() {
		return xMove;
	}

	/**
	 * Change la valeur de xMove
	 * @param xMove : le d�placement horizontal du joueur
	 */
	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	/**
	 * @return la valeur du d�placement vertical du joueur
	 */
	public int getyMove() {
		return yMove;
	}
	/**
	 * Change la valeur de yMove
	 * @param yMove : le d�placement vertical du joueur
	 */
	public void setyMove(int yMove) {
		this.yMove = yMove;
	}
	
	/**
	 * @return la valeur de la position horizontale de d�part du joueur
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * @return la valeur de la position verticale de d�part du joueur
	 */
	public int getStartY() {
		return startY;
	}
	
}