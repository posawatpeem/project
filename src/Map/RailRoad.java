package Map;

import java.util.ArrayList;

import base.car;
import entity.ObjectInMap;
import entity.Train;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public class RailRoad extends ObjectInMap{
	private ArrayList<Train> train;
	private ImageView rail;
	private Group groupRail;
	private double yAxis;
	private Rectangle[] rails ;
	
	public RailRoad(int yAxis) {
		super(yAxis);
		this.train = new ArrayList<Train>();
		this.createTrain();
	}

	
	public Group getGroupRail() {
		return groupRail;
	}


	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		/*this.rail = Resloader.rail2;
		this.rail.setFitHeight(100);
		this.rail.setFitWidth(400);
		this.groupRail = new Group(rail);*/
		
		rails = new Rectangle[1] ; 
		rails[0] = new Rectangle(400, 100) ; 
		rails[0].setFill(new ImagePattern(Resloader.rail2));
	}

	@Override
	public void setSpawnPosition(double yAxis) {
		// TODO Auto-generated method stub
		/*this.groupRail.setLayoutX(0);
		this.groupRail.setLayoutY(yAxis);
		this.yAxis = yAxis;*/
		
		rails[0].setLayoutX(0);
		rails[0].setLayoutY(yAxis);
		this.yAxis = yAxis ; 
	}
	
	public void createTrain() {
		train = new ArrayList<Train>() ; 
		for (int i = 0 ; i< 1 ; i++) {
			int min = 1 ; 
			int max =6 ; 
			int carNum = min +(int)(Math.random()*((max-min)+1)) ;
			for (int j = 0 ; j < carNum ;j++) {
				Train train1 = new Train(this.yAxis) ; 
				train.add(train1) ;
			}
		}
	}
	
	public Rectangle[] getRails() {
		return rails;
	}

	public ArrayList<Train> getTrain() {
		return train;
	}

}
