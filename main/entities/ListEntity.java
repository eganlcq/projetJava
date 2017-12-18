package main.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import model.Game;

/**
 * Cette classe représente la liste des ennemis
 * @author Octikoros
 *
 */
public class ListEntity implements Runnable{

	// Le jeu possédant les données de cette liste
	private Game game;
	// Le tableau contenant les ennemis
	private ArrayList<Mob> arrayMob;
	// Permet de savoir si les ennemis sont en train de tourner ou pas
	private boolean running = false;
	
	/**
	 * Initialise une nouvelle liste d'ennemis
	 * @param game : les données de jeu
	 */
	public ListEntity(Game game) {
		this.game = game;
		arrayMob = new ArrayList<Mob>();
		running = true;
		new Thread(this).start();
	}
	
	/**
	 * Affiche les éléments mis à jour en GUI
	 */
	public void renderGUI(Graphics g) {
		for(Mob mob : arrayMob) {
			mob.renderGUI(g);
		}
	}
	
	/*
	 * Affiche les élements mis à jour en console
	 */
	public void renderCon() {
		for(Mob mob : arrayMob) {
			mob.renderCon();
		}
	}
	@Override
	/**
	 * Cette méthode est appelée lorsque la méthode start() du thread courant est appelée
	 */
	public void run() {
		setMob();
				
		while(running) {
			for(Mob mob : arrayMob) {
				mob.move();
			}
			game.moveMob();
			try {
				Thread.sleep(1000 / 3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialise la postion et le mouvement de tous les ennemis par niveau
	 */
	public void setMob() {
		arrayMob.removeAll(arrayMob);
		if(game.getWorld().getId() == 1) {
			arrayMob.add(new Mob(game, 5, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 6, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 7, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 8, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 9, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 10, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 11, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 12, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 13, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 14, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 15, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 16, 5, "down", "", 0, 0, 3, 3));
		}
		else if(game.getWorld().getId() == 2){
			arrayMob.add(new Mob(game, 3, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 4, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 5, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 6, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 7, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 8, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 9, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 10, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 11, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 12, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 13, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 14, 8, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 15, 8, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 9, 7, "right", "", 6, 6, 0, 0));
			arrayMob.add(new Mob(game, 9, 9, "left", "", 6, 6, 0, 0));
			
		}
		else if(game.getWorld().getId() == 3) {
			arrayMob.add(new Mob(game, 3, 3, "right", "turnRight", 0, 6, 0, 6));
			arrayMob.add(new Mob(game, 9, 3, "down", "turnRight", 6, 0, 0, 6));
			arrayMob.add(new Mob(game, 9, 9, "left", "turnRight", 6, 0, 6, 0));
			arrayMob.add(new Mob(game, 3, 9, "up", "turnRight", 0, 6, 6, 0));
		}
		else if(game.getWorld().getId() == 4){
			arrayMob.add(new Mob(game, 2, 9, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 3, 9, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 4, 9, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 5, 8, "down", "", 0, 0, 0, 4));
			arrayMob.add(new Mob(game, 6, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 7, 7, "down", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 8, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 9, 6, "up", "", 0, 0, 4, 0));
			arrayMob.add(new Mob(game, 10, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 11, 7, "down", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 12, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 13, 8, "down", "", 0, 0, 0, 4));
			arrayMob.add(new Mob(game, 14, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 15, 7, "down", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 16, 7, "up", "", 0, 0, 5, 5));
			arrayMob.add(new Mob(game, 17, 6, "up", "", 0, 0, 4, 0));
			arrayMob.add(new Mob(game, 18, 5, "up", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 19, 5, "down", "", 0, 0, 3, 3));
			arrayMob.add(new Mob(game, 20, 5, "up", "", 0, 0, 3, 3));
			
		}
		else if(game.getWorld().getId() == 5) {
            arrayMob.add(new Mob(game, 4, 2, "right", "turnRight", 0, 13, 0, 9));
            arrayMob.add(new Mob(game, 17, 2, "down", "turnRight", 13, 0, 0, 9));
            arrayMob.add(new Mob(game, 17, 11, "left", "turnRight", 13, 0, 9, 0));
            arrayMob.add(new Mob(game, 4, 11, "up", "turnRight", 0, 13, 9, 0));
            arrayMob.add(new Mob(game, 6, 4, "right", "turnRight", 0, 9, 0, 5));
            arrayMob.add(new Mob(game, 15, 4, "down", "turnRight", 9, 0, 0, 5));
            arrayMob.add(new Mob(game, 15, 9, "left", "turnRight", 9, 0, 5, 0));
            arrayMob.add(new Mob(game, 6, 9, "up", "turnRight", 0, 9, 5, 0));
            arrayMob.add(new Mob(game, 9, 5, "right", "turnRight", 0, 3, 0, 3));
            arrayMob.add(new Mob(game, 12, 5, "down", "turnRight", 3, 0, 0, 3));
            arrayMob.add(new Mob(game, 12, 8, "left", "turnRight", 3, 0, 3, 0));
            arrayMob.add(new Mob(game, 9, 8, "up", "turnRight", 0, 3, 3, 0));
        }
		else if(game.getWorld().getId() == 6){
			arrayMob.add(new Mob(game, 2, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 4, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 2, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 4, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 2, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 4, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 6, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 8, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 10, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 8, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 10, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 8, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 10, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 12, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 14, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 16, 4, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 14, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 16, 6, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 14, 8, "right", "turnRight", 0, 1, 0, 1));
			arrayMob.add(new Mob(game, 16, 8, "right", "turnRight", 0, 1, 0, 1));
		}
		else if(game.getWorld().getId() == 7){
			arrayMob.add(new Mob(game, 5, 2, "down", "", 0, 0, 0, 10));
			arrayMob.add(new Mob(game, 7, 7, "right", "", 0, 9, 0, 0));
			arrayMob.add(new Mob(game, 7, 10, "right", "", 0, 7, 0, 0));
			arrayMob.add(new Mob(game, 16, 14, "up", "", 0, 0, 9, 0));
			arrayMob.add(new Mob(game, 18, 5, "left", "", 11, 0, 0, 0));
			arrayMob.add(new Mob(game, 2, 12, "right", "", 0, 14, 0, 0));
		}
		else if(game.getWorld().getId() == 8){
			arrayMob.add(new Mob(game, 3, 11, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 11, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 3, 12, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 12, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 3, 7, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 7, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 3, 8, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 8, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 3, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 3, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 4, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 7, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 8, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 7, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 8, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 11, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 12, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 11, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 12, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 3, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 4, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 7, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 7, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 8, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 8, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 11, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 11, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 15, 12, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 16, 12, "", "", 0, 0, 0, 0));
			arrayMob.add(new Mob(game, 2, 10, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 2, 6, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 2, 2, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 6, 2, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 10, 2, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 14, 2, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 14, 6, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 14, 10, "right", "turnRight", 0, 3, 0, 3));
			arrayMob.add(new Mob(game, 5, 13, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 5, 9, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 5, 5, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 9, 5, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 13, 5, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 17, 5, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 17, 9, "left", "turnRight", 3, 0, 3, 0));
			arrayMob.add(new Mob(game, 17, 13, "left", "turnRight", 3, 0, 3, 0));
		}
		
		for(Mob mob : arrayMob) {
			mob.changeDirection();
		}
		
	}

	/**
	 * @return le tableau d'ennemis
	 */
	public ArrayList<Mob> getArrayMob() {
		return arrayMob;
	}

}

