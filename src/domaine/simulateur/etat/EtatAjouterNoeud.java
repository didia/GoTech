package domaine.simulateur.etat;


import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import domaine.simulateur.Simulateur;

import domaine.reseau.Noeud;


public class EtatAjouterNoeud extends EtatDEdition {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2498054043862854173L;
	private Noeud dernierAjoute = null;
	public EtatAjouterNoeud(Simulateur simulateur){
		super(simulateur);
		
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e) && !e.isControlDown())
		{
			
			//m_simulateur.ajouterNoeud(e.getX(), e.getY());
			dernierAjoute = noeud_temporaire;
			this.noeud_temporaire = null;
		}
		
			
		super.mouseClicked(e);
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		this.noeud_temporaire = m_simulateur.ajouterNoeud(e.getX(), e.getY());
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.noeud_temporaire != null){
			m_simulateur.deplacerNoeud(this.noeud_temporaire, e.getX(), e.getY());
		}
		else{
			
			Noeud noeud = m_simulateur.ajouterNoeud(e.getX(), e.getY());
			if(!noeud.equals(dernierAjoute)){
				this.noeud_temporaire = noeud;
			}
		}
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		m_simulateur.supprimer_noeud(this.noeud_temporaire);
		
	}
	

}
