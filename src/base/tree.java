package base;

import entity.ObjectInMap;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public class tree extends ObjectInMap implements moveAble {

	private AnimationTimer timer ; 
	private Rectangle[] trees ; 
	private double yLayout ; 
	private boolean first; 
	
	public Rectangle[] getTrees() {
		return trees;
	}
	public tree(double x , double y , boolean first) {
		super(x,y) ; 
		this.move();
		this.first = first ;
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				trees[0].setLayoutY(trees[0].getLayoutY() +1);
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
		trees = new Rectangle[1] ;
		trees[0] = new Rectangle(40,100) ; 
		trees[0].setFill(new ImagePattern(Resloader.tree)) ; 
	}
	@Override
	public void setSpawnPosition(double xAxis ,double yAxis) {
		// TODO Auto-generated method stub
		double x = xAxis ; 
		if (first) {
			if (xAxis ==200) {
				x = -100 ; 
			}
		}
		this.yLayout = yAxis ; 
		trees[0].setLayoutY(yAxis);
		trees[0].setLayoutX(x);
	
	}

}
