/**
* Cette classe encapsule les coordonnees cartesiennes d'une position.
*
* <i><u><b>Contient les methodes de requisitions, asignations ainsi que sa distance a l'origine</u></b></i>
*
* @version 1.0 
*
* @author GoTech
*
* @see domainePartie1
* 
*/

package domaine.reseau;

import java.io.Serializable;

public class Position implements Serializable
{
	private float positionX;
	private float positionY;

	public Position(float x, float y)
	{
		this.positionX = x;
		this.positionY = y;
	}
	
	public float reqPositionX()
	{
		return this.positionX;
	}
	
	public float reqPositionY()
	{
		return this.positionY;
	}
	
	public double reqDistanceOrigine()
	{
		return Math.sqrt(positionX*positionX + positionY*positionY);
	}

	
	public boolean equals(Position o)
	{
		// TODO Auto-generated method stub
		if (positionX == o.reqPositionX() && positionY == o.reqPositionY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	


}
