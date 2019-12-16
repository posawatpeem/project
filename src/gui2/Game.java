package gui2;

import java.util.ArrayList;

import Map.RailRoad;
import Map.Road;
import base.Map;
import base.car;
import entity.ObjectInMap;
import entity.Player;
import entity.Train;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resloader.Resloader;

public class Game {
	private AnchorPane gamePane ; 
	private Scene gameScene ; 
	public static Stage gameStage ; 
	
	public static Player player ; 
	private AnimationTimer Timer ; 
	private AnimationTimer Loop ; 
	
	private int size ; 
	private Map map ; 
	
	private boolean up ;
	private boolean down ;
	private boolean left ; 
	private boolean right ;
	
	private Road road1 ; 
	private Road road2 ; 
	public Game() {
		 Resloader.load();
		 setSceneGame();
		 newGame();
		 up = down = right = left = false ; 
		 createKeyListener();
		 playerMove();
		 createLoop();
		 
	}
	public void playerMove() {
		Timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				player.checkOutScene();
				if(up) {
					if (!player.isOutUp()) {
						player.moveUp();
					}
				}
				if(down) {
					if(!player.isOutDown()) {
						player.moveDown();
					}
				}
				if(right) {
					if(!player.isOutRight()) {
						player.moveRight();
					}
				}
				if(left) {
					if(!player.isOutLeft()) {
						player.moveLeft();
					}
				}
			}
			 
		 };
		 Timer.start();
	}
	
	public void newGame() {
		player = new Player() ; 
		map = new Map(); 
		gamePane.getChildren().add(map.getBox()) ; 
		gamePane.getChildren().add(player.getFoxGroup()) ; 
		player.getFoxGroup().toFront();
	}
	public void setSceneGame() {
		 gamePane = new AnchorPane();
		 gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		 
		 
		 gameScene =new Scene(gamePane,400,600) ;
		 gameStage = new Stage() ; 
		 gameStage.setTitle("20 Century Fox");
		 gameStage.setScene(gameScene);
		 gameStage.setResizable(false); 
		 
	}
	public void createLoop() {
		Loop = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if (map.checkOut()) {
					int random = (int)(Math.random() * (100 - 1 +1 ) +1) ; 
					if (random % 2 == 0) {
						map.addfootpath(); 
					}
					else {
						map.addRoad();
					}
				}
			}
			
		};
		Loop.start();
		
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

	public Scene getGameScene() {
		return gameScene;
	}

}
