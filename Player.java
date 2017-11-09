package main.entities;

import java.awt.Graphics;

import main.Handler;
import main.gfx.Assets;

/**
 * Cette classe représente le joueur
 * @author Octikoros
 *
 */
public class Player extends MobileEntity {

	/**
	 * Initialise un nouveau joueur
	 * @param handler : permettra d'accéder aux données du jeu
	 * @param x : l'abscisse du joueur
	 * @param y : l'ordonnée du joueur
	 */
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
		
		// Position horizontale de la hitbox par rapport au joueur
		bounds.x = 0;
		// Position verticale de la hitbox par rapport au joueur
		bounds.y = 0;
		// Largeur de la hitbox
		bounds.width = 17;
		// Hauteur de la hitbox
		bounds.height = 17;
	}

	/**
	 * Met à jour divers éléments
	 */
	public void update() {
		getInput();
		super.move();
	}
	
	/**
	 * Initialise les mouvements à effectuer par le joueur dans la méthode update
	 */
	private void getInput() {
		// Réinitialise le déplacement à 0
		xMove = 0;
		yMove = 0;
		
		// Si la touche up est pressée, yMove vaut -3 (la vitesse par défaut)
		if(handler.getKeyManager().up) yMove = -speed;
		// Si la touche down est pressée, yMove vaut 3 (la vitesse par défaut)
		if(handler.getKeyManager().down) yMove = speed;
		// Si la touche left est pressée, xMove vaut -3 (la vitesse par défaut)
		if(handler.getKeyManager().left) xMove = -speed;
		// Si la touche right est pressée, xMove vaut -3 (la vitesse par défaut)
		if(handler.getKeyManager().right) xMove = speed;
	}

	/**
	 * Affiche les éléments mis à jour à l'écran
	 */
	public void render(Graphics g) {
		// Affiche un élément d'une image préalablement découpé dans la classe Assets
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
