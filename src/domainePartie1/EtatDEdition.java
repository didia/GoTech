package domainePartie1;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;



class EtatDEdition implements MouseInputListener {
	
	protected static Noeud noeud_selectione = null;
	protected static Carte.Arc arc_selectione = null;
	protected static Simulateur m_simulateur;
	public EtatDEdition(Simulateur simulateur){
		m_simulateur = simulateur;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		noeud_selectione = m_simulateur.reqNoeud(e.getX(), e.getY());
		if (noeud_selectione == null){
			arc_selectione = m_simulateur.reqArc(e.getX(), e.getY());
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
	
	public Noeud reqNoeudSelectione(){
		return noeud_selectione;
	}
	public Carte.Arc reqArcSelectione(){
		return arc_selectione;
	}
	


}
