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
	public void press(KeyEvent e) {
		if(view.keys[KeyEvent.VK_Z]) {
			model.getPlayer().setyMove(- model.getPlayer().getSpeed());
		}
		if(view.keys[KeyEvent.VK_S]) {
			model.getPlayer().setyMove(model.getPlayer().getSpeed());
		}
		if(view.keys[KeyEvent.VK_Q]) {
			model.getPlayer().setxMove(- model.getPlayer().getSpeed());
		}
		if(view.keys[KeyEvent.VK_D]) {
			model.getPlayer().setxMove(model.getPlayer().getSpeed());
		}
		model.movePlayer();
	}
	
	/**
	 * Gère les déplacements du joueur en console
	 */
	public void moveCon() {
		model.getWorldConsole().getGrid()[model.getPlayerCon().getX()][model.getPlayerCon().getY()] = "_";
		if(model.getPlayerCon().getyMove() < 0) {
			model.getPlayerCon().y -= 1;
			if(model.getPlayerCon().collisionMob()) model.getPlayerCon().restart();
			else if(model.getWorldConsole().notWalkable()) model.getPlayerCon().y += 1;
		}
		if(model.getPlayerCon().getyMove() > 0) {
			model.getPlayerCon().y += 1;
			if(model.getPlayerCon().collisionMob()) model.getPlayerCon().restart();
			else if(model.getWorldConsole().notWalkable()) model.getPlayerCon().y -= 1;
		}
		if(model.getPlayerCon().getxMove() < 0) {
			model.getPlayerCon().x -= 3;
			if(model.getPlayerCon().collisionMob()) model.getPlayerCon().restart();
			else if(model.getWorldConsole().notWalkable()) model.getPlayerCon().x += 3;
		}
		if(model.getPlayerCon().getxMove() > 0) {
			model.getPlayerCon().x += 3;
			if(model.getPlayerCon().collisionMob()) model.getPlayerCon().restart();
			else if(model.getWorldConsole().notWalkable()) model.getPlayerCon().x -= 3;
		}
		model.generateCon();
	}
}
