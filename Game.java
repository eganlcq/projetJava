package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import main.display.Display;
import main.gfx.Assets;
import main.input.KeyManager;
import main.states.GameState;
import main.states.State;
import main.states.StateManager;

/**
 * Classe principale pour la création du jeu
 * @author Octikoros
 *
 */
public class Game implements Runnable {

	// Initialisation d'une fenêtre
	private Display display;
	// Largeur de la fenêtre
	private int width;
	// Longueur de la fenêtre
	private int height;
	// Titre de la fenêtre
	private String title;
	
	// Permet de décider si le jeu est en train d'être exécuté ou non
	private boolean running = false;
	// fil d'exécution du programme lui permettant d'effectuer plusieurs choses en même temps
	private Thread thread;
	
	// Permet d'organiser la mémoire d'un canvas où d'une fenêtre
	// Indique le nombre de buffers utilisés
	// Permet d'éviter les scintillements d'écran
	private BufferStrategy bs;
	// Permet à l'application d'afficher du contenu sur divers éléments tel qu'un canvas
	private Graphics g;
	
	// Déclaration d'une state de gameplay
	private State gameState;
	
	// Déclaration d'un key manager
	private KeyManager keyManager;
	
	/**
	 * Création des options du jeu
	 * @param title : titre
	 * @param width : largeur
	 * @param height : hauteur
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	/**
	 * Initialise certains des éléments du jeu
	 */
	private void init() {
		// Création d'une nouvelle fenêtre
		display = new Display(title, width, height);
		// Permet de pouvoir utiliser le clavier pour effectuer des opérations à l'écran
		display.getFrame().addKeyListener(keyManager);
		// Initialise tout le contenu une seule fois avant de faire tourner le jeu
		Assets.init();
		
		// Initialisation d'une state de gameplay
		gameState = new GameState(this);
		// La current state est une state de gameplay
		StateManager.setState(gameState);
	}
	
	/**
	 * Met à jour divers éléments tel que les variable d'instance régulièrement
	 */
	private void update() {
		
		// Initialise les 4 variables de déplacement avec une touche du clavier chacune
		keyManager.update();
		
		// Si la current state du programme n'est pas null
		if(StateManager.getState() != null) {
			// Mise à jour de divers éléments liés à la current state
			StateManager.getState().update();
		}
	}
	
	/**
	 * Affiche le contenu des éléments mis à jours régulièrement
	 */
	private void render() {
		// Initialise "bs" avec le type d'organisation de mémoire courante du canvas
		// Contiendra entre autre le nombre de buffers que le canvas utilisera
		bs = display.getCanvas().getBufferStrategy();
		// Si le canvas ne possède aucun buffers
		if(bs == null) {
			// Crée 3 buffers que le canvas utilisera
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		// Initialise "g" avec un espace graphique dans lequel un buffer peut "dessiner"
		g = bs.getDrawGraphics();
		// Nettoie une partie définie de l'esapce graphique
		// Ici c'est l'entièreté de la fenêtre
		g.clearRect(0, 0, width, height);
		
		// /!\ On commence à afficher du contenu ici /!\
		
		// Si la current state du programme n'est pas null
		if(StateManager.getState() != null) {
			// Affichage des éléments mis à jour liés à la current state à l'écran
			StateManager.getState().render(g);
		}
		
		// /!\ On arrête d'afficher du contenu ici /!\
		
		// Affiche le contenu du buffer à l'écran
		// Le contenu étant l'espace graphique
		bs.show();
		// Se débarasser de l'espace graphique en mémoire
		g.dispose();
	}
	
	/**
	 * Permet à la classe Game de s'exécuter
	 */
	public void run() {
		// Initialise le contenu avant de faire tourner le jeu
		init();
		
		// Le nombre de frames auxquelles le jeu tournera par seconde
		int fps = 60;
		// L'intervalle de temps qu'il y a entre chaque updates
		// Utilisé en nanosecondes
		double timeUpdate = 1000000000 / fps;
		// Contiendra le temps restant avant d'effectuer de nouveau une update
		double delta = 0.0;
		// Contiendra le current time de la machine
		long now;
		// Enregistre la dernière fois que l'on a demandé le current time de la machine
		long lastTime = System.nanoTime();
		// Permettra de vérifier si le nombre d'updates est bien a 60 par secondes
		long timer = 0;
		// Contiendra le nombre d'updates effectué en 1 seconde
		int updates = 0;
		
		while(this.running) {
			// Enregistrer le current time dans la variable "now"
			now = System.nanoTime();
			// Ajoute le temps restant avant de rappeler update() et render()
			delta += (now - lastTime) / timeUpdate;
			// Ajoute le temps passé depuis la dernière fois que l'on a demandé la current time de la machine
			timer += now - lastTime;
			// Met à jour la dernière fois que l'on a demandé le current time de la machine
			lastTime = now;
			
			// Vérifie si update() et render() peuvent se lancer ou non
			// Cela permet de respecter les 60 updates par secondes convenus
			if(delta >= 1) {
			// Met à jour régulièrement le contenu du jeu
			update();
			// Renvoie les éléments mis à jours à l'écran
			render();
			// Ajoute 1 au nombre de fois que l'on a effectué une update
			updates ++;
			// Remet la variable "delta" en dessous de 1
			delta --;
			}
			// Si le timer dépasse une seconde
			if((timer/1000000000) >= 5) {
				// Affiche le nombre d'updates effectuées en 1 seconde
				System.out.println("Frames par seconde : " + updates/5);
				// Remise à 0 du nombre d'updates
				updates = 0;
				// Remis eà 0 du compteur
				timer = 0;
			}
		}
		stop();
	}
	
	/**
	 * @return la largeur de la fenêtre de jeu
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return la hauteur de la fenêtre de jeu
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return la valeur du key manager courant
	 */
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	/**
	 * Permet de démarrer le fil d'exécution
	 */
	public synchronized void start() {
		// Si le jeu est déjà en fonctionnement, ne rien faire
		if(running) return;
		// Le jeu est en état de fonctionnement
		running = true;
		// Crée un fil d'exécution pour faire tourner la classe Game à part du reste du reste du programme
		// La classe Game a donc besoin d'être runnable pour rentrer dans un fil d'exécution
		thread = new Thread(this);
		// Active le fil d'exécution
		// Appelle la méthode run spécifiant ce qu'il doit s'exécuter
		thread.start();
	}
	
	/**
	 * Permet d'arreter le fil d'exécution
	 */
	public synchronized void stop() {
		// Si le jeu n'est déjà plus en fonctionnement, ne rien faire
		if(!running) return;
		// Le jeu n'est plus en état de fonctionnement
		running = false;
		try {
			// En attente pour que le fil d'exécution se ferme
			thread.join();
		} catch (InterruptedException e) {
			// Imprime l'erreur si le fil d'exécution a été interrompu
			e.printStackTrace();
		}
	}
}
