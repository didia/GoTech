package domainePartie1;

public class Position implements Comparable<Position>{
	private float positionX;
	private float positionY;

	public Position(float x, float y)
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
	public double reqDistanceOrigine(){
		return Math.sqrt(positionX*positionX + positionY*positionY);
	}

	@Override
	public int compareTo(Position o) {
		// TODO Auto-generated method stub
		if (positionX == o.reqPositionX() && positionY == o.reqPositionY()){
			return 0;
		}
		else{
			return (int)(this.reqDistanceOrigine() - o.reqDistanceOrigine());
		}
	}
	

}
