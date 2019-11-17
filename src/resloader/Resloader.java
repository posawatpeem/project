package resloader;

import javafx.scene.image.ImageView;

public class Resloader {
	public static ImageView fox ; 
	public static ImageView train ; 
	public static ImageView rail ; 
	public static ImageView rail2 ; 
	public static ImageView car ; 
	public static ImageView river ; 
	public static ImageView road ; 
	
	public static void load() {
		fox = new ImageView(ClassLoader.getSystemResource("fox1.png").toString()) ; 
		train = new ImageView(ClassLoader.getSystemResource("train.png").toString()) ; 
		rail = new ImageView(ClassLoader.getSystemResource("rail.png").toString()) ;
		rail2 = new ImageView(ClassLoader.getSystemResource("rail2.png").toString()) ;
		river = new ImageView(ClassLoader.getSystemResource("river.png").toString()) ;
		road = new ImageView(ClassLoader.getSystemResource("road.png").toString()) ;
		car = new ImageView(ClassLoader.getSystemResource("car.png").toString()) ;
		
	}
	
}
