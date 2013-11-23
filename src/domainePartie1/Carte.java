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
	
	public ArrayList<Noeud> trouverNoeudsAdjacents (Noeud noeud1)
	{
		ArrayList<Noeud> tab = new ArrayList<Noeud>(); 
		if (this.m_listeDeNoeuds.contains(noeud1))
		{
			for(int i = 0; i < this.m_listeArcs.size(); i++)
			{
				if(this.m_listeArcs.get(i).reqNoeudDest() == noeud1)
				{
					tab.add(this.m_listeArcs.get(i).reqNoeudSource());
				}
				if(this.m_listeArcs.get(i).reqNoeudSource() == noeud1)
				{
					tab.add(this.m_listeArcs.get(i).reqNoeudDest());
				}
				
			}
		 
		}
		return tab;
	}
	
	private float calculerDist(Noeud n1 , Noeud n2)
	{
		float res = 0;
		float res1 = (float)Math.pow((float)(n1.reqPosition().reqPositionX() - n2.reqPosition().reqPositionX()), 2);
		float res2 = (float)Math.pow((float)(n1.reqPosition().reqPositionY() - n2.reqPosition().reqPositionY()), 2);
		res = (float)Math.sqrt(res1+res2);
		return res;
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
			
			this.m_listeDeNoeuds.get(i).setPredecesseur(null);
		}

	}
	
	

	public ArrayList<Noeud> trouverItineraire(Noeud noeud1, Noeud noeud2) 
	{// gestion d'erreur
		
		this._initialisationDijkstra(noeud1);
		//int a = this.m_listeDeNoeuds.indexOf(noeud1);

		ArrayList<Noeud> tabPasParcourus = new ArrayList<Noeud>(this.m_listeDeNoeuds);
		
		
		while(!tabPasParcourus.isEmpty())
		{
			Noeud n1 = new Noeud();
			n1.setCout(INF);
			for(Noeud item: tabPasParcourus)
			{
				if(n1.reqCout()>item.reqCout())
					n1 = item;
			}  // Le n�ud dans tabpasParcouru avec le plus petit cout
			
			tabPasParcourus.remove(n1);
			
			for (Noeud n2:trouverNoeudsAdjacents(n1))

			{
				if(n2.reqCout()>(n1.reqCout()+ calculerDist(n1,n2)))
				{
					n2.setCout(n1.reqCout()+ calculerDist(n1,n2));
					n2.setPredecesseur(n1);
				}
			}
		}
		
		ArrayList<Noeud> chemin = new ArrayList<Noeud>();
		Noeud fin = noeud2;
		Noeud debut = noeud1;
		
		while(fin!=debut)
		{
			chemin.add(0, fin);
			fin = fin.reqPredecesseur();
		}
		

		return chemin;
	}

}

/*
  Fonction Dijkstra (n�uds, fils, distance, d�but, fin)
     Pour n parcourant n�uds
         n.parcouru = infini   // Peut �tre impl�ment� avec -1 (*)
         n.pr�c�dent = 0
     Fin pour
     d�but.parcouru = 0
     pasEncoreVu = n�uds
     Tant que pasEncoreVu != liste vide
         n1 = minimum(pasEncoreVu)   // Le n�ud dans pasEncoreVu avec parcouru le plus petit
         pasEncoreVu.enlever(n1)
         Pour n2 parcourant fils(n1)   // Les n�uds reli�s � n1 par un arc
             Si n2.parcouru > n1.parcouru + distance(n1, n2)   // distance correspond au poids de l'arc reliant n1 et n2
                 n2.parcouru = n1.parcouru + distance(n1, n2)
                 n2.pr�c�dent = n1   // Dit que pour aller � n2, il faut passer par n1
             Fin si
         Fin pour
     Fin tant que
     chemin = liste vide
     n = fin
     Tant que n != d�but
         chemin.ajouterAvant(n)
         n = n.pr�c�dent
     Fin tant que
     chemin.ajouterAvant(d�but)
     Retourner chemin
 Fin fonction Dijkstra 
 */

