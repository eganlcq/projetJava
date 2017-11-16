package control;

import java.awt.event.KeyEvent;

import model.Game;
import view.GameViewGUI;

/**
 * Cette classe représente le contrôleur de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameController {

	// Le modèle de l'architecture MVC
	private Game model;
	// La vue graphique de l'architecture MVC
	private GameViewGUI view;
	
	// Indique si oui où non la touche du haut est pressée
	public boolean up;
	// Indique si oui où non la touche du bas est pressée
	public boolean down;
	// Indique si oui où non la touche de gauche est pressée
	public boolean left;
	// Indique si oui où non la touche de droite est pressée
	public boolean right;
	
	/**
	 * Initialisation d'un nouveau contrôleur
	 * @param model : le modèle
	 */
	public GameController(Game model) {
		this.model = model;
	}
	
	/**
	 * On donne la référence à la vue pour ce contrôleur
	 * @param view : la vue
	 */
	public void addView(GameViewGUI view) {
		this.view = view;
	}
	
	/**
	 * Vérifie quelle touche est pressée
	 * @param e : évènement du keyListener
	 */
	public void press(KeyEvent e) {
		if(view.keys[KeyEvent.VK_Z]) model.up();
		if(view.keys[KeyEvent.VK_S]) model.down();
		if(view.keys[KeyEvent.VK_Q]) model.left();
		if(view.keys[KeyEvent.VK_D]) model.right();
	}
	
}
