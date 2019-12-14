package gui;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class howToPlay extends VBox {
	
	public static final int Width = 300 ; 
	public static final int Height = 500 ; 
	private Text howToText;
	 
	public howToPlay() {
		
		setPrefWidth(Width);
		setPrefHeight(Height);
		this.initializInfo();
		
	}
	
	public void initializInfo() {
	
		this.howToText = new Text("How To Play.");
		
		this.howToText.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 130));
		this.howToText.setFill(Color.web("#b27e43"));
		this.howToText.setStrokeWidth(1);
		this.howToText.setStroke(Color.web("#cacf34"));
	}
}
