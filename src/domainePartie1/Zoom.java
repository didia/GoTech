package domainePartie1;

public class Zoom {
	private float m_zoom = Default.ZOOM;
	
	public float reqZoom(){
		return m_zoom;
	}
	
	public float augmenteZoom(){
		if(m_zoom<1){
			m_zoom += 0.25;
		}
		else if(m_zoom <4){
			m_zoom += 1;
		}
			
		return m_zoom;
		
	}
	
	public float diminueZoom(){
		if(m_zoom <= 0.5){
			
		}
		else if (m_zoom <= 1){
			m_zoom -= 0.25;
		}
		else{
			m_zoom -= 1;
		}
		return m_zoom;
	}
	
}
