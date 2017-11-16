package main.entities;

import java.awt.Graphics;
import main.gfx.Assets;

/**
 * Cette classe représente un joueur
 * @author Octikoros
 *
 */
public class Player extends MobileEntity{

	/**
	 * initialisation d'un nouveau joueur
	 * @param x = abscisse
	 * @param y = ordonnée
	 */
	public Player(float x, float y) {
		super(x, y, MobileEntity.DEFAULT_WIDTH, MobileEntity.DEFAULT_HEIGHT);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
