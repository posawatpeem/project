package gui;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Buttons extends Button{
	
	private static final int BUTTON_HEIGHT = 52;
	private static final int BUTTON_WIDTH = 250;

	private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('"
			+ ClassLoader.getSystemResource("blue_button01.png").toString() + "');";
	private final String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('"
			+ ClassLoader.getSystemResource("blue_button00.png").toString() + "');";

	public Buttons(String text) {
		setText(text);
		setPrefWidth(BUTTON_WIDTH);
		setPrefHeight(BUTTON_HEIGHT);
		setButtonsFont();
		setStyle(BUTTON_FREE_STYLE);
		
	}

	private void setButtonsFont() {
		setFont(Font.loadFont(ClassLoader.getSystemResource("Kenney_Future.ttf").toString(), 26));
	}

	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}

	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
		setLayoutY(getLayoutY() - 4);
	}

	

}
