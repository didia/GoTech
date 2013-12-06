package domaine.simulateur;

import java.awt.event.MouseEvent;


import javax.swing.event.MouseInputListener;
import java.io.*;

import domaine.reseau.Carte;


import domaine.reseau.Noeud;

import domaine.simulateur.etat.*;
import domaine.reseau.*;
import domaine.simulation.resultat.*;
import domaine.simulation.urgence.*;



public class Simulateur implements MouseInputListener, Serializable 
{
	private static final long serialVersionUID = 42L;

	
	private static Vehicule m_vehicule = Vehicule.getInstance();
	private Etat m_etat = new EtatDEdition(this);

	private Parametres m_parametres = new Parametres();
	private GestionnaireResultat m_gestionnaireResultat;
	


	private GestionnaireReseau m_gestionnaireReseau= new GestionnaireReseau();
	private  Carte m_carte  = m_gestionnaireReseau.reqCarte();



	int tempattente ;


	private GestionnaireUrgence m_gestionnaireUrgence = new GestionnaireUrgence();

	transient private EtatSimulateur m_etatsimu = new EtatSimulateur();

	public Simulateur() 
	{
		m_gestionnaireResultat = new GestionnaireResultat(m_vehicule, m_gestionnaireUrgence);
	}
	

	public void setEtatAjouterNoeud() 
	{
		m_etat = new EtatAjouterNoeud(this);
	}

	public void setEtatAjouterArc() 
	{
		m_etat = new EtatAjouterArc(this);
	}

	public void setEtatSelectioneur() 
	{
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
	
	public void initialiseMap(float largeurMap,float longueurMap){
		m_gestionnaireReseau.initialiseMap(largeurMap, longueurMap);
	}
	public void lancerSimulation() 
	{

		m_etat = new EtatEnSimulation(this);
		m_gestionnaireUrgence.asgStrategie(m_parametres.reqStrategie());
		m_vehicule.lancerMission(m_gestionnaireUrgence, m_carte,
				m_parametres.reqVitesseVehicule(),
				m_parametres.reqTempsTraitement(),
				m_parametres.reqRetourPointAttache(), m_parametres.reqEchelleTemps());
	
	}

	public void terminerSimulation() 
	{
		this.m_gestionnaireReseau.resetReseau();
		this.m_gestionnaireUrgence.reset();
		m_vehicule.reset();
		this.setEtatSelectioneur();
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
		return this.m_gestionnaireReseau.reqMetreParStep();
	}

	public void asgMetreParStep(int value) 
	{
		if (value > 0) 
		{
			this.m_gestionnaireReseau.asgMetreParStep(value);
			updaterCarte();
		}
	}

	public float reqTempsTraitement() 
	{
		return m_parametres.reqTempsTraitement();
	}

	public void asgTempsTraitement(float tempsTraitement) 
	{
		m_parametres.asgTempsTraitement(tempsTraitement);
	}
	
	public int reqEchelleTemps()
	{
		return m_parametres.reqEchelleTemps();
	}
	
	public void asgEchelleTemps(int echelleTemps)
	{
		m_parametres.asgEchelleTemps(echelleTemps);
	}

	public Carte reqCarte() {
		return this.m_gestionnaireReseau.reqCarte();
	}
	
	 public void asgCarte( Carte carte) {
		     this.m_gestionnaireReseau.asgCarte(carte);
 }


	public void toggleGrille()
	{
		this.m_gestionnaireReseau.toggleGrille();
	}
	

	public boolean isGrilleActive(){
		return this.m_gestionnaireReseau.isGrilleActive();
	}


	public void ajouterNoeud(int positionX, int positionY) 
	{
		this.m_gestionnaireReseau.ajouterNoeud(positionX, positionY);
	}

	public void ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		this.m_gestionnaireReseau.ajouterArc(noeudSource, noeudDest);
	}

	public Noeud reqNoeud(int positionX, int positionY) {
		return this.m_gestionnaireReseau.reqNoeud(positionX, positionY);
	}

	public void deplacerNoeud(Noeud noeud, int positionX, int positionY) 
	{
		this.m_gestionnaireReseau.deplacerNoeud(noeud, positionX, positionY);
	}
	
	public void modifierPositionPreciseNoeud(float positionX, float positionY){
		Noeud noeud = m_etat.reqNoeudSelectione();
		if(noeud != null)
		{
			this.m_gestionnaireReseau.modifierPositionPreciseNoeud(noeud, positionX, positionY);
		}
	}
	
	public void updaterCarte() 
	{
		this.m_gestionnaireReseau.updaterCarte();
	}

