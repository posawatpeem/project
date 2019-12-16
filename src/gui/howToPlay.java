package gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import resloader.Resloader;

public class howToPlay  {
	
	private Text howToText;
	private Text firstRules;
	private Text secondRules;
	private Text thirdRules;
	private Text fourthRules;
	private AnchorPane mainPane;
	private VBox textBox;
	private Button exitButt;
	private Scene gameScene ;
	private HBox subTextBox;
	private boolean exit ; 
	 
	public howToPlay() {
		
		mainPane = new AnchorPane();
		exit = false ; 
		this.TextBox();
		this.createBg();
		gameScene = new Scene(mainPane,GameSetting.Game_width,GameSetting.Game_height);
		Stage mainStage = new Stage();

		mainStage.setTitle("Foxxy Road");
		mainStage.setScene(gameScene);
		mainStage.setResizable(false);
		
	}
	
	public boolean isExit() {
		return exit;
	}

	public void initializeInfo() {
	
		
		this.howToText = new Text("How To Play.\n");
		this.firstRules = new Text("\t1. Press ArrowUp \n \t to go forward.");
		this.secondRules = new Text("\t2. Press ArrowLeft \n \t to go left.");
		this.thirdRules = new Text("\t3. Press ArrowRight \n \t to go right.");
		this.fourthRules = new Text("\t4. Press ArrowDown \n \t to go backward.");
		
		this.subTextBox = new HBox();
		this.subTextBox.getChildren().add(this.howToText);
		this.subTextBox.setAlignment(Pos.CENTER);
		
		this.howToText.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 70));
		this.howToText.setFill(Color.web("#ECFF29"));
		this.howToText.setStrokeWidth(1);
		this.howToText.setStroke(Color.web("#cacf34"));
		
		this.setCustomFont(firstRules);
		this.setCustomFont(secondRules);
		this.setCustomFont(thirdRules);
		this.setCustomFont(fourthRules);
		
		this.textBox.getChildren().addAll(this.subTextBox,this.firstRules,this.secondRules,this.thirdRules,this.fourthRules);
	}
	
	private void createBg() {
		
		BackgroundImage wallpaper = new BackgroundImage(Resloader.MAIN_BG,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));;
        mainPane.setBackground(new Background(wallpaper));
	}
	
	private void TextBox() {
		
		this.textBox = new VBox();
		this.textBox.setPrefHeight(500);
		this.textBox.setPrefWidth(340);
		this.textBox.setLayoutX(30);
		this.textBox.setLayoutY(50);
		this.initializedButton();
		this.initializeInfo();
		

		this.textBox.setStyle("-fx-background-color: #CAAC73");
		this.textBox.setBorder(new Border(new BorderStroke(Color.web("#B47B51"), 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		
		mainPane.getChildren().add(this.textBox);
		
		
		
	}
	
	private void initializedButton() {
		
		this.exitButt = new Button();

		this.exitButt.setPrefHeight(50);
		this.exitButt.setPrefWidth(50);
		this.exitButt.setGraphic(Resloader.exitButt);
		this.exitButt.setStyle("-fx-background-color: #CAAC73");
		this.exitButt.setAlignment(Pos.TOP_LEFT);
		
		this.subTextBox = new HBox();
		this.subTextBox.getChildren().add(this.exitButt);
		this.subTextBox.setAlignment(Pos.TOP_RIGHT);
		
		this.exitButt.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				exitButt.setPrefWidth(30);
				exitButt.setPrefHeight(30);
			}
		});

		this.exitButt.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				exit = true ; 
				gui.mainMenu.mainStage.setScene(gui.mainMenu.gameScene);
				
			}
		});
		
		this.exitButt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				exitButt.setEffect(new DropShadow());
			}
		});

		this.exitButt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				exitButt.setEffect(null);
			}
		});
		
		this.textBox.getChildren().add(this.subTextBox);
	}

	public Scene getGameScene() {
		return gameScene;
	}
	
	public void setCustomFont(Text x) {
		x.setFill(Color.WHITESMOKE);
		x.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 40));
	}

	
	
}
