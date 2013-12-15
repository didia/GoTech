/**
* Cette classe encapsule et gere la grille
* 
*
* Permet de determiner la position finale d'un noeud en arrondissant au plus proche
* point de la grille
*
*
* @version 1.0
*
* @author GoTech
*
*
*/


package domaine.reseau;


public class Grille 
{

	public static Echelle m_echelle;
	private boolean isActive = true;
	
	public Grille(Echelle echelle)
	{
		m_echelle = echelle;
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
		return m_echelle.reqPositionEnPixel(positionEnMetre);
	}
	
	
	/**
	* Convertie une position en pixels en metres
	*
	* @param positionEnMetre, la Position en metres
	*
	* @return la position en metre
	*
    */
	public Position reqPositionEnMetre(Position positionEnPixel)
	{	
		Position positionEnStep = reqPrecisePositionEnStep(positionEnPixel);
		
		return m_echelle.reqPositionDeStepEnMetre(new Position(positionEnStep.reqPositionX() - 1, positionEnStep.reqPositionY()-1));
	}
	
	
	public Position reqUpdatedPosition(Position position)
	{
		return m_echelle.reqUpdatedPosition(position);
	}
	
	/**
	* Convertie la position en pixel en unite de la grille
	*
	* @param positionEnPixel, la Position en pixel
	*
	* @return la position en unite de la grille
	*
    */
	public Position reqPrecisePositionEnStep(Position positionEnPixel)
	{
		float pixelParStep = m_echelle.reqPixelParStep();
		float posX = positionEnPixel.reqPositionX();
		float posY = positionEnPixel.reqPositionY();
		
		if ((posX % pixelParStep) != 0 || (posY % pixelParStep) == 0)
		{	
			if(this.isActive)
			{
				
			
				if (posX % pixelParStep <= pixelParStep / 2)
				{
				posX -= posX%pixelParStep;
				}
				else
				{
				posX += pixelParStep - posX % pixelParStep;
				}
			
				if (posY % pixelParStep <= pixelParStep / 2)
				{
				posY -= posY % pixelParStep;
				}
				else
				{
				posY += pixelParStep - posY % pixelParStep;
				}
			}
		}
		
		posX /= pixelParStep;
		posY /= pixelParStep;
		
		return new Position(posX, posY);
	}
	
	public boolean isActive()
	{
		return this.isActive;
	}
	public void toggle()
	{
		this.isActive = !this.isActive;
	}
}
