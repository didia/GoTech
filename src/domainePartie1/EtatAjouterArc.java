package domainePartie1;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;





public class EtatAjouterArc extends EtatDEdition{
	
	
	private static Noeud noeud_selectione = null;
	public EtatAjouterArc(Simulateur simulateur){
		super(simulateur);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		mousePressed(e);
		
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
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());

			
			if (noeud != null){
				System.out.println("Noeud trouvé");
				if(noeud_selectione == null){
					noeud_selectione = noeud;
					
				}
				else{
					
					
					
					m_simulateur.ajouterArc(noeud_selectione, noeud);
					noeud_selectione = null;
				}
		
			}
			else{
				noeud_selectione = null;
				
			}
			}
		
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
