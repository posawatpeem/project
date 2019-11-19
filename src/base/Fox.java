package base;


import entity.Entity;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Fox  extends Entity{
	
	private static final int Velocity = 5 ; 
	
	protected Group foxGroup ; 
	protected boolean haveLive ; 
	protected ImageView imageFox ;
	protected Thread moveThread ; 
	
	public Fox() {
		super() ; 
		this.haveLive = true ; 
	}
	
	public void moveUp() {
		foxGroup.setLayoutY(foxGroup.getLayoutY() - Velocity);
	}
	
	public void moveDown() {
		foxGroup.setLayoutY(foxGroup.getLayoutY() + Velocity);
	}
	
	public void moveRight() {
		foxGroup.setLayoutX(foxGroup.getLayoutX() + Velocity);
	}

	public void moveLeft() {
		foxGroup.setLayoutX(foxGroup.getLayoutX() - Velocity);
	}
	
	public Group getFoxGroup() {
		return foxGroup;
	}

}
