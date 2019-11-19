package gui;

import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import resloader.Resloader;

public class mainMenu extends GridPane{
	
	private Buttons playButt;
	private Buttons howToButt;
	private Buttons exitButt;
	private Image MAIN_BG;
	
	public mainMenu () {
		
		this.setPrefWidth(400);
		this.setPrefHeight(600);
		
		try {
			
			MAIN_BG = new Image(ClassLoader.getSystemResource("bg.jpg").toURI().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		BackgroundImage wallpaper = new BackgroundImage(MAIN_BG,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));;
		this.setBackground(new Background(wallpaper));
		
		Text scenetitle1 = new Text("Foxxy");
		Text scenetitle2 = new Text("Road.");
		
		scenetitle1.setFont(Font.loadFont("Kenney_Future.ttf",96));
		scenetitle1.setFill(Color.WHITE);
		scenetitle1.setStrokeWidth(3);
		scenetitle1.setStroke(Color.LIGHTGRAY);
		
		scenetitle2.setFont(Font.loadFont("Kenney_Future.ttf",96));
		scenetitle2.setFill(Color.WHITE);
		scenetitle2.setStrokeWidth(3);
		scenetitle2.setStroke(Color.LIGHTGRAY);
		
		this.playButt = new Buttons("PLAY");
		this.howToButt = new Buttons("HOW TO PLAY");
		this.exitButt = new Buttons("EXIT");
		this.initializeMain();
		
		
	}
	
	private void initializeMain() {
		
		this.playButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		this.howToButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		this.exitButt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	}

}
