package domainePartie1;
import java.awt.event.MouseEvent;
import domainePartie1.Simulateur;
import domainePartie1.EtatDEdition;


public class EtatModifierComponent implements EtatDEdition {

	private static Simulateur m_simulateur;
	private static Noeud noeud_selectionne;
	
	public EtatModifierComponent(Simulateur simulateur){
		m_simulateur = simulateur;
	}
	
	@Override
	public void doAction(MouseEvent e) {
		m_simulateur.changeNoeudPosition(noeud_selectionne, e.getX(), e.getY());
		
		
	}

}
