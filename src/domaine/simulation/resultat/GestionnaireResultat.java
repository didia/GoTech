package domaine.simulation.resultat;

import domaine.simulateur.Vehicule;
import domaine.simulation.urgence.GestionnaireUrgence;

public class GestionnaireResultat {
	
	private final Vehicule m_vehicule;
	private final GestionnaireUrgence m_gestionnaireUrgence;
	
	public GestionnaireResultat(Vehicule vehicule, GestionnaireUrgence gestionnaireUrgence){
		m_vehicule = vehicule;
		m_gestionnaireUrgence = gestionnaireUrgence;
	}
	
	public Resultats reqResultats(){
		int tempsDattenteMoyen = m_gestionnaireUrgence.reqTempsAttenteMoyen();
		int nombreUrgenceTraitee = m_gestionnaireUrgence.reqNombreUrgenceTraitee();
		int nombreUrgenceNonTraitee = m_gestionnaireUrgence.reqNombreUrgenceNonTraitee();
		int nombreUrgenceNonAccessible = m_gestionnaireUrgence.reqNombreUrgenceNonAccessible();
		float distanceParcourue = m_vehicule.reqDistanceparcouru();
		
		return new Resultats(tempsDattenteMoyen, distanceParcourue,nombreUrgenceTraitee, nombreUrgenceNonTraitee, nombreUrgenceNonAccessible);
		
	}
}
