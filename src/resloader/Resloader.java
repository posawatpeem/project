package resloader;

import javafx.scene.image.ImageView;

public class Resloader {
	public static ImageView fox ; 
	
	public static void load() {
		fox = new ImageView(ClassLoader.getSystemResource("fox1.png").toString()) ; 
	}
	
}
