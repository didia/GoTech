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
	private float prevMetreParStep;
	private float m_metreParStep = Default.METRE_PAR_STEP;
	public static ZoomModel m_zoom;
	private boolean existeMap = false;
	private float echelleMap = 0;
	
	public Echelle(ZoomModel zoom)
	{
		m_zoom = zoom;
	}
	
	
	public float reqMetreParStep()
	{
		if(existeMap)
		{
			return this.echelleMap * reqPixelParStep();
		}
		else{
			return m_metreParStep;
		}
		
	}
	
	public float reqPixelParStep()
	{
		
			return Default.WIDTH_NOEUD / 2 * 3 * m_zoom.reqZoom();
		
	}
	
	public void setMetreParStep(int metreParStep)
	{
		prevMetreParStep = m_metreParStep;
		m_metreParStep = metreParStep;
	}
	
	/**
	* Convertie une position en metres en pixels
	*
	* @param positionEnMetre, la Position en metre
	*
	* @return la position en metre
	*
    */
	public Position reqPositionEnPixel(Position positionEnMetre)
	{
		Position positionEnStep =reqPositionEnStep(positionEnMetre);
		
		float pixelParStep = reqPixelParStep();
		int posX = Math.round((positionEnStep.reqPositionX() + 1) * pixelParStep);
		int posY = Math.round((positionEnStep.reqPositionY() + 1) * pixelParStep);
		
		return new Position(posX, posY);
	}
	
	
	/**
	* Convertie une position unite de la grille en metre
	*
	* @param positionEnStep, une Position en unite de la grille
	*
	* @return la position en metre
	*
    */
	public Position reqPositionDeStepEnMetre(Position positionEnStep)
	{	
		float posX = positionEnStep.reqPositionX() * this.reqMetreParStep();
		float posY = positionEnStep.reqPositionY() * this.reqMetreParStep();
		
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
		
		float posX = positionEnMetre.reqPositionX()/this.reqMetreParStep();
		float posY = positionEnMetre.reqPositionY()/this.reqMetreParStep();
		
		return new Position(posX, posY);
	}
	
	public Position reqPositionEnMetre(Position positionEnPixel){
		float posX = positionEnPixel.reqPositionX()/reqPixelParStep();
		float posY = positionEnPixel.reqPositionY()/reqPixelParStep();
		return reqPositionDeStepEnMetre(new Position(posX, posY));
	}
	
	private Position reqPositionEnOldStep(Position positionEnMetre)
	{
		float posX = positionEnMetre.reqPositionX()/prevMetreParStep;
		float posY = positionEnMetre.reqPositionY()/prevMetreParStep;
		
		return new Position(posX, posY);
	}
	
	
	
	public Position reqUpdatedPosition(Position position)
	{
		return reqPositionDeStepEnMetre(reqPositionEnOldStep(position));
	}
	public void initialiseMap(float echelleMap){
		this.existeMap = true;
		this.echelleMap = echelleMap;
		this.prevMetreParStep = m_metreParStep;
		
	}
	
}
