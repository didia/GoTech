package domainePartie1;

import java.util.ArrayList;

public class StrategieMinchemin extends StrategieGestion
{
	public StrategieMinchemin(ArrayList<Urgence> listeUrgence)
	{
		super(listeUrgence);
	}

	public Urgence reqUrgenceAcctuelle()
	{
		return this.reqUrgencActuelle();
	}
	
	public String toString()
	{
		return Default.STRATEGIE_MIN;
	}
}
