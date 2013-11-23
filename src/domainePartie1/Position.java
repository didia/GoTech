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

package domainePartie1;

public class Position implements Comparable<Position>
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

	
	//TODO Doit etre reviser car deux points de sorties
	@Override
	public int compareTo(Position o)
	{
		// TODO Auto-generated method stub
		if (positionX == o.reqPositionX() && positionY == o.reqPositionY())
		{
			return 0;
		}
		else
		{
			return (int)(this.reqDistanceOrigine() - o.reqDistanceOrigine());
		}
	}
	


}
