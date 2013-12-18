package domaine.simulateur.etat;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domaine.simulateur.Simulateur;
import domaine.reseau.Noeud;
import domaine.reseau.Arc;

public class EtatEnSimulation implements Etat{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Simulateur m_simulateur;
	private Noeud noeud_selectionne;
	public EtatEnSimulation(Simulateur simulateur){
		m_simulateur = simulateur;
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
			noeud_selectionne = m_simulateur.reqNoeud(e.getX(), e.getY());
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

	@Override
	public Arc reqArcSelectione() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noeud reqNoeudSelectione() {
		// TODO Auto-generated method stub
		return this.noeud_selectionne;
	}
	@Override
	public String reqPositionDescription(int posX, int posY) {
		
		return m_simulateur.reqNoeudDescription(posX, posY);
	}
	@Override
	public void cancel() {
		m_simulateur.terminerSimulation();
		
	}
	

}
