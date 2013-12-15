package domaine.simulateur.etat;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import domaine.reseau.Noeud;
import domaine.reseau.Position;
import domaine.simulateur.Simulateur;





public class EtatAjouterArc extends EtatDEdition{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904393767749519010L;	
	private static Noeud noeud_selectione = null;
	public EtatAjouterArc(Simulateur simulateur){
		super(simulateur);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		super.mouseClicked(e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(noeud_selectione != null){
			
	
			this.noeud_temporaire = new Noeud(m_simulateur.reqPositionEnMetre(e.getX(), e.getY()));
		
			this.arc_temporaire = m_simulateur.ajouterArc(noeud_selectione, this.noeud_temporaire);
	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		m_simulateur.supprimer_arc(this.arc_temporaire);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());

			
			if (noeud != null){
				
				if(noeud_selectione == null){
					noeud_selectione = noeud;
					
				}
				else{
					
					
					if(!noeud_selectione.equals(noeud)){
						m_simulateur.supprimer_arc(this.arc_temporaire);
						m_simulateur.ajouterArc(noeud_selectione, noeud);
						noeud_selectione = null;
						this.noeud_temporaire = null;
					}
					
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
		if(this.noeud_temporaire != null){
			m_simulateur.deplacerNoeud(this.noeud_temporaire, e.getX(), e.getY());
		}
		else if (noeud_selectione != null)
		{
			this.mouseEntered(e);
		}
		
	}
	
	@Override
	public void cancel() {
		noeud_selectione = null;
		super.cancel();
		
	}


}
