package main.gfx;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.DataLine.Info;

/**
 * Cette classe représente la musique du jeu
 * @author Octikoros
 *
 */
public class Music {

	// Le fichier .wav comportant le son
	private File soundFile;
	// Le flux permettant de transporter le son en output
	private AudioInputStream stream;
	// Le format du son (.wav)
	private AudioFormat format;
	// Les informations supplémentaires concernant le son
	private Info info;
	// Ce qui permet de lancer le son
	private Clip clip;
	// Permet de contrôler divers éléments du son (par exemple les décibels)
	private FloatControl control;
	// Le chemin d'accès au fichier audio
	private String path;
	
	/**
	 * Initialisation d'un nouveau son
	 * @param path : chemin d'accès au fichier audio
	 */
	public Music(String path) {
		this.path = path;
	}
	
	/**
	 * Permet de jouer le son
	 */
	public void playSound() {
		try {
			soundFile = new File(path);
			stream = AudioSystem.getAudioInputStream(soundFile);
			format = stream.getFormat();
			info = new Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			if(path != "res/music/fart.wav") clip.loop(Clip.LOOP_CONTINUOUSLY);
			control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(-20);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Permet d'arrêter le son lorsqu'il est en train d'être joué
	 */
	public void stopSound() {
		clip.stop();
	}
	
}
