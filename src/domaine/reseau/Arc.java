/**
* Cette classe encapsule et gere les informations d'un arc reliant deux noeuds
*
* Permet l'asignation et la requisition d'un noeud source et destination, 
* permet aussi de calculer la longueur de l'arc reliant ceux-ci.
*
*
* @version 1.0
*
* @author GoTech
*
*
*/

package domaine.reseau;

import java.io.Serializable;

public class Arc implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float m_longueur;
	private Noeud m_source;
	private Noeud m_destination;
	private float a;
    private float b;

	public Arc(Noeud source, Noeud destination)
	{
		this.m_source = source;
		this.m_destination = destination;
		this.m_longueur = calculerLongueur();
		this.initAetB();
	}
	

	public float reqLongueur() 
	{
		return this.m_longueur;
	}

	public Noeud reqNoeudSource()
	{
		return this.m_source;
	}

	public Noeud reqNoeudDest()
	{
		return this.m_destination;
	}

	
	/**
	* Met a jour la longueur de l'arc avec les coordonnees actuelles
	*
	*
    */
	public void asgLongueur()
	{
		this.m_longueur = this.calculerLongueur();
	}
	
	
	
	/**
	* Verifie que la position entree est a l'interieur d'un arc
	*
	*
	* @param position une Position
	*
	*
	* @return un booleen, vrai si la position entrer fait partie d'un arc, faux sinon
	*
    */
	public boolean isPositionIn(Position position)
	{
		this.initAetB();
		float droite = position.reqPositionY() - this.a*position.reqPositionX() -this.b;
		System.out.println(droite);
		if(Math.round(droite) == 0){
			return true;
		}
		float c2 = this.a * position.reqPositionX() + this.b;
		
		float x = position.reqPositionX();
		float y = position.reqPositionY();
		float c1 = x;
		
		float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);
		if (circle <= 3 * 3)
		{
			return true;
		}
		else{
			c1 = (position.reqPositionY() - this.b)/this.a;
			c2 = y;
			circle = (x-c1)*(x-c1) + (y-c2)*(y-c2);
			if(circle <= 3 * 3){
				return true;
			}
		}
		return false;
	}

	
	/**
	* Calcul la longueur d'un arc entre deux noeuds
	* 
	* 
	* @return la longueur d'un arc en float
	*
    */
	private float calculerLongueur() 
	{
		float distX = (this.reqNoeudSource().reqPosition().reqPositionX() - this.reqNoeudDest().reqPosition().reqPositionX());
		float distX1 = distX * distX;
		float distY = (this.reqNoeudSource().reqPosition().reqPositionY() - this.reqNoeudDest().reqPosition().reqPositionY());
		float distY1 = distY * distY;
		double somme = (double) (distY1 + distX1);
		return (float) (Math.sqrt(somme));
	}
	
	
	/**
	*
	* Initialise les parametres a et b d'un arc sachant y = ax + b
	*
    */
	private void initAetB()
	{
		float x1 = m_source.reqPosition().reqPositionX();
		float x2 = m_destination.reqPosition().reqPositionX();
		float y1 = m_source.reqPosition().reqPositionY();
		float y2 = m_destination.reqPosition().reqPositionY();
		
		this.a = (y2-y1)/(x2-x1);
		this.b = y1 - (x1 * this.a);
	}
   
	 
}