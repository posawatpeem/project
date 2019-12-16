package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resloader.Resloader;

public class GameOver {
	
	
	private Buttons playAgainBtn;
	private Buttons mainMenuBtn;
	private VBox buttonPane;
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
		gameScene = new Scene(mainPane,GameSetting.Game_width,GameSetting.Game_height);
		
	}
	
	private void initializeMain() {
		
		this.playAgainBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Game g = new Game(); 
				mainStage.setScene(g.getGameScene());
				
			}
		});
		
		this.mainMenuBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gui.mainMenu.mainStage.setScene(gui.mainMenu.gameScene);
			}
		});
	}

	private void initializeButton() {
		
		this.playAgainBtn = new Buttons("PLAY AGAIN");
		this.mainMenuBtn = new Buttons("MAIN MENU");
		this.gameOver = Resloader.gameOver;
		this.gameOver.setFitWidth(300);
		this.gameOver.setFitHeight(300);
		
		buttonPane = new VBox(15);
		buttonPane.setLayoutX(50);
		buttonPane.setLayoutY(50);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(this.gameOver,this.playAgainBtn,this.mainMenuBtn);
		
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
	

}
