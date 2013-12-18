/**
* Cette classe encapsule et gere les resultats de la simulation
* 
* 
* Permet de reccuperer et de gerer le temps total, le nombre d'urgence
* ainsi que la distance parcourrue d'une simulation.
*
*
* @version 1.0
*
* @author GoTech
*
*
*/

package domaine.simulation.resultat;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Resultats  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private String strategie;
	
	@SuppressWarnings("unused")
	private boolean retournePointAttache;
	
	
	private  int tempsDattente = 0;
	private int nombreUrgenceTraitee = 0;
	private int nombreUrgenceNonTraitee = 0;
	private int nombreUrgenceNonAccessible = 0;
	private float distanceParcourue = 0;
	
	public Resultats(String strategie, boolean retournePointAttache)
	{
		this.strategie = strategie;
		this.retournePointAttache = retournePointAttache;
	}

	public void update(int p_tempsDattente, float p_distanceParcourue, 
			int nombreUrgenceTraitee, int nombreUrgenceNonTraitee, int nombreUrgenceNonAccessible)
	{
		this.tempsDattente = p_tempsDattente;
		this.nombreUrgenceTraitee = nombreUrgenceTraitee;
		this.distanceParcourue = p_distanceParcourue;
		this.nombreUrgenceNonTraitee = nombreUrgenceNonTraitee;
		this.nombreUrgenceNonAccessible = nombreUrgenceNonAccessible;
	}
	public Resultats ()
	{
		this.tempsDattente = 0;
		
		this.distanceParcourue = 0;
	}
	 
		
	
	/**
	* 
	* 
	* Differents accesseurs pour la classe resultats
	* 
	*/
	public String gettempsDattente()
	{
		String toReturn="";
		int minutes = (int) ((tempsDattente / (60)) % 60);
		int hours   = (int) ((tempsDattente / (60*60)) % 24);
		if(hours != 0){
			toReturn = toReturn +hours+"h";
		}
		if(minutes != 0){
			toReturn = toReturn + minutes +"min";
		}
		return toReturn + this.tempsDattente + "sec";
	}
	
	public int getNombreUrgence()
	{
		return this.nombreUrgenceNonAccessible + this.nombreUrgenceNonTraitee + this.nombreUrgenceTraitee;
	}
	
	public String getDistanceParcourue()
	{
		String distance = "";
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		if(this.distanceParcourue >= 1000){
			distance += numberFormat.format(this.distanceParcourue/1000) + " Km"; 
		}
		else{
			distance += numberFormat.format(this.distanceParcourue) + " m";
		}
		
		return distance;
	}
	

	
	public void setStrategie(String strategie)
	{
		this.strategie = strategie;
	}

}