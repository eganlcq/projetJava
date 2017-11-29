package main.tiles;

import main.gfx.Assets;

/**
 * Cette classe repr�sente une case d'arriv�e
 * @author Octikoros
 *
 */
public class FlagTile extends Tile{

	/**
	 * Initialisation d'une nouvelle case d'arriv�e
	 * @param id : l'id de la case
	 */
	public FlagTile(int id) {
		super(Assets.flag, id);
	}

}
