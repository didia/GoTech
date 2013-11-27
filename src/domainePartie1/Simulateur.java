package domainePartie1;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.event.MouseInputListener;



public class Simulateur implements MouseInputListener {

	private static Carte m_carte = new Carte();
	private static Vehicule m_vehicule = Vehicule.getInstance();
	private Etat m_etat = new EtatDEdition(this);
	private static ZoomModel m_zoom = new ZoomModel();
	private static Echelle m_echelle = new Echelle();
	private static Grille m_grille = new Grille(m_echelle, m_zoom);
	private Parametres m_parametres = new Parametres();
	
	
	private Resultats m_statistiques ;
	
	
	private  GestionnaireUrgence m_gestionnaireUrgence = new GestionnaireUrgence();

	private EtatSimulateur m_etatsimu = new EtatSimulateur();



	public Simulateur() {
		

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

	public void setEtatPlacerVehicule() 
	{
		m_etat = new EtatPlacerVehicule(this);
	}
	public void setEtatAjouterUregence() 
	{
		m_etat = new EtatAjouterUrgence(this);
	}

	public void lancerSimulation() {

		m_etat = new EtatEnSimulation(this);
		m_gestionnaireUrgence.asgStrategie(m_parametres.reqStrategie());
		m_vehicule.lancerMission(m_gestionnaireUrgence, m_carte, m_parametres.reqVitesseVehicule(),m_parametres.reqTempsTraitement() );
//		m_statistiques = new Resultats(m_vehicule.reqTempAttente(),m_vehicule.reqNombreUrgence(),m_vehicule.reqDistanceparcouru());
//		m_statistiques.afficherResultat(m_vehicule.reqVistess());

	}
	public boolean isStrategieCourante(String strategie)
	{
		return m_parametres.reqStrategie().equals(strategie);	
	}
	public String reqStrategieCourante()
	{
		return m_parametres.reqStrategie();
	}
	public void asgStrategie(String strategie)
	{
		m_parametres.asgStrategie(strategie);
	}
	public float reqVitesseVehicule()
	{
		return m_parametres.reqVitesseVehicule();
	}
	public void asgVitesseVehicule(float vitesse)
	{
		if (vitesse > 0)
		{
			m_parametres.asgVitesseVehicule(vitesse);
		}
	}
	public boolean isretourPointAttache()
	{
		return m_parametres.reqRetourPointAttache();
	}
	public void asgRetourPointAttache(boolean flag)
	{
		m_parametres.asgRetourPointAttache(flag);
	}
	public int reqMetreParStep()
	{
		return m_echelle.reqMetreParStep();
	}
	public void asgMetreParStep(int value)
	{
		if (value  > 0)
		{
			m_echelle.setMetreParStep(value);
		    updaterCarte();
		}
	}
	public float reqTempsTraitement(){
		return m_parametres.reqTempsTraitement();
	}
	public void asgTempsTraitement(int m_tempsTraitement){
		m_parametres.asgTempsTraitement(m_tempsTraitement);
	}
	
	public Carte reqCarte() 
	{
		return m_carte;
	}
	
	public void ajouterNoeud(int positionX, int positionY) 
	{
		Position position = new Position((float) positionX, (float) positionY);
		position = m_grille.reqPositionEnMetre(position);
		if (m_carte.reqNoeud(position) == null) 
		{
			m_carte.ajouterNoeud(position);
		}	
		

		} 

	public void ajouterArc(Noeud noeudSource, Noeud noeudDest) 
	{
		m_carte.ajouterArc(noeudSource, noeudDest);
	}

	public Noeud reqNoeud(int positionX, int positionY) 
	{
		return m_carte.reqNoeud(m_grille.reqPositionEnMetre(new Position((float) positionX, (float) positionY)));
	}

	public void deplacerNoeud(Noeud noeud, int positionX, int positionY) 
	{
		Position nouvellePosition = new Position((float) positionX, (float) positionY);
		nouvellePosition = m_grille.reqPositionEnMetre(nouvellePosition);
		
		if (nouvellePosition.reqPositionX() >= 0 && nouvellePosition.reqPositionY() >= 0)
		{
			m_carte.deplacerNoeud(noeud, nouvellePosition);
		}
	}
	
	public void updaterCarte()
	{
		for(Noeud noeud : m_carte.reqListeNoeuds())
		{
			m_carte.deplacerNoeud(noeud, m_grille.reqUpdatedPosition(noeud.reqPosition()));
		}
	}

	public Arc reqArc(int positionX, int positionY) 
	{
		return m_carte.reqArc(m_grille.reqPositionEnMetre(new Position((float) positionX, (float) positionY)));
	}

	public boolean existeComponent(int positionX, int positionY) 
	{
		if (this.reqNoeud(positionX, positionY) != null || this.reqArc(positionX, positionY) != null) 
		{
			return true;
		}

		else 
		{
			return false;
		}
	}

	public void supprimer_component() 
	{
		Noeud noeud = m_etat.reqNoeudSelectione();

		if (noeud != null) 
		{
			System.out.println("Entrain de supprimer un noeud");
			m_carte.enleverNoeud(noeud);
		}

		else 
		{
			Arc arc = m_etat.reqArcSelectione();
			if (arc != null) 
			{
				System.out.println("Entrain de supprimer un arc");
				m_carte.enleverArc(arc);
			}
		}
	}
	
	public String reqPositionDescription(int posX, int posY)
	{
		Position position = m_grille.reqPositionEnMetre(new Position(posX, posY));
		int positionX = Math.round(position.reqPositionX());
		int positionY = Math.round(position.reqPositionY());
		
		if (positionX/1000 > 1 || positionY/1000 > 1)
		{
			return "<html>Abscisse : "+ positionX/1000 + "Km<br/> Ordonn�e : " + positionY/1000 +"Km</html>";
		}
		return "<html>Abscisse : " + positionX + "m<br/> Ordonn�e : " + positionY + "m</html>";
	}
	
	public Grille reqGrille() 
	{
		return m_grille;
	}
	
	public void asgVehiculeUrgence(Noeud noeud) 
	{
		m_vehicule.asgPointAttache(noeud);
	}


	public Position reqPositionVehicule() 
	{
		return m_vehicule.reqPosition();
	}
	public double reqDirectionVehicule(){
		return m_vehicule.reqDirection();
	}
	
	
	public float reqZoom()
	{
		return m_zoom.reqZoom();
	}
	
	public String augmenteZoom()
	{
		return (int)(m_zoom.augmenteZoom()*100) + "%";
	}
	public String diminueZoom()
	{
		return (int)(m_zoom.diminueZoom()*100)+ "%";
	}

	public void supprimerUrgence(Urgence uneUrgence) 
	{

		m_gestionnaireUrgence.supprimerUrgence(uneUrgence);
	}


	
	public void deplacerVehiculeUrgence(int duree){
		m_vehicule.avance(duree);
	}
	public void terminerSimulation() 
	{
		m_vehicule.allerPortAttache();
	}

	public void declencherUrgence(Noeud noeud) 
	{	if(noeud.isFree()){
			this.m_gestionnaireUrgence.ajouterUrgence(noeud);
			noeud.setEnAttente();
		}
		
		
	}
	
	public Position reqPositionProchaineUrgence(){
		Urgence urgence = m_gestionnaireUrgence.reqProchaineUrgence();
		if (urgence != null){
			return m_gestionnaireUrgence.reqProchaineUrgence().reqNoeudCible().reqPosition();
		}
		return null;
		
	}


	public void SauvegarderEtatActuel() 
	{
		if (m_etatsimu.reqListeEtatSimu().contains(this))
			System.out.println("cette simulation a eté dejas enregistré");
		else
			m_etatsimu.ajouterEtatSimu(this);
	}

	public void annuler() 
	{
		if (!m_etatsimu.reqListeEtatSimu().isEmpty()) 
		{
			m_etatsimu.ajouterEtatsuivantSimu(m_etatsimu.reqListeEtatSimu().peek());
			// TODO this = m_etatsimu.reqListeEtatSimu().peek();
			m_etatsimu.reqListeEtatSimu().poll();
		}

	}

	public void retablir() {

		if (!m_etatsimu.reqListeEtatsuivantSimu().isEmpty()) 
		{
			m_etatsimu.ajouterEtatSimu(m_etatsimu.reqListeEtatsuivantSimu().peek());
			// TODO this = m_etatsimu.reqListeEtatsuivantSimu().peek();
			m_etatsimu.reqListeEtatsuivantSimu().poll();
		}
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

}
