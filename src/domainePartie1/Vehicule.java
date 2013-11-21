package domainePartie1;

public class Vehicule {
	
	private static Vehicule m_vehicule = new Vehicule();
	private static Noeud m_portAttache = null;
	private float m_Vistesse = 0;
	private Position m_position = null;
	private static Noeud m_noeudAtuel = null;
	
	
	//constructeur priv�e vehicule
	
	public Vehicule(){
		this.m_portAttache = new Noeud();
		this.m_Vistesse = 0;
		this.m_noeudAtuel = new Noeud();	
	}
	
	public Vehicule(Noeud p_noeudActuel, float p_vitesse){
		
		this.m_noeudAtuel = p_noeudActuel;
		this.m_Vistesse = p_vitesse;
		
	}
	
	//Obtenir le v�hicule
	public static Vehicule getInstance()
	{
		return m_vehicule;
	}
	
	public void asgPointAttache(Noeud noeud){
		m_portAttache = noeud;
		m_position = m_portAttache.reqPosition();
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
	
	public Position reqPosition()
	{
		return this.m_position;
	}
	
	public Noeud reqPortAttache()
	{
		return this.m_portAttache;
	}

	public  float reqVistess()
	{
		return this.m_Vistesse;
	}
	public Noeud reqnoeudActuel()
	{
		return m_noeudAtuel;
	}
	
	public void asgNoeudActuel(Noeud noeud)
	{
		this.m_portAttache = noeud;
	}
}