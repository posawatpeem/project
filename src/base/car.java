package base;

import entity.Entity;
import entity.ObjectInMap;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
public class car extends ObjectInMap implements moveAble{

	private static final int velocity1 = 5 ;
	private static final int velocity2 = 6 ; 
	private static final int velocity3 = 7 ; 
	private ImageView car1  ; 
	private double yLayout ; 
	private AnimationTimer timer ; 
	private Rectangle[] cars ; 
	
	public car(double y) {
		super(y) ; 
		this.move() ;
		
	}

	public Rectangle[] getCars() {
		return cars;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		cars = new Rectangle[1] ;
		cars[0] = new Rectangle(50,100) ;
		cars[0].setFill(new ImagePattern(Resloader.car)) ; 
	}

	@Override
	public void setSpawnPosition(double yAxis) {
		// TODO Auto-generated method stub
		this.yLayout = yAxis ; 
		cars[0].setLayoutX(300);
		cars[0].setLayoutY(yAxis);
	}

	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				cars[0].setLayoutX(cars[0].getLayoutX() - velocity1);
				if (cars[0].getLayoutX() ==-50) {
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
