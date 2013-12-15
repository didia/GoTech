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

package domaine.simulation.urgence;

import java.util.ArrayList;

import domaine.reseau.Noeud;
import domaine.simulateur.Default;
import domaine.simulation.strategie.*;
import domaine.simulation.strategie.anciennete.StrategieAnciennete;
import domaine.simulation.strategie.minchemin.StrategieMinChemin;
import domaine.simulation.strategie.proximite.StrategieProximite;

public class GestionnaireUrgence
{
	private ArrayList<Urgence> m_urgencesNonTraitee;
	private ArrayList<Urgence> m_urgencesTraitee;
	private ArrayList<Urgence> m_urgencesNonAccessible;
	private ArrayList<Urgence> m_urgencesEnAttente;
	private AbstractStrategie m_strategie = null;
	
	
	public GestionnaireUrgence()
	{
		m_urgencesNonTraitee = new ArrayList<Urgence>();
		m_urgencesTraitee = new ArrayList<Urgence>();
		m_urgencesNonAccessible = new ArrayList<Urgence>();
		m_urgencesEnAttente = new ArrayList<Urgence>();
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
			m_strategie = new StrategieProximite(m_urgencesNonTraitee, m_urgencesTraitee, m_urgencesNonAccessible);
		}
		else if (strategie.equals(Default.STRATEGIE_MIN))
		{
			m_strategie = new StrategieMinChemin(m_urgencesNonTraitee, m_urgencesTraitee,m_urgencesNonAccessible);

		}
		else if (strategie.equals(Default.STRATEGIE_PRIORITE))
		{
			m_strategie = new StrategiePriorite(m_urgencesNonTraitee, m_urgencesTraitee,m_urgencesNonAccessible);
		}
		else
		{
			m_strategie = new StrategieAnciennete(m_urgencesNonTraitee, m_urgencesTraitee,m_urgencesNonAccessible);

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
		//if(m_strategie == null){
			m_urgencesNonTraitee.add(new Urgence(noeud));
		//}
		//else{
			//m_strategie.ajouterUrgence(new Urgence(noeud));
		//}
		
		
	}
	
	public void ajouterUrgence(Noeud noeud, long tempsDeclenchement){
		this.m_urgencesEnAttente.add(new Urgence(noeud, tempsDeclenchement));
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
		//TODO this.m_urgencesNonTraitee.clear();
		this.m_strategie = null;
	}
	
	/**
	 * Envoie un signal que l'urgence actuelle n'est pas accessible
	 */
	
	public void setUrgenceActuelleNonAccessible(){
		m_strategie.setUrgenceActuelleNonAccessible();
	}
	
	/**
	 * 
	 */
	public ArrayList<Urgence> reqUrgencesNonTraitee()
	{
		return this.m_urgencesNonTraitee;
	}
	/**
	 * 
	 */
	public void incrementerTempsAttenteUrgence(int duree){
		for(Urgence urgence: m_urgencesNonTraitee){
			urgence.incrementeTempsAttente(duree);
		}
	}
	
	/**
	 * 
	 */
	 
	public int reqTempsAttenteMoyen(){
		int tempsTotal = 0;
		int nombreUrgence = m_urgencesNonTraitee.size() + m_urgencesTraitee.size();
		if (nombreUrgence == 0){
			return 0;
		}
		for(Urgence urgence : m_urgencesNonTraitee)
		{
			tempsTotal += urgence.reqtempsAttente();
		}
		for(Urgence urgence : m_urgencesTraitee){
			tempsTotal += urgence.reqtempsAttente();
		}
	
		return Math.round(tempsTotal/nombreUrgence);
	}
	
	public int reqNombreUrgenceNonTraitee(){
		return this.m_urgencesNonTraitee.size();
		
	}
	public int reqNombreUrgenceTraitee(){
		return this.m_urgencesTraitee.size();
	}
	public int reqNombreUrgenceNonAccessible(){
		return this.m_urgencesTraitee.size();
	}
	
	public Urgence reqUrgenceAssocieA(Noeud noeud){
		Urgence urgence;
		urgence = this.reqUrgenceNonTraiteeAssocieA(noeud);
		if(urgence != null){
			return urgence;
		}
		urgence = this.reqUrgenceTraiteeAssocieA(noeud);
		if(urgence != null){
			return urgence;
		}
		urgence = this.reqUrgenceNonAccessibleAssocieA(noeud);
		return urgence;
		
		
	}
	
	public Urgence reqUrgenceNonTraiteeAssocieA(Noeud noeud){
		for (Urgence urgence:this.m_urgencesNonTraitee){
			if (urgence.reqNoeudCible().equals(noeud)){
				return urgence;
			}
		}
		return null;
	}
	
	public Urgence reqUrgenceTraiteeAssocieA(Noeud noeud){
		for (Urgence urgence:this.m_urgencesTraitee)
		{
			if (urgence.reqNoeudCible().equals(noeud))
			{
				return urgence;
			}
		}
		return null;
	}
	
	public Urgence reqUrgenceNonAccessibleAssocieA(Noeud noeud){
		for (Urgence urgence:this.m_urgencesNonAccessible){
			if (urgence.reqNoeudCible().equals(noeud)){
				return urgence;
			}
		}
		return null;
	}

	public void enleverUrgenceAuNoeud(Noeud noeud){
		
		for(Urgence urgence: this.m_urgencesNonTraitee)
		{
			if(urgence.reqNoeudCible().equals(noeud)){
				this.supprimerUrgence(urgence);
				break;
			}
		}
	}

	public void declencherUrgenceEnAttente(long clock) {
		ArrayList<Urgence> tempList = new ArrayList<Urgence>();
		for(Urgence urgence: this.m_urgencesEnAttente){
			if(urgence.reqTempsDeclenchement() <= Math.round(clock/1000))
			{
				tempList.add(urgence);	
			
			}
		}
		for (Urgence urgence:tempList)
		{
			this.m_urgencesNonTraitee.add(urgence);
			this.m_urgencesEnAttente.remove(urgence);
			urgence.reqNoeudCible().setEnAttente();
		}

}
}
