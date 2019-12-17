package resloader;

import java.net.URISyntaxException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Resloader {
	public static ImageView fox ;  
	public static ImageView gameOver ;
	public static Image car ; 
	public static Image car2 ; 
	public static Image road ; 
	public static ImageView exitButt ;
	public static Image MAIN_BG;
	public static Image muteBtn ;
	public static Image gameOver_BG;
	public static Image tree ; 
	public static Image footpath ;
	public static MediaPlayer backgroundGameSound;
	public static AudioClip jumpSound;

	
	public static void load() {
		
		fox = new ImageView(new Image(ClassLoader.getSystemResource("fox1.png").toString())) ; 
		MAIN_BG = new Image(ClassLoader.getSystemResource("background.jpg").toString());
		car = new Image(ClassLoader.getSystemResource("car.png").toString()) ; 
		car2 = new Image(ClassLoader.getSystemResource("car2.png").toString()) ; 
		muteBtn = new Image(ClassLoader.getSystemResource("volume.png").toString(),30,30,true,true) ; 
		road = new Image(ClassLoader.getSystemResource("road.jpg").toString());
		exitButt = new ImageView(new Image(ClassLoader.getSystemResource("exit2.png").toString(),35,35,true,true)) ; 
		gameOver_BG = new Image(ClassLoader.getSystemResource("gameoverbg.jpg").toString());
		gameOver = new ImageView(new Image(ClassLoader.getSystemResource("gameover.png").toString())) ; 
		tree = new Image(ClassLoader.getSystemResource("tree.png").toString()) ; 
		footpath = new Image(ClassLoader.getSystemResource("footpath.png").toString()) ; 
		backgroundGameSound = new MediaPlayer(
				new Media(ClassLoader.getSystemResource("backgroundSound.mp3").toString()));
		//jumpSound = new AudioClip(ClassLoader.getSystemResource("phaseJump4.wav").toString());
	}
	
}