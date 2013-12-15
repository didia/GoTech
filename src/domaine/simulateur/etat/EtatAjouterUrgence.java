package domaine.simulateur.etat;


import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domaine.simulateur.Simulateur;
import domaine.reseau.Noeud;
public class EtatAjouterUrgence extends EtatDEdition{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 717799009258404096L;

	public EtatAjouterUrgence(Simulateur simulateur){
		super(simulateur);
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e) && !e.isControlDown())
		{
		Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());
		if(noeud != null){
			m_simulateur.declencherUrgence(noeud);
		}
		}
		else
		{
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



