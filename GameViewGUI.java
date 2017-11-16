package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import control.GameController;
import model.Game;

/**
 * Cette classe représente la vue graphique de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameViewGUI extends GameView implements KeyListener{
	
	// Déclaration d'un tableau indiquant si oui ou non une touche est pressée
	public boolean[] keys;
	
	// Indique si oui où non une touche est pressée
	private boolean pushed = false;

	/**
	 * Initialisation d'une nouvelle vue GUI
	 * @param model : le modèle
	 * @param controller : le contrôleur
	 */
	public GameViewGUI(Game model, GameController controller) {
		super(model, controller);
		
		keys = new boolean[256];
		// Ajout d'un key listener à la fenêtre courante
		model.getDisplay().getFrame().addKeyListener(this);
	}

	@Override
	/**
	 * Cette méthode est appelée lorsque la modèle notifie la vue d'un changement
	 */
	public void update(Observable o, Object arg) {
		render();
	}

	@Override
	/**
	 * Méthode appelée lorsqu'on presse une touche du clavier
	 */
	public void keyPressed(KeyEvent e) {
		if(!pushed) {
			keys[e.getKeyCode()] = true;
			controller.press(e);
			pushed = true;
		}
	}

	@Override
	/**
	 * Méthode appelée lorsqu'on relache une touche du clavier
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		pushed = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * Rafraichissement de la fenêtre avec les éléments mis à jour
	 */
	public void render() {
		model.bs = model.getDisplay().getCanvas().getBufferStrategy();
		if(model.bs == null) {
			model.getDisplay().getCanvas().createBufferStrategy(3);
			return;
		}
		model.g = model.bs.getDrawGraphics();
		model.g.clearRect(0, 0, model.getWidth(), model.getHeight());
		
		// Début affichage
		
		model.getPlayer().render(model.g);
		
		// Fin affichage
		model.bs.show();
		model.g.dispose();
	}

}
