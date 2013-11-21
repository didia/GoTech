package domainePartie1;

public class Parametres {
	
	private  float m_vitesseVehicule;
	private  StrategieGestion m_strategie;
	private boolean m_comportementVehicule ;
	
	
	
	public float reqVitesseVehicule()
	{
		return this.m_vitesseVehicule;
	}

	public StrategieGestion  reqStrategie ()
	{
	return this.m_strategie;
	}
	
	public boolean reqcomportementVehicule()
	{
		return this.m_comportementVehicule;
	}
	
	public void asgVitesseVehicule(float vitesse)
	{
		this.m_vitesseVehicule = vitesse;
	}

	public void  asgStrategie ( StrategieGestion strategie)
	{
		this.m_strategie = strategie;
	}
	
	
}
