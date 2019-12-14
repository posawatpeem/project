package Map;

import java.util.ArrayList;

import base.car;
import entity.Entity;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resloader.Resloader;
public class Road extends Entity{
	private int numRoads ; 
	private ArrayList<car> Car ; 
	private double yAxis ; 
	private ImageView road ; 
	private Group groupRoad ;
	
	public Road(int yAxis ) {
		super() ; 
		this.yAxis = yAxis ; 
		this.createCar();
		
		
	}
	

	public Group getGroupRoad() {
		this.groupRoad.toBack();
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
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		this.road.setLayoutX(0);
		this.road.setLayoutY(this.yAxis);
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