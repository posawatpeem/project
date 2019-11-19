package application;

import GameView.Game;
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
	 new Game() ;
	 
	 primaryStage = Game.gameStage ; 
	 primaryStage.setTitle("20 Century Fox");
	 primaryStage.show();
		
  
 }
 
 public static void main(String[] args) {
	 launch(args) ; 
 }
}