package domainePartie1;

import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Timer;
import javax.swing.event.MouseInputListener;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

public class Simulateur implements MouseInputListener {

	private static Carte carte = new Carte();
	private static Vehicule m_vehicule = Vehicule.getInstance();
	private EtatDEdition m_etat = new EtatDEdition(this);
	private static ZoomModel m_zoom = new ZoomModel();
	private static Echelle m_echelle = new Echelle();
	private static Grille m_grille = new Grille(m_echelle, m_zoom);
	private static Resultats m_resultat = new Resultats();
	private static Urgence m_urgence;
	private static StrategieGestion m_strategie = new StrategieGestion();
	//private EtatSimulateur m_etatsimu = new EtatSimulateur();
	
	public Simulateur() {

	}

	public Carte reqCarte() {
		return carte;
	}

	public Grille reqGrille() {
		return m_grille;
	}

	public void asgVehiculeUrgence(Noeud noeud) {
		m_vehicule.asgPointAttache(noeud);
	}

	public Position reqPositionVehicule() {
		return m_vehicule.reqPosition();
	}

	public void ajouterNoeud(int positionX, int positionY) {
		Position position = new Position((float) positionX, (float) positionY);
		position = m_grille.reqPositionEnMetre(position);
		if (carte.reqNoeud(position) == null) {
			carte.ajouterNoeud(position);

		}	
		

		} 

	public void ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		carte.ajouterArc(noeudSource, noeudDest);
	}

	public Noeud reqNoeud(int positionX, int positionY) {
		return carte.reqNoeud(m_grille.reqPositionEnMetre(new Position(
				(float) positionX, (float) positionY)));
	}

	public void deplacerNoeud(Noeud noeud, int positionX, int positionY) {
		Position nouvellePosition = new Position((float) positionX,
				(float) positionY);
		nouvellePosition = m_grille.reqPositionEnMetre(nouvellePosition);
		
		if(nouvellePosition.reqPositionX() >= 0 && nouvellePosition.reqPositionY() >= 0)
		{
		carte.deplacerNoeud(noeud, nouvellePosition);
		}
	}

	public Arc reqArc(int positionX, int positionY) {

		return carte.reqArc(m_grille.reqPositionEnMetre(new Position(
				(float) positionX, (float) positionY)));
	}

	public boolean existeComponent(int positionX, int positionY) {

		if (this.reqNoeud(positionX, positionY) != null
				|| this.reqArc(positionX, positionY) != null) {
			return true;
		}

		else {
			return false;
		}
	}

	public void supprimer_component() {
		Noeud noeud = m_etat.reqNoeudSelectione();

		if (noeud != null) {
			System.out.println("Entrain de supprimer un noeud");
			carte.enleverNoeud(noeud);
		}

		else {
			Arc arc = m_etat.reqArcSelectione();
			if (arc != null) {
				System.out.println("Entrain de supprimer un arc");
				carte.enleverArc(arc);
			}
		}
	}

	public void setEtatAjouterNoeud() {
		m_etat = new EtatAjouterNoeud(this);
	}

	public void setEtatAjouterArc() {
		m_etat = new EtatAjouterArc(this);
	}

	public void setEtatSelectioneur() {
		m_etat = new EtatModifierComponent(this);
	}

	public void setEtatPlacerVehicule() {
		m_etat = new EtatPlacerVehicule(this);
	}

	
	public float reqZoom(){
		return m_zoom.reqZoom();
	}
	
	public String augmenteZoom(){
		return (int)(m_zoom.augmenteZoom()*100) + "%";
	}
	public String diminueZoom(){
		return (int)(m_zoom.diminueZoom()*100)+ "%";
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		m_etat.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		m_etat.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		m_etat.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		m_etat.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		m_etat.mouseReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		m_etat.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		m_etat.mouseMoved(e);
	}

	private void supprimerUrgence(Urgence uneUrgence) {
	
		m_strategie.reqListeUrgence().remove(uneUrgence);
	}

	public void lancerSimulation() {
		
	if(m_strategie.reqListeUrgence().isEmpty())
			{
			m_vehicule.AllerVers(m_strategie.reqUrgencActuelle().reqNoeudCible());
			m_strategie.traiterUrgencAtuelle();
			}
		
	}

	public void terminerSimulation() {
		m_vehicule.AllerPointAttache();
		
	}

	public void declencherUrgence(Noeud noeudcible, int p_priorite) {

		m_urgence = new Urgence(noeudcible, p_priorite);
		m_strategie.reqListeUrgence().add(m_urgence);
		System.out.println("une urgence a eté declenché Position "
				+ noeudcible.reqPosition().reqPositionX() + ","
				+ noeudcible.reqPosition().reqPositionY());
	}


	/*

	public void SauvegarderEtatActuel() {
		if (m_etatsimu.reqListeEtatSimu().contains(this))
			System.out.println("cette simulation a eté dejas enregistré");
		else
			m_etatsimu.ajouterEtatSimu(this);

	}

	public void annuler() {
		if (!m_etatsimu.reqListeEtatSimu().isEmpty()) {
			m_etatsimu.ajouterEtatsuivantSimu(m_etatsimu.reqListeEtatSimu().peek());
			//TODO this = m_etatsimu.reqListeEtatSimu().peek();
			m_etatsimu.reqListeEtatSimu().poll();
		}

	}

	public void retablir() {
		
		if(!m_etatsimu.reqListeEtatsuivantSimu().isEmpty())
		{
			m_etatsimu.ajouterEtatSimu(m_etatsimu.reqListeEtatsuivantSimu().peek());
			//TODO this = m_etatsimu.reqListeEtatsuivantSimu().peek();
			m_etatsimu.reqListeEtatsuivantSimu().poll();
		}
	}
	*/

}
