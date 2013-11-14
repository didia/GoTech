package domainePartie1;
import java.util.ArrayList;
import domainePartie1.Position;
import domainePartie1.Noeud;


public class Carte {
	
	
	private ArrayList<Noeud> listeDeNoeuds;
	private ArrayList<Arc> listeArcs;
	
	
	class Arc
	//début de l'arc
	{
		private float m_longueur;
		private Noeud m_source;
		private Noeud m_destination;
		
		Arc(Noeud src, Noeud dest, float dist)
		{
			this.m_source = src;
			this.m_destination = dest;
			this.m_longueur = dist;	
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
		
		public void asgLongueur(float dist)
		{
			this.m_longueur = this.calculerLongueur(); 
		}
		
		private float calculerLongueur()
		{
			float distX = (this.m_source.reqPosition().reqPositionX() - this.m_destination.reqPosition().reqPositionX());
			float distX1 = distX * distX;
			float distY = (this.m_source.reqPosition().reqPositionY() - this.m_destination.reqPosition().reqPositionY());
			float distY1 = distY*distY;
			double somme = (double)(distY1 + distX1);
			return (float)(Math.sqrt(somme));
		}
		
		
		
		
	}//fin classe arc
	
	public ArrayList<Noeud> reqListeNoeuds() {
		
		return this.listeDeNoeuds;
		
	}
	
	public void ajouterNoeud(Position position)
	{
		this.listeDeNoeuds.add(new Noeud(position));
	}
	
	public void ajouterArc(Noeud noeudSource, Noeud noeudDest)
	{
		if(this.listeDeNoeuds.contains(noeudSource) && this.listeDeNoeuds.contains(noeudDest))
		{
			Arc nouvelArc = new Arc(noeudSource, noeudDest, 0);
			float dist = nouvelArc.calculerLongueur();
			nouvelArc.asgLongueur(dist);
			this.listeArcs.add(nouvelArc);
			
		}
		
		/*else
		{
			throw
		}*/
		
		
	}
	
	public void enleverNoeud(Noeud noeud)
	{
		
	}
	 
	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds)
	{
		return noeudSrc;
	}
	
	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2)
	{
		return listeArcs;
	}

}
