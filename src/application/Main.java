package application;

import base.Fox;
import entity.Player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resloader.Resloader;

public class Main extends Application {

 @Override
 public void start(Stage primaryStage) throws Exception {
  // TODO Auto-generated method stub
	 Resloader.load(); 
	 AnchorPane gamePane = new AnchorPane();
	 Player player = new Player() ; 
	 gamePane.getChildren().add(player.getFoxGroup()) ; 
	
	 
	 Scene gameScene =new Scene(gamePane,400,600) ; 
	 gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			// TODO Auto-generated method stub
			if (event.getCode() == KeyCode.UP) {
				player.moveUp();
			}
			else if (event.getCode() == KeyCode.DOWN) {
				player.moveDown();
			}
			else if (event.getCode() == KeyCode.LEFT) {
				player.moveLeft();
			}
			else if (event.getCode() == KeyCode.RIGHT) {
				player.moveRight();
			}
		}
		 
	});
	 
	 primaryStage = new Stage() ; 
	 primaryStage.setTitle("20_CenturyFox");
	 primaryStage.setScene(gameScene);
	 primaryStage.show();
		
  
 }
 
 public static void main(String[] args) {
	 launch(args) ; 
 }
}