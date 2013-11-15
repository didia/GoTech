package domainePartie1;

import java.util.ArrayList;
import domainePartie1.Position;
import domainePartie1.Noeud;


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
		public Arc(Noeud src, Noeud dest, float dist) {
			this.m_source = src;
			this.m_destination = dest;
			this.m_longueur = dist;
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


		private float calculerLongueur() {

			float distX = (this.m_source.reqPosition().reqPositionX() - this.m_destination.reqPosition().reqPositionX());
			float distX1 = distX * distX;
			float distY = (this.m_source.reqPosition().reqPositionY() - this.m_destination.reqPosition().reqPositionY());

			float distY1 = distY * distY;
			double somme = (double) (distY1 + distX1);
			return (float) (Math.sqrt(somme));
		}

	}// fin classe arc


	 public Carte(){
	    	m_listeDeNoeuds = new ArrayList<Noeud>();
	    	m_listeArcs = new ArrayList<Arc>();
	    }


	public void ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		if (this.m_listeDeNoeuds.contains(noeudSource)
				&& this.m_listeDeNoeuds.contains(noeudDest)) {
			Arc nouvelArc = new Arc(noeudSource, noeudDest, 0);
			float dist = nouvelArc.calculerLongueur();
			nouvelArc.asgLongueur(dist);
			this.m_listeArcs.add(nouvelArc);

		}
		else{
			System.out.println("Pas dans la liste de Noeuds");
		}

		/*
		 * else { throw }
		 */

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
			
		}

	}

	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {
		return noeudSrc;
	}




	
	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2)
	{
		return m_listeArcs;

	}

}
