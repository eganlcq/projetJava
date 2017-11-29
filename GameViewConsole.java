package view;

import java.util.Observable;
import java.util.Scanner;

import control.GameController;
import model.Game;

/**
 * Cette classe repr�sente la vue console de l'architecture MVC
 * @author Octikoros
 *
 */
public class GameViewConsole extends GameView implements Runnable{
	
	// Le scanner �coutant les input entr�s au clavier
	private Scanner sc;

	/**
	 * Initialisation d'une nouvelle vue console
	 * @param model : le mod�le de l'architecture MVC
	 * @param controller : le contr�lleur de l'architecture MVC
	 */
	public GameViewConsole(Game model, GameController controller) {
		super(model, controller);
		
		sc = new Scanner(System.in);
		new Thread(this).start();
	}

	/**
	 * Cette m�thode est appel�e lorsque le mod�le notifie la vue d'un changement
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
			model.getWorldConsole().render();
	}
	
	/**
	 * Scanne en permanence les input rentr�s en console
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
	 * Permet au scanner de s'ex�cuter
	 */
	@Override
	public void run() {
		scan();
		
	}
}
