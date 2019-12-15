package resloader;

import java.net.URISyntaxException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Resloader {
	public static ImageView fox ; 
	public static ImageView train ; 
	public static ImageView rail ; 
	public static Image rail2 ; 
	public static ImageView car ; 
	public static ImageView river ; 
	public static Image road ; 
	public static Image exitButt ;
	public static Image MAIN_BG;
	public static Image howTo_BG;
	public static Image muteBtn ;
	public static Image unmuteBtn ; 
	public static Image grass_BG;
	
	public static void load() {
		
		fox = new ImageView(new Image(ClassLoader.getSystemResource("fox1.png").toString())) ; 
		MAIN_BG = new Image(ClassLoader.getSystemResource("background.jpg").toString());
		car = new ImageView(new Image(ClassLoader.getSystemResource("car.png").toString())) ; 
		muteBtn = new Image(ClassLoader.getSystemResource("volume.png").toString(),30,30,true,true) ; 
		road = new Image(ClassLoader.getSystemResource("road.jpg").toString());
		rail2 = (new Image(ClassLoader.getSystemResource("rail2.png").toString()));
		train = new ImageView(new Image(ClassLoader.getSystemResource("train.png").toString()));
		howTo_BG = (new Image(ClassLoader.getSystemResource("howTobg.jpg").toString()));
		exitButt = new Image(ClassLoader.getSystemResource("exit2.png").toString(),35,35,true,true) ; 
		grass_BG = new Image(ClassLoader.getSystemResource("grassBg.png").toString());
	}
	
}