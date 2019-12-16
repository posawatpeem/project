package base;

import java.util.ArrayList;
import java.util.Random;
import entity.ObjectInMap;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Map.Road;  

public  class Map  implements moveAble {
	private ArrayList<Road> map ; 
	private boolean check ; 
	private Group groupMap ; 
	private AnimationTimer timer ; 
	private AnchorPane box ; 
	
	public Map() {
		box = new AnchorPane() ; 
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
		for (int i = 0 ; i< 7 ; i++) {
			box.getChildren().add(map.get(i).getRoads()[0]) ; 
			for (car x : map.get(i).getCar()) {
				box.getChildren().addAll(x.getCars()) ; 
			}
		}
		
	}
	
	public AnchorPane getBox() {
		return box;
	}

	public boolean checkOut() {
		return check;
		
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

	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method s
				box.setLayoutY(box.getLayoutY() +1 );
			}
		};
	}

	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}
}

