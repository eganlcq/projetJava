package main.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Cette classe permet d'afficher la fen�tre de jeu
 * @author Octikoros
 *
 */
public class Display {

	// La fen�tre
	private JFrame frame;
	// Un espace rectangulaire de l'�cran dans lequel on dessine/ajoute des �l�ments graphiques
	// Ces �l�ments graphiques seront ensuite affich� dans la fen�tre
	private Canvas canvas;
	 // Le titre de la fen�tre (ce qui apparait au dessus)
	private String title;
	//La largeur de la fen�tre (en pixel)
	private int width;
	// La hauteur de la fen�tre (en pixel)
	private int height;
	
	/**
	 * Initialise une nouvelle fen�tre
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
	 * Cr�e une fen�tre
	 */
	public void createDisplay() {
		// La fen�tre est invisible de base
		frame = new JFrame(title);
		// D�finit la taille de la fen�tre
		frame.setSize(width, height);
		// D�finit ce qu'il se passe lorsqu'on veut fermer la fen�tre
		// Dans ce cas l� on ferme compl�tement l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Ne permet pas � l'utilisateur de changer la taille de la fen�tre
		frame.setResizable(false);
		// La fen�tre s'affiche au centre de l'�cran
		frame.setLocationRelativeTo(null);
		// La fen�tre est maintenant visible
		frame.setVisible(true);
		
		// Initialise un nouveau canvas
		canvas = new Canvas();
		// D�finit la taille du canvas
		canvas.setPreferredSize(new Dimension(width, height));
		// S'assurer que la taille du canvas ne changeras pas
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		// Ne permet pas au canvas d'�tre focus
		// Permet uniquement � la fen�tre d'�tre focus
		canvas.setFocusable(false);
		
		// Ajouter le canvas � la fen�tre
		frame.add(canvas);
		// Redimensionne la fen�tre pour que l'on puisse voir l'int�gralit� du canvas
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