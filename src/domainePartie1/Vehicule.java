package domainePartie1;

public class Vehicule {
	private Carte.Noeud m_portAttache ;
	private float m_Vistesse;
	private Carte.Noeud m_noeud_actuel;
	
	
	//constructeur de la classe Vehicule
	public Vehicule(Carte.Noeud p_porAttache, Carte.Noeud p_noeudActuel, float p_vitesse)
	{
		this.m_noeud_actuel = p_noeudActuel;
		this.m_portAttache = p_porAttache;
		this.m_Vistesse = p_vitesse;
	}
	public void AllerVers(Carte.Noeud p_noeudDestination)
	{
		//TODO
	}
	
	public void AllerPointAttache()
	{
		//TODO
	}
	
	public Carte.Noeud	getNoeudActuel()
	{
		return this.m_noeud_actuel;
	}
	
	public Carte.Noeud getPortAttache()
	{
		return this.m_portAttache;
	}

	public  void reqVistess()
	{
		
	}
}