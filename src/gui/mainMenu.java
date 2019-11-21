package gui;

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

public class mainMenu extends AnchorPane {
	
	private Buttons playBtn;
	private Buttons howToBtn;
	private Buttons exitBtn;
	private Text scenetitle1;
	private Text scenetitle2;
	private AnchorPane mainPane;
	private VBox titlePane;
	private VBox buttonPane;
	private ImageView soundBtn;
	public static Stage mainStage;
	public static final int Width = 400 ; 
	public static final int Height = 600 ; 
	
	public mainMenu () {
		
		Resloader.load();
		mainPane = new AnchorPane();
		this.initializeButton();
		this.initializeTitle();
		this.createBg();
		Scene scene = new Scene(mainPane,Width,Height);
		mainStage = new Stage();

		mainStage.setTitle("Foxxy Road");
		mainStage.setScene(scene);
		mainStage.setResizable(false);
		this.initializeMain();
		
		
	}
	
	private void initializeMain() {
		
		this.playBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainStage.hide();
				new Game();
				Game.gameStage.show(); 
				
			}
		});
		this.howToBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
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
		
	
		titlePane = new VBox();
		titlePane.setPrefHeight(250);
		titlePane.setPrefWidth(400);
		
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
	
	private void createSoundBtn() {
		this.soundBtn = Resloader.volumeBtn;
		this.soundBtn.setOnMousePressed(new EventHandler<MouseEvent>() {

	        public void handle(MouseEvent event) {
	        	soundBtn.setFitHeight(50);
	        	soundBtn.setFitWidth(50);
	        }
	    });
		this.soundBtn.setLayoutX(0);
		this.soundBtn.setLayoutY(300);
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

}
