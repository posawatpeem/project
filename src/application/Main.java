package application;


import base.Fox;
import entity.Player;
import gui.mainMenu;
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
	 new mainMenu() ;
	 
	 primaryStage = mainMenu.mainStage ; 
	 primaryStage.show();
		
  
 }
 
 public static void main(String[] args) {
	 launch(args) ; 
 }
}