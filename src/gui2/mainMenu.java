package gui2;

import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import resloader.Resloader;

public class mainMenu  {
	
	private Buttons playBtn;
	private Buttons howToBtn;
	private Buttons exitBtn;
	private Text scenetitle1;
	private Text scenetitle2;
	private AnchorPane mainPane;
	private VBox buttonPane;
	private SoundButton soundBtn;
	public static Stage mainStage;
	public static Scene gameScene ; 
	private howToPlay hT ; 
	
	public mainMenu () {
		
		Resloader.load();
		this.createMenu();
		this.initializeMain();
		hT = new howToPlay();
		mainStage = new Stage();
		mainStage.setTitle("Foxxy Road");
		mainStage.setScene(gameScene);
		mainStage.setResizable(false);
		
		
	}
	

	public void createMenu() {
		mainPane = new AnchorPane();
		this.initializeButton();
		this.initializeTitle();
		this.initializeSoundButton();
		this.createBg();
		gameScene = new Scene(mainPane,GameSetting.Game_width,GameSetting.Game_height);
		
		
	}
	private void initializeMain() {
		
		this.playBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Game g = new Game(); 
				mainStage.setScene(g.getGameScene());
				
			}
		});
		this.howToBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainStage.setScene(hT.getGameScene());
				
			}
		});
		this.exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	}

	private void initializeButton() {
		
		this.playBtn = new Buttons("PLAY");
		this.howToBtn = new Buttons("HOW TO PLAY");
		this.exitBtn = new Buttons("EXIT");
		
		buttonPane = new VBox(15);
		buttonPane.setLayoutX(100);
		buttonPane.setLayoutY(320);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(this.playBtn,this.howToBtn,this.exitBtn);
		
		mainPane.getChildren().add(buttonPane);
		
		
	}
	
	private void initializeTitle() {
		
		this.scenetitle1 = new Text("Foxxy");
		this.scenetitle2 = new Text("Road.");
		

		this.scenetitle1.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 130));
		this.scenetitle1.setFill(Color.web("#b27e43"));
		this.scenetitle1.setStrokeWidth(1);
		this.scenetitle1.setStroke(Color.web("#cacf34"));
		this.scenetitle1.setLayoutX(70);
		this.scenetitle1.setLayoutY(200);
		
		this.scenetitle2.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 100));
		this.scenetitle2.setFill(Color.web("#b27e43"));
		this.scenetitle2.setStrokeWidth(1);
		this.scenetitle2.setStroke(Color.web("#cacf34"));
		this.scenetitle2.setLayoutX(180);
		this.scenetitle2.setLayoutY(270);
		
		mainPane.getChildren().addAll(this.scenetitle1,this.scenetitle2);
		
	}
	
	private void initializeSoundButton() {
		
		this.soundBtn = new SoundButton();
		
		this.soundBtn.setLayoutX(320);
		this.soundBtn.setLayoutY(20);
		
		
		mainPane.getChildren().add(this.soundBtn);
		
		
	}
	
	
	private void createBg() {
		
		BackgroundImage wallpaper = new BackgroundImage(Resloader.MAIN_BG,
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
