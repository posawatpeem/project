package base;

import java.util.ArrayList;

import java.util.Random;
import entity.ObjectInMap;
import gui2.PointsPane;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Map.ExceptionCreate;
import Map.Road;
import Map.footpath;  

public  class Map  {
	
	private ArrayList<ObjectInMap> map ; 
	private static boolean check ;  
	private AnchorPane box ; 
	private int point;
	
	public Map() throws ExceptionCreate {
		
		box = new AnchorPane() ; 
		map = new ArrayList<ObjectInMap>();
		this.check = false ; 
		
		footpath foot1 = new footpath(400 , 500 , true);
		footpath foot2 = new footpath(400 , 400 , true);
		footpath foot3 = new footpath(400 , 100 , false);
		footpath foot4 = new footpath(400 , 0 , false);
		
		Road road1 = new Road(400 , 300,((int)(2+Math.random()*(3-1)))) ; 
		Road road2 = new Road(400 , 200,((int)(2+Math.random()*(3-1)))) ; 
		Road road3 = new Road(400 , -100,((int)(2+Math.random()*(3-1)))) ; 
		
		map.add(foot1) ; 
		map.add(foot2) ; 
		map.add(road1) ; 
		map.add(road2) ; 
		map.add(foot3) ; 
		map.add(foot4) ; 
		map.add(road3) ; 
		
		for (int i =0 ; i< 7 ;i++) {
			if (map.get(i) instanceof Road) {
				box.getChildren().addAll(((Road) map.get(i)).getRoads()[0]) ;
				for (car x : ((Road)map.get(i)).getCar()) {
					box.getChildren().addAll(x.getCars()) ; 
				}
			}
			if (map.get(i) instanceof footpath) {
				box.getChildren().add(((footpath) map.get(i)).getFootpaths()[0]) ;
				for (tree x :((footpath)map.get(i)).getTree()) {
					box.getChildren().addAll(x.getTrees()) ; 
				}
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
	
	public void addRoad() throws ExceptionCreate {
		
		if (this.check) {
			
			map.remove(0) ;
			PointsPane.setPoints(point++);
			PointsPane.updateScore();
			PointsPane.updateHighScore();
			Road road = new Road(400 , -100,((int)(2+Math.random()*(3-1)))) ; 
			map.add(road) ; 
			box.getChildren().add(((Road)map.get(map.size()-1)).getRoads()[0]) ; 
			
			for (car x : road.getCar()) {
				box.getChildren().add(x.getCars()[0]) ; 
			}
			
			this.check = false; 
			System.out.print(1);
		
		}
	}
	public void addfootpath() {
		
		if (this.check) {
			
			map.remove(0) ; 
			PointsPane.setPoints(point++);
			PointsPane.updateScore();
			PointsPane.updateHighScore();
			footpath footpath = new footpath(400 , -100 , false) ; 
			map.add(footpath) ; 
			box.getChildren().add(((footpath)map.get(map.size()-1)).getFootpaths()[0]) ; 
			
			for (tree x : footpath.getTree()) {
				box.getChildren().add(x.getTrees()[0]) ; 
			}
			
			this.check = false; 
			System.out.print(2);
		
		}
	}

	public ArrayList<ObjectInMap> getMap() {
		return map;
	}
	

}

