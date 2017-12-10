package main.entities;

import java.awt.Graphics;

import main.gfx.Assets;
import model.Game;

/**
 * Cette classe représente un ennemi
 * @author Octikoros
 *
 */
public class Mob extends MobileEntity{
	
	// La direction de déplacement de l'ennemi
	private String direction;
	// La chemin que va prendre l'ennemi sur la map
	private String path;
	// La position maximale que peut avoir l'ennemi vers la gauche
	private int treshXleft;
	// La position maximale que peut avoir l'ennemi vers la droite
	private int treshXright;
	// La position maximale que peut avoir l'ennemi vers le haut
	private int treshYup;
	// La position maximale que peut avoir l'ennemi vers le bas
	private int treshYdown;
	
	/**
	 * Initialisation d'un nouvel ennemi
	 * @param game : le jeu dans lequel l'ennemi se déplacera
	 * @param x : la postion horizontale de l'ennemi
	 * @param y : la position verticale de l'ennemi
	 * @param direction : la direction de déplacement de l'ennemi
	 */
	public Mob(Game game, int positionX, int positionY, String direction, String path, int treshXleft, int treshXright, int treshYup, int treshYdown) {
		super(game, positionX, positionY, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
		this.direction = direction;
		this.path = path;
		this.treshXleft = treshXleft;
		this.treshXright = treshXright;
		this.treshYup = treshYup;
		this.treshYdown = treshYdown;
	}

	/**
	 * Affiche les éléments mis à jour
	 */
	public void renderGUI(Graphics g) {
		g.drawImage(Assets.mob, (int) x, (int) y, width, height, null);
	}
	
	/**
	 * Affiche les éléments mis à jour en console
	 */
	public void renderCon() {
		game.getWorld().getGridCon()[xCon][yCon] = "[O]";
	}
  
	/**
	 * Permet de changer la position de l'ennemi
	 */
	public void move(){
	  game.getWorld().getGridCon()[xCon][yCon] = "[_]";
	  moveX();
	  moveY();
	  if(collisionPlayer() || collisionPlayerCon()) game.getPlayer().restart();
	}
	
	/**
	 * Gère le déplacement horizontal
	 */
	public void moveX() {
		// Mouvement à droite
		if(xMove > 0) {
			if(x != startX + treshXright * xMove || xCon != startXCon + treshXright * xMoveCon) {
				x += xMove;
				xCon += xMoveCon;
			}
			else {
				if(path.equals("turnLeft")) direction = "up";
				else if(path.equals("turnRight")) direction = "down";
				else direction = "left";
				changeDirection();
			}
		}
		// Mouvement à gauche
		else if(xMove < 0) {
			if(x != startX + treshXleft * xMove || xCon != startXCon + treshXleft * xMoveCon) {
				x += xMove;
				xCon += xMoveCon;
			}
			else {
				if(path.equals("turnLeft")) direction = "down";
				else if(path.equals("turnRight")) direction = "up";
				else direction = "right";
				changeDirection();
			}
		}
	}
	
	/**
	 * Gère le déplacement vertical
	 */
	public void moveY() {
		// Mouvement vers le bas
		if(yMove > 0) {
			if(y != startY + treshYdown * yMove || yCon != startYCon + treshYdown * yMoveCon) {
				y += yMove;
				yCon += yMoveCon;
			}
			else {
				if(path.equals("turnLeft")) direction = "right";
				else if(path.equals("turnRight")) direction = "left";
				else direction = "up";
				changeDirection();
			}
		}
		// Mouvement vers le haut
		else if(yMove < 0) {
			if(y != startY + treshYup * yMove || yCon != startYCon + treshYup * yMoveCon) {
				y += yMove;
				yCon += yMoveCon;
			}
			else {
				if(path.equals("turnLeft")) direction = "left";
				else if(path.equals("turnRight")) direction = "right";
				else direction = "down";
				changeDirection();
			}
		}
	}
	
	/**
	 * change les données de déplacement de l'ennemi
	 */
	public void changeDirection() {
		if(direction == "up"){
      yMove = -speed;
      yMoveCon = -speedCon;
    } 
		else if(direction == "right"){
      xMove = speed;
      xMoveCon = speedCon;
    } 
		else if(direction == "down"){
      yMove = speed;
      yMoveCon = speedCon;
    } 
		else if(direction == "left"){
      xMove = -speed;
      xMoveCon = -speedCon;
		} 
	}
}
