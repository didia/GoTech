package domainePartie1;

import java.util.ArrayList;

public class GestionnaireUrgence {
	
	private ArrayList<Urgence> m_urgencesNonTraitee;
	private StrategieGestion m_strategie = null;
	
	public GestionnaireUrgence(){
		m_urgencesNonTraitee = new ArrayList<Urgence>();
	}
	
	public void asgStrategie(String strategie){
		if(strategie.equals(Default.STRATEGIE_PROX)){
			m_strategie = new StrategieProximite(m_urgencesNonTraitee);
		}
		else if (strategie.equals(Default.STRATEGIE_MIN)){
			m_strategie = new StrategieMinchemin(m_urgencesNonTraitee);
		}
		else{
			m_strategie = new StrategieAnciennete(m_urgencesNonTraitee);
		}
		
	}
	public void ajouterUrgence(Noeud noeud){
		m_urgencesNonTraitee.add(new Urgence(noeud));
	}
	public void supprimerUrgence(Urgence urgence){
		m_urgencesNonTraitee.remove(urgence);
	}
	public Urgence reqProchaineUrgence(){
		if(m_strategie != null){
			return m_strategie.reqUrgencActuelle();
		}
		return null;
	}
	
	public Noeud reqProchainNoeudATraite(){
		if(!(reqProchaineUrgence() == null)){
			return reqProchaineUrgence().reqNoeudCible();
		}
		return null;
	}
	public void traiterUrgenceActuelle(){
		m_strategie.traiterUrgencAtuelle();
	}
}
