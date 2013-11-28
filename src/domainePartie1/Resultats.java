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

package domainePartie1;

public class Resultats 
{
	private  int tempsDattente;
	private int nombreUrgenceTraitee = 0;
	private int nombreUrgenceNonTraitee = 0;
	private int nombreUrgenceNonAccessible = 0;
	private float distanceParcourue;
	

	public Resultats(int p_tempsDattente, float p_distanceParcourue, 
			int nombreUrgenceTraitee, int nombreUrgenceNonTraitee, int nombreUrgenceNonAccessible){
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
	public int gettempsDattente()
	{
		return this.tempsDattente;
	}
	
	public int getNombreUrgence()
	{
		return this.nombreUrgenceNonAccessible + this.nombreUrgenceNonTraitee + this.nombreUrgenceTraitee;
	}
	
	public float getDistanceParcourue()
	{
		return this.distanceParcourue;
	}
	
	public void afficherResultat( float vitessVehicule)
	{
		System.out.println("Vistess du vehicule"+vitessVehicule);
		System.out.println("temps d'Attente"+tempsDattente);
		
		System.out.println("distance Parcourue"+distanceParcourue);
	}

}