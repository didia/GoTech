package domainePartie1;

import domainePartie1.Simulateur;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domainePartie1.EtatDEdition;


public class EtatAjouterNoeud extends EtatDEdition {
	
	private static Simulateur m_simulateur;
	public EtatAjouterNoeud(Simulateur simulateur){
		m_simulateur = simulateur;
		
	}
	
	public void doAction(MouseEvent e){
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
