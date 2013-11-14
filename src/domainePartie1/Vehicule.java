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
		//le Noeud actuel devien le noeud de destination 
		this.asgNoeudActuel(p_noeudDestination);
	}
	
	public void AllerPointAttache()
	{
		//le Noeud actuel devien le noeudAttache
		this.asgNoeudActuel(this.m_portAttache);
	}
	
	public Noeud reqNoeudActuel()
	{
		return this.m_noeud_actuel;
	}
	
	public Noeud reqPortAttache()
	{
		return this.m_portAttache;
	}

	public  float reqVistess()
	{
		return this.m_Vistesse;
	}
	
	public void asgNoeudActuel(Noeud noeud)
	{
		
	}
}