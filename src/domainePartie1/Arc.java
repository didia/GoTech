package domainePartie1;

public class Arc
{
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

	public float reqLongueur() {
		return this.m_longueur;
	}

	public Noeud reqNoeudSource() {
		return this.m_source;
	}

	public Noeud reqNoeudDest() {
		return this.m_destination;
	}

	public void asgLongueur(float dist) {
		this.m_longueur = this.calculerLongueur();
	}
	
	public boolean isPositionIn(Position position)
	{
		float c2 = this.a * position.reqPositionX() + this.b;
		
		float x = position.reqPositionX();
		float y = position.reqPositionY();
		float c1 = x;
		
		float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);
		if (circle <= 3 * 3)
		{
			return true;
		}
		return false;
	}

	private float calculerLongueur() 
	{
		float distX = (this.reqNoeudSource().reqPosition().reqPositionX() - this.reqNoeudDest().reqPosition().reqPositionX());
		float distX1 = distX * distX;
		float distY = (this.reqNoeudSource().reqPosition().reqPositionY() - this.reqNoeudDest().reqPosition().reqPositionY());
		float distY1 = distY * distY;
		double somme = (double) (distY1 + distX1);
		return (float) (Math.sqrt(somme));
	}
	
	private void initAetB()
	{
		float x1 = m_source.reqPosition().reqPositionX();
		float x2 = m_destination.reqPosition().reqPositionX();
		float y1 = m_source.reqPosition().reqPositionY();
		float y2 = m_destination.reqPosition().reqPositionY();
		
		this.a = (y2-y1)/(x2-x1);
		this.b = y1 - (x1 * this.a);
	}

}// fin classe arc