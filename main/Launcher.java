package main;

import control.GameController;
import model.Game;
import view.GameViewConsole;
import view.GameViewGUI;

/**
 * Cette classe permet de lancer le jeu
 * @author Octikoros
 *
 */
public class Launcher {

	public static void main(String[] args) {
		// Cr�ation du mod�le
		Game model = new Game("P�te une case !", 800, 600);
		model.init();
		//Cr�ation des contr�leurs : un pour chaque vue
		//Chaque contr�leur doit avoir une r�f�rence vers le mod�le pour pouvoir le commander
		GameController ctrlGUI = new GameController(model);										///!\/!\/!\
		GameController ctrlConsole = new GameController(model);
		// Cr�ation des vues
		// Chaque vue doit conna�tre son contr�leur et avoir une r�f�rence vers le mod�le
		GameViewGUI GUI = new GameViewGUI(model, ctrlGUI);										///!\/!\/!\
		GameViewConsole console = new GameViewConsole(model, ctrlConsole);
		// On donne la r�f�rence � la vue pour chaque contr�leur
		ctrlGUI.addView(GUI);																		///!\/!\/!\
		ctrlConsole.addView(console);
	}
	
}

