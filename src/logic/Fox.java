package logic;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fox {
	private ImageView img ; 
	private boolean haveLive ; 
	private final int speed = 1 ; 
	private int point  ; 
	protected Group[] foxGroup ;
	private boolean isOutSceneOn ; 
	private boolean isOutSceneUnder ; 
	private boolean isOutSceneLeft ; 
	private boolean isOutSceneRight ; 
	
	public Fox() {
		this.point = 0 ; 
		this.haveLive = true ; 
		this.img = new ImageView(ClassLoader.getSystemResource("fox1.png").toString()) ; 
		
	}
	
	public void checkOutScene() {
		if (foxGroup.getLayOutX() > 100) {
			
		}
	}
	
	public void addPoint() {
		this.point++ ; 
		
	}

	public boolean isHaveLive() {
		return haveLive;
	}

	public void setHaveLive(boolean haveLive) {
		this.haveLive = haveLive;
	}

	public int getPoint() {
		return point;
	}

	public void resetPoint() {
		this.point = 0 ; 
	}
	
	public Group[] getPlayer() {
		return this.foxGroup ; 
	}
	
}
