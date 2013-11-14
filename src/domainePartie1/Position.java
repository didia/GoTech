package domainePartie1;

public class Position {
	private float positionX;
	private float positionY;
	Position(float x, float y)
	{
		this.positionX = x;
		this.positionY = y;
	}
	
	public float reqPositionX(){
		return this.positionX;
	}
	
	public float reqPositionY(){
		return this.positionY;
	}
	

}
