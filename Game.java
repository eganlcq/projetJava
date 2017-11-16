package model;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Observable;

import main.display.Display;
import main.entities.Player;
import main.gfx.Assets;

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
	
	// Déclaration d'un nouveau joueur
	private Player player;
	
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
		player = new Player(20, 20);
		initRender();
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
		
		player.render(g);
		
		// Fin affichage
		
		// Affiche le contenu du buffer à l'écran
		// Le contenu étant l'espace graphique
		bs.show();
		// Se débarasser de l'espace graphique en mémoire
		g.dispose();
	}
	
	/**
	 * Permet de déplacer le joueur vers le haut
	 */
	public void up() {
		player.y -= 17;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Permet de déplacer le joueur vers le bas
	 */
	public void down() {
		player.y += 17;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Permet de déplacer le joueur vers la gauche
	 */
	public void left() {
		player.x -= 17;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Permet de déplacer le joueur vers la droite
	 */
	public void right() {
		player.x += 17;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * @return le joueur courant
	 */
	public Player getPlayer() {
		return player;
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
