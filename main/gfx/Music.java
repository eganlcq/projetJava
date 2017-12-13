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

public class Music {

	private File soundFile;
	private AudioInputStream stream;
	private AudioFormat format;
	private Info info;
	private Clip clip;
	private FloatControl control;
	
	private String path;
	
	public Music(String path) {
		this.path = path;
	}
	
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
	
	public void stopSound() {
		clip.stop();
	}
	
}
