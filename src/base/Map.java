package base;

import java.util.ArrayList;
import java.util.Random;
import entity.ObjectInMap;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import Map.Road;  

public  class Map extends VBox  {
	private ArrayList<Road> map ; 
	private boolean check ; 
	private Group groupMap ; 
	
	public Map() {
		super() ;
		map = new ArrayList<Road>();
		Road road1 = new Road(500);
		Road road2 = new Road(400) ; 
		Road road3 = new Road(300) ; 
		Road road4 = new Road(200) ; 
		Road road5 = new Road(100) ; 
		Road road6 = new Road(0) ; 
		Road road7 = new Road(-100) ; 
		map.add(road1) ; 
		map.add(road2) ; 
		map.add(road3) ; 
		map.add(road4) ; 
		map.add(road5) ; 
		map.add(road6) ; 
		map.add(road7) ; 
		this.getChildren().add(road1.getGroupRoad()) ; 
		this.getChildren().add(road2.getGroupRoad()) ; 
		this.getChildren().add(road3.getGroupRoad()) ; 
		this.getChildren().add(road4.getGroupRoad()) ; 
		this.getChildren().add(road5.getGroupRoad()) ; 
		this.getChildren().add(road6.getGroupRoad()) ; 
		this.getChildren().add(road7.getGroupRoad()) ; 
	}
	
	public boolean checkOut() {
		if (map.get(0).getGroupRoad().getLayoutY()>600) {
			this.check = true ; 
			return true ; 
		}
		this.check = false ; 
		return false ;	
	}
	
	public void addRoad() {
		if (this.check) {
			map.remove(0) ; 
			Road road = new Road(-100) ; 
			map.add(road) ; 	
		}
	}

	public ArrayList<Road> getMap() {
		return map;
	}
}

