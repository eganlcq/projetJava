package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import control.GameController;
import model.Game;

/**
 * Cette classe repr�sente la vue graphique de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameViewGUI extends GameView implements KeyListener{

	/**
	 * Initialisation d'une nouvelle vue GUI
	 * @param model : le mod�le
	 * @param controller : le contr�leur
	 */
	public GameViewGUI(Game model, GameController controller) {
		super(model, controller);
		
		// Ajout d'un key listener � la fen�tre courante
		model.getDisplay().getFrame().addKeyListener(this);
	}

	@Override
	/**
	 * Cette m�thode est appel�e lorsque le mod�le notifie la vue d'un changement
	 */
	public void update(Observable o, Object arg) {
		render();
	}

	@Override
	/**
	 * M�thode appel�e lorsqu'on presse une touche du clavier
	 */
	public void keyPressed(KeyEvent e) {
		if(!pushed) {
			keys[e.getKeyCode()] = true;
			controller.moveGUI(e);
			pushed = true;
		}
	}

	@Override
	/**
	 * M�thode appel�e lorsqu'on relache une touche du clavier
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		pushed = false;
		model.getPlayer().setxMove(0);
		model.getPlayer().setyMove(0);
		model.getPlayer().setxMoveCon(0);
		model.getPlayer().setyMoveCon(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * Rafraichissement de la fen�tre avec les �l�ments mis � jour
	 */
	public void render() {
		model.bs = model.getDisplay().getCanvas().getBufferStrategy();
		if(model.bs == null) {
			model.getDisplay().getCanvas().createBufferStrategy(3);
			render();
		}
		model.g = model.bs.getDrawGraphics();
		model.g.clearRect(0, 0, model.getWidth(), model.getHeight());
		
		// D�but affichage
		
		
		model.getWorld().renderGUI(model.g);
		if(model.getPlayer() != null) {
			model.getPlayer().renderGUI(model.g);
			model.getList().renderGUI(model.g);
		}
		
		
		
		// Fin affichage
		model.bs.show();
		model.g.dispose();
	}
}
