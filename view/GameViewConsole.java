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
		render();
	}
	
	/**
	 * Scanne en permanence les input rentrés en console
	 */
	public void scan() {
		while(model.getPlayer() != null) {
			model.getPlayer().setxMoveCon(0);
			model.getPlayer().setyMoveCon(0);
			model.getPlayer().setxMove(0);
			model.getPlayer().setyMove(0);
			String msg = sc.nextLine();
			if(model.getPlayer() == null) {
				sc.close();
				break;
			}
			if(msg.equals("stop")) {
				sc.close();
				System.exit(0);
			}
			controller.moveCon(msg);
		}
	}
	
	/**
	 * Affiche les élements mis à jour
	 */
	public void render() {
		if(model.getPlayer() != null) {
			System.out.println("\nTimer : " + model.getScore() + "\n");
			System.out.println("nb Death : " + model.getDeath() + "\n\n");
			model.getPlayer().renderCon();
			model.getList().renderCon();
			model.getWorld().renderCon();
		}
		else {
			System.out.println("\nFinal result : " + model.getResult() + "\n");
			System.out.println("Total time : " + model.getTime() + "\n\n");
			System.out.println("Bien joué !");
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
