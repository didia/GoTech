package domaine.simulation.resultat;

import java.util.ArrayList;

import domaine.simulateur.Vehicule;
import domaine.simulation.urgence.GestionnaireUrgence;

public class GestionnaireResultat {
	
	private final Vehicule m_vehicule;
	private final GestionnaireUrgence m_gestionnaireUrgence;
	private  ArrayList<Resultats> latestResultats = new ArrayList<Resultats>();
	private  Resultats currentResultat;
	
	public GestionnaireResultat(Vehicule vehicule, GestionnaireUrgence gestionnaireUrgence){
		m_vehicule = vehicule;
		m_gestionnaireUrgence = gestionnaireUrgence;
		
	}
	
	public void generateResultats(String strategie, boolean retournePointAttache)
	{
		currentResultat = new Resultats(strategie, retournePointAttache);
		latestResultats.add(currentResultat);
		
	}
	
	public void reset(){
		latestResultats.clear();
	}
	
	public Resultats reqResultats(){
		int tempsDattenteMoyen = m_gestionnaireUrgence.reqTempsAttenteMoyen();
		int nombreUrgenceTraitee = m_gestionnaireUrgence.reqNombreUrgenceTraitee();
		int nombreUrgenceNonTraitee = m_gestionnaireUrgence.reqNombreUrgenceNonTraitee();
		int nombreUrgenceNonAccessible = m_gestionnaireUrgence.reqNombreUrgenceNonAccessible();
		float distanceParcourue = m_vehicule.reqDistanceparcouru();
		if(currentResultat != null)
		currentResultat.update(tempsDattenteMoyen, distanceParcourue,nombreUrgenceTraitee, nombreUrgenceNonTraitee, nombreUrgenceNonAccessible);
		return currentResultat;
	}
}
