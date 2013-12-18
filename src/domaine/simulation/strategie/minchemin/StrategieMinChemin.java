package domaine.simulation.strategie.minchemin;

import java.util.ArrayList;


import domaine.reseau.Noeud;
import domaine.simulateur.Default;
import domaine.simulation.strategie.AbstractStrategie;

import domaine.simulation.urgence.Urgence;

public class StrategieMinChemin extends AbstractStrategie
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tour tour = null;
	public StrategieMinChemin(ArrayList<Urgence> listeUrgence, ArrayList<Urgence> listeUrgenceTraitee, ArrayList<Urgence> listeUrgenceNonAccessible)
	{
		super(listeUrgence, listeUrgenceTraitee,listeUrgenceNonAccessible);

	}

	public Urgence reqProchaineUrgence(Noeud m_noeudActuel)
	{
		if (super.reqProchaineUrgence() == null && !this.reqListeUrgence().isEmpty())
		{
			if(tour == null)
			{
				tour = GA.getNextTour(this.reqListeUrgence(),m_noeudActuel);
			}
			if(tour != null && !tour.isEmpty())
			{
				this.asgProchaineUrgence(tour.getUrgence(0));
				tour.removeUrgence(0);
			}
			else 
			{
				tour = null;
			}
		}
		return this.reqProchaineUrgence();
	}
	
	public String toString()
	{
		return Default.STRATEGIE_MIN;
	}
	
	public void informeNouvelleUrgenceAjoutee(){
		tour = null;
	}
	
	
}
