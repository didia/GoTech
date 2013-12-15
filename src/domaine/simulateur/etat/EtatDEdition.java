package domaine.simulateur.etat;

import java.awt.event.MouseEvent;
import java.io.*;

import domaine.reseau.Arc;
import domaine.reseau.Noeud;
import domaine.simulateur.Simulateur;



public class EtatDEdition implements Etat, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4382112817494141737L;
	protected Noeud noeud_selectione = null;
	protected Noeud noeud_temporaire = null;
	protected Arc arc_selectione = null;
	protected Arc arc_temporaire = null;
	protected static Simulateur m_simulateur;
	
	public EtatDEdition(Simulateur simulateur){
		m_simulateur = simulateur;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		noeud_selectione = m_simulateur.reqNoeud(e.getX(), e.getY());
		if (noeud_selectione == null){
			arc_selectione = m_simulateur.reqArc(e.getX(), e.getY());
			System.out.println("Un arc selection� "+ (arc_selectione != null));
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
		if(this.reqNoeudSelectione() != null)
		{
			m_simulateur.deplacerNoeud(this.reqNoeudSelectione(), e.getX(), e.getY());
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Noeud reqNoeudSelectione(){
		return noeud_selectione;
	}
	public Arc reqArcSelectione(){
		return arc_selectione;
	}
	
	public void asgNoeudSelectione(Noeud noeud){
		noeud_selectione = noeud;
	}
	public void asgArcSelectione(Arc arc){
		arc_selectione = arc;
	}

	@Override
	public String reqPositionDescription(int posX, int posY) {
		
		return m_simulateur.reqPositionString(posX, posY);
	}

	@Override
	public void cancel() {
		noeud_selectione = null;
		m_simulateur.supprimer_noeud(noeud_temporaire);
		noeud_temporaire = null;
		arc_selectione = null;
		m_simulateur.supprimer_arc(arc_temporaire);
		arc_temporaire = null;
	}
	


}
