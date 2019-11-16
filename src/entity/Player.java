package entity;

import base.fox;
import javafx.scene.Group;
import resloader.Resloader;

public class Player extends fox  {
	
	private boolean isOutSceneUp ; 
	private boolean isOutSceneDown ;
	private boolean isOutSceneleft ; 
	private boolean isOutSceneRight ; 
	
	public Player() {
		this.alive = true ; 
	}

	public void checkOutScene() {
		if (foxGroup.getLayoutY() < 0) {
			this.isOutSceneDown = true ;  
		}else {
			this.isOutSceneDown =false ; 
		}
		
		if (foxGroup.getLayoutY() > 600) {
			this.isOutSceneUp = true ;  
		}else {
			this.isOutSceneUp = false ; 
		}
		
		if (foxGroup.getLayoutX() < 0 ) {
			this.isOutSceneleft = true ; 
		}else {
			this.isOutSceneleft = false ; 
		}
		
		if (foxGroup.getLayoutX() > 400) {
			this.isOutSceneRight = true ; 
		}
		else {
			this.isOutSceneRight = false ; 
		}
	}
	public void setSpawnPosition() {
		foxGroup.setLayoutX(200);
		foxGroup.setLayoutY(100);
	}
	public void setGc() {
		this.foxGroup =new Group(Resloader.fox) ; 
	}
	
	@Override
	public void moveup() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void movedown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveright() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveleft() {
		// TODO Auto-generated method stub
		
	}
}
