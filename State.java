package main.states;

import java.awt.Graphics;

import main.Handler;

/**
 * Cette classe regroupe tous les états que peut prendre le programme
 * @author Octikoros
 *
 */
public abstract class State {

	// Déclaration d'un handler comportant les données de jeu
	//permet d'entrer dans le fil d'exécution courant du jeu
	protected Handler handler;
	
	/**
	 * Initialisation d'un nouvel état
	 * @param game : les paramètres à prendre en compte
	 */
	public State(Handler handler) {
		this.handler = handler;
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
