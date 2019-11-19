package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainMenu extends GridPane{
	
	private Buttons playButt;
	private Buttons howToButt;
	private Buttons exitButt;
	
	public mainMenu () {
		this.setPrefWidth(400);
		this.setPrefHeight(600);
		
		this.playButt = new Buttons("PLAY");
		this.howToButt = new Buttons("HOW TO PLAY");
		this.exitButt = new Buttons("EXIT");
		
		
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
				Stage stage = (Stage) exitButt.getScene().getWindow();
				stage.close();
			}
		});
	}

}
