package application;


import base.Fox;
import entity.Player;
import gui2.mainMenu;
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
	 try {
		 new mainMenu() ;
		 primaryStage.setResizable(false);
		 primaryStage = mainMenu.mainStage ; 
		 primaryStage.show();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	
		
  
 }
 
 public static void main(String[] args) {
	 launch(args) ; 
 }
}