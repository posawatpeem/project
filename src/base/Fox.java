package base;

import entity.Entity;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Fox  extends Entity{
	
	protected Group foxGroup ; 
	protected boolean haveLive ; 
	protected ImageView imageFox ;
	protected Thread moveThread ; 
	
	public Fox() {
		super() ; 
		this.haveLive = true ; 
	}
	
	public abstract void moveUp() ; 
	
	public abstract void moveDown() ; 
	
	public abstract void moveRight() ;
	
	public Group getFoxGroup() {
		return foxGroup;
	}

	public abstract void moveLeft() ; 
	
	
}
