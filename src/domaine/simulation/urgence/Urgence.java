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
import domaine.simulateur.Clock;
import domaine.simulation.resultat.Resultats;

public class Urgence
{
	private long m_tempsDebut; 
	private int m_tempsAttente = 0;
	private long m_tempsDeclenchement=0;
	private final Noeud m_noeudCible;
	private int m_priorite = 0; // de 0 a 5
	
	private Resultats m_resultat = new Resultats();

	
	public Urgence(Noeud p_NoeudCible)
	{
		this.m_noeudCible = p_NoeudCible;
		this.m_tempsDebut = Clock.getTime();
	}
	
	public Urgence(Noeud p_NoeudCible, long tempsDeclenchement)
	{
		this.m_noeudCible = p_NoeudCible;
		this.m_tempsDeclenchement = tempsDeclenchement;
		this.m_tempsDebut = Clock.getTime();
	}

	public float reqtempsAttente()
	{
		return this.m_tempsAttente/1000;
	}
	
	public long reqTempsDebut()
	{
		return this.m_tempsDebut;
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

	public long reqTempsDeclenchement() {
		
		return this.m_tempsDeclenchement;
	}
	public void reset()
	{
		this.m_tempsDeclenchement = this.m_tempsDeclenchement + this.m_tempsDebut;
		this.m_tempsDebut = 0;
		this.m_tempsAttente = 0;
	}
	public float cout(Urgence urgence)
	{
		return this.m_noeudCible.cout(urgence.reqNoeudCible());
	}
	
	
}
