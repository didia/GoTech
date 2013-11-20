package domainePartie1;

public class Echelle {
	
	private int m_metreParStep;
	
	public Echelle(){
		m_metreParStep = Default.METRE_PAR_STEP;
	}
	
	public void setMetreParStep(int metreParStep){
		m_metreParStep = metreParStep;
	}
	
	public Position reqPositionEnMetre(Position positionEnStep){
		
		float posX = positionEnStep.reqPositionX() *m_metreParStep;
		float posY = positionEnStep.reqPositionY()* m_metreParStep;
		
		return new Position(posX, posY);
	}
	
	public Position reqPositionEnStep(Position positionEnMetre){
		
		float posX = positionEnMetre.reqPositionX()/m_metreParStep;
		float posY = positionEnMetre.reqPositionY()/m_metreParStep;
		
		return new Position(posX, posY);
	}
 
}
