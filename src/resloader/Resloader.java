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
	}
	
}
