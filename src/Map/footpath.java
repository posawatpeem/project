package Map;

import entity.ObjectInMap;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

import java.util.ArrayList;

import base.moveAble;
import base.tree;

public class footpath extends ObjectInMap implements moveAble {

	private Rectangle[] footpaths ; 
	private AnimationTimer timer ; 
	private ArrayList<tree> Tree ; 
	private double Y ; 
	public static final int maxTree =5  ; 
	public static final int minTree =1 ;
	
	public ArrayList<tree> getTree() {
		return Tree;
	}

	public footpath(double xAxis, double yAxis) {
		super(xAxis, yAxis);
		this.Y = yAxis ; 
		// TODO Auto-generated constructor stub
		this.Tree = new ArrayList<tree>() ; 
		this.createTree();
		this.move() ; 
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				footpaths[0].setLayoutY(footpaths[0].getLayoutY()+1);
				
			}
			
		};
		timer.start();
	}

	@Override
	public void checkCrash() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		footpaths = new Rectangle[1] ; 
		footpaths[0] = new Rectangle(400 ,100) ; 
		footpaths[0].setFill(new ImagePattern(Resloader.footpath));
	}

	public Rectangle[] getFootpaths() {
		return footpaths;
	}

	@Override
	public void setSpawnPosition(double xAxis, double yAxis) {
		// TODO Auto-generated method stub
		footpaths[0].setLayoutX(0);
		footpaths[0].setLayoutY(yAxis);
		
	}
	public void createTree() {
		int numTree = (int)((Math.random() * (maxTree - minTree +1)) +minTree) ; 
		for (int i = 0 ; i < numTree ;i++) {
			int x = (int)(Math.random() * (100 - 1 +1 ) +1) ; 
			x = x % 40 ; 
			x = x * 40 ; 
			tree tree = new tree(x , this.footpaths[0].getLayoutY()) ; 
			Tree.add(tree) ; 
		}
	}

}
