/**
* Cette classe encapsule l'itineraire employe par le vehicule d'urgence
*
* 
* Gere la liste des noeuds a visiter ainsi que la longueur totale du chemin
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


public class Itineraire 
{
	private ArrayList<Arc> m_listeArcs;
	private float m_longueur;

	

	public Itineraire ()
	{
		this.m_longueur = 0;
		this.m_listeArcs = new ArrayList<Arc>();
	}

	public Itineraire(ArrayList<Arc> p_listeArcs)
	{
		this.m_longueur = 0;
		this.m_listeArcs = p_listeArcs;
	}
	
	public float reqLongueur()
	{
		return this.m_longueur;
	}
	
	public void asgLongueur( float longueur)
	{
		this.m_longueur = longueur;
	}
	public ArrayList<Arc> reqListeArcs( )
	{
		return this.m_listeArcs;
	}
	
	/**
	* Calcul la longueur totale du chemin
	*
	* @param listeArcs, la liste des arcs reliants les noeuds
	*
	* @return la distance totale du chemin
	*
    */
	public float calculerLongueur(ArrayList<Arc> listeArcs) 
	{
		float longueur = 0;
		
		for (int i = 0; i <listeArcs.size(); ++i) 
		{
			longueur += listeArcs.get(i).reqLongueur();
		}
		
		return longueur;
	}
}

