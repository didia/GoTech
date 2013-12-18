/**
* Cette gere les urgence selon leur proximite
* 
* 
* Permet de trier la liste des urgences selon leur proximite
*
*
* @version 1.0
*
* @author GoTech
*
*
*/

package domaine.simulation.strategie.proximite;

import java.util.ArrayList;

import domaine.reseau.Carte;
import domaine.reseau.Noeud;
import domaine.simulateur.Default;
import domaine.simulation.strategie.AbstractStrategie;
import domaine.simulation.urgence.Urgence;

public class StrategieProximite extends AbstractStrategie
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Carte m_gps;
	public StrategieProximite(ArrayList<Urgence> listeUrgence, ArrayList<Urgence> listeUrgenceTraitee, 
			ArrayList<Urgence> listeUrgenceNonAccessible, Carte gps)
	{
		super(listeUrgence, listeUrgenceTraitee,listeUrgenceNonAccessible);
		m_gps = gps;
	}
	
	/**
	* Retourne le noeud ayant l'urgence la plus proche
	* 
	* @return l'urgence la plus proche
	*
	*/
	public Urgence reqProchaineUrgence(Noeud noeudActuel)
	{	
		if (super.reqProchaineUrgence() == null && !this.reqListeUrgence().isEmpty())
		{
			ArrayList<Noeud> listeDesNoeuds = listeDesNoeudAyantUneUrgence();
			Noeud noeudPlusProche = m_gps.plusProche(noeudActuel, listeDesNoeuds);
		
			this.asgProchaineUrgence(this.reqListeUrgence().get(listeDesNoeuds.indexOf(noeudPlusProche)));
		}
		return super.reqProchaineUrgence();
		
	}
	
	/**
	* Liste tous les noeuds ayant une urgence
	* 
	* @return la liste des noeuds ayant une urgence
	*
	*/
	public ArrayList<Noeud> listeDesNoeudAyantUneUrgence()
	{
		ArrayList<Noeud> listNoeudUrgence = new ArrayList<Noeud>();
		for(Urgence urgence: this.reqListeUrgence())
		{
			listNoeudUrgence.add(urgence.reqNoeudCible());
		}
			
		return listNoeudUrgence;
	}
	
	

	
	public String toString() 
	{
		return Default.STRATEGIE_PROX;
	}

	
}
