package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Observable;

import main.display.Display;
import main.entities.ListEntity;
import main.entities.Player;
import main.gfx.Assets;
import main.gfx.Music;
import main.worlds.World;

/**
 * Cette classe repr�sente le mod�le de l'architecture MVC
 * @author Octikoros
 *
 */
public class Game extends Observable{
	
	// La fen�tre
	private Display display;
	
	// Le titre de la fen�tre
	private String title;
	// La largeur de la fen�tre
	private int width;
	// La hauteur de la fen�tre
	private int height;
	
	// Permet d'organiser la m�moire d'un canvas o� d'une fen�tre
	// Indique le nombre de buffers utilis�s
	public BufferStrategy bs;
	// Permet � l'application d'afficher du contenu sur divers �l�ments tel qu'un canvas
	public Graphics g;
	
	// La map
	private World world;
	// Le joueur
	private Player player;
	// Les ennemis en console
	private ListEntity listMob;
	
	// La musique de fond
	private Music backgroundSound;
	// Son jou� lors de la mort du joueur
	private Music deathSound;
	// Son jou� lors de la victoire du joueur
	private Music winSound;
	
	// Score du joueur
	private int score;
	// Permet de rafraichir le score uniquement 1 fois par seconde
	private int countScore = 0;
	// R�sultat final
	private int finalResult;
	// Temps pour finir un niveau
	private int time;
	// Temps pour finir les niveaux
	private int totalTime;
	// Nombre de fois que le joueur est mort
	private int nbDeath;
	
	/**
	 * Initialisation du jeu
	 * @param title : titre de la fen�tre
	 * @param width : largeur de la fen�tre
	 * @param height : hauteur de la fen�tre
	 */
	public Game(String title) {
		this.title = title;
	}
	
	/**
	 * Initialisation des donn�es du jeu
	 */
	public void init() {
		nbDeath = 0;
		finalResult = 0;
		time = 0;
		totalTime = 0;
		backgroundSound = new Music("res/music/main.wav");
		deathSound = new Music("res/music/fart.wav");
		winSound = new Music("res/music/win.wav");
		world = new World(this, "res/worlds/level1.txt");
		display = new Display(title, width, height);
		Assets.init();
		player = new Player(this, 3, 5);
		listMob = new ListEntity(this);
		initRender();
		initConsole();
		backgroundSound.playSound();
	}
	
	/**
	 * Premier affichage apr�s initialisation de la fen�tre
	 */
	public void initRender() {
		// Initialise "bs" avec le type d'organisation de m�moire courante du canvas
		// Contiendra entre autre le nombre de buffers que le canvas utilisera
		bs = display.getCanvas().getBufferStrategy();
		// Si le canvas ne poss�de aucun buffers
		if(bs == null) {
			// Cr�e 3 buffers que le canvas utilisera
			display.getCanvas().createBufferStrategy(3);
			initRender();
		}
		// Initialise "g" avec un espace graphique dans lequel un buffer peut "dessiner"
		g = bs.getDrawGraphics();
		// Nettoie une partie d�finie de l'esapce graphique
		// Ici c'est l'enti�ret� de la fen�tre
		g.clearRect(0, 0, width, height);
		
		// D�but affichage
		
		
		world.renderGUI(g);
		if(player != null) {
			player.renderGUI(g);
			listMob.renderGUI(g);
		}
		
		
				
		// Fin affichage
		
		// Affiche le contenu du buffer � l'�cran
		// Le contenu �tant l'espace graphique
		bs.show();
		// Se d�barasser de l'espace graphique en m�moire
		g.dispose();
	}
	
	/**
	 * Affiche la map en console lors de la premi�re frame
	 */
	public void initConsole(){
		if(player != null) {
			player.renderCon();
			listMob.renderCon();
		}
		
		world.renderCon();
	}
	
	/**
	 * Permet de d�placer le joueur
	 */
	public void movePlayer() {
		player.move();
		setChanged();
		notifyObservers();
		if(player.isFlagged(player.getCenterX(), player.getCenterY()) || player.isFlaggedCon()) {
			changeWorld();
		}
	}
	
	/**
	 * Permet le d�placement du mob
	 */
	public synchronized void moveMob() {
		countScore++;
		if(countScore >= 3) {
			score--;
			time++;
			if(score < 0) score = 0;
			countScore = 0;
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Change de monde lorsque le joueur passe sur une case d'arriv�e
	 */
	public void changeWorld() {
		if(world.getId() == 1) {
			world = new World(this, "res/worlds/level2.txt");
			player = new Player(this, 9, 13);
		}
		else if(world.getId() == 2) {
			world = new World(this, "res/worlds/level3.txt");
			player = new Player(this, 6, 6);
		}
		else if(world.getId() == 3){
			world = new World(this, "res/worlds/level4.txt");
			player = new Player(this, 3, 3);
			
		}
		else if(world.getId() == 4) {
            world = new World(this, "res/worlds/level5.txt");
            player = new Player(this, 2, 2);
        }
		else if(world.getId() == 5){
			world = new World(this, "res/worlds/level6.txt");
			player = new Player(this, 4, 2);
		}
		else if(world.getId() == 6){
			world = new World(this, "res/worlds/level7.txt");
			player = new Player(this, 4, 4);
		}
		else if(world.getId() == 7){
			world = new World(this, "res/worlds/level8.txt");
			player = new Player(this, 7, 13);
		}
		else {
			backgroundSound.stopSound();
			winSound.playSound();
			world = new World(this, "res/worlds/gg.txt");
			player = null;
			display.getFrame().setFocusable(false);
			finalResult -= nbDeath * 20;
			totalTime = time;
			if(finalResult < 0) finalResult = 0;
		}
		display.getFrame().setSize(width, height);
		display.getFrame().setLocationRelativeTo(null);
		listMob.setMob();
	}
	
	/**
	 * @return la map utilis�e par le jeu
	 */
	public World getWorld() {
		return world;
	}
	
	/**
	 * @return le joueur utilis� par le jeu
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return la liste d'ennemi utilis�e par le jeu
	 */
	public ListEntity getList() {
		return listMob;
	}

	/**
	 * @return la fen�tre courante
	 */
	public Display getDisplay() {
		return display;
	}
	
	/**
	 * @return la largeur de la fen�tre
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Change la valeur de la largeur de la fen�tre
	 * @param width : la largeur
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return la hauteur de la fen�tre
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Change la valeur de la hauteur de la fen�tre
	 * @param height : la hauteur
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @return la musique de mort du joueur
	 */
	public Music getDS() {
		return deathSound;
	}
	
	/**
	 * @return la valeur du score du joueur
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Change la valeur du score du joueur
	 * @param score : le score du joueur
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * @return le nombre de fois qu'est mort le joueur
	 */
	public int getDeath() {
		return nbDeath;
	}
	
	/**
	 * Change le nombre de fois que le joueur est mort
	 * @param nbDeath : le nombre de fois que le joueur est mort
	 */
	public void setDeath(int nbDeath) {
		this.nbDeath = nbDeath;
	}
	
	/**
	 * @return le resultat final du joueur
	 */
	public int getResult() {
		return finalResult;
	}
	
	/**
	 * Change la valeur du r�sultat final du joueur
	 * @param result : le r�sultat final du joueur
	 */
	public void setResult(int result) {
		this.finalResult = result;
	}
	
	/**
	 * @return le temps que le joueur a mis pour finir les niveaux
	 */
	public int getTime() {
		return totalTime;
	}
}
