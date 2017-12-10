package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Observable;

import main.entities.Player;
import main.display.Display;
import main.entities.ListEntity;
import main.gfx.Assets;
import main.tiles.Tile;
import main.worlds.World;

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
	
	// La map
	private World world;
	// Le joueur
	private Player player;
	// Les ennemis en console
	private ListEntity listMob;
	
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
		world = new World(this, "res/worlds/level1.txt");
		display = new Display(title, width, height);
		Assets.init();
		player = new Player(this, 3, 5);
		listMob = new ListEntity(this);
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
		
		
		world.renderGUI(g);
		if(player != null) {
			player.renderGUI(g);
			listMob.renderGUI(g);
		}
		
		
				
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
		if(player != null) {
			player.renderCon();
			listMob.renderCon();
		}
		
		world.renderCon();
	}
	
	/**
	 * Permet de déplacer le joueur
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
	 * Permet le déplacement du mob
	 */
	public synchronized void moveMob() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Change de monde lorsque le joueur passe sur une case d'arrivée
	 */
	public void changeWorld() {
		if(world.getId() == 1) {
			world = new World(this, "res/worlds/level2.txt");
			player = new Player(this, 6, 6);
		}
		else {
			world = new World(this, "res/worlds/gg.txt");
			player = null;
			display.getFrame().setFocusable(false);
		}
		display.getFrame().setSize(width, height);
		display.getFrame().setLocationRelativeTo(null);
		listMob.setMob();
	}
	
	/**
	 * @return la map utilisée par le jeu
	 */
	public World getWorld() {
		return world;
	}
	
	/**
	 * @return le joueur utilisé par le jeu
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * @return la liste d'ennemi utilisée par le jeu
	 */
	public ListEntity getList() {
		return listMob;
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
	 * Change la valeur de la largeur de la fenêtre
	 * @param width : la largeur
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @return la hauteur de la fenêtre
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Change la valeur de la hauteur de la fenêtre
	 * @param height : la hauteur
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
