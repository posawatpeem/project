package resloader;

import java.net.URISyntaxException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Resloader {
	public static ImageView fox ; 
	public static ImageView train ; 
	public static ImageView rail ; 
	public static ImageView rail2 ; 
	public static ImageView car ; 
	public static ImageView river ; 
	public static ImageView road ; 
	public static Image MAIN_BG;
	public static Image muteBtn ;
	public static Image unmuteBtn ; 
	
	public static void load() {
		
		fox = new ImageView(new Image(ClassLoader.getSystemResource("fox1.png").toString())) ; 
		MAIN_BG = new Image(ClassLoader.getSystemResource("background.jpg").toString());
		muteBtn = new Image(ClassLoader.getSystemResource("volume.png").toString(),30,30,true,true) ; 
		unmuteBtn = new Image(ClassLoader.getSystemResource("unmute.png").toString(),30,30,true,true) ;
	}
	
}