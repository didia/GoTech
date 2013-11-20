package domainePartie1;

public class Echelle {
	
	private float m_zoom = 1f;
	private int precision = 10;
	private int pixel_par_metre;
	
	public Echelle(){
		pixel_par_metre = Math.round(Default.WIDTH_NOEUD*2*m_zoom)/precision;
	}
	
	public void setZoom(float zoom){
		if(zoom <= 1 && zoom >= 0.1){
			m_zoom = zoom;
			pixel_par_metre = Math.round(Default.WIDTH_NOEUD*2*m_zoom)/precision;
		}
	}
	
	public Position reqPositionEnMetre(Position position){
		float posX = position.reqPositionX()/pixel_par_metre;
		float posY = position.reqPositionY()/pixel_par_metre;
		
		return new Position(posX, posY);
	}
	
	public Position reqPositionEnPixel(Position position){
		float posX = position.reqPositionX()*pixel_par_metre;
		float posY = position.reqPositionY()*pixel_par_metre;
		
		return new Position(posX, posY);
	}
 
}
