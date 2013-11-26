/**
* Cette classe permet de faire la gestion des urgences
*
*
*
* @version 1.0
*
* @author GoTech
*
*
*/

package domainePartie1;

import java.util.ArrayList;

public class GestionnaireUrgence
{
	private ArrayList<Urgence> m_urgencesNonTraitee;
	private ArrayList<Urgence> m_urgencesTraitee;
	private StrategieGestion m_strategie = null;
	
	
	public GestionnaireUrgence()
	{
		m_urgencesNonTraitee = new ArrayList<Urgence>();
		m_urgencesTraitee = new ArrayList<Urgence>();
	}
	
	/**
	* Assigne la strategie a utilise par le vehicule d'urgence
	*
	* @param strategie, une chaine de caractere correspondant a la strategie
	*
    */
	public void asgStrategie(String strategie)
	{
		if (strategie.equals(Default.STRATEGIE_PROX))
		{
			m_strategie = new StrategieProximite(m_urgencesNonTraitee, m_urgencesTraitee);
		}
		else if (strategie.equals(Default.STRATEGIE_MIN))
		{
			m_strategie = new StrategieMinchemin(m_urgencesNonTraitee, m_urgencesTraitee);
		}
		else
		{
			m_strategie = new StrategieAnciennete(m_urgencesNonTraitee, m_urgencesTraitee);
		}	
	}
	
	/**
	* Ajoute une urgence a la liste des urgences non traitees
	* 
	* @param noeud, le noeud a ajouter l'urgence
	*
	*
    */
	public void ajouterUrgence(Noeud noeud)
	{
		m_urgencesNonTraitee.add(new Urgence(noeud));
	}
	
	/**
	* Supprime une urgence
	*
	* @param urgence, l'urgence a supprimer
	*
	*
    */
	public void supprimerUrgence(Urgence urgence)
	{
		m_urgencesNonTraitee.remove(urgence);
	}
	
	public Urgence reqProchaineUrgence()
	{		
		if (m_strategie != null)
		{	
			return m_strategie.reqProchaineUrgence();
		}
		
		return null;
	}
	
	public Noeud reqProchainNoeudATraite()
	{
		if (reqProchaineUrgence() != null)
		{
			return reqProchaineUrgence().reqNoeudCible();
		}
		
		return null;
	}
	
	
	/**
	* Envoie un signal pour traitee l'urgence actuelle
	*
	*
    */
	public void traiterUrgenceActuelle()
	{
		m_strategie.traiterUrgenceAtuelle();
	}
	
	public void reset(){
		this.m_urgencesNonTraitee.clear();
		this.m_urgencesNonTraitee.clear();
		this.m_strategie = null;
	}
}
