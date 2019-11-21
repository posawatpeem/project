package gui;

import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
	
	private Button playBtn;
	private Button howToBtn;
	private Button exitBtn;
	private Text scenetitle1;
	private Text scenetitle2;
	private AnchorPane mainPane;
	private VBox titlePane;
	private VBox buttonPane;
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

		mainStage.setTitle("Main menu");
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
		
		this.playBtn = new Button("PLAY");
		this.howToBtn = new Button("HOW TO PLAY");
		this.exitBtn = new Button("EXIT");
		
		buttonPane = new VBox(8);
		buttonPane.setPadding(new Insets(10));
		buttonPane.setLayoutX(150);
		buttonPane.setLayoutY(250);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(this.playBtn,this.howToBtn,this.exitBtn);
		
		mainPane.getChildren().add(buttonPane);
		
		
	}
	
	private void initializeTitle() {
		
		this.scenetitle1 = new Text("Foxxy");
		this.scenetitle2 = new Text("Road.");
		
		titlePane = new VBox();
		titlePane.setPrefHeight(300);
		titlePane.setPrefWidth(600);
		
		this.scenetitle1.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 80));
		this.scenetitle1.setFill(Color.WHITE);
		this.scenetitle1.setStrokeWidth(3);
		this.scenetitle1.setStroke(Color.LIGHTGRAY);
		
		
		this.scenetitle2.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 70));
		this.scenetitle2.setFill(Color.WHITE);
		this.scenetitle2.setStrokeWidth(3);
		this.scenetitle2.setStroke(Color.LIGHTGRAY);
		
		titlePane.getChildren().addAll(this.scenetitle1,this.scenetitle2);
		
		mainPane.getChildren().add(titlePane);
		
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
