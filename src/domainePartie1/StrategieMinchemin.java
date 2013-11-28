package domainePartie1;

import java.util.ArrayList;

public class StrategieMinchemin extends StrategieGestion
{
	public StrategieMinchemin(ArrayList<Urgence> listeUrgence, ArrayList<Urgence> listeUrgenceTraitee, ArrayList<Urgence> listeUrgenceNonAccessible)
	{
		super(listeUrgence, listeUrgenceTraitee,listeUrgenceNonAccessible);
	}

	public Urgence reqUrgenceAcctuelle()
	{
		return this.reqProchaineUrgence();
	}
	
	public String toString()
	{
		return Default.STRATEGIE_MIN;
	}
}
