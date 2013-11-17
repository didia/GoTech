package domainePartie1;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;





public class EtatAjouterArc extends EtatDEdition{
	
	private static Simulateur m_simulateur;
	private static Noeud noeud_selectione = null;
	public EtatAjouterArc(Simulateur simulateur){
		m_simulateur = simulateur;
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
		Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());
		
		
		if (noeud != null){
			if(noeud_selectione == null){
				noeud_selectione = noeud;
				
			}
			else{
				
				
				
				m_simulateur.ajouterArc(noeud_selectione, noeud);
				noeud_selectione = null;
			}
	
		}
		else {
			noeud_selectione = null;
			
		}
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
