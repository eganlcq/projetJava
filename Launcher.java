package main;

import main.Game;

/**
 * Cette classe permet de lancer le jeu
 * @author Octikoros
 *
 */
public class Launcher {

	public static void main(String [] args) {
		Game game = new Game("Péter une case !", 800, 600);
		game.start();
	}
}
