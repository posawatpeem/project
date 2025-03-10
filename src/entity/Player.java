package entity;

import base.Fox;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;

public class Player extends Fox  {

	private ImageView fox1 ; 
	private boolean outUp ; 
	private boolean outDown;
	private boolean outRight; 
	private boolean outLeft ;
	private AnimationTimer timer;
	
	public Player() {
		
		super() ; 
		this.move();
		
	}
	
	public void checkOutScene() {
		
		if (foxGroup.getLayoutY()>550) {
			this.outDown =true ; 
			Fox.setDead(this.outDown);
		}else {
			this.outDown = false ; 
		}
		if(foxGroup.getLayoutY()<5) {
			this.outUp = true ; 
		}else {
			this.outUp= false ; 
		}
		if(foxGroup.getLayoutX()>350) {
			this.outRight = true ; 
		}else {
			this.outRight =false ; 
		}
		if(foxGroup.getLayoutX()<0) {
			this.outLeft =true; 
		}else {
			this.outLeft = false ; 
		}
	
	}

	public boolean isOutUp() {
		return outUp;
	}
	public boolean isOutDown() {
		return outDown;
	}
	public boolean isOutRight() {
		return outRight;
	}
	public boolean isOutLeft() {
		return outLeft;
	}
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.fox1 = Resloader.fox ; 
		this.fox1.setFitHeight(50);
		this.fox1.setFitWidth(50);
		this.foxGroup = new Group(fox1) ; 
		
	}

	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		foxGroup.setLayoutX(200);
		foxGroup.setLayoutY(430);
	}
	
	public void move() {
		timer = new AnimationTimer(){
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				foxGroup.setLayoutY(foxGroup.getLayoutY()+1);
			}
			
		};
		timer.start();
		
	}
	
	
}
