/**
* Cette classe encapsule et gere une urgence
* 
* 
* Permet de gere l'heure de debut, la duree, le noeud cible
* la prioriete d'une urgence.
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

import domaine.reseau.Noeud;
import domaine.simulation.resultat.Resultats;

public class Urgence
{
	private int m_heuredebut; 
	private int m_tempsAttente = 0;
	private Noeud m_noeudCible;
	private int m_priorite = 0; // de 0 a 5
	
	private Resultats m_resultat = new Resultats();

	
	public Urgence(Noeud p_NoeudCible)
	{
		this.m_noeudCible = p_NoeudCible;
	}
	
	public Urgence(Noeud p_NoeudCible, int p_priorite)
	{
		this.m_noeudCible = p_NoeudCible;
		this.m_priorite = p_priorite;	
	}

	public float reqtempsAttente()
	{
		return this.m_tempsAttente/1000;
	}
	
	public int reqHeureDebut()
	{
		return this.m_heuredebut;
	}
	
	public int reqPriorite()
	{
		return this.m_priorite;
	}
	public void incrementeTempsAttente(int duree){
		this.m_tempsAttente += duree;
	}
	public Noeud reqNoeudCible()
	{
		return this.m_noeudCible;
	}
	
	public Resultats reqresultats()
	{
		return this.m_resultat;
	}	
}
