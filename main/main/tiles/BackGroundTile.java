package main.tiles;

import main.gfx.Assets;

/**
 * Cette classe représente une case de fond
 * @author Octikoros
 *
 */
public class BackGroundTile extends Tile{

	/**
	 * Initialisation d'une case de fond
	 * @param id : l'id de la case
	 */
	public BackGroundTile(int id) {
		super(Assets.background, id);
	}
	
	/**
	 * Indique que la case est solide
	 */
	@Override
	public boolean isSolid() {
		return true;
	}

}
