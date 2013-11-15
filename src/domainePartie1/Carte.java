package domainePartie1;

import domainePartie1.Noeud;
import domainePartie1.Position;
import java.util.ArrayList;

import java.util.Timer;

public class Carte {


	private ArrayList<Noeud> m_listeDeNoeuds;
	private ArrayList<Arc> m_listeArcs;
	

	

	public class Arc
	// début de l'arc
	{
		private float m_longueur;
		private Noeud m_source;
		private Noeud m_destination;

		public Arc()
		{
			
		}
		public Arc(Noeud src, Noeud dest, float dist)
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
			float distX = (this.reqNoeudSource().reqPosition().reqPositionX() - this.reqNoeudDest().reqPosition().reqPositionX());
			float distX1 = distX * distX;
			float distY = (this.reqNoeudSource().reqPosition().reqPositionY() - this.reqNoeudDest().reqPosition().reqPositionY());
			float distY1 = distY*distY;
			double somme = (double)(distY1 + distX1);
			return (float)(Math.sqrt(somme));
		}
		
	}// fin classe arc


	 public Carte(){
	    	m_listeDeNoeuds = new ArrayList<Noeud>();
	    	m_listeArcs = new ArrayList<Arc>();
	    }



	 public void ajouterArc(Noeud noeudSource, Noeud noeudDest)
		{
			if(this.m_listeDeNoeuds.contains(noeudSource) && this.m_listeDeNoeuds.contains(noeudDest))
			{
				Arc nouvelArc = new Arc(noeudSource, noeudDest, 0);
				float dist = nouvelArc.calculerLongueur();
				nouvelArc.asgLongueur(dist);
				this.m_listeArcs.add(nouvelArc);
				int index = this.m_listeDeNoeuds.indexOf(noeudSource);
				this.m_listeDeNoeuds.get(index).reqListeArcsAdjacents().add(nouvelArc);
			}
			

		
		}
	
   
	public void ajouterNoeud(Position position)
	{
		this.m_listeDeNoeuds.add(new Noeud(position));
	}



	public ArrayList<Noeud> reqListeNoeuds()
	{
		return this.m_listeDeNoeuds;
	}
	public ArrayList<Arc> reqListeArcs()
	{
		return this.m_listeArcs;
	}
	
	public Noeud reqNoeud(Position position){
		
		for (int i= 0; i<m_listeDeNoeuds.size(); i++){
			Position noeud_position = m_listeDeNoeuds.get(i).reqPosition();
			float x = position.reqPositionX();
			float y = position.reqPositionY();
			float c1 = noeud_position.reqPositionX();
			float c2 = noeud_position.reqPositionY();
			float circle = (x-c1)*(x-c1) + (y-c2)*(y-c2);
			
			if(circle <= 10*10){
				return m_listeDeNoeuds.get(i);
			}
		}
		
		return null;
	}
	


	
	
	
	public void enleverNoeud(Noeud noeud)
	{
		if(this.m_listeDeNoeuds.contains(noeud))
		{
			this.m_listeDeNoeuds.get(this.m_listeDeNoeuds.indexOf(noeud)).reqListeArcsAdjacents().clear();//enlever la liste des noeuds adjacents
			this.m_listeDeNoeuds.remove(noeud);//enlever le noeud
		}
	}
	 
	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds)
	{
		float res = 999999999;
		Noeud noeudDest = new Noeud();
		if(this.m_listeDeNoeuds.contains(noeudSrc))
		{
			for (int i = 0; i<listNoeuds.size(); i++)
			{
				trouverItineraire(noeudSrc, listNoeuds.get(i));
				if(listNoeuds.get(i).reqCout()<res) 
				{
					res =listNoeuds.get(i).reqCout();
					noeudDest = listNoeuds.get(i);
				}
			}			
		
		}
		return noeudDest;
	}
	
	private void _initialisationDijkstra(Noeud a)//noeud a doit appartenir à la carte
	{
		for (int i = 0; i<this.m_listeDeNoeuds.size(); i++)
		{
			if(this.m_listeDeNoeuds.get(i)==a)
			{
				this.m_listeDeNoeuds.get(i).setCout(0);
			}
			else
			{
				this.m_listeDeNoeuds.get(i).setCout(999999999);
			}
		}
		
	}
	
	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2)
	{
		this._initialisationDijkstra(noeud1);
		
		for(int i = 0; i<noeud1.reqListeArcsAdjacents().size(); i++)
			
		{
			float dist =noeud1.reqListeArcsAdjacents().get(i).reqLongueur();
			if(dist < noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest().reqCout())
			{
				noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest().setCout(dist);
				noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest().setPredecesseur(noeud1.reqListeArcsAdjacents().get(i));
			}
			
		}
		
		
		
		return m_listeArcs;
	}

}
