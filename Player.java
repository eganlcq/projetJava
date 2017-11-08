package main.entities;

import java.awt.Graphics;

import main.Game;
import main.gfx.Assets;

/**
 * Cette classe représente le joueur
 * @author Octikoros
 *
 */
public class Player extends MobileEntity {

	/**
	 * Initialise un nouveau joueur
	 * @param game : permettra d'accéder aux input du clavier
	 * @param x : l'abscisse du joueur
	 * @param y : l'ordonnée du joueur
	 */
	public Player(Game game, float x, float y) {
		super(game, x, y, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
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
		if(game.getKeyManager().up) yMove = -speed;
		// Si la touche down est pressée, yMove vaut 3 (la vitesse par défaut)
		if(game.getKeyManager().down) yMove = speed;
		// Si la touche left est pressée, xMove vaut -3 (la vitesse par défaut)
		if(game.getKeyManager().left) xMove = -speed;
		// Si la touche right est pressée, xMove vaut -3 (la vitesse par défaut)
		if(game.getKeyManager().right) xMove = speed;
	}

	/**
	 * Affiche les éléments mis à jour à l'écran
	 */
	public void render(Graphics g) {
		// Affiche un élément d'une image préalablement découpé dans la classe Assets
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
