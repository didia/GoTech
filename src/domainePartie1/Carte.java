package domainePartie1;

import domainePartie1.Noeud;
import domainePartie1.Position;
import java.util.ArrayList;



public class Carte {

	final private int INF = 999999999;
	private ArrayList<Noeud> m_listeDeNoeuds;
	private ArrayList<Arc> m_listeArcs;

	
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
			/*
			float x = position.reqPositionX();
			float y = position.reqPositionY();
			float c1 = noeud_position.reqPositionX();
			float c2 = noeud_position.reqPositionY();
			float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);

			if (circle <= 10 * 10) {
				return noeud;
			}
			*/
			
			if (noeud_position.reqPositionX() == position.reqPositionX() && 
					noeud_position.reqPositionY() == position.reqPositionY()){
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
			ArrayList<Arc> liste_arcs_adjacents = this.trouverArcsAdjacents(noeud);
			for(Arc arc:liste_arcs_adjacents)
			{
				
				m_listeArcs.remove(arc);
			}
			
			this.m_listeDeNoeuds.remove(noeud);//enlever le noeud
		}
	}
	
	public void enleverArc(Arc arc){
		if (m_listeArcs.contains(arc))
		{
			
			this.m_listeArcs.remove(arc);
		}
		
	}
	


	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {

		float res = INF;
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
	
	public ArrayList<Arc> trouverArcsAdjacents (Noeud noeud1)
	{
		ArrayList<Arc> tab = new ArrayList<Arc>(); 
		if (this.m_listeDeNoeuds.contains(noeud1))
		{
			for(int i = 0; i < this.m_listeArcs.size(); i++)
			{
				if(this.m_listeArcs.get(i).reqNoeudDest() == noeud1)
				{
					tab.add(this.m_listeArcs.get(i));
				}
				if(this.m_listeArcs.get(i).reqNoeudSource() == noeud1)
				{
					tab.add(this.m_listeArcs.get(i));
				}
				
			}
		 
		}
		return tab;
	}
	

	private void _initialisationDijkstra(Noeud a)// noeud a doit appartenir � la
													// carte
	{
		for (int i = 0; i < this.m_listeDeNoeuds.size(); i++) {
			if (this.m_listeDeNoeuds.get(i) == a) 
			{
				this.m_listeDeNoeuds.get(i).setCout(0);
			} 
			else {
				this.m_listeDeNoeuds.get(i).setCout(INF);
			}
		}

	}
	
	

	public ArrayList<Noeud> trouverItineraire(Noeud noeud1, Noeud noeud2) 
	{// gestion d'erreur
		
		this._initialisationDijkstra(noeud1);
		int a = this.m_listeDeNoeuds.indexOf(noeud1);
		ArrayList<Noeud> tabPrets = new ArrayList<Noeud>();
		this.m_listeDeNoeuds.get(a).setEtat(true);
		tabPrets.add(this.m_listeDeNoeuds.get(a));
		
			for (int i = 0; i < this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).size(); i++)

			{
				float dist = this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqLongueur();
				
				if (dist < this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqNoeudDest()
						.reqCout())
				{
					this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqNoeudDest().setCout(dist);
					
					this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqNoeudDest()
							.setPredecesseur(this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i));
				}
				
				this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqNoeudDest().setEtat(true);
				tabPrets.add(this.trouverArcsAdjacents(this.m_listeDeNoeuds.get(a)).get(i).reqNoeudDest());

			}
			noeud1 = tabPrets.get(a+1);
		

		return m_listeDeNoeuds;
	}

}
