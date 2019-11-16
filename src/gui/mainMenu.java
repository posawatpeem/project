package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class mainMenu extends VBox{
	
	public mainMenu () {
		this.setPrefWidth(450);
		this.setPrefHeight(600);
		
		Button play = new Button("Play");
		Button howTo = new Button("How to play");
		Button exit = new Button("Exit");
		play.setPrefWidth(150);
		play.setPrefHeight(50);
		play.setStyle(
			"-fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: \"Arial Narrow\"; -fx-background-color: darkgreen;");
		play.setPrefHeight(800);
	}

}
