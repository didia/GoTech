package domainePartie1;


import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;




public class EtatAjouterNoeud extends EtatDEdition {
	
	
	public EtatAjouterNoeud(Simulateur simulateur){
		super(simulateur);
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(SwingUtilities.isLeftMouseButton(e)){
			m_simulateur.ajouterNoeud(e.getX(), e.getY());
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
