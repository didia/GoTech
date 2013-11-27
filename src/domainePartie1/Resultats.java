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
	private  int tempsTotal;
	private int nombreUrgence;
	private float distanceParcourue;

	public Resultats(int p_tempstotale, int p_nbUrgences, float p_distanceParcourue )
	{
		this.tempsTotal = p_tempstotale;
		this.nombreUrgence = p_nbUrgences;
		this.distanceParcourue = p_distanceParcourue;
	}
	
	public Resultats ()
	{
		this.tempsTotal = 0;
		this.nombreUrgence = 0;
		this.distanceParcourue = 0;
	}
		
	
	/**
	* 
	* 
	* Differents accesseurs pour la classe resultats
	* 
	*/
	public int getTempsTotal()
	{
		return this.tempsTotal;
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
		System.out.println("temps d'Attente"+tempsTotal);
		System.out.println("nombre d'urgence"+nombreUrgence);
		System.out.println("distance Parcourue"+distanceParcourue);
	}

}