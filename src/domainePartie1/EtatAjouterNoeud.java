package domainePartie1;

import domainePartie1.Simulateur;
import domainePartie1.EtatDEdition;
import java.awt.event.MouseEvent;


public class EtatAjouterNoeud implements EtatDEdition {
	
	private static Simulateur m_simulateur;
	public EtatAjouterNoeud(Simulateur simulateur){
		m_simulateur = simulateur;
		
	}
	
	public void doAction(MouseEvent e){
		
		m_simulateur.ajouterNoeud(e.getX(), e.getY());
	}

}
