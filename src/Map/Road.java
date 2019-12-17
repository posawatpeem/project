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
import java.util.ArrayList;
public class Road  extends ObjectInMap implements moveAble{
	
	private ArrayList<car> Car ; 
	private Thread thread ; 
	private Rectangle[] roads ; 
	private AnimationTimer timer ; 
	private static final int  maxCar = 20 ; 
	private static final int minCar =10 ;
	private boolean out ; 
	private car newCar ; 
	private ArrayList<Integer> check ; 
	
	public Road(double xAxis , double yAxis,int velo ) {
		super(xAxis ,yAxis) ; 
		this.out = false ;
		this.Car = new ArrayList<car>()  ;  
		this.createCar(velo);
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
		
	}
	
	
	public void createCar(int velo) { 
		int numCar = (int) ((Math.random() * (maxCar - minCar +1)) +minCar) ; 
		int randomX = 50 ;
		check = new ArrayList<Integer>() ; 
		for (int i = 0 ; i < numCar ; i++) {
			int X = (int)((Math.random() * (100 -1 +1 ))+1) ;
			randomX= randomX+X ; 
			randomX = randomX%50 ; 
			randomX =randomX*100;
			if (!check.contains(randomX)) {
				car car1 = new car(randomX , this.roads[0].getLayoutY(),velo) ; 
				check.add(randomX) ; 
				Car.add(car1) ;
			 
			}
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

	

	public boolean isOut() {
		return out;
	}

	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}
	
}