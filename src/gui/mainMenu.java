package gui;

import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
	
	private Buttons playBtn;
	private Buttons howToBtn;
	private Buttons exitBtn;
	private Text scenetitle1;
	private Text scenetitle2;
	private AnchorPane mainPane;
	private AnchorPane titlePane;
	private HBox buttonPane;
	public static Stage mainStage;
	
	public mainMenu () {
		
		Resloader.load();
		mainPane = new AnchorPane();
		mainStage = new Stage();
		Scene scene = new Scene(mainPane,GameSetting.Game_width,GameSetting.Game_height);
		mainStage.setTitle("Main menu");
		mainStage.setScene(scene);

		
		this.createBg();
		this.initializeTitle();
		this.initializeButton();
		this.initializeMain();
		
		
	}
	
	private void initializeMain() {
		
		this.playBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
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
		
		buttonPane = new HBox();
		buttonPane.setPadding(new Insets(10));
		buttonPane.setLayoutX(200);
		buttonPane.setLayoutY(250);
		buttonPane.getChildren().addAll(this.playBtn,this.howToBtn,this.exitBtn);
		
		mainPane.getChildren().add(buttonPane);
		
	}
	
	private void initializeTitle() {
		
		this.scenetitle1 = new Text("Foxxy");
		this.scenetitle2 = new Text("Road.");
		
		titlePane = new AnchorPane();
		
		this.scenetitle1.setFont(Font.loadFont("Kenney_Future.ttf",96));
		this.scenetitle1.setFill(Color.WHITE);
		this.scenetitle1.setStrokeWidth(3);
		this.scenetitle1.setStroke(Color.LIGHTGRAY);
		this.scenetitle1.setLayoutX(20);
		this.scenetitle1.setLayoutY(20);
		
		this.scenetitle2.setFont(Font.loadFont("Kenney_Future.ttf",96));
		this.scenetitle2.setFill(Color.WHITE);
		this.scenetitle2.setStrokeWidth(3);
		this.scenetitle2.setStroke(Color.LIGHTGRAY);
		this.scenetitle2.setLayoutX(40);
		this.scenetitle2.setLayoutY(60);
		
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
