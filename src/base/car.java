package base;

import entity.Entity;
import entity.ObjectInMap;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import resloader.Resloader;
public class car extends ObjectInMap implements moveAble{

	private static final int velocity1 = 5 ;
	private static final int velocity2 = 6 ; 
	private static final int velocity3 = 7 ; 
	private ImageView car1  ; 
	private Group carGroup ; 
	private double yLayout ; 
	private AnimationTimer timer ; 
	
	public car(double y) {
		super(y) ; 
		this.move() ;
		
	}
	public Group getCarGroup() {
		this.carGroup.toFront();
		return carGroup;
	}
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.car1 = Resloader.car ; 
		this.car1.setFitHeight(100);
		this.car1.setFitWidth(100);
		this.carGroup = new Group(car1) ;
		this.carGroup.toFront();
		
	}

	@Override
	public void setSpawnPosition(double yAxis) {
		// TODO Auto-generated method stub
		this.yLayout = yAxis ; 
		carGroup.setLayoutY(yAxis);
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
				if (carGroup.getLayoutX() ==-50) {
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
