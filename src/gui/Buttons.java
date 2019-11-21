package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Buttons extends Button{
	
	private static final int BUTTON_HEIGHT = 50;
	private static final int BUTTON_WIDTH = 200;

	

	public Buttons(String text) {
		setText(text);
		setPrefWidth(BUTTON_WIDTH);
		setPrefHeight(BUTTON_HEIGHT);
		setButtonsFont();
		//setStyle(BUTTON_FREE_STYLE);
		initializedButton();
		
	}

	private void setButtonsFont() {
		setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 15));
	
	}

	
	
	private void initializedButton() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setPrefHeight(48);
				setPrefWidth(190);
			}
		});

		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setPrefHeight(50);
				setPrefWidth(200);
			}
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}
	

}
