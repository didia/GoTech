package domainePartie1;

import java.util.ArrayList;
import java.util.Timer;

public class Carte {

	private ArrayList<Noeud> listeDeNoeuds;
	private ArrayList<Arc> listeArcs;
	
	//constructeur de la class Carte
	public Carte()
	{
		
	}

	class Noeud
	// début classe noeud
	{

		private Position m_position;
		private ArrayList<Arc> m_listeArcsAdjacents;
		private float m_cout; // pour Dijkstra
		private Arc m_predecesseur;

		public Noeud() {
			this.m_cout = 0;
			this.m_listeArcsAdjacents = new ArrayList<Arc>();
			this.m_position = new Position(0, 0);
		}

		public Noeud(Position pos, ArrayList<Arc> listeArc, float cout, Arc pred) {

		}

		public Position reqPosition() {
			return this.m_position;
		}

		public void setPosition(Position nouvellePos) {
			m_position = nouvellePos;
		}

		class Position
		// Début classe position
		{
			private float positionX;
			private float positionY;

			public Position(float x, float y) {
				this.positionX = x;
				this.positionY = y;
			}

		}// fin de la classe position

	}// fin classe noeud

	class Arc
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
			float distX = (this.m_source.m_position.positionX - this.m_destination.m_position.positionX);
			float distX1 = distX * distX;
			float distY = (this.m_source.m_position.positionY - this.m_destination.m_position.positionY);
			float distY1 = distY * distY;
			double somme = (double) (distY1 + distX1);
			return (float) (Math.sqrt(somme));
		}

	}// fin classe arc

	
	
//	public class Position
//	//debut de la Classe Position
//	{
//
//	}// fin Position

	public void ajouterNoeud(Noeud noeud) {
		this.listeDeNoeuds.add(noeud);
	}

	public void ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		if (this.listeDeNoeuds.contains(noeudSource)
				&& this.listeDeNoeuds.contains(noeudDest)) {
			Arc nouvelArc = new Arc(noeudSource, noeudDest, 0);
			float dist = nouvelArc.calculerLongueur();
			nouvelArc.asgLongueur(dist);
			this.listeArcs.add(nouvelArc);

		}

		/*
		 * else { throw }
		 */

	}

	public void enleverNoeud(Noeud noeud) {

	}

	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {
		return noeudSrc;
	}

	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2) {
		return listeArcs;
	}

}
