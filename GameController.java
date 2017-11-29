package control;

import java.awt.event.KeyEvent;

import model.Game;
import view.GameView;

/**
 * Cette classe repr�sente le contr�leur de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameController {

	// Le mod�le de l'architecture MVC
	private Game model;
	// La vue graphique de l'architecture MVC
	private GameView view;
	
	// Indique si oui o� non la touche du haut est press�e
	public boolean up;
	// Indique si oui o� non la touche du bas est press�e
	public boolean down;
	// Indique si oui o� non la touche de gauche est press�e
	public boolean left;
	// Indique si oui o� non la touche de droite est press�e
	public boolean right;
	
	/**
	 * Initialisation d'un nouveau contr�leur
	 * @param model : le mod�le
	 */
	public GameController(Game model) {
		this.model = model;
	}
	
	/**
	 * On donne la r�f�rence � la vue pour ce contr�leur
	 * @param view : la vue
	 */
	public void addView(GameView view) {
		this.view = view;
	}
	
	/**
	 * V�rifie quelle touche est press�e
	 * @param e : �v�nement du keyListener
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
	 * G�re les d�placements du joueur en console
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
