/**
* Cette classe fait la conversion des pixels en metres selon la valeur indiquee.
*
*
* @version 1.0
*
* @author GoTech
*
*
*/


package domaine.reseau;

import domaine.simulateur.Default;

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
	
	
	/**
	* Convertie une position unite de la grille en metre
	*
	* @param positionEnStep, une Position en unite de la grille
	*
	* @return la position en metre
	*
    */
	public Position reqPositionEnMetre(Position positionEnStep)
	{	
		float posX = positionEnStep.reqPositionX() * m_metreParStep;
		float posY = positionEnStep.reqPositionY() * m_metreParStep;
		
		return new Position(posX, posY);
	}
	
	
	/**
	* Convertie une position metreen unite de la grille 
	* 
	* @param positionEnMetre, une Position en metre
	*
	* @return la position en unite de la grille
	*
    */
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
