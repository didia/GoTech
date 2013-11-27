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


package domainePartie1;
public class Urgence
{
	private int m_heuredebut; 
	private int m_duree = 0;
	private Noeud m_noeudCible;
	private int m_priorite = 0; // de 0 a 5

	
	public Urgence(Noeud p_NoeudCible)
	{
		this.m_noeudCible = p_NoeudCible;
	}
	
	public Urgence(Noeud p_NoeudCible, int p_priorite)
	{
		this.m_noeudCible = p_NoeudCible;
		this.m_priorite = p_priorite;	
	}

	public int reqDuree()
	{
		return this.m_duree;
	}
	
	public int reqHeureDebut()
	{
		return this.m_heuredebut;
	}
	
	public int reqPriorite()
	{
		return this.m_priorite;
	}
	
	public Noeud reqNoeudCible()
	{
		return this.m_noeudCible;
	}
	
}
