package main.states;

import java.awt.Graphics;

import main.Handler
import main.entities.Player;
import main.tiles.Tile;
import main.worlds.World;

/**
 * Cette classe représente l'état du programme "gameplay"
 * @author Octikoros
 *
 */
public class GameState extends State {

	// Déclare un nouveau joueur
	private Player player;
	// Déclare un nouveau monde
	private World world;
	
	/**
	 * Initialise une nouvelle state de gameplay
	 */
	public GameState(Handler handler) {
		super(handler);
		// Crée un nouveau joueur commencant en (100;100)
		player = new Player(handler, 100, 100);
		world = new World(handler, "res/worlds/test.txt");
	}
	
	/**
	 * Met à jour divers éléments
	 */
	public void update() {
		world.update();
		player.update();
	}

	/**
	 * Affiche à l'écran les éléments mis à jour
	 */
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
