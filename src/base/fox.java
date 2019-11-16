package base;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class fox {
	
	protected boolean alive; 
	protected ImageView fox1 ;
	protected Group foxGroup ; 
	protected Thread moveThread ; 
	protected Timeline moving ; 
	
	public fox() {
		super() ; 
		this.alive =true ; 
		
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public ImageView getFox1() {
		return fox1;
	}
	public void setFox1(ImageView fox1) {
		this.fox1 = fox1;
	}
	public Group getFoxGroup() {
		return foxGroup;
	}
	public void setFoxGroup(Group foxGroup) {
		this.foxGroup = foxGroup;
	}
	public Thread getMoveThread() {
		return moveThread;
	}
	public void setMoveThread(Thread moveThread) {
		this.moveThread = moveThread;
	}
	public Timeline getMoving() {
		return moving;
	}
	public void setMoving(Timeline moving) {
		this.moving = moving;
	}
	public abstract void moveup() ; 
	
	public abstract void movedown() ; 
	
	public abstract void moveright() ;
	
	public abstract void moveleft() ; 
}
