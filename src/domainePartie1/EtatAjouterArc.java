package domainePartie1;

import java.awt.event.MouseEvent;
import domainePartie1.Simulateur;
import domainePartie1.EtatDEdition;
import domainePartie1.Noeud;



public class EtatAjouterArc implements EtatDEdition{
	
	private static Simulateur m_simulateur;
	private static Noeud noeud_selectione = null;
	public EtatAjouterArc(Simulateur simulateur){
		m_simulateur = simulateur;
		
	}
	
	public void doAction(MouseEvent e){
		System.out.println(e.getX());
		Noeud noeud = m_simulateur.reqNoeud(e.getX(), e.getY());
		
		
		if (noeud != null){
			if(noeud_selectione == null){
				noeud_selectione = noeud;
				
			}
			else{
				
				
				
				m_simulateur.ajouterArc(noeud_selectione, noeud);
				noeud_selectione = null;
			}
	
		}
		else {
			noeud_selectione = null;
			
		}
	}


}
