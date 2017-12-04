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
		// Création du modèle
		Game model = new Game("Pète une case !", 800, 600);
		model.init();
		//Création des contrôleurs : un pour chaque vue
		//Chaque contrôleur doit avoir une référence vers le modèle pour pouvoir le commander
		GameController ctrlGUI = new GameController(model);										///!\/!\/!\
		GameController ctrlConsole = new GameController(model);
		// Création des vues
		// Chaque vue doit connaître son contrôleur et avoir une référence vers le modèle
		GameViewGUI GUI = new GameViewGUI(model, ctrlGUI);										///!\/!\/!\
		GameViewConsole console = new GameViewConsole(model, ctrlConsole);
		// On donne la référence à la vue pour chaque contrôleur
		ctrlGUI.addView(GUI);																		///!\/!\/!\
		ctrlConsole.addView(console);
	}
	
}

