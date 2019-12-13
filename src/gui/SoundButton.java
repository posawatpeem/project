package gui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import resloader.Resloader;

public class SoundButton extends Button{
	private static boolean SoundOn ; 
	private AudioClip song ; 
	private final ImageView btnBg;
	private static final int BUTTON_HEIGHT = 30;
	private static final int BUTTON_WIDTH = 30;
	
	public SoundButton() {
		this.SoundOn = true ; 
		this.btnBg = new ImageView(Resloader.muteBtn);
		this.setPrefHeight(BUTTON_HEIGHT);
		this.setPrefWidth(BUTTON_WIDTH);
		this.setGraphic(this.btnBg);
		this.setStyle("-fx-background-color: #FEAD32");
		
		this.btnBg.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
            	//if (btnBg == new ImageView(Resloader.unmuteBtn))  {
            		btnBg.setImage(Resloader.unmuteBtn);
            	//} else {
            		//btnBg.setImage(Resloader.unmuteBtn);
            	//}      
            }
            
        });

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
