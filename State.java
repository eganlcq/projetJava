package main.states;

import java.awt.Graphics;

import main.Game;

/**
 * Cette classe regroupe tous les états que peut prendre le programme
 * @author Octikoros
 *
 */
public abstract class State {

	// Déclaration des données de jeu (permet d'entrer dans le fil d'exécution courant du jeu)
	protected Game game;
	
	/**
	 * Initialisation d'un nouvel état
	 * @param game : les paramètres à prendre en compte
	 */
	public State(Game game) {
		this.game = game;
	}
	
	/**
	 * Met à jour divers éléments tel que des variables d'instance régulièrement
	 */
	public abstract void update();
	
	/**
	 * Affiche les éléments mis à jour à l'écran
	 * @param g : l'espace graphique nous permettant d'afficher du contenu
	 */
	public abstract void render(Graphics g);
}
