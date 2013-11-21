package domainePartie1;

public class ZoomModel {
	private float m_zoom = Default.ZOOM;
    private double[] m_zoomOptions;
    
    public float reqZoom(){
            return m_zoom;
    }
    public double[] reqZoomOptions(){
    	return m_zoomOptions;
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
