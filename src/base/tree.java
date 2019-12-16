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

	
	public Rectangle[] getTrees() {
		return trees;
	}
	public tree(double x , double y) {
		super(x,y) ; 
		this.move();
		
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
		trees[0] = new Rectangle(50,100) ; 
		trees[0].setFill(new ImagePattern(Resloader.tree)) ; 
	}
	@Override
	public void setSpawnPosition(double xAxis ,double yAxis) {
		// TODO Auto-generated method stub
		this.yLayout = yAxis ; 
		trees[0].setLayoutY(yAxis);
		trees[0].setLayoutX(50);
	
	}

}
