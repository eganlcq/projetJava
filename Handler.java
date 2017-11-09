package main;

import main.input.KeyManager;
import main.worlds.World;

/**
 * Cette classe regroupe une série de getters et de setters pour rendre le code plus simple à implémenter
 * @author Octikoros
 *
 */
public class Handler {

	// Les données de jeu
	private Game game;
	// Le monde généré dans le jeu
	private World world;
	
	/**
	 * Initialisation d'un nouveau handler
	 * @param game : les données de jeu
	 */
	public Handler(Game game) {
		this.game = game;
	}
	
	/**
	 * @return la largeur de la fenêtre de jeu
	 */
	public int getWidth() {
		return game.getWidth();
	}
	
	/**
	 * @return la hauteur de la fenêtre de jeu
	 */
	public int getHeight() {
		return game.getHeight();
	}
	
	/**
	 * @return le key manager actuel
	 */
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	/**
	 * @return les données de jeu actuelles
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Change les données de jeu actuelles
	 * @param game : les données de jeu
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return le monde généré actuel
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Change le monde généré actuel
	 * @param world : le monde généré
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	
}
