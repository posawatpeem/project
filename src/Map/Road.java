package Map;

import java.util.ArrayList;

import base.car;
import base.moveAble;
import entity.Entity;
import entity.ObjectInMap;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resloader.Resloader;
public class Road  extends ObjectInMap implements moveAble{
	private int numRoads ; 
	private ArrayList<car> Car ; 
	private double yAxis ; 
	private ImageView road ; 
	private Group groupRoad ;
	public double getyAxis() {
		return yAxis;
	}



	private Thread thread ; 
	
	public Road(int yAxis ) {
		super(yAxis) ;  
		this.Car = new ArrayList<car>()  ;  
		this.createCar();
		this.move();
		
	}
	
	

	public Group getGroupRoad() {
		return groupRoad;
		
	}


	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		this.road = Resloader.road ;
		this.road.setFitHeight(100);
		this.road.setFitWidth(400);
		this.groupRoad = new Group(road) ; 
	}


	@Override
	public void setSpawnPosition(double yAxis) {
		// TODO Auto-generated method stub
		this.groupRoad.setLayoutX(0);
		this.groupRoad.setLayoutY(yAxis);
		this.yAxis = yAxis ; 
	}
	
	
	public void createCar() { 
		car car1 = new car(this.yAxis) ; 
		Car.add(car1) ;
	}


	public ArrayList<car> getCar() {
		return Car;
	}



	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							groupRoad.setLayoutY(groupRoad.getLayoutY()+1 );
							for(car x : Car ) {
								x.getCarGroup().setLayoutY(x.getCarGroup().getLayoutY()+1);
							}
							thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						};
					}
				});
	
			}
		});
		thread.start(); 
	}



	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}



	
}