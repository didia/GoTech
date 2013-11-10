package domainePartie1;

public class Vehicule {
	private Noeud m_portAttache ;
	private float m_Vistesse;
	private Noeud m_noeud_actuel;
	
	
	//constructeur de la classe Vehicule
	public Vehicule(Noeud p_porAttache, Noeud p_noeudActuel, float p_vitesse)
	{
		this.m_noeud_actuel = p_noeudActuel;
		this.m_portAttache = p_porAttache;
		this.m_Vistesse = p_vitesse;
	}
	public void AllerVers(Noeud p_noeudDestination)
	{
		//TODO
	}
	
	public void AllerPointAttache()
	{
		//TODO
	}
	
	public Noeud	getNoeudActuel()
	{
		return this.m_noeud_actuel;
	}
	
	public Noeud getPortAttache()
	{
		return this.m_portAttache;
	}
//	public Itineraire reqItineraie()
//	{
//		//TODO //liste des Arcs entre sont port d'atache et son noeud actuel
//	
//	}
//	
}