	public Arc reqArc(int positionX, int positionY) 
	{
		return this.m_gestionnaireReseau.reqArc(positionX, positionY);
	}

	public boolean existeComponent(int positionX, int positionY) 
	{
		return this.m_gestionnaireReseau.existeComponent(positionX, positionY);
	}

	public void supprimer_component() 
	{
		Noeud noeud = m_etat.reqNoeudSelectione();
		
		if (noeud != null) 
		{
			if (noeud.isEnAttente())
			{
				this.m_gestionnaireUrgence.enleverUrgenceAuNoeud(noeud);
			}
			this.m_gestionnaireReseau.enleverNoeud(noeud);			
		}

		else 
		{
			Arc arc = m_etat.reqArcSelectione();
			if (arc != null) 
			{
				
				this.m_gestionnaireReseau.enleverArc(arc);
			}
		}
	}
	
	public String reqPositionDescription(int posX, int posY)
	{
		return m_etat.reqPositionDescription(posX, posY);
	}
	public String reqPositionString(int posX, int posY) {

		return this.m_gestionnaireReseau.reqPositionString(posX, posY);
	}
	public String reqNoeudDescription(int posX, int posY){
		Noeud noeud = this.reqNoeud(posX, posY);
		String statut;
		int tempsAttente;
		Urgence urgence;
		if( noeud == null){
			return null;
		}
		
		if(noeud.isEnAttente()){
			urgence = this.m_gestionnaireUrgence.reqUrgenceNonTraiteeAssocieA(noeud);
			statut = "En Attente de traitement";
			tempsAttente = Math.round(urgence.reqtempsAttente());
		}
		else if (noeud.isEnTraitement()){
			urgence = this.m_gestionnaireUrgence.reqUrgenceTraiteeAssocieA(noeud);
			statut = "En traitement";
			tempsAttente = Math.round(urgence.reqtempsAttente());
		}
		else if (noeud.isTraitee()){

			urgence = this.m_gestionnaireUrgence.reqUrgenceTraiteeAssocieA(noeud);
			statut = "Trait�e r�cemment";

			tempsAttente = Math.round(urgence.reqtempsAttente());
		}
		else{
			return this.reqPositionString(posX, posY);
		}
		return "<html>Statut : <b>" + statut + "</b><br/> Temps d'attente : <b>"
		+ tempsAttente + "</b></html>";
	}
	public String reqResults(){
		Resultats results = this.m_gestionnaireResultat.reqResultats();
		return "Temps De Traitement Moyen : " + results.gettempsDattente() + " secondes\n" +
		       "Distance Totale parcourue : " + results.getDistanceParcourue() + " m�tres";
	}
	public Resultats reqResultats(){
		Resultats results = this.m_gestionnaireResultat.reqResultats();
		return results;
	}
	public GestionnaireReseau reqGestionnaireReseau() {
		return this.m_gestionnaireReseau;
	}

	public void asgVehiculeUrgence(Noeud noeud) {
		m_vehicule.asgPointAttache(noeud);
	}

	public Position reqPositionVehicule() {
		return m_vehicule.reqPosition();
	}

	public double reqDirectionVehicule() {
		return m_vehicule.reqDirection();
	}
	
	public void ajusteVitesseSimulation(int coefficient){
		m_vehicule.ajusteVitesseVehicule(coefficient);
	}

	public float reqZoom() {
		return this.m_gestionnaireReseau.reqZoom();
	}

	public String augmenteZoom() {
		return this.m_gestionnaireReseau.augmenteZoom();
	}

	public String diminueZoom() {
		return this.m_gestionnaireReseau.diminueZoom();
	}

	public void supprimerUrgence(Urgence uneUrgence) {

		m_gestionnaireUrgence.supprimerUrgence(uneUrgence);
	}

	public void deplacerVehiculeUrgence(int duree) {
		m_vehicule.avance(duree);
	}

	public void declencherUrgence(Noeud noeud) {
		if (noeud.isFree()) {
			this.m_gestionnaireUrgence.ajouterUrgence(noeud);
			noeud.setEnAttente();
			 
		}

	}

	public Position reqPositionProchaineUrgence() {
		Urgence urgence = m_gestionnaireUrgence.reqProchaineUrgence();
		if (urgence != null) {
			return m_gestionnaireUrgence.reqProchaineUrgence().reqNoeudCible()
					.reqPosition();
		}
		return null;

	}

	public void SauvegarderEtatActuel() {
		if (m_etatsimu.reqListeEtatSimu().contains(this))
			System.out.println("cette simulation a etÃ© dejas enregistrÃ©");
		else
			m_etatsimu.ajouterEtatSimu(this);
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
