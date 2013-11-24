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
	protected ArrayList<Urgence> m_listeUrgence;
	protected Urgence m_urgenceActuelle;
	protected ArrayList<Urgence> m_listeUrgenceTraitee;
	protected Itineraire m_itineraire;

	
	//Constructeur
	public StrategieGestion(ArrayList<Urgence> list_urgence) 
	{
		this.m_listeUrgence = list_urgence;
		this.m_urgenceActuelle =null;
		this.m_listeUrgenceTraitee = new ArrayList<Urgence>();
	}

	// retourne l'urgenc actuelle
	public Urgence reqUrgenceActuelle() 
	{
	
		return this.m_urgenceActuelle;
	}

	// renvoyer sous forme de liste les urgence les urgence non traitées
	public ArrayList<Urgence> reqListeUrgence()
	{
		return this.m_listeUrgence;
	}
	
	//retourne sous forme de liste toutes les uregence deja trait�es 
	public ArrayList<Urgence> reqListerUrgencetraitee() 
	{
		return this.m_listeUrgenceTraitee;
	}

	public Itineraire reqItineraire()
	{
		return m_itineraire;
	}
	
	//TODO logique a revoir
	// determine si toute les urgence on été dejas traitées ou pas
	public boolean existeUrgenceNonTraitee() 
	{
		boolean existeUrgenceNonTraitee = true;
		
		if (this.m_listeUrgence.size() == this.m_listeUrgenceTraitee.size())
		{
			existeUrgenceNonTraitee = false;
		}
		
		return existeUrgenceNonTraitee;
	}

	// effectue les operation attendu sur une urgence
	public void traiterUrgenceAtuelle() 
	{
		this.m_listeUrgenceTraitee.add(m_urgenceActuelle);
		this.m_listeUrgence.remove(m_urgenceActuelle);			
	}
	
	public void asgListUrgence(ArrayList<Urgence> listeUrgences) 
	{
		this.m_listeUrgence = listeUrgences;
	}

	public void asgUrgenceAtuelle(Urgence uneUrgence) 
	{
		this.m_urgenceActuelle = uneUrgence;
	}

}
