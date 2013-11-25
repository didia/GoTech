package domainePartie1;

import java.util.ArrayList;

public class StrategieAnciennete extends StrategieGestion 
{

	public StrategieAnciennete(ArrayList<Urgence> listeUrgence) 
	{
		super(listeUrgence);
	}
	
	public Urgence reqProchaineUrgence()
	{
		if(super.reqProchaineUrgence() == null && !this.reqListeUrgence().isEmpty()){
			this.asgProchaineUrgence(this.reqListeUrgence().get(0));
		}
		return super.reqProchaineUrgence();
	}

	
	public String toString()
	{
		return Default.STRATEGIE_ANC;
	}

}