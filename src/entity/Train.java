package entity;

import base.moveAble;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;

public class Train extends ObjectInMap implements moveAble{
	
	private static final int velocity1 = 2 ;
	private static final int velocity2 = 6 ; 
	private static final int velocity3 = 7 ; 
	private ImageView train  ; 
	private Group trainGroup ; 
	private double yLayout ; 
	private AnimationTimer timer ; 

	public Train(double yAxis) {
		super(yAxis);
		this.move();
	}

	
	public Group getTrainGroup() {
		this.trainGroup.toFront();
		return trainGroup;
	}
	
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.train = Resloader.train;
		this.train.setFitHeight(150);
		this.train.setFitWidth(150);
		this.trainGroup = new Group(train);
		this.trainGroup.toFront();
		
	}

	@Override
	public void setSpawnPosition(double yAxis) {
		// TODO Auto-generated method stub
		this.yLayout = yAxis-25 ; 
		trainGroup.setLayoutY(this.yLayout);
		trainGroup.setLayoutX(300);
		
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				trainGroup.setLayoutX(trainGroup.getLayoutX() - velocity1);
				if (trainGroup.getLayoutX() ==-50) {
					timer.stop();
				}
			}
			
		};
		timer.start() ; 
	}

	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
