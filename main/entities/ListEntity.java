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
		// Le nombre de frames auxquelles le jeu tournera par seconde
		int fps = 3;
		// L'intervalle de temps qu'il y a entre chaque updates
		// Utilisé en nanosecondes
		double timeUpdate = 1000000000 / fps;
		// Contiendra le temps restant avant d'effectuer de nouveau une update
		double delta = 0.0;
		// Contiendra le current time de la machine
		long now;
		// Enregistre la dernière fois que l'on a demandé le current time de la machine
		long lastTime = System.nanoTime();
				
		while(running) {
			// Enregistrer le current time dans la variable "now"
			now = System.nanoTime();
			// Ajoute le temps restant avant de rappeler update() et render()
			delta += (now - lastTime) / timeUpdate;
			// Met à jour la dernière fois que l'on a demandé le current time de la machine
			lastTime = now;
					
			// Vérifie si update() et render() peuvent se lancer ou non
			// Cela permet de respecter les 60 updates par secondes convenus
			if(delta >= 1) {
				for(Mob mob : arrayMob) {
					mob.move();
				}
				game.moveMob();
				// Remet la variable "delta" en dessous de 1
				delta --;
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

