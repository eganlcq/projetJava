package main.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import main.display.Display;
import main.entities.Mob;
import main.entities.Player;
import main.worlds.World;
import model.Game;
/**
 * Cette classe va effectuer certains tests unitaires
 * @author Octikoros
 *
 */
public class JUnitTest{
	
	Player player;
	Game game;
	Mob mob;
	World world;
	Display display;
	
	
	@Before
	public void setUp(){

		game = new Game("Title");
		game.init();
		display = new Display("Title", game.getWidth(), game.getHeight());
		player = new Player(game, 3, 5);
		mob = new Mob(game, 3, 6, "" , "", 0, 0, 0, 0);
		
		
	}
	
	
	
	@Test
	public void test(){
		assertEquals(79, player.getX(), 0.0);
		assertEquals(129, player.getY(), 0.0);
		assertEquals(3, player.getxCon(), 0.0);
		assertEquals(5, player.getyCon(), 0.0);
		
		player.setxMove(player.getSpeed());
		player.setxMoveCon(player.getSpeedCon());
		player.setyMove(- player.getSpeed());
		player.setyMoveCon(- player.getSpeedCon());
		player.move();
		assertEquals(104, player.getX(), 0.0);
		assertEquals(104, player.getY(), 0.0);
		assertEquals(4, player.getxCon(), 0.0);
		assertEquals(4, player.getyCon(), 0.0);
		
		player.restart();
		assertEquals(79,player.getX(), 0.0);
		assertEquals(129,player.getY(), 0.0);
		assertEquals(3, player.getxCon(), 0.0);
		assertEquals(5, player.getyCon(), 0.0);
			
	}
	
	
	
	
	@Test
	public void testFlag(){
		assertFalse(player.isFlagged(3, 5));
		assertFalse(player.isFlaggedCon());
	}
	
	
	
	@Test
	public void testMoveMob(){
		mob.setDirection("up");
		mob.changeDirection();
		assertEquals(- mob.getSpeed(), mob.getyMove(), 0.0);
		mob.setDirection("right");
		mob.changeDirection();
		assertEquals(mob.getSpeed(), mob.getxMove(), 0.0);
		mob.setDirection("down");
		mob.changeDirection();
		assertEquals(mob.getSpeed(), mob.getyMove(), 0.0);
		mob.setDirection("left");
		mob.changeDirection();
		assertEquals(- mob.getSpeed(), mob.getxMove(), 0.0);
		
	}
	
}

