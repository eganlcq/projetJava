package view;

import java.util.Observable;
import java.util.Scanner;

import control.GameController;
import model.Game;

/**
 * Cette classe représente la vue console de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameViewConsole extends GameView implements Runnable{
	
	// Le scanner écoutant les input entrés au clavier
	private Scanner sc;

	/**
	 * Initialisation d'une nouvelle vue console
	 * @param model : le modèle de l'architecture MVC
	 * @param controller : le contrôlleur de l'architecture MVC
	 */
	public GameViewConsole(Game model, GameController controller) {
		super(model, controller);
		
		sc = new Scanner(System.in);
		new Thread(this).start();
	}

	/**
	 * Cette méthode est appelée lorsque le modèle notifie la vue d'un changement
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
			model.getWorldConsole().render();
	}
	
	/**
	 * Scanne en permanence les input rentrés en console
	 */
	public void scan() {
		while(true) {
			model.getPlayerCon().setxMove(0);
			model.getPlayerCon().setyMove(0);
			String msg = sc.nextLine();
			if(msg.equals("z")) model.getPlayerCon().setyMove(-1);
			if(msg.equals("s")) model.getPlayerCon().setyMove(1);
			if(msg.equals("q")) model.getPlayerCon().setxMove(-3);
			if(msg.equals("d")) model.getPlayerCon().setxMove(3);
			if(msg.equals("stop")) {
				sc.close();
				System.exit(0);
			}
			controller.moveCon();
		}
	}

	/**
	 * Permet au scanner de s'exécuter
	 */
	@Override
	public void run() {
		scan();
		
	}
}
