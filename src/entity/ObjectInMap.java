package entity;

public abstract class ObjectInMap {
	
	public ObjectInMap(double xAxis , double yAxis) {
		setGc();
		setSpawnPosition(xAxis , yAxis);
		
	}
	
	public abstract void setGc();
	public abstract void setSpawnPosition(double xAxis , double yAxis) ; 
}
