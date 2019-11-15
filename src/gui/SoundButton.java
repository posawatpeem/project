package gui;

import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

public class SoundButton extends Button{
	private static boolean SoundOn ; 
	private AudioClip song ; 
	
	public SoundButton() {
		this.SoundOn = true ; 
		
	}
	
	public void Mute() {
		this.SoundOn = false ; 
		this.stopSound();
	}
	
	public void UnMute() {
		this.SoundOn = true ; 
		this.playSound(); 
	}
	public static boolean IsSoundOn() {
		return SoundOn ; 
	}
	
	public void playSound() {
		if (IsSoundOn()) {
			this.song.play(); 
		}
	}
	
	public void stopSound() {
		if (!IsSoundOn()) {
			this.song.stop();
		}
	}
}
