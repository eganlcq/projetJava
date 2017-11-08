package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Cette classe permet aux user de contrôller le personnage
 * @author Octikoros
 *
 */
public class KeyManager implements KeyListener {

	// Déclaration d'un tableau indiquant si oui ou non une touche est pressée
	private boolean [] keys;
	// Indiquera ou non si la touche haut est pressée
	public boolean up;
	// Indiquera ou non si la touche bas est pressée
	public boolean down;
	// Indiquera ou non si la touche gauche est pressée
	public boolean left;
	// Indiquera ou non si la touche droite est pressée
	public boolean right;
	
	/**
	 * Initialise le tableau des touches du clavier
	 */
	public KeyManager() {
		keys = new boolean [256];
	}
	
	/**
	 * Met à jour divers éléments
	 */
	public void update() {
		// Assigne le déplacement vers le haut à la touche "Z"
		up = keys[KeyEvent.VK_Z];
		// Assigne le déplacement vers le bas à la touche "S"
		down = keys[KeyEvent.VK_S];
		// Assigne le déplacement vers la gauche à la touche "Q"
		left = keys[KeyEvent.VK_Q];
		// Assigne le déplacement vers la droite à la touche "D"
		right = keys[KeyEvent.VK_D];
	}
	
	/**
	 * Méthode appelée lorsqu'on presse une touche du clavier
	 */
	public void keyPressed(KeyEvent e) {
		// Indique qu'une touche spécifique est pressée
		keys[e.getKeyCode()] = true;
	}

	/**
	 * Méthode appelée lorsqu'on relache une touche du clavier
	 */
	public void keyReleased(KeyEvent e) {
		// Indique qu'une touche définie est relachée
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
