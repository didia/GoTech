package domainePartie1;

import java.util.ArrayList;

public class StrategieAnciennete extends StrategieGestion 
{

	public StrategieAnciennete(ArrayList<Urgence> listeUrgence) 
	{
		super(listeUrgence);
	}
	
	public Urgence reqUrgenceActuelle()
	{
		System.out.println("Je suis lˆ");
		if(this.m_urgenceActuelle == null && !this.m_listeUrgence.isEmpty()){
			this.m_urgenceActuelle = this.m_listeUrgence.get(0);
		}
		return this.m_urgenceActuelle;
	}


	public void traiterUrgenceActuelle() 
	{
		if(this.m_urgenceActuelle != null)
		{
			this.m_urgenceActuelle.reqNoeudCible().setTraitee();
			this.m_listeUrgence.remove(this.m_urgenceActuelle);
			this.m_listeUrgenceTraitee.add(this.m_urgenceActuelle);
			if(this.m_listeUrgence.isEmpty()){
				this.m_urgenceActuelle = null;
			}
			else{
			this.m_urgenceActuelle = this.m_listeUrgence.get(0);
			}
		}
		
	}

	public void ajouterUrgence(Urgence uneUrgence) 
	{ 
		ArrayList<Urgence> listTempTriee = new ArrayList<Urgence>();

		listTempTriee.add(uneUrgence);

		this.asgListUrgence(listTempTriee);
	}
	
	public String toString()
	{
		return Default.STRATEGIE_ANC;
	}

}