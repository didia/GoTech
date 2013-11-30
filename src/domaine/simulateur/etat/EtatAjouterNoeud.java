package domaine.simulateur.etat;


import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domaine.simulateur.Simulateur;



public class EtatAjouterNoeud extends EtatDEdition {
	
	
	public EtatAjouterNoeud(Simulateur simulateur){
		super(simulateur);
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e)){
			m_simulateur.ajouterNoeud(e.getX(), e.getY());
		}
		else{
			super.mouseClicked(e);
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
		mouseClicked(e);
		
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
