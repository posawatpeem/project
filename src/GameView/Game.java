package GameView;

import entity.Player;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resloader.Resloader;

public class Game {
	
	private AnchorPane gamePane ; 
	private Scene gameScene ; 
	public static Stage gameStage ; 
	
	public static Player player ; 
	private AnimationTimer Timer ; 
	
	private boolean up ;
	private boolean down ;
	private boolean left ; 
	private boolean right ;
	
	public Game() {
		 Resloader.load();
		 setSceneGame();
		 up = down = right = left = false ; 
		 createKeyListener();
		 Timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(up) {
					player.moveUp();
				}
				if(down) {
					player.moveDown();
				}
				if(right) {
					player.moveRight();
				}
				if(left) {
					player.moveLeft();
				}
			}
			 
		 };
		 Timer.start();
		 
	}
	
	public void setSceneGame() {
		
		 gamePane = new AnchorPane();
		 player = new Player() ; 
		 gamePane.getChildren().add(player.getFoxGroup()) ; 
		 gameScene =new Scene(gamePane,400,600) ;
		 
		 gameStage = new Stage() ; 
		 gameStage.setTitle("20 Century Fox");
		 gameStage.setScene(gameScene);
	
	}
	
	public void  createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.UP) {
					up = true ; 
				}
				else if (event.getCode() == KeyCode.DOWN) {
					down = true ;
				}
				else if (event.getCode() == KeyCode.LEFT) {
					left =true ;
				}
				else if (event.getCode() == KeyCode.RIGHT) {
					right = true ;
				}
			}
			 
		});
		
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.UP) {
					up = false ; 
				}
				else if (event.getCode() == KeyCode.DOWN) {
					down = false  ;
				}
				else if (event.getCode() == KeyCode.LEFT) {
					left =false;
				}
				else if (event.getCode() == KeyCode.RIGHT) {
					right = false;
				}
			}
		});	
	}
}
