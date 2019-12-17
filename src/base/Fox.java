package base;


import entity.Entity;
import gui2.Game;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Fox  extends Entity{
	
	private static final int Velocity = 10 ; 
	
	protected Group foxGroup ; 
	protected ImageView imageFox ;
	private static boolean dead ; 
	
	public static void setDead(boolean dead) {
		Fox.dead = dead;
	}

	public Fox() {
		super() ; 
		this.dead = false ; 
	}
	
	public boolean isDead() {
		return dead;
	}

	public void moveUp() {
		foxGroup.setLayoutY(foxGroup.getLayoutY() - Velocity);
		}
	
	public void moveDown() {
		foxGroup.setLayoutY(foxGroup.getLayoutY() + Velocity);
		
	}
	
	public void moveRight() {
		foxGroup.setLayoutX(foxGroup.getLayoutX() + 7);
		
	}

	public void moveLeft() {
		foxGroup.setLayoutX(foxGroup.getLayoutX() - 7);
		
	}
	
	public Group getFoxGroup() {
		return foxGroup;
	}
	
	

	

}
