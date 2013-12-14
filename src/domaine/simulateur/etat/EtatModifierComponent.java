package domaine.simulateur.etat;

import java.awt.event.MouseEvent;
import domaine.simulateur.Simulateur;






public class EtatModifierComponent extends EtatDEdition {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5027314231182483676L;

	public EtatModifierComponent(Simulateur simulateur){
		super(simulateur);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
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
		
		this.asgNoeudSelectione(m_simulateur.reqNoeud(e.getX(), e.getY()));
		
	
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		m_simulateur.deplacerNoeud(this.reqNoeudSelectione(), e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}
	
	

}
