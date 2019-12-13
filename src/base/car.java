package base;

import entity.Entity;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;
public class car extends Entity implements moveAble{

	private static final int velocity1 = 5 ;
	private static final int velocity2 = 6 ; 
	private static final int velocity3 = 7 ; 
	private ImageView car1  ; 
	private Group carGroup ; 
	private double yLayout ; 
	private AnimationTimer timer ; 
	
	public car(double y) {
		super() ; 
		this.yLayout = y ;
		this.move() ;
	}
	public Group getCarGroup() {
		return carGroup;
	}
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.car1 = Resloader.car ; 
		this.car1.setFitHeight(50);
		this.car1.setFitWidth(50);
		this.carGroup = new Group(car1) ; 
		
	}

	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		carGroup.setLayoutY(yLayout);
		carGroup.setLayoutX(300);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				carGroup.setLayoutX(carGroup.getLayoutX() - velocity1);
				if (carGroup.getLayoutX() ==10) {
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
