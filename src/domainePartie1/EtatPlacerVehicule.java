package domainePartie1;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;



public class EtatPlacerVehicule extends EtatDEdition {
	
	
	public EtatPlacerVehicule(Simulateur simulateur){
		super(simulateur);
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());
		if(noeud != null){
			m_simulateur.asgVehiculeUrgence(noeud);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
