package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.Fox;
import resloader.Resloader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Resloader.load() ; 
		AnchorPane gamePane = new AnchorPane() ; 
		Fox fox = new Fox() ; 
		gamePane.getChildren().add(fox.getPlayer()) ;
		
		gamePane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		Scene gamescene = new Scene(gamePane,500,600) ; 
		
		
		primaryStage.setTitle("20_CenturyFox");
		primaryStage.setScene(gamescene);
		primaryStage.show() ; 
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args) ; 
	}

}
