package Map;

import java.util.ArrayList;

import base.car;
import entity.Entity;
import entity.ObjectInMap;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resloader.Resloader;
public class Road extends ObjectInMap{
	private int numRoads ; 
	private ArrayList<car> Car ; 
	private double yAxis ; 
	private ImageView road ; 
	private Group groupRoad ;
	
	public Road(int yAxis ) {
		super(yAxis) ;  
		this.createCar();
		
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
		Car = new ArrayList<car>() ; 
		for (int i = 0 ; i< 1 ; i++) {
			int min = 1 ; 
			int max =6 ; 
			int carNum = min +(int)(Math.random()*((max-min)+1)) ;
			for (int j = 0 ; j < carNum ;j++) {
				car car1 = new car(this.yAxis) ; 
				Car.add(car1) ;
			}
		}
	}


	public ArrayList<car> getCar() {
		return Car;
	}



	
}