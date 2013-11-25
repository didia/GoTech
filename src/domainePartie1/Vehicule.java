package domainePartie1;

import java.util.ArrayList;

public class Vehicule {

	private static Vehicule m_vehicule = new Vehicule();
	private Noeud m_portAttache = null;
	private float m_vitesse = 0;
	private Position m_position = null;
	private Noeud m_noeudActuel = null;
	private Arc m_arcActuel = null;
	private GestionnaireUrgence m_gestionnaireUrgence;
	private Noeud m_noeudDestination = null;
	private Carte m_gps;
	private ArrayList<Noeud> m_itineraireActuel = null;

	// constructeur priv�e vehicule

	private Vehicule() {

	}

	// Obtenir le v�hicule
	public static Vehicule getInstance() {
		return m_vehicule;
	}

	public void lancerMission(GestionnaireUrgence gestionnaire, float vitesse,
			Carte gps) {
		m_gestionnaireUrgence = gestionnaire;
		m_vitesse = vitesse;
		m_gps = gps;
	}

	public void asgPointAttache(Noeud noeud) {
		m_portAttache = noeud;
		m_noeudActuel = m_portAttache;
		m_position = m_portAttache.reqPosition();
	}

	public void asgGestionnaireUrgence(GestionnaireUrgence gps) {
		m_gestionnaireUrgence = gps;
	}

	public void AllerVers(Noeud p_noeudDestination) {
		// le Noeud actuel devien le noeud de destination
		this.asgNoeudActuel(p_noeudDestination);
	}

	public void allerPortAttache() {
		// le Noeud actuel devien le noeudAttache
		this.asgNoeudActuel(this.m_portAttache);
	}

	public Position reqPosition() {
		return this.m_position;
	}

	public Noeud reqPortAttache() {
		return this.m_portAttache;
	}

	public float reqVistess() {
		return this.m_vitesse;
	}

	public Noeud reqnoeudActuel() {
		return m_noeudActuel;
	}

	// TODO
	public Arc arcActuel() {
		return m_arcActuel = new Arc(m_noeudActuel, m_noeudDestination);
	}

	public void asgNoeudActuel(Noeud noeud) {
		this.m_noeudActuel = noeud;
		this.m_position = noeud.reqPosition();
	}

	public void asgPositin(Position unePosition) {
		this.m_position = unePosition;
	}

	public void avance(int duree) {
		// ne tiens pas encore compte du chemin

		nouvellePositionVoiture(duree);// TODO

		if (this.m_itineraireActuel != null
				&& !this.m_itineraireActuel.isEmpty()) {
			this.poursuisChemin();
		} else {
			m_noeudDestination = this.m_gestionnaireUrgence
					.reqProchainNoeudATraite();

			if (m_noeudDestination != null) {
				this.m_itineraireActuel = this.m_gps.trouverItineraire(
						m_noeudActuel, m_noeudDestination);
				this.poursuisChemin();
			}
		}

	}

	private void poursuisChemin() {
		Noeud noeud = this.m_itineraireActuel.get(0);
		this.asgNoeudActuel(noeud);
		this.m_itineraireActuel.remove(noeud);
		if ((m_noeudActuel.reqPosition().reqPositionX() == m_noeudDestination
				.reqPosition().reqPositionX())
				&& (m_noeudActuel.reqPosition().reqPositionY() == m_noeudDestination
						.reqPosition().reqPositionY())) {
			this.m_gestionnaireUrgence.traiterUrgenceActuelle();
			this.m_itineraireActuel = null;
			this.m_noeudDestination = null;
		}
	}

	public Position nouvellePositionVoiture(int duree) {
		// TODO
		Position position = null;
		float newHypotenuse = this.m_vitesse * duree;

		float newPositionX = (m_arcActuel.reqNoeudDest().reqPosition()
				.reqPositionX() * newHypotenuse)
				/ m_arcActuel.reqLongueur();
		float newPositionY = (m_arcActuel.reqNoeudDest().reqPosition()
				.reqPositionY() * newHypotenuse)
				/ m_arcActuel.reqLongueur();
		position = new Position(newPositionX, newPositionY);
		this.asgPositin(position);
		return position;

	}
}