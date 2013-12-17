/**
 * Cette classe encapsule et gere les informations d'un reseaux routier,
 * constitue de noeuds et d'arc reliant les noeuds.
 *
 * 
 * @version 1.0
 *
 *
 * @author GoTech
 *
 *
 */

package domaine.reseau;

import java.util.ArrayList;

public class Carte {

	final private int INFINI = 999999999;
	private ArrayList<Noeud> m_listeDeNoeuds = new ArrayList<Noeud>();;
	private ArrayList<Arc> m_listeArcs = new ArrayList<Arc>();

	/**
	 * Constructeur d'une carte vide
	 * 
	 * 
	 */

	public Carte() {
		m_listeDeNoeuds = new ArrayList<Noeud>();
		m_listeArcs = new ArrayList<Arc>();
	}

	public Carte(Carte carte) {
		for (Noeud noeud : carte.reqListeNoeuds())
			this.m_listeDeNoeuds.add(noeud);
		for (Arc noeud : carte.reqListeArcs())
			this.m_listeArcs.add(noeud);

	}
	
	public void effacerTout()
	{
		m_listeDeNoeuds.clear();
		m_listeArcs.clear();
	}
	/**
	 * Ajoute un noeud a la carte
	 * 
	 * 
	 * @param position
	 *            une Position
	 * 
	 * 
	 */
	public Noeud ajouterNoeud(Position position) {
		Noeud nouveauNoeud = new Noeud(position);
		this.m_listeDeNoeuds.add(nouveauNoeud);
		return nouveauNoeud;
	}

	/**
	 * Ajoute un arc a la carte
	 * 
	 * 
	 * @param noeudSource
	 *            , le Noeud source contenu dans la carte
	 * @param noeudDest
	 *            , un Noeud destination contenu dans la carte
	 * 
	 */
	public Arc ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		Arc arc = this.reqArc(noeudSource, noeudDest);
		if (arc == null) {
			Arc nouvelArc = new Arc(noeudSource, noeudDest);
			this.m_listeArcs.add(nouvelArc);
			return nouvelArc;
		}
		return arc;

	}

	/**
	 * Deplace la position d'un noeud
	 * 
	 * 
	 * @param noeud
	 *            , le Noeud a deplacer
	 * @param nouvellePosition
	 *            , la nouvelle Position du noeud
	 * 
	 */
	public void deplacerNoeud(Noeud noeud, Position nouvellePosition) {
		if (noeud != null) {
			noeud.setPosition(nouvellePosition);
		}
	}

	/**
	 * Acceder a la liste des noeuds de la carte
	 * 
	 * 
	 * @return la liste des noeuds contenues dans la carte
	 */
	public ArrayList<Noeud> reqListeNoeuds() {
		return this.m_listeDeNoeuds;
	}

	/**
	 * Acceder a la liste des arcs de la carte
	 * 
	 * 
	 * @return la liste des arcs contenus dans la carte
	 */
	public ArrayList<Arc> reqListeArcs() {
		return this.m_listeArcs;
	}

	public void asgListeNoeuds(ArrayList<Noeud> listNoeud) {
		this.m_listeDeNoeuds = listNoeud;
	}

	/**
	 * Acceder a la liste des arcs de la carte
	 * 
	 * 
	 * @return la liste des arcs contenus dans la carte
	 */
	public void asgListeArcs(ArrayList<Arc> listArc) {
		this.m_listeArcs = listArc;
	}

	/**
	 * Acceder a un noeud par sa position
	 * 
	 * @param position
	 *            , une Position a laquelle on veut evaluer si il y a un noeud
	 * 
	 * @return le noeud si il existe a cet endroit, null sinon
	 * 
	 */
	public Noeud reqNoeud(Position position) {
		for (Noeud noeud : m_listeDeNoeuds) {
			Position noeud_position = noeud.reqPosition();

			if (noeud_position.reqPositionX() == position.reqPositionX()
					&& noeud_position.reqPositionY() == position.reqPositionY()) {

				return noeud;
			} else {
				float x = position.reqPositionX();
				float y = position.reqPositionY();
				float c1 = noeud_position.reqPositionX();
				float c2 = noeud_position.reqPositionY();
				float circle = (x - c1) * (x - c1) + (y - c2) * (y - c2);

				if (circle <= 5 * 5) {
					return noeud;
				}

			}
		}

		return null;
	}

	/**
	 * Accesseur pour un arc par sa position
	 * 
	 * 
	 * @param position
	 *            , une Position que l'on veut evaluer si un arc passe
	 * 
	 * @return l'arc si il croise la position, null sinon
	 * 
	 */
	public Arc reqArc(Position position) {
		for (Arc arc : m_listeArcs) {
			if (arc.isPositionIn(position)) {
				return arc;
			}
		}
		return null;
	}

	public Arc reqArc(Noeud source, Noeud dest) {
		for (Arc arc : m_listeArcs) {
			if (arc.reqNoeudSource().equals(source)
					&& arc.reqNoeudDest().equals(dest)) {
				return arc;
			}
		}
		return null;
	}

	/**
	 * Supprime un noeud de la carte en verifiant s'il existe
	 * 
	 * 
	 * @param noeud
	 *            , le Noeud a supprimer
	 * 
	 */
	public void enleverNoeud(Noeud noeud) {
		if (this.m_listeDeNoeuds.contains(noeud)) {
			ArrayList<Arc> liste_arcs_adjacents = this
					.trouverArcsAdjacents(noeud);

			for (Arc arc : liste_arcs_adjacents) {
				m_listeArcs.remove(arc);
			}

			// enlever le noeud
			this.m_listeDeNoeuds.remove(noeud);
		}
	}

	/**
	 * Supprime un arc en verifiant s'il existe
	 * 
	 * 
	 * @param position
	 *            , une Position a laquel on veut evaluer si il y a un noeud
	 * 
	 * @return le noeud si il existe a cet endroit, null sinon
	 * 
	 */
	public void enleverArc(Arc arc) {
		if (m_listeArcs.contains(arc)) {
			this.m_listeArcs.remove(arc);
		}
	}

	/**
	 * Trouve quel est le plus proche noeud
	 * 
	 * 
	 * @param noeudSrc
	 *            , le Noeud source
	 * @param listeNoeuds
	 *            , la liste des noeuds de la carte
	 * 
	 * @return le plus proche noeud du noeud source
	 * 
	 */
	public Noeud plusProche(Noeud noeudSrc, ArrayList<Noeud> listNoeuds) {

		float res = INFINI;
		Noeud plusProche = null;
		if (this.m_listeDeNoeuds.contains(noeudSrc)) {
			for (Noeud noeud : listNoeuds) {
				if (!noeudSrc.hasNoeudDansTable(noeud)) {
					trouverItineraire(noeudSrc, noeud);
				}

				if (res > noeudSrc.cout(noeud)) {
					plusProche = noeud;
					res = noeudSrc.cout(noeud);
				}
			}
		}

		return plusProche;

	}

	/**
	 * Trouve les arcs adjacents a un noeud
	 * 
	 * 
	 * @param noeud
	 *            , le Noeud dont l'on veut trouver les arcs adjacents
	 * 
	 * @return la liste des arcs permettant de se rendre au noeud destination
	 * 
	 */
	public ArrayList<Arc> trouverArcsAdjacents(Noeud noeud1) {
		ArrayList<Arc> tab = new ArrayList<Arc>();
		if (this.m_listeDeNoeuds.contains(noeud1)) {
			for (int i = 0; i < this.m_listeArcs.size(); i++) {
				if (this.m_listeArcs.get(i).reqNoeudDest() == noeud1) {
					tab.add(this.m_listeArcs.get(i));
				}

				if (this.m_listeArcs.get(i).reqNoeudSource() == noeud1) {
					tab.add(this.m_listeArcs.get(i));
				}
			}

		}

		return tab;
	}

	/**
	 * Trouve les noeuds adjacents a un noeud
	 * 
	 * 
	 * @param noeud
	 *            , le Noeud dont l'on veut trouver les noeuds adjacents
	 * 
	 * @return la liste des noeuds adjacents
	 * 
	 */
	public ArrayList<Noeud> trouverNoeudsAdjacents(Noeud noeud1) {
		ArrayList<Noeud> tab = new ArrayList<Noeud>();
		if (this.m_listeDeNoeuds.contains(noeud1)) {
			for (int i = 0; i < this.m_listeArcs.size(); i++) {
				if (this.m_listeArcs.get(i).reqNoeudDest() == noeud1) {
					tab.add(this.m_listeArcs.get(i).reqNoeudSource());
				}

				if (this.m_listeArcs.get(i).reqNoeudSource() == noeud1) {
					tab.add(this.m_listeArcs.get(i).reqNoeudDest());
				}
			}
		}

		return tab;
	}

	/**
	 * Calculer la distance entre deux noeuds
	 * 
	 * 
	 * @param n1
	 *            , le Noeud source
	 * @param n2
	 *            , le Noeud de destinations
	 * 
	 * @return la distance entre deux noeuds en float
	 * 
	 */
	private float calculerDist(Noeud n1, Noeud n2) {
		float res = 0;
		float res1 = (float) Math.pow(
				(float) (n1.reqPosition().reqPositionX() - n2.reqPosition()
						.reqPositionX()), 2);
		float res2 = (float) Math.pow(
				(float) (n1.reqPosition().reqPositionY() - n2.reqPosition()
						.reqPositionY()), 2);
		res = (float) Math.sqrt(res1 + res2);
		return res;
	}

	/**
	 * Initialise les donnes relatives au calcul du plus court chemin
	 * 
	 * 
	 * @param a
	 *            , le Noeud source ou l'algorithme sera applique
	 * 
	 * 
	 */
	private void _initialisationDijkstra(Noeud a)// noeud a doit appartenir
													// ï¿½ï¿½ï¿½ la carte
	{

		for (int i = 0; i < this.m_listeDeNoeuds.size(); i++) {
			if (this.m_listeDeNoeuds.get(i) == a) {

				this.m_listeDeNoeuds.get(i).setCout(0);
			} else {
				this.m_listeDeNoeuds.get(i).setCout(INFINI);
			}

			this.m_listeDeNoeuds.get(i).setPredecesseur(null);
		}

	}

	public ArrayList<Noeud> trouverItineraire(Noeud noeud1, Noeud noeud2){
		
		if(noeud1.next(noeud2) == null){
			
			return trouverItineraireDjikstra(noeud1, noeud2);
		}
		else
		{
			
			ArrayList <Noeud> chemin = new ArrayList<Noeud>();

			Noeud next = noeud1.next(noeud2);
			chemin.add(next);
			while (next != noeud2) {
				next = next.next(noeud2);
				chemin.add(next);
			}
			return chemin;
		}
	}

	/**
	 * Trouve le plus court itineraire pour se rendre d'un noeud source a un
	 * noeud destination
	 * 
	 * 
	 * @param noeud1
	 *            , le Noeud source
	 * @param noeud2
	 *            , le Noeud de destination
	 * 
	 * @return le plus proche noeud du noeud source
	 * 
	 */
	public ArrayList<Noeud> trouverItineraireDjikstra(Noeud noeud1, Noeud noeud2) {// gestion
		// d'erreur

		this._initialisationDijkstra(noeud1);

		if (noeud2.reqCout() == 0) {

			ArrayList<Noeud> res = new ArrayList<Noeud>();
			res.add(noeud2);
			return res;

		}
		// int a = this.m_listeDeNoeuds.indexOf(noeud1);

		ArrayList<Noeud> tabPasParcourus = new ArrayList<Noeud>(
				this.m_listeDeNoeuds);

		int cpt = 0;
		while (!tabPasParcourus.isEmpty() && cpt <= this.m_listeDeNoeuds.size()) {
			cpt = cpt + 1;
			Noeud n1 = new Noeud(new Position(0, 0));
			n1.setCout(INFINI);

			for (Noeud item : tabPasParcourus) {
				if (n1.reqCout() > item.reqCout()) {
					n1 = item;
				}
			} // Le nï¿½ï¿½ï¿½ud dans tabpasParcouru avec le plus petit cout

			tabPasParcourus.remove(n1);

			for (Noeud n2 : trouverNoeudsAdjacents(n1)) {
				float dist = calculerDist(n1, n2);
				n1.updateTableReseau(n2, n2, dist);
				n2.updateTableReseau(n1, n1, dist);
				if (n2.reqCout() > (n1.reqCout() + dist)) {
					n2.setCout(n1.reqCout() + dist);
					n2.setPredecesseur(n1);
				}
			}

		}

		if (!tabPasParcourus.isEmpty() && tabPasParcourus.contains(noeud2)) {

			return null;

		}

		else {
			ArrayList<Noeud> chemin = new ArrayList<Noeud>();
			Noeud fin = noeud2;
			Noeud debut = noeud1;
			float icout;
			Noeud noeudi;
			Noeud noeudj;
			float jcout;
			Noeud prochainNoeud;
			while (fin != debut) {
				chemin.add(0, fin);
				fin = fin.reqPredecesseur();
			}
			chemin.add(0, debut);
			for (int i = 0; i < chemin.size() - 1; i++) {
				noeudi = chemin.get(i);
				icout = noeudi.reqCout();
				prochainNoeud = chemin.get(i + 1);
				for (int j = i + 1; j < chemin.size(); j++) {
					noeudj = chemin.get(j);
					jcout = noeudj.reqCout();
					noeudi.updateTableReseau(noeudj, prochainNoeud, jcout
							- icout);
					noeudj.updateTableReseau(noeudi, chemin.get(j - 1), jcout
							- icout);

				}
			}
			chemin.remove(0);
			return chemin;

		}

	}

	public Noeud prochainNoeud(Noeud source, Noeud destination) {
		Noeud next = source.next(destination);
		if (next == null) {

			return this.trouverItineraire(source, destination).get(0);
		}

		return next;

	}

	public float trouverCout(Noeud source, Noeud destination) {
		Noeud next = source.next(destination);
		if (next == null) {
			this.trouverItineraire(source, destination);
		}
		return source.cout(destination);
	}

	/**
	 * 
	 */
	public boolean equals(Carte carte) {
		return (carte.reqListeNoeuds().size() == this.reqListeNoeuds().size() && carte
				.reqListeArcs().size() == this.reqListeArcs().size());

	}

	/**
	 * Remet les noeuds ˆ l'Žtat initial
	 * 
	 * 
	 * 
	 */

	public void resetEtatNoeud() {
		for (Noeud noeud : this.m_listeDeNoeuds) {
			noeud.reset();
		}
	}

}
