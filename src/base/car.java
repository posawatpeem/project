package base;

import java.util.Random;

import entity.Entity;
import entity.ObjectInMap;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
public class car extends ObjectInMap implements Vehicle{

	private double yLayout ; 
	private double xLayout ; 
	private AnimationTimer timer ; 
	private Rectangle[] cars ; 
	private boolean outScene ; 
	
	public car(double x , double y,int velo) {
		super(x , y) ; 
		this.move(velo) ;
		this.outScene = false ; 
		
	}

	public Rectangle[] getCars() {
		return cars;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		cars = new Rectangle[1] ;
		cars[0] = new Rectangle(100,100) ;
		Random rand = new Random();
		if (rand.nextInt(2)==0) {
			cars[0].setFill(new ImagePattern(Resloader.car)) ; 
		} else {
			cars[0].setFill(new ImagePattern(Resloader.car2)) ; 
		}
	}

	@Override
	public void setSpawnPosition(double xAxis , double yAxis) {
		// TODO Auto-generated method stub
		this.yLayout = yAxis ; 
		this.xLayout = xAxis ; 
		cars[0].setLayoutX(xAxis);
		cars[0].setLayoutY(yAxis);
	}

	
	@Override
	public void move(int velo) {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				cars[0].setLayoutX(cars[0].getLayoutX() - velo);
				cars[0].setLayoutY(cars[0].getLayoutY() + 1 );
				if (cars[0].getLayoutX() < 0 ){
					outScene = true ; 
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
