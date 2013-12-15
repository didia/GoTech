package domaine.simulateur.etat;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domaine.reseau.Noeud;
import domaine.simulateur.Simulateur;

public class EtatEditionRapide extends EtatDEdition {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4701463971778876339L;
	private Noeud noeud_precedent;

	public EtatEditionRapide(Simulateur simulateur) {
		super(simulateur);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e) && !e.isControlDown())
		{
			
			Noeud noeud = m_simulateur.ajouterNoeud(e.getX(), e.getY());
			if(this.noeud_precedent != null && !this.noeud_precedent.equals(noeud))
			{
				m_simulateur.supprimer_arc(this.arc_temporaire);
				m_simulateur.ajouterArc(noeud_precedent, noeud);
				this.noeud_temporaire = null;
			}
			this.noeud_precedent = noeud;
			
		}
		else
		{
			
			super.mouseClicked(e);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if(noeud_precedent != null){
			
	
			this.noeud_temporaire = new Noeud(m_simulateur.reqPositionEnMetre(e.getX(), e.getY()));
		
			this.arc_temporaire = m_simulateur.ajouterArc(noeud_precedent, this.noeud_temporaire);
	
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		m_simulateur.supprimer_arc(this.arc_temporaire);
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.noeud_temporaire != null){
			m_simulateur.deplacerNoeud(this.noeud_temporaire, e.getX(), e.getY());
		}
		else if (noeud_precedent != null)
		{
			this.mouseEntered(e);
		}
		
	}
	
	@Override
	public void cancel()
	{
		noeud_precedent = null;
		super.cancel();
	}

}
