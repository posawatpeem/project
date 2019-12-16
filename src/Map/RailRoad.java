package Map;

import java.util.ArrayList;

import base.car;
import base.moveAble;
import entity.ObjectInMap;
import entity.Train;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public class RailRoad extends ObjectInMap implements moveAble{
	private ArrayList<Train> train;
	private ImageView rail;
	private Group groupRail;
	private Rectangle[] rails ;
	private boolean out ; 
	private AnimationTimer timer ; 
	private Thread thread ;

	
	public RailRoad(double xAxis , double yAxis) {
		super(xAxis , yAxis);
		this.train = new ArrayList<Train>();
		this.createTrain();
		this.move();
		this.out = false;
	}

	

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		rails = new Rectangle[1];
		rails[0] = new Rectangle(400, 100) ; 
		rails[0].setFill(new ImagePattern(Resloader.rail2));
	}

	
	public void createTrain() {
		
		int randomX = 50 ;
		for (int i = 0 ; i < 3 ; i++) {
			int X = (int)((Math.random() * (100 -1 +1 ))+1) ;
			randomX= randomX+X ; 
			randomX = randomX%50 ; 
			randomX =randomX*100;
			Train train1 = new Train(randomX , this.rails[0].getLayoutY()) ; 
			train.add(train1) ;
		 
		}
	}
	
	@Override
	public void move() {
		timer = new AnimationTimer(){
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				rails[0].setLayoutY(rails[0].getLayoutY() + 1);
			}
			
		};
		timer.start();
	}

	public Rectangle[] getRails() {
		return rails;
	}

	public ArrayList<Train> getTrain() {
		return train;
	}


	@Override
	public void setSpawnPosition(double xAxis, double yAxis) {
		
		rails[0].setLayoutX(0);
		rails[0].setLayoutY(yAxis);
				
	}



	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}

}
