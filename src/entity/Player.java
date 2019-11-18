package entity;

import base.Fox;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;

public class Player extends Fox  {

	private ImageView fox1 ; 
	
	private static final int Velocity = 5 ; 
	private boolean outUp ; 
	private boolean outDown;
	private boolean outRight; 
	private boolean outLeft ; 
	
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
	public void moveUp() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i = 0 ; i < 5 ;i++) {
						foxGroup.setLayoutY(foxGroup.getLayoutY() - Velocity);
						Thread.sleep(30);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		moveThread.start();
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i = 0 ; i < 5 ;i++) {
						foxGroup.setLayoutY(foxGroup.getLayoutY() + Velocity);
						Thread.sleep(15);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		moveThread.start();
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i = 0 ; i < 5 ;i++) {
						foxGroup.setLayoutX(foxGroup.getLayoutX() + Velocity);
						Thread.sleep(15);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		moveThread.start();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					for(int i = 0 ; i < 5 ;i++) {
						foxGroup.setLayoutX(foxGroup.getLayoutX() - Velocity);
						Thread.sleep(15);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		moveThread.start();
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.fox1 = Resloader.fox ; 
		this.fox1.setFitHeight(50);
		this.fox1.setFitWidth(50);
		this.foxGroup = new Group(Resloader.fox) ; 
		
	}

	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		foxGroup.setLayoutX(200);
		foxGroup.setLayoutY(500);
	}
	
	
}
