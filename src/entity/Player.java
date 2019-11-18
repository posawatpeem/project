package entity;

import base.Fox;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;

public class Player extends Fox  {

	private ImageView fox1 ; 
	
	
	private boolean outUp ; 
	private boolean outDown;
	private boolean outRight; 
	private boolean outLeft ; 
	
	public Player() {
		super() ; 
	}
	public void checkOutScene() {
		if (foxGroup.getLayoutY()<0) {
			this.outDown =true ; 
		}else {
			this.outDown = false ; 
		}
		if(foxGroup.getLayoutY() > 600) {
			this.outUp = true ; 
		}else {
			this.outUp= false ; 
		}
		if(foxGroup.getLayoutX() < 0) {
			this.outLeft = true ; 
		}else {
			this.outLeft =false ; 
		}
		if(foxGroup.getLayoutX() > 400) {
			this.outLeft =true; 
		}else {
			this.outLeft = false ; 
		}
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
		foxGroup.setLayoutY(500);
	}
	
	
}
