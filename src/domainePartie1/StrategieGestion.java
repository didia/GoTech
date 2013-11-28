/**
* Cette classe encapsule une classe generale de strategie de gestion.
*
*
* @version 1.0
*
* @author GoTech
*
*
*/



package domainePartie1;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class StrategieGestion 
{
	private ArrayList<Urgence> m_listeUrgence;
	private ArrayList<Urgence> m_listeUrgenceTraitee;
	private ArrayList<Urgence> m_listeUrgenceNonAccessible;
	private Urgence m_prochaineUrgence;
	
	private Itineraire m_itineraire;

	
	public StrategieGestion(ArrayList<Urgence> listUrgence, ArrayList<Urgence> listUrgenceTraitee, ArrayList<Urgence> listeUrgenceNonAcessible) 
	{
		this.m_listeUrgence = listUrgence;
		this.m_prochaineUrgence =null;
		this.m_listeUrgenceTraitee = listUrgenceTraitee;
		this.m_listeUrgenceNonAccessible = listeUrgenceNonAcessible;
	}
	
	public Urgence reqProchaineUrgence() 
	{
	
		return this.m_prochaineUrgence;
	}

	public ArrayList<Urgence> reqListeUrgence()
	{
		return this.m_listeUrgence;
	}
	
	public ArrayList<Urgence> reqListerUrgencetraitee() 
	{
		return this.m_listeUrgenceTraitee;
	}

	public Itineraire reqItineraire()
	{
		return m_itineraire;
	}
	public void asgListUrgence(ArrayList<Urgence> listeUrgences) 
	{
		this.m_listeUrgence = listeUrgences;
	}
	
	public void asgProchaineUrgence(Urgence uneUrgence) 
	{
		this.m_prochaineUrgence = uneUrgence;
	}

	
	/**
	* 
	* Test si il existe toujours une urgence a traitee
	*
	* @return true si une urgence non traitee existe, false sinon
	*
	*/
	public boolean existeUrgenceNonTraitee() 
	{
		boolean existeUrgenceNonTraitee = true;
		
		if (this.m_listeUrgence.size() == this.m_listeUrgenceTraitee.size())
		{
			existeUrgenceNonTraitee = false;
		}
		
		return existeUrgenceNonTraitee;
	}

	public void traiterUrgenceAtuelle() 
	{
		this.m_listeUrgenceTraitee.add(m_prochaineUrgence);
		this.m_listeUrgence.remove(m_prochaineUrgence);	
		this.m_prochaineUrgence = null;
		this.m_prochaineUrgence = this.reqProchaineUrgence();
	}
	
	public void trierListeUrgence(){
		// DO NOTHING,
		// TO BE IMPLEMENTED IN CHILDREN
	}
	public void ajouterUrgence(Urgence urgence){
		
	}
	public void setUrgenceActuelleNonAccessible(){
		this.m_listeUrgenceNonAccessible.add(m_prochaineUrgence);
		this.m_listeUrgence.remove(m_prochaineUrgence);
		this.m_prochaineUrgence = null;
		this.m_prochaineUrgence = this.reqProchaineUrgence();
	}
}
