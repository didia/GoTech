package domainePartie1;

import java.awt.event.MouseEvent;

public class EtatEnSimulation implements Etat{

	private Simulateur m_simulateur;
	
	public EtatEnSimulation(Simulateur simulateur){
		m_simulateur = simulateur;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());
		if(noeud != null){
			m_simulateur.declencherUrgence(noeud);
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
		return null;
	}
	@Override
	public String reqPositionDescription(int posX, int posY) {
		
		return m_simulateur.reqNoeudDescription(posX, posY);
	}
	

}
