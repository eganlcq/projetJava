package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Observable;

import main.entities.Player;
import main.display.Display;
import main.entities.Mob;
import main.gfx.Assets;
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
	// L'ennemi
	private Mob mob;
	// Les ennemis en console
	private ArrayList<Mob> arrayMob;
	
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
		//playerCon = new PlayerConsole(this, 7, 2);
		//arrayMob = new ArrayList<MobConsole>();
		//setMob();
		world = new World(this, "res/worlds/testGUI.txt");
		player = new Player(this, 5, 5);
		mob = new Mob(this, 5, 8, "right");
		initRender();
		initConsole();
	}
	
	/*public void setMob() {
		for(MobConsole mob : arrayMob) {
			mob.running = false;
		}
		arrayMob.removeAll(arrayMob);
		arrayMob.add(new MobConsole(this, 7, 5, "right"));
		arrayMob.add(new MobConsole(this, 22, 8, "up"));
	}*/
	
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
		player.renderGUI(g);
		mob.renderGUI(g);
		
				
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
		player.renderCon();
		mob.renderCon();
		world.renderCon();
	}
	
	/**
	 * Permet de déplacer le joueur
	 */
	public void movePlayer() {
		player.move();
		if(player.collisionEntity() || player.collisionEntityCon()) {
			player.restart();
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Permet le déplacement du mob
	 */
	public void moveMob() {
		if(player.collisionEntity() || player.collisionEntityCon()) {
			player.restart();
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Affiche la console avec les éléments mis à jour
	 */
	public void generateCon() {
		/*if(world.flagged()) {
			if(world.getId() == 2) {
				world.getGrid()[4][11] = "B";
				worldConsole.getGrid()[7][11] = "I";
				worldConsole.getGrid()[10][11] = "E";
				worldConsole.getGrid()[13][11] = "N";
				worldConsole.getGrid()[19][11] = "J";
				worldConsole.getGrid()[22][11] = "O";
				worldConsole.getGrid()[25][11] = "U";
				worldConsole.getGrid()[28][11] = "E";
				worldConsole.getGrid()[playerCon.getX()][playerCon.getY()] = "P";
				setChanged();
				notifyObservers();
				System.exit(0);
			}
			else{
				playerCon = new PlayerConsole(this, 7, 2);
				setMob();
				worldConsole = new WorldConsole(this);
				initConsole();
			}
			
		}
		else{
			
		}*/
		setChanged();
		notifyObservers();
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
	 * @return l'ennemi utilisé par le jeu
	 */
	public Mob getMob() {
		return mob;
	}
	
	public ArrayList<Mob> getArrayList(){
		return arrayMob;
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
