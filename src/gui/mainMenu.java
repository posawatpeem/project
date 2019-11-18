package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class mainMenu extends GridPane{
	
	public mainMenu () {
		this.setPrefWidth(400);
		this.setPrefHeight(600);
		
		Button play = new Button("Play");
		Button howTo = new Button("How to play");
		Button exit = new Button("Exit");
		
		play.setPrefWidth(250);
		play.setPrefHeight(52);
		howTo.setPrefWidth(250);
		howTo.setPrefHeight(52);
		exit.setPrefWidth(250);
		exit.setPrefHeight(52);
		
		this.setStyle("-fx-background-image: url('/Users/posawat/eclipse/eclipse-workspace/project-2019-1-20_centuryfox/res')");
		
	}

}
