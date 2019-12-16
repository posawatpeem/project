package Map;

import java.util.ArrayList;

import base.car;
import base.moveAble;
import entity.Entity;
import entity.ObjectInMap;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
public class Road  extends ObjectInMap implements moveAble{
	private int numCar ; 
	private ArrayList<car> Car ; 
	private double yAxis ; 
	private Thread thread ; 
	private Rectangle[] roads ; 
	private AnimationTimer timer ; 
	private static final int  maxCar = 4 ; 
	private static final int minCar =1 ; 
	
	public Road(double xAxis , double yAxis ) {
		super(xAxis ,yAxis) ;  
		this.Car = new ArrayList<car>()  ;  
		this.createCar();
		this.move();
		
	}
	
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		roads = new Rectangle[1] ; 
		roads[0] = new Rectangle(400, 100) ; 
		roads[0].setFill(new ImagePattern(Resloader.road));
		
	}


	@Override
	public void setSpawnPosition(double xAxis , double yAxis) {
		// TODO Auto-generated method stub
		roads[0].setLayoutX(0);
		roads[0].setLayoutY(yAxis);
		this.yAxis = yAxis ; 
	}
	
	
	public void createCar() { 
		numCar = (int) ((Math.random() * (maxCar - minCar +1)) +minCar) ; 
		System.out.print(numCar);
		for (int i = 0 ; i < numCar ; i++) {
			int randomX = (int)((Math.random()*(400 -20 +1))+20) ; 
			randomX  = randomX%4 ; 	
			randomX = randomX*100 ; 
			car car1 = new car(randomX , this.yAxis) ; 
			Car.add(car1) ;
		}
	}


	public ArrayList<car> getCar() {
		return Car;
	}



	@Override
	public void move() {
		timer = new AnimationTimer(){
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				roads[0].setLayoutY(roads[0].getLayoutY() + 1);
				
				
			}
			
		};
		timer.start();
	}

	
	public Rectangle[] getRoads() {
		return roads;
	}

	public double getyAxis() {
		return yAxis;
	}

	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}

	public void checkOut() {
		
	}


	
}