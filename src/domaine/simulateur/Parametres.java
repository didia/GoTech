/**
* Cette classe encapsule et gere les parametres de la simulation
* 
* 
* Permet de reccuperer et d'emagasiner les parametres de la simulation
*
*
* @version 1.0
*
* @author GoTech
*
*
*/

package domaine.simulateur;

public class Parametres 
{
	private  float m_vitesseVehicule;
	private  String m_strategie;
	private  boolean m_retourPointAttache ;
	private  float m_tempsTraitement; 
	private int m_echelleTemps;
	
	public Parametres()
	{
		m_vitesseVehicule = Default.VITESSE_VEHICULE;
		m_strategie = Default.STRATEGIE_GESTION;
		m_retourPointAttache = Default.RETOUR_POINT_ATTACHE;
		m_tempsTraitement = Default.TEMPS_TRAITEMENT;
		m_echelleTemps = Default.ECHELLE_TEMPS;
	}
	

	
	public float reqVitesseVehicule()
	{
		return this.m_vitesseVehicule;
	}
	
	public void asgVitesseVehicule(float vitesse)
	{
		this.m_vitesseVehicule = vitesse;
	}
	
	public String reqStrategie ()
	{
		return this.m_strategie;
	}
	
	public void  asgStrategie(String strategie)
	{
		this.m_strategie = strategie;
	}
	
	public boolean reqRetourPointAttache()
	{
		return this.m_retourPointAttache;
	}
	
	public void asgRetourPointAttache(boolean value)
	{
		this.m_retourPointAttache = value;
	}

	public float reqTempsTraitement() 
	{
		return m_tempsTraitement;
	}

	public void asgTempsTraitement(float m_tempsTraitement) 
	{
		this.m_tempsTraitement = m_tempsTraitement;
	}
	
	public int reqEchelleTemps()
	{
		return this.m_echelleTemps;
	}
	public void asgEchelleTemps(int echelleTemps)
	{
		this.m_echelleTemps = echelleTemps;
	}
}
