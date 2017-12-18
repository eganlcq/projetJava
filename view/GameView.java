package view;

import java.util.Observer;

import control.GameController;
import model.Game;

/**
 * Cette classe repr�sente la vue de l'architecture MVC
 * @author Octikoros
 *
 */
public abstract class GameView implements Observer{
	
	// Indique si une touche est press�e ou pas
	protected boolean pushed = false;

	// Le mod�le de l'architecture MVC
	protected Game model;
	// Le contr�leur de l'architecture MVC
	protected GameController controller;
	
	/**
	 * Initialisation d'une nouvelle vue
	 * @param model : le mod�le
	 * @param controller : le contr�leur
	 */
	public GameView(Game model, GameController controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}
	
}
