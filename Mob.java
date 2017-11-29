package main.entities;

import java.awt.Graphics;

import main.gfx.Assets;
import main.tiles.Tile;
import model.Game;

/**
 * Cette classe représente un ennemi
 * @author Octikoros
 *
 */
public class Mob extends MobileEntity implements Runnable{

	// Vérifie si le thread de l'ennemi est en train de tourner ou non
	private boolean running = false;
	// Le fil d'exécution de l'ennemi
	private Thread thread;
	// La direction de déplacement de l'ennemi
	private String direction;
	
	/**
	 * Initialisation d'un nouvel ennemi
	 * @param game : le jeu dans lequel l'ennemi se déplacera
	 * @param x : la postion horizontale de l'ennemi
	 * @param y : la position verticale de l'ennemi
	 * @param direction : la direction de déplacement de l'ennemi
	 */
	public Mob(Game game, float x, float y, String direction) {
		super(game, x, y, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
		this.direction = direction;
		start();
	}

	/**
	 * Affiche les éléments mis à jour
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.mob, (int) x, (int) y, width, height, null);
	}
	
	/**
	 * Gère le déplacement horizontal
	 */
	public void moveX() {
		int tileXLeft = (int) (x + xMove + hitbox.x) / Tile.TILEWIDTH;
		int tileXRight = (int) (x + xMove + hitbox.x + hitbox.width) / Tile.TILEWIDTH;
		int tileYUp = (int) (y + hitbox.y) / Tile.TILEHEIGHT;
		int tileYDown = (int) (y + hitbox.y + hitbox.width) / Tile.TILEHEIGHT;
		// Mouvement à droite
		if(xMove > 0) {
			if(!collisionTile(tileXRight, tileYUp) && !collisionTile(tileXRight, tileYDown)) {
				x += xMove;
			}
			else {
				x = tileXRight * Tile.TILEWIDTH - hitbox.x - hitbox.width -1;
				xMove = -speed;
			}
		}
		// Mouvement à gauche
		else if(xMove < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXLeft, tileYDown)) {
				x += xMove;
			}
			else {
				x = tileXLeft * Tile.TILEWIDTH + Tile.TILEWIDTH - hitbox.x +1;
				xMove = speed;
			}
		}
	}
	
	/**
	 * Gère le déplacement vertical
	 */
	public void moveY() {
		int tileXLeft = (int) (x + hitbox.x -1) / Tile.TILEWIDTH;
		int tileXRight = (int) (x + hitbox.x + hitbox.width -1) / Tile.TILEWIDTH;
		int tileYUp = (int) (y + yMove + hitbox.y -1) / Tile.TILEHEIGHT;
		int tileYDown = (int) (y + yMove + hitbox.y + hitbox.width -1) / Tile.TILEHEIGHT;
		// Mouvement vers le bas
		if(yMove > 0) {
			if(!collisionTile(tileXLeft, tileYDown) && !collisionTile(tileXRight, tileYDown)) {
				y += yMove;
			}
			else {
				y = tileYDown * Tile.TILEHEIGHT - hitbox.y - hitbox.height -1;
				yMove = -speed;
			}
		}
		// Mouvement vers le haut
		else if(yMove < 0) {
			if(!collisionTile(tileXLeft, tileYUp) && !collisionTile(tileXRight, tileYUp)) {
				y += yMove;
			}
			else {
				y = tileYUp * Tile.TILEHEIGHT + Tile.TILEHEIGHT - hitbox.y +1;
				yMove = speed;
			}
		}
	}
	
	/**
	 * Initialisation des données de déplacement de l'ennemi
	 */
	public void init() {
		if(direction == "up") yMove = -speed;
		else if(direction == "right") xMove = speed;
		else if(direction == "down") yMove = speed;
		else if(direction == "left") xMove = -speed;
	}

	/**
	 * Permet à l'ennemi de s'exécuter
	 */
	@Override
	public void run() {
		init();
		// Le nombre de frames auxquelles le jeu tournera par seconde
		int fps = 3;
		// L'intervalle de temps qu'il y a entre chaque updates
		// Utilisé en nanosecondes
		double timeUpdate = 1000000000 / fps;
		// Contiendra le temps restant avant d'effectuer de nouveau une update
		double delta = 0.0;
		// Contiendra le current time de la machine
		long now;
		// Enregistre la dernière fois que l'on a demandé le current time de la machine
		long lastTime = System.nanoTime();
				
		while(running) {
			// Enregistrer le current time dans la variable "now"
			now = System.nanoTime();
			// Ajoute le temps restant avant de rappeler update() et render()
			delta += (now - lastTime) / timeUpdate;
			// Met à jour la dernière fois que l'on a demandé le current time de la machine
			lastTime = now;
					
			// Vérifie si update() et render() peuvent se lancer ou non
			// Cela permet de respecter les 60 updates par secondes convenus
			if(delta >= 1) {
				moveX();
				moveY();
				game.moveMob();
				// Remet la variable "delta" en dessous de 1
				delta --;
			}
		}
		stop();
	}
	
	/**
	 * Démarre le thread de l'ennmi
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Arrête le thread de l'ennemi
	 */
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
