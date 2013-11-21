package domainePartie1;

public class Grille {
	
	public static ZoomModel m_zoom;
	public static Echelle m_echelle;
	
	public Grille(Echelle echelle, ZoomModel zoom){
		m_echelle = echelle;
		m_zoom = zoom;
	}
	
	public int reqPixelParStep(){
		return Math.round(Default.WIDTH_NOEUD/2 * 3 * m_zoom.reqZoom());
	}
	
	public Position reqPositionEnPixel(Position positionEnMetre){
		
		Position positionEnStep = m_echelle.reqPositionEnStep(positionEnMetre);
		int pixelParStep = reqPixelParStep();
		int posX = Math.round(positionEnStep.reqPositionX() * pixelParStep);
		int posY = Math.round(positionEnStep.reqPositionY() * pixelParStep);
		
		return new Position(posX, posY);
		
	}
	
	public Position reqPositionEnMetre(Position positionEnPixel){
		
		Position positionEnStep = reqPrecisePositionEnStep(positionEnPixel);
		
		return m_echelle.reqPositionEnMetre(positionEnStep);
		
	}
	
	public Position reqPrecisePositionEnStep(Position positionEnPixel){
		int pixelParStep = reqPixelParStep();
		
		int posX = Math.round(positionEnPixel.reqPositionX());
		int posY = Math.round(positionEnPixel.reqPositionY());
		if((posX%pixelParStep) != 0 || (posY%pixelParStep) == 0){
			
			if(posX%pixelParStep <= pixelParStep/2){
				posX -= posX%pixelParStep;
			}
			else{
				posX += pixelParStep - posX%pixelParStep;
			}
			
			if(posY%pixelParStep <= pixelParStep/2){
				posY -= posY%pixelParStep;
			}
			else{
				posY += pixelParStep - posY%pixelParStep;
			}
			
		}
		
		posX /= pixelParStep;
		posY /= pixelParStep;
		
		return new Position(posX, posY);
	}
}
