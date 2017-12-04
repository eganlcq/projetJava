package main.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Cette classe permet d'afficher la fenêtre de jeu
 * @author Octikoros
 *
 */
public class Display {

	// La fenêtre
	private JFrame frame;
	// Un espace rectangulaire de l'écran dans lequel on dessine/ajoute des éléments graphiques
	// Ces éléments graphiques seront ensuite affiché dans la fenêtre
	private Canvas canvas;
	 // Le titre de la fenêtre (ce qui apparait au dessus)
	private String title;
	//La largeur de la fenêtre (en pixel)
	private int width;
	// La hauteur de la fenêtre (en pixel)
	private int height;
	
	/**
	 * Initialise une nouvelle fenêtre
	 * @param title : titre
	 * @param width : largeur
	 * @param height : hauteur
	 */
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}

	/**
	 * Crée une fenêtre
	 */
	public void createDisplay() {
		// La fenêtre est invisible de base
		frame = new JFrame(title);
		// Définit la taille de la fenêtre
		frame.setSize(width, height);
		// Définit ce qu'il se passe lorsqu'on veut fermer la fenêtre
		// Dans ce cas là on ferme complètement l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ne permet pas à l'utilisateur de changer la taille de la fenêtre
		frame.setResizable(false);
		// La fenêtre s'affiche au centre de l'écran
		frame.setLocationRelativeTo(null);
		// La fenêtre est maintenant visible
		frame.setVisible(true);
		
		// Initialise un nouveau canvas
		canvas = new Canvas();
		// Définit la taille du canvas
		canvas.setPreferredSize(new Dimension(width, height));
		// S'assurer que la taille du canvas ne changeras pas
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		// Ne permet pas au canvas d'être focus
		// Permet uniquement à la fenêtre d'être focus
		canvas.setFocusable(false);
		
		// Ajouter le canvas à la fenêtre
		frame.add(canvas);
		// Redimensionne la fenêtre pour que l'on puisse voir l'intégralité du canvas
		// La redimension se fait en fonction de setPreferredSize du canvas
		frame.pack();
	}
	
	/**
	 * @return le contenu de la variable "canvas"
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	
	/**
	 * @return le contenu de la variable "frame"
	 */
	public JFrame getFrame() {
		return frame;
	}
}