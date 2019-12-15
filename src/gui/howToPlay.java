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
	
	public static final int Width = 400 ; 
	public static final int Height = 600 ; 
	private Text howToText;
	private AnchorPane mainPane;
	public static Stage mainStage;
	private VBox textBox;
	private Button exitButt;
	private ImageView btnBg;
	private Scene gameScene ;
	private HBox subTextBox;
	 
	public howToPlay() {
		
		mainPane = new AnchorPane();
		
		this.TextBox();
		this.createBg();
		//this.initializeInfo();
		gameScene = new Scene(mainPane,Width,Height);
		mainStage = new Stage();

		mainStage.setTitle("Foxxy Road");
		mainStage.setScene(gameScene);
		mainStage.setResizable(false);
		
	}
	
	public void initializeInfo() {
	
		
		this.howToText = new Text("How To Play.");
		
		this.subTextBox = new HBox();
		this.subTextBox.getChildren().add(this.howToText);
		this.subTextBox.setAlignment(Pos.CENTER);
		
		this.howToText.setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Pixel.ttf").toString(), 70));
		this.howToText.setFill(Color.web("#ECFF29"));
		this.howToText.setStrokeWidth(1);
		this.howToText.setStroke(Color.web("#cacf34"));
		
		this.textBox.getChildren().addAll(this.subTextBox);
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
		this.btnBg = new ImageView(Resloader.exitButt);
		this.exitButt.setPrefHeight(50);
		this.exitButt.setPrefWidth(50);
		this.exitButt.setGraphic(this.btnBg);
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
				exitButt.setPrefWidth(30);
				exitButt.setPrefHeight(30);
				mainMenu mM = new mainMenu();
				mainStage.setScene(mM.getGameScene());
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

	
	
}
