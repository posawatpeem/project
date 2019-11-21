package gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Buttons extends Button{
	
	private static final int BUTTON_HEIGHT = 50;
	private static final int BUTTON_WIDTH = 250;

	

	public Buttons(String text) {
		setText(text);
		setPrefWidth(BUTTON_WIDTH);
		setPrefHeight(BUTTON_HEIGHT);
		setButtonsFont();
		//setStyle(BUTTON_FREE_STYLE);
		initializedButton();
		
	}

	private void setButtonsFont() {
		setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 26));
	}

	private void setButtonPressedStyle() {
		//setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setPrefWidth(230);
	}

	private void setButtonReleasedStyle() {
		//setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(50);
		setPrefWidth(250);
	}
	
	private void initializedButton() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setPrefHeight(48);
				setPrefWidth(240);
			}
		});

		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setPrefHeight(50);
				setPrefWidth(250);
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
