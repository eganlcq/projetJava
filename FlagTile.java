package main.tiles;

import main.gfx.Assets;

/**
 * Cette classe représente une case d'arrivée
 * @author Octikoros
 *
 */
public class FlagTile extends Tile{

	/**
	 * Initialisation d'une nouvelle case d'arrivée
	 * @param id : l'id de la case
	 */
	public FlagTile(int id) {
		super(Assets.flag, id);
	}

}
