package domainePartie1;

import domainePartie1.Noeud;
import domainePartie1.Position;
import java.util.ArrayList;

import java.util.Timer;

public class Carte {

	private ArrayList<Noeud> m_listeDeNoeuds;
	private ArrayList<Arc> m_listeArcs;

	public class Arc
	// d�but de l'arc
	{
		private float m_longueur;
		private Noeud m_source;
		private Noeud m_destination;
		private float a; // given the equation of the arc is y = ax+b
        private float b;
	
		public Arc(Noeud src, Noeud dest)
		{

			this.m_source = src;
			this.m_destination = dest;
			this.m_longueur = this.calculerLongueur();
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
		
		public boolean isPositionIn(Position position){
			
			float c2 = this.a * position.reqPositionX() + this.b;
			
			float x = position.reqPositionX();
			float y = position.reqPositionY();
			float c1 = x;
			
			float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);
			if (circle <= 3 * 3){
				return true;
			}
			return false;
		}

		private float calculerLongueur() {
			float distX = (this.reqNoeudSource().reqPosition().reqPositionX() - this
					.reqNoeudDest().reqPosition().reqPositionX());
			float distX1 = distX * distX;
			float distY = (this.reqNoeudSource().reqPosition().reqPositionY() - this
					.reqNoeudDest().reqPosition().reqPositionY());
			float distY1 = distY * distY;
			double somme = (double) (distY1 + distX1);
			return (float) (Math.sqrt(somme));
		}
		private void initAetB(){
			float x1 = m_source.reqPosition().reqPositionX();
			float x2 = m_destination.reqPosition().reqPositionX();
			float y1 = m_source.reqPosition().reqPositionY();
			float y2 = m_destination.reqPosition().reqPositionY();
			
			this.a = (y2-y1)/(x2-x1);
			this.b = y1-(x1*this.a);
		}

	}// fin classe arc

	public Carte() {
		m_listeDeNoeuds = new ArrayList<Noeud>();
		m_listeArcs = new ArrayList<Arc>();
	}


	 public void ajouterArc(Noeud noeudSource, Noeud noeudDest)
		{
			if(this.m_listeDeNoeuds.contains(noeudSource) && this.m_listeDeNoeuds.contains(noeudDest))
			{
				Arc nouvelArc = new Arc(noeudSource, noeudDest);
				
				this.m_listeArcs.add(nouvelArc);
				noeudSource.reqListeArcsAdjacents().add(nouvelArc);
				noeudDest.reqListeArcsAdjacents().add(nouvelArc);
			}

	}


	public void ajouterNoeud(Position position) {
		this.m_listeDeNoeuds.add(new Noeud(position));
	}


    public void deplacerNoeud(Noeud noeud, Position position){
    	if(m_listeDeNoeuds.contains(noeud)){
    		noeud.setPosition(position);
    	}
    }

	public ArrayList<Noeud> reqListeNoeuds()
	{

		return this.m_listeDeNoeuds;
	}

	public ArrayList<Arc> reqListeArcs() {
		return this.m_listeArcs;
	}

	public Noeud reqNoeud(Position position) {

		for (Noeud noeud: m_listeDeNoeuds) {
			Position noeud_position = noeud.reqPosition();
			float x = position.reqPositionX();
			float y = position.reqPositionY();
			float c1 = noeud_position.reqPositionX();
			float c2 = noeud_position.reqPositionY();
			float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);

			if (circle <= 10 * 10) {
				return noeud;
			}
		}

		return null;
	}
	
	public Arc reqArc(Position position){
		for (Arc arc:m_listeArcs){
			if(arc.isPositionIn(position)){
				return arc;
			}
		}
		return null;
	}

	public void enleverNoeud(Noeud noeud)
	{
		if(this.m_listeDeNoeuds.contains(noeud))
		{
			ArrayList<Arc> liste_arcs_adjacents = noeud.reqListeArcsAdjacents();
			for(Arc arc:liste_arcs_adjacents){
				
				m_listeArcs.remove(arc);
			}
			
			this.m_listeDeNoeuds.remove(noeud);//enlever le noeud
		}
	}
	
	public void enleverArc(Arc arc){
		if (m_listeArcs.contains(arc)){
			arc.reqNoeudSource().reqListeArcsAdjacents().remove(arc);
			arc.reqNoeudDest().reqListeArcsAdjacents().remove(arc);
			m_listeArcs.remove(arc);
		}
		
	}
	


	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {

		float res = 999999999;
		Noeud noeudDest = new Noeud();
		if (this.m_listeDeNoeuds.contains(noeudSrc)) {
			for (int i = 0; i < listNoeuds.size(); i++) {
				trouverItineraire(noeudSrc, listNoeuds.get(i));
				if (listNoeuds.get(i).reqCout() < res) {
					res = listNoeuds.get(i).reqCout();
					noeudDest = listNoeuds.get(i);
				}
			}

		}
		return noeudDest;
	}

	private void _initialisationDijkstra(Noeud a)// noeud a doit appartenir � la
													// carte
	{
		for (int i = 0; i < this.m_listeDeNoeuds.size(); i++) {
			if (this.m_listeDeNoeuds.get(i) == a) {
				this.m_listeDeNoeuds.get(i).setCout(0);
			} else {
				this.m_listeDeNoeuds.get(i).setCout(999999999);
			}
		}

	}

	public ArrayList<Arc> trouverItineraire(Noeud noeud1, Noeud noeud2) {
		this._initialisationDijkstra(noeud1);

		for (int i = 0; i < noeud1.reqListeArcsAdjacents().size(); i++)

		{
			float dist = noeud1.reqListeArcsAdjacents().get(i).reqLongueur();
			if (dist < noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest()
					.reqCout()) {
				noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest()
						.setCout(dist);
				noeud1.reqListeArcsAdjacents().get(i).reqNoeudDest()
						.setPredecesseur(noeud1.reqListeArcsAdjacents().get(i));
			}

		}

		return m_listeArcs;
	}

}
