package control;

import java.awt.event.KeyEvent;

import model.Game;
import view.GameView;

/**
 * Cette classe représente le contrôleur de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameController {

	// Le modèle de l'architecture MVC
	private Game model;
	// La vue graphique de l'architecture MVC
	private GameView view;
	
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
	public void addView(GameView view) {
		this.view = view;
	}
	
	/**
	 * Vérifie quelle touche est pressée
	 * @param e : évènement du keyListener
	 */
	public void moveGUI(KeyEvent e) {
		if(view.keys[KeyEvent.VK_Z]) {
			model.getPlayer().setyMove(- model.getPlayer().getSpeed());
			model.getPlayer().setyMoveCon(- model.getPlayer().getSpeedCon());
		}
		if(view.keys[KeyEvent.VK_S]) {
			model.getPlayer().setyMove(model.getPlayer().getSpeed());
			model.getPlayer().setyMoveCon(model.getPlayer().getSpeedCon());
		}
		if(view.keys[KeyEvent.VK_Q]) {
			model.getPlayer().setxMove(- model.getPlayer().getSpeed());
			model.getPlayer().setxMoveCon(- model.getPlayer().getSpeedCon());
		}
		if(view.keys[KeyEvent.VK_D]) {
			model.getPlayer().setxMove(model.getPlayer().getSpeed());
			model.getPlayer().setxMoveCon(model.getPlayer().getSpeedCon());
		}
		model.movePlayer();
	}
	
	/**
	 * Gère les déplacements du joueur en console
	 */
	public void moveCon(String msg) {
		if(msg.equals("z")) {
			model.getPlayer().setyMove(- model.getPlayer().getSpeed());
			model.getPlayer().setyMoveCon(- model.getPlayer().getSpeedCon());
		}
		if(msg.equals("s")) {
			model.getPlayer().setyMove(model.getPlayer().getSpeed());
			model.getPlayer().setyMoveCon(model.getPlayer().getSpeedCon());
		}
		if(msg.equals("q")) {
			model.getPlayer().setxMove(- model.getPlayer().getSpeed());
			model.getPlayer().setxMoveCon(- model.getPlayer().getSpeedCon());
		}
		if(msg.equals("d")) {
			model.getPlayer().setxMove(model.getPlayer().getSpeed());
			model.getPlayer().setxMoveCon(model.getPlayer().getSpeedCon());
		}
		model.movePlayer();
	}
}
