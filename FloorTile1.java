package main.tiles;

import main.gfx.Assets;

/**
 * Cette classe représente la case de sol n°1
 * @author Octikoros
 *
 */
public class FloorTile1 extends Tile{

	/**
	 * Initialisation d'une nouvelle case de sol
	 * @param id : l'id de la case
	 */
	public FloorTile1(int id) {
		super(Assets.tile1, id);
	}

}
