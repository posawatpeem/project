package base;

import java.util.ArrayList;
import java.util.Random;
import entity.ObjectInMap;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Map.Road;
import Map.footpath;  

public  class Map  {
	private ArrayList<ObjectInMap> map ; 
	private boolean check ; 
	private Group groupMap ; 
	private AnimationTimer timer ; 
	private AnchorPane box ; 
	
	public Map() {
		box = new AnchorPane() ; 
		map = new ArrayList<ObjectInMap>();
		this.check = false ; 
		footpath foot1 = new footpath(400 , 500);
		Road road2 = new Road(400 , 400) ; 
		Road road3 = new Road(400 ,300) ; 
		Road road4 = new Road(400 , 200) ; 
		Road road5 = new Road(400 ,100) ; 
		Road road6 = new Road(400 , 0) ; 
		Road road7 = new Road(400 , -100) ; 
		map.add(foot1) ; 
		map.add(road2) ; 
		map.add(road3) ; 
		map.add(road4) ; 
		map.add(road5) ; 
		map.add(road6) ; 
		map.add(road7) ; 
		for (int i =0 ; i< 7 ;i++) {
			if (map.get(i) instanceof Road) {
				box.getChildren().addAll(((Road) map.get(i)).getRoads()[0]) ;
			}
			if (map.get(i) instanceof footpath) {
				box.getChildren().add(((footpath) map.get(i)).getFootpaths()[0]) ; 
			}
		}
		
		
	}
	
	public AnchorPane getBox() {
		return box;
	}

	public boolean checkOut() {
		if (map.get(0) instanceof Road) {
			if (((Road) map.get(0)).getRoads()[0].getLayoutY() == 600 ) {
				this.check  = true ; 
			}
		}
		if (map.get(0) instanceof footpath) {
			if (((footpath) map.get(0)).getFootpaths()[0].getLayoutY() == 600 ) {
				this.check  = true ; 
			} 
		}
		return check;
		
	}
	
	public void addRoad() {
		if (this.check) {
			map.remove(0) ; 
			Road road = new Road(400 , -100) ; 
			map.add(road) ; 
			box.getChildren().add(((Road)map.get(map.size()-1)).getRoads()[0]) ; 
			
			this.check = false; 
		}
	}

	public ArrayList<ObjectInMap> getMap() {
		return map;
	}


}

