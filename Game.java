package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Observable;

import main.console.MobConsole;
import main.console.PlayerConsole;
import main.display.Display;
import main.entities.Mob;
import main.entities.Player;
import main.gfx.Assets;
import main.worlds.WorldConsole;
import main.worlds.WorldGUI;

/**
 * Cette classe représente le modèle de l'architecture MVC
 * @author Octikoros
 *
 */
public class Game extends Observable{
	
	// La fenêtre
	private Display display;
	
	// Le titre de la fenêtre
	private String title;
	// La largeur de la fenêtre
	private int width;
	// La hauteur de la fenêtre
	private int height;
	
	// Permet d'organiser la mémoire d'un canvas où d'une fenêtre
	// Indique le nombre de buffers utilisés
	public BufferStrategy bs;
	// Permet à l'application d'afficher du contenu sur divers éléments tel qu'un canvas
	public Graphics g;
	
	// La map en interface graphique
	private WorldGUI worldGUI;
	// La map en console
	private WorldConsole worldConsole;
	// Le joueur
	private Player player;
	// L'ennemi
	private Mob mob;
	// Le joueur en console
	private PlayerConsole playerCon;
	// Les ennemis en console
	private MobConsole mobCon;
	private MobConsole mobCon2;
	
	/**
	 * Initialisation du jeu
	 * @param title : titre de la fenêtre
	 * @param width : largeur de la fenêtre
	 * @param height : hauteur de la fenêtre
	 */
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Initialisation des données du jeu
	 */
	public void init() {
		display = new Display(title, width, height);
		Assets.init();
		playerCon = new PlayerConsole(this, 7, 2);
		mobCon = new MobConsole(this, 7, 5, "right");
		mobCon2 = new MobConsole(this, 22, 8, "up");
		worldGUI = new WorldGUI("res/worlds/testGUI.txt");
		worldConsole = new WorldConsole(this, "res/worlds/testConsole.txt");
		player = new Player(this, 100, 100);
		mob = new Mob(this, 100, 200, "right");
		initRender();
		initConsole();
	}
	
	/**
	 * Premier affichage après initialisation de la fenêtre
	 */
	public void initRender() {
		// Initialise "bs" avec le type d'organisation de mémoire courante du canvas
		// Contiendra entre autre le nombre de buffers que le canvas utilisera
		bs = display.getCanvas().getBufferStrategy();
		// Si le canvas ne possède aucun buffers
		if(bs == null) {
			// Crée 3 buffers que le canvas utilisera
			display.getCanvas().createBufferStrategy(3);
			initRender();
		}
		// Initialise "g" avec un espace graphique dans lequel un buffer peut "dessiner"
		g = bs.getDrawGraphics();
		// Nettoie une partie définie de l'esapce graphique
		// Ici c'est l'entièreté de la fenêtre
		g.clearRect(0, 0, width, height);
		
		// Début affichage
		
		
		worldGUI.render(g);
		player.render(g);
		mob.render(g);
		
				
		// Fin affichage
		
		// Affiche le contenu du buffer à l'écran
		// Le contenu étant l'espace graphique
		bs.show();
		// Se débarasser de l'espace graphique en mémoire
		g.dispose();
	}
	
	/**
	 * Affiche la map en console lors de la première frame
	 */
	public void initConsole(){
		worldConsole.render();
	}
	
	/**
	 * Permet de déplacer le joueur
	 */
	public void movePlayer() {
		player.moveX();
		player.moveY();
		if(player.collisionEntity()) {
			player.setX(100);
			player.setY(100);
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Permet le déplacement du mob
	 */
	public void moveMob() {
		if(player.collisionEntity()) {
			player.setX(100);
			player.setY(100);
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Affiche la console avec les éléments mis à jour
	 */
	public void generateCon() {
		if(worldConsole.flagged()) {
			worldConsole.getGrid()[4][8] = "B";
			worldConsole.getGrid()[7][8] = "I";
			worldConsole.getGrid()[10][8] = "E";
			worldConsole.getGrid()[13][8] = "N";
			worldConsole.getGrid()[19][8] = "J";
			worldConsole.getGrid()[22][8] = "O";
			worldConsole.getGrid()[25][8] = "U";
			worldConsole.getGrid()[28][8] = "E";
			worldConsole.getGrid()[playerCon.getX()][playerCon.getY()] = "P";
			setChanged();
			notifyObservers();
			System.exit(0);
		}
		else{
			worldConsole.getGrid()[playerCon.getX()][playerCon.getY()] = "P";
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * @return la map en interface graphique utilisée par le jeu
	 */
	public WorldGUI getWorldGUI() {
		return worldGUI;
	}
	
	/**
	 * @return la map en console utilisée par la jeu
	 */
	public WorldConsole getWorldConsole() {
		return worldConsole;
	}
	
	/**
	 * @return le joueur utilisé par le jeu
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return l'ennemi utilisé par le jeu
	 */
	public Mob getMob() {
		return mob;
	}
	
	/**
	 * @return le joueur console utilisé par le jeu
	 */
	public PlayerConsole getPlayerCon() {
		return playerCon;
	}
	
	/**
	 * @return l'ennemi numéro 1 en console utilisé par le jeu
	 */
	public MobConsole getMobCon() {
		return mobCon;
	}
	
	/**
	 * @return l'ennemi numéro 2 en console utilisé par le jeu
	 */
	public MobConsole getMobCon2() {
		return mobCon2;
	}

	/**
	 * @return la fenêtre courante
	 */
	public Display getDisplay() {
		return display;
	}
	
	/**
	 * @return la largeur de la fenêtre
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return la hauteur de la fenêtre
	 */
	public int getHeight() {
		return height;
	}
}
