package domainePartie1;
import java.awt.event.MouseEvent;







public class EtatModifierComponent extends EtatDEdition {



	
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
