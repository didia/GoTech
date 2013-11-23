/**
* Cette classe fait la conversion des pixel en metre selon la valeur indiquee.
*
*
* @version 1.0
*
* @author GoTech
*
*
*/




package domainePartie1;

public class Echelle 
{
	private int prevMetreParStep;
	private int m_metreParStep = Default.METRE_PAR_STEP;
	
	public Echelle()
	{
		
	}
	
	public int reqMetreParStep()
	{
		return m_metreParStep;
	}
	
	public void setMetreParStep(int metreParStep)
	{
		prevMetreParStep = m_metreParStep;
		m_metreParStep = metreParStep;
	}
	
	public Position reqPositionEnMetre(Position positionEnStep)
	{	
		float posX = positionEnStep.reqPositionX() *m_metreParStep;
		float posY = positionEnStep.reqPositionY()* m_metreParStep;
		
		return new Position(posX, posY);
	}
	
	public Position reqPositionEnStep(Position positionEnMetre)
	{
		
		float posX = positionEnMetre.reqPositionX()/m_metreParStep;
		float posY = positionEnMetre.reqPositionY()/m_metreParStep;
		
		return new Position(posX, posY);
	}
	
	private Position reqPositionEnOldStep(Position positionEnMetre)
	{
		float posX = positionEnMetre.reqPositionX()/prevMetreParStep;
		float posY = positionEnMetre.reqPositionY()/prevMetreParStep;
		
		return new Position(posX, posY);
	}
	
	public Position reqUpdatedPosition(Position position)
	{
		return reqPositionEnMetre(reqPositionEnOldStep(position));
	}
	
}
