package view;

import java.util.Observer;

import control.GameController;
import model.Game;

/**
 * Cette classe représente la vue de l'architecture MVC
 * @author Octikoros
 *
 */
public abstract class GameView implements Observer{
	
	// Indique si une touche est pressée ou pas
	protected boolean pushed = false;

	// Le modèle de l'architecture MVC
	protected Game model;
	// Le contrôleur de l'architecture MVC
	protected GameController controller;
	
	/**
	 * Initialisation d'une nouvelle vue
	 * @param model : le modèle
	 * @param controller : le contrôleur
	 */
	public GameView(Game model, GameController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
}
