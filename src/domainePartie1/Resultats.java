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
	private int nombreUrgence;
	private float distanceParcourue;

	public Resultats(int p_tempsDattente, int p_nbUrgences, float p_distanceParcourue )
	{
		this.tempsDattente = p_tempsDattente;
		this.nombreUrgence = p_nbUrgences;
		this.distanceParcourue = p_distanceParcourue;
	}
	
	public Resultats ()
	{
		this.tempsDattente = 0;
		this.nombreUrgence = 0;
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
		return this.nombreUrgence;
	}
	
	public float getDistanceParcourue()
	{
		return this.distanceParcourue;
	}
	
	public void afficherResultat( float vitessVehicule)
	{
		System.out.println("Vistess du vehicule"+vitessVehicule);
		System.out.println("temps d'Attente"+tempsDattente);
		System.out.println("nombre d'urgence"+nombreUrgence);
		System.out.println("distance Parcourue"+distanceParcourue);
	}

}