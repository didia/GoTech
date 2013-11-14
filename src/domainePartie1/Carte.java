package domainePartie1;

import java.util.ArrayList;
import java.util.Timer;





public class Carte {
<<<<<<< HEAD
<<<<<<< HEAD

	private ArrayList<Noeud> listeDeNoeuds;
	private ArrayList<Arc> listeArcs;
=======
=======
	
	
	private ArrayList<Noeud> m_listeDeNoeuds;
	private ArrayList<Arc> m_listeArcs;
	
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
	
	
	private ArrayList<Noeud> m_listeDeNoeuds;
	private ArrayList<Arc> m_listeArcs;
	
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
	
	//constructeur de la class Carte
	public Carte()
	{
		
	}

	class Noeud
	// début classe noeud
	{

		private Position m_position;
<<<<<<< HEAD
<<<<<<< HEAD
		private ArrayList<Arc> m_listeArcsAdjacents;
		private float m_cout; // pour Dijkstra
=======
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
		private ArrayList<Arc> m_m_listeArcsAdjacents;
		private float m_cout; // pour Dijkstra 
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
		private Arc m_predecesseur;

		public Noeud() {
			this.m_cout = 0;
<<<<<<< HEAD
<<<<<<< HEAD
			this.m_listeArcsAdjacents = new ArrayList<Arc>();
			this.m_position = new Position(0, 0);
		}

		public Noeud(Position pos, ArrayList<Arc> listeArc, float cout, Arc pred) {

=======
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
			this.m_m_listeArcsAdjacents = new ArrayList<Arc>();
			this.m_position = new Position(0,0);
		}
		
		Noeud(Position pos)
		{
			this.m_position = pos;
			this.m_cout = 0;
			this.m_m_listeArcsAdjacents = new ArrayList<Arc>();
<<<<<<< HEAD
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
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
<<<<<<< HEAD
<<<<<<< HEAD
			private float positionX;
			private float positionY;

			public Position(float x, float y) {
				this.positionX = x;
				this.positionY = y;
=======
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
			private float m_positionX;
			private float m_positionY;
			Position(float x, float y)
			{
				this.m_positionX = x;
				this.m_positionY = y;
<<<<<<< HEAD
=======
			}
			public float reqPositionX()
			{
				return this.m_positionX;
			}
			public float reqPositionY()
			{
				return this.m_positionY;
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
			}
			public float reqPositionX()
			{
				return this.m_positionX;
			}
			public float reqPositionY()
			{
				return this.m_positionY;
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
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
<<<<<<< HEAD

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

=======
		
		private float calculerLongueur()
		{
			float distX = (this.m_source.m_position.reqPositionX() - this.m_destination.m_position.reqPositionX());
			float distX1 = distX * distX;
			float distY = (this.m_source.m_position.reqPositionY() - this.m_destination.m_position.reqPositionY());
			float distY1 = distY*distY;
			double somme = (double)(distY1 + distX1);
			return (float)(Math.sqrt(somme));
		}
		
		
		
		
	}//fin classe arc
	
	public ArrayList<Noeud> reqListeNoeuds()
	{
		return this.m_listeDeNoeuds;
	}
	
	public ArrayList<Arc> reqm_listeArcs()
	{
		return this.m_listeArcs;
	}
	
	
	public void ajouterNoeud(Noeud.Position pos)
	{
		Noeud noeud = new Noeud(pos);
		this.m_listeDeNoeuds.add(noeud);
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
			this.m_listeDeNoeuds.get(index).m_m_listeArcsAdjacents.add(nouvelArc);
		}
		

	
	}
	
	public void enleverNoeud(Noeud noeud)
	{
		if(this.m_listeDeNoeuds.contains(noeud))
		{
			
		}
<<<<<<< HEAD
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
	}

	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {
		return noeudSrc;
	}
<<<<<<< HEAD

	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2) {
		return listeArcs;
=======
	
	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2)
	{
		return m_listeArcs;
<<<<<<< HEAD
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
=======
>>>>>>> 3838174672bd51d94d4a86ca9b16a7dd0119d91e
	}

}
