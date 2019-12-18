package gui2;

import Map.ExceptionCreate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import resloader.Resloader;

public class GameOver {
	
	
	private Buttons playAgainBtn;
	private Buttons mainMenuBtn;
	private HBox buttonPane;
	private AnchorPane mainPane;
	public static Stage mainStage;
	public static Scene gameScene ;
	private ImageView gameOver;
	
	
	public GameOver() {
		this.createMenu();
		mainStage = new Stage();
		mainStage.setTitle("Foxxy Road");
		mainStage.setScene(gameScene);
		mainStage.setResizable(false);

	}
	
	public void createMenu() {
		mainPane = new AnchorPane();
		this.initializeButton();
		this.initializeMain();
		this.createBg();
		this.createCurrentScoreLabel();
		this.createHighestScoreLabel();
		gameScene = new Scene(mainPane,GameSetting.Game_width,GameSetting.Game_height);
		
	}
	
	private void initializeMain() {
		
		this.playAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Game g = null;
				try {
					g = new Game();
				} catch (ExceptionCreate e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				gui2.mainMenu.mainStage.setScene(g.getGameScene());
				
			}
		});
		
		this.mainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gui2.mainMenu.mainStage.setScene(gui2.mainMenu.gameScene);
			}
		});
		
		this.playAgainBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				playAgainBtn.setPrefSize(90,50);
			}
		});
		
		this.mainMenuBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainMenuBtn.setPrefSize(90, 50);
			}
		});
		
		this.playAgainBtn.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				playAgainBtn.setPrefSize(100,50);
			}
		});
		
		this.mainMenuBtn.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				mainMenuBtn.setPrefSize(100, 50);
			}
		});

		
	}

	private void initializeButton() {
		
		this.playAgainBtn = new Buttons("PLAY AGAIN");
		this.mainMenuBtn = new Buttons("MAIN MENU");
		this.playAgainBtn.setStyle("-fx-background-color: #CA382C");
		this.mainMenuBtn.setStyle("-fx-background-color: #CA382C");
		this.mainMenuBtn.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 10));
		this.playAgainBtn.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 10));
		this.playAgainBtn.setPrefSize(100,50);
		this.mainMenuBtn.setPrefSize(100, 50);
		
		
		this.gameOver = Resloader.gameOver;
		this.gameOver.setFitWidth(300);
		this.gameOver.setFitHeight(100);
		this.gameOver.setLayoutX(55);
		this.gameOver.setLayoutY(100);
		
		buttonPane = new HBox(30);
		buttonPane.setLayoutX(85);
		buttonPane.setLayoutY(420);
		buttonPane.getChildren().addAll(this.playAgainBtn,this.mainMenuBtn);
		
		mainPane.getChildren().add(this.gameOver);
		mainPane.getChildren().add(buttonPane);
		
		
	}
	
	private void createBg() {
		
		BackgroundImage wallpaper = new BackgroundImage(Resloader.gameOver_BG,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));;
       mainPane.setBackground(new Background(wallpaper));
	}

	public Scene getGameScene() {
		return gameScene;
	}
	
	private void createHighestScoreLabel() {
		Label highestScoreLabel = new Label("BEST");
		highestScoreLabel.setTextFill(Color.ANTIQUEWHITE);
		highestScoreLabel.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 25));
		highestScoreLabel.setLayoutX(160);
		highestScoreLabel.setLayoutY(240);
		Label highestScore = new Label(String.valueOf(PointsPane.highestPoints));
		highestScore.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 25));
		highestScore.setLayoutX(190);
		highestScore.setLayoutY(280);
		highestScore.setTextFill(Color.ANTIQUEWHITE);
		mainPane.getChildren().addAll(highestScoreLabel, highestScore);
	}

	private void createCurrentScoreLabel() {
		Label scoreLabel = new Label("SCORE");
		scoreLabel.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 25));
		scoreLabel.setLayoutX(150);
		scoreLabel.setLayoutY(320);
		scoreLabel.setTextFill(Color.ANTIQUEWHITE);
		Label score = new Label(String.valueOf(PointsPane.points));
		score.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 25));
		score.setLayoutX(190);
		score.setLayoutY(360);
		score.setTextFill(Color.ANTIQUEWHITE);
		mainPane.getChildren().addAll(scoreLabel, score);
	}
	

}
