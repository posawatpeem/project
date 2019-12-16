package entity;

import base.moveAble;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public class Train extends ObjectInMap implements moveAble{
	
	private static final int velocity1 = 2 ;
	private static final int velocity2 = 6 ; 
	private static final int velocity3 = 7 ; 
	private ImageView train  ; 
	private double yLayout ;
	private double xLayout ;
	private Rectangle[]  Train; 
	private AnimationTimer timer ; 
	private boolean outScene ; 

	public Train(double xAxis , double yAxis) {
		super(xAxis , yAxis);
		this.move();
		this.outScene = false;
	}

	
	public Rectangle[] getTrain() {
		return Train;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		Train = new Rectangle[1];
		Train[0] = new Rectangle(200,200);
		Train[0].setFill(new ImagePattern(Resloader.train));
		
	}

	@Override
	public void setSpawnPosition(double xAxis , double yAxis) {
		// TODO Auto-generated method stub
		//this.yLayout = yAxis-25 ; 
		this.yLayout = yAxis ; 
		this.xLayout = xAxis ; 
		Train[0].setLayoutX(xAxis);
		Train[0].setLayoutY(yAxis-30);
		
	}


	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				Train[0].setLayoutX(Train[0].getLayoutX() - velocity1);
				Train[0].setLayoutY(Train[0].getLayoutY() +1 );
				if (Train[0].getLayoutX() < 0 ){
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
