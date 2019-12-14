package gui;

import Map.RailRoad;
import Map.Road;
import base.car;
import entity.Player;
import entity.Train;
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
	private Road road ; 
	private RailRoad railRoad;
	
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
	
	public void setSceneGame() {
		
		 gamePane = new AnchorPane();
		 player = new Player() ; 
		 road = new Road(100) ; 
		 railRoad = new RailRoad(200);
		 
		 gamePane.getChildren().add(player.getFoxGroup()) ; 
		 gamePane.getChildren().addAll(road.getGroupRoad()) ;
		 gamePane.getChildren().addAll(railRoad.getGroupRail());
		 for (car x : road.getCar()) {
			 gamePane.getChildren().add(x.getCarGroup()) ; 
		 }
		// for (Train x : railRoad.getTrain()) {
			// gamePane.getChildren().add(x.getTrainGroup()) ; 
		 //s}
		 player.getFoxGroup().toFront();
		 gameScene =new Scene(gamePane,400,600) ;
		 
		 gameStage = new Stage() ; 
		 gameStage.setTitle("20 Century Fox");
		 gameStage.setScene(gameScene);
		 gameStage.setResizable(false); 
	
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
