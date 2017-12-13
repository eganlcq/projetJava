package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import control.GameController;
import main.gfx.Assets;
import model.Game;

/**
 * Cette classe représente la vue graphique de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameViewGUI extends GameView implements KeyListener{

	/**
	 * Initialisation d'une nouvelle vue GUI
	 * @param model : le modèle
	 * @param controller : le contrôleur
	 */
	public GameViewGUI(Game model, GameController controller) {
		super(model, controller);
		
		// Ajout d'un key listener à la fenêtre courante
		model.getDisplay().getFrame().addKeyListener(this);
	}

	@Override
	/**
	 * Cette méthode est appelée lorsque le modèle notifie la vue d'un changement
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
			controller.moveGUI(e);
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
		model.getPlayer().setxMove(0);
		model.getPlayer().setyMove(0);
		model.getPlayer().setxMoveCon(0);
		model.getPlayer().setyMoveCon(0);
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
			render();
		}
		model.g = model.bs.getDrawGraphics();
		model.g.clearRect(0, 0, model.getWidth(), model.getHeight());
		
		// Début affichage
		
		
		model.getWorld().renderGUI(model.g);
		if(model.getPlayer() != null) {
			model.getPlayer().renderGUI(model.g);
			model.getList().renderGUI(model.g);
			model.g.drawImage(Assets.rip, 5, 20, 20, 20, null);
			model.g.setFont(new Font("Arial black", Font.PLAIN, 14));
			model.g.setColor(Color.BLACK);
			model.g.drawString("Timer : " + Integer.toString(model.getScore()), 7, 17);
			model.g.drawString(Integer.toString(model.getDeath()), 32, 37);
			model.g.setColor(Color.WHITE);
			model.g.drawString("Timer : " + Integer.toString(model.getScore()), 5, 15);
			model.g.drawString(Integer.toString(model.getDeath()), 30, 35);
		}
		else {
			model.g.drawImage(Assets.time, 5, 20, 20, 20, null);
			model.g.setFont(new Font("Arial black", Font.PLAIN, 14));
			model.g.setColor(Color.BLACK);
			model.g.drawString("Final result : " + Integer.toString(model.getResult()), 7, 17);
			model.g.drawString(Integer.toString(model.getTime()) + " sec", 32, 37);
			model.g.setColor(Color.WHITE);
			model.g.drawString("Final result : " + Integer.toString(model.getResult()), 5, 15);
			model.g.drawString(Integer.toString(model.getTime()) + " sec", 30, 35);
		}
		
		
		
		// Fin affichage
		model.bs.show();
		model.g.dispose();
	}
}
