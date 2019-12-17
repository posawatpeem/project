package gui2;

import java.util.ArrayList;

import Map.RailRoad;
import Map.Road;
import Map.footpath;
import base.Map;
import base.car;
import base.tree;
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
import gui2.GameOver;

public class Game {
	private AnchorPane gamePane ; 
	private Scene gameScene ; 
	public static Stage gameStage ; 
	public static PointsPane pointsLabel;
	private int point;
	
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
		pointsLabel = new PointsPane(); 
		gamePane.getChildren().add(map.getBox()) ; 
		gamePane.getChildren().add(player.getFoxGroup()) ; 
		gamePane.getChildren().add(pointsLabel.getPointsLabel());
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
				if (player.isDead()) {
					Dead();
				}
				else {
					if (map.checkOut()) {
						int random = (int)(Math.random() * (100 - 1 +1 ) +1) ; 
						if (random % 2 == 0) {
							map.addfootpath();
							//PointsPane.setPoints(point++);
							//PointsPane.updateScore();
							System.out.print(true);
						}
						else {
							map.addRoad();
							//PointsPane.setPoints(point++);
							//PointsPane.updateScore();
							System.out.print(false);
						}
					}
					if (!player.isDead()) {
						for (int i = 0 ; i< 7 ; i++) {
							if (map.getMap().get(i) instanceof Road) {
								for (car x : ((Road)map.getMap().get(i)).getCar()) {
									if (x.getCars()[0].getLayoutX() + 100  >   player.getFoxGroup().getLayoutX()  && x.getCars()[0].getLayoutX()  <    player.getFoxGroup().getLayoutX() || 
										x.getCars()[0].getLayoutX() + 100  >   player.getFoxGroup().getLayoutX() + 50  && x.getCars()[0].getLayoutX()  <    player.getFoxGroup().getLayoutX()+ 50) {
										if (x.getCars()[0].getLayoutY() + 100  >   player.getFoxGroup().getLayoutY()  && x.getCars()[0].getLayoutY()  <    player.getFoxGroup().getLayoutY()||
											x.getCars()[0].getLayoutY() + 100  >   player.getFoxGroup().getLayoutY() +50  && x.getCars()[0].getLayoutY()  <    player.getFoxGroup().getLayoutY() +50) {
											player.setDead(true);
											
										}	
									}
								}
							}else if (map.getMap().get(i) instanceof footpath) {
								for (tree x : ((footpath)map.getMap().get(i)).getTree()) {
									if (x.getTrees()[0].getLayoutX() + 40  >   player.getFoxGroup().getLayoutX()  && x.getTrees()[0].getLayoutX()  <    player.getFoxGroup().getLayoutX() || 
											x.getTrees()[0].getLayoutX() + 40  >   player.getFoxGroup().getLayoutX() + 50  && x.getTrees()[0].getLayoutX()  <    player.getFoxGroup().getLayoutX()+ 50) {
											if (x.getTrees()[0].getLayoutY() + 100  >   player.getFoxGroup().getLayoutY()  && x.getTrees()[0].getLayoutY()  <    player.getFoxGroup().getLayoutY()||
												x.getTrees()[0].getLayoutY() + 100  >   player.getFoxGroup().getLayoutY() +50  && x.getTrees()[0].getLayoutY()  <    player.getFoxGroup().getLayoutY() +50) {
												player.setDead(true);

											}	
										}
								}
							}
						}
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
	
	public void Dead() {
		Loop.stop();
		Timer.stop();
		GameOver go = new GameOver();
		gui2.mainMenu.mainStage.setScene(go.getGameScene());
		
	}
	

}
