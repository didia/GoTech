package domaine.simulation.strategie.minchemin;

import java.util.ArrayList;

import domaine.simulateur.Default;
import domaine.simulation.strategie.AbstractStrategie;

import domaine.simulation.urgence.Urgence;

public class StrategieMinChemin extends AbstractStrategie
{
	public StrategieMinChemin(ArrayList<Urgence> listeUrgence, ArrayList<Urgence> listeUrgenceTraitee, ArrayList<Urgence> listeUrgenceNonAccessible)
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
