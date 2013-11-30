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


package domainePartie1;

public class Grille 
{
	public static ZoomModel m_zoom;
	public static Echelle m_echelle;
	
	public Grille(Echelle echelle, ZoomModel zoom)
	{
		m_echelle = echelle;
		m_zoom = zoom;
	}
	
	
	public int reqPixelParStep()
	{
		return Math.round(Default.WIDTH_NOEUD / 2 * 3 * m_zoom.reqZoom());
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
		Position positionEnStep = m_echelle.reqPositionEnStep(positionEnMetre);
		
		int pixelParStep = reqPixelParStep();
		int posX = Math.round((positionEnStep.reqPositionX() + 1) * pixelParStep);
		int posY = Math.round((positionEnStep.reqPositionY() + 1) * pixelParStep);
		
		return new Position(posX, posY);
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
		
		return m_echelle.reqPositionEnMetre(new Position(positionEnStep.reqPositionX() - 1, positionEnStep.reqPositionY()-1));
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
		int pixelParStep = reqPixelParStep();
		int posX = Math.round(positionEnPixel.reqPositionX());
		int posY = Math.round(positionEnPixel.reqPositionY());
		
		if ((posX % pixelParStep) != 0 || (posY % pixelParStep) == 0)
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
		
		posX /= pixelParStep;
		posY /= pixelParStep;
		
		return new Position(posX, posY);
	}
}
