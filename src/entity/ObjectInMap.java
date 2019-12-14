package entity;

public abstract class ObjectInMap {
	
	public ObjectInMap(double yAxis) {
		setGc();
		setSpawnPosition(yAxis);
	}
	
	public abstract void setGc();
	public abstract void setSpawnPosition(double yAxis) ; 
}
