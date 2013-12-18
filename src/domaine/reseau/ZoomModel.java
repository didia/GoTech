package domaine.reseau;

import java.io.Serializable;

import domaine.simulateur.Default;

public class ZoomModel   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float m_zoom = Default.ZOOM;
    
    
    public float reqZoom(){
            return m_zoom;
    }
 
    public float augmenteZoom(){
           if(m_zoom <4){
                    m_zoom += 0.25;
            }
                    
            return m_zoom;
            
    }
    
    public float diminueZoom(){
            if(m_zoom > 0.25){
                    m_zoom -= 0.25;
            }
           
            return m_zoom;
    }

}
