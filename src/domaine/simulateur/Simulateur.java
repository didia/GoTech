package domaine.simulateur;

import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import javax.imageio.ImageIO;
import javax.swing.event.MouseInputListener;


import java.io.*;
import java.util.ArrayList;

import domaine.reseau.Carte;


import domaine.reseau.Noeud;
import domaine.simulateur.etat.*;

import domaine.simulateur.serialization.Enregistreur;

import domaine.reseau.*;
import domaine.simulation.resultat.*;
import domaine.simulation.urgence.*;



public class Simulateur implements MouseInputListener, Serializable 
{
	private static final long serialVersionUID = 42L;
	private Vehicule m_vehicule = Vehicule.getInstance();

	private Etat m_etat = new EtatDEdition(this);

	private File m_currentFile = null;
	private Parametres m_parametres = new Parametres();
	private GestionnaireResultat m_gestionnaireResultat;
	private GestionnaireReseau m_gestionnaireReseau= new GestionnaireReseau();
	
	private boolean m_changeHappened = false;
	private boolean enSimulation = false;
	
	private GestionnaireUrgence m_gestionnaireUrgence = new GestionnaireUrgence(m_gestionnaireReseau.reqCarte());

	

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
	public void setEtatEditionRapide()
	{
		m_etat = new EtatEditionRapide(this);
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
	
	public void cancelState(){
		m_etat.cancel();
	}
	
	public void initialiseMap(File image, float dimReel){
		Image imageDeFond;
		try
		{
			 imageDeFond = ImageIO.read(image);
			 m_gestionnaireReseau.initialiseMap(imageDeFond, dimReel);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public void lancerSimulation() 
	{
		if(this.m_changeHappened)
		{
			this.m_gestionnaireResultat.reset();
		}
		this.m_changeHappened = false;

		m_etat = new EtatEnSimulation(this);
		m_gestionnaireUrgence.asgStrategie(m_parametres.reqStrategie());
		m_vehicule.lancerMission(m_gestionnaireUrgence, m_gestionnaireReseau.reqCarte(),
		m_parametres.reqVitesseVehicule(),
		m_parametres.reqTempsTraitement(),
		m_parametres.reqRetourPointAttache(), m_parametres.reqEchelleTemps());
		this.m_gestionnaireResultat.generateResultats(m_parametres.reqStrategie(), m_parametres.reqRetourPointAttache());
		this.enSimulation = true;
	
	}
	
	public void restartSimulation ()
	{
		this.m_gestionnaireUrgence.restart();
		m_vehicule.reset();
		Clock.reset();
		this.lancerSimulation();
	}
	public void terminerSimulation() 
	{
		
		this.m_gestionnaireReseau.resetReseau();
		this.m_gestionnaireUrgence.restart();
		this.m_gestionnaireResultat.EnregistrerDernierResulats();
		m_vehicule.reset();
		this.setEtatSelectioneur();
		this.enSimulation = false;
	}
	public boolean isEnSimulation()
	{
		return this.enSimulation;
	}
	public boolean hasChangeHappened()
	{
		return this.m_changeHappened;
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

	public float reqMetreParStep() 
	{
		return this.m_gestionnaireReseau.reqMetreParStep();
	}

	public void asgMetreParStep(int value) 
	{
		if (value > 0) 
		{		this.m_gestionnaireReseau.asgMetreParStep(value);
			updaterCarte();
		}
		this.m_changeHappened = true;
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
	
	public void effacerToutReseau(){
		this.m_gestionnaireReseau.effacerTout();
		this.m_gestionnaireUrgence.reset();
		this.m_etat.cancel();
		this.m_changeHappened = true;
		m_vehicule.asgPointAttache(null);
	}
	public void effacerToutesLesUrgences()
	{
		this.m_gestionnaireUrgence.reset();
		this.m_gestionnaireReseau.resetReseau();
	}
	public Noeud ajouterNoeud(int positionX, int positionY) 
	{
		this.m_changeHappened = true;
		return this.m_gestionnaireReseau.ajouterNoeud(positionX, positionY);
	}

	public Arc ajouterArc(Noeud noeudSource, Noeud noeudDest) {
		this.m_changeHappened = true;
		return this.m_gestionnaireReseau.ajouterArc(noeudSource, noeudDest);
	}

	public Noeud reqNoeud(int positionX, int positionY) {
		return this.m_gestionnaireReseau.reqNoeud(positionX, positionY);
	}
	public Noeud reqNoeudSelectionne()
	{
		return m_etat.reqNoeudSelectione();
	}

	public void deplacerNoeud(Noeud noeud, int positionX, int positionY) 
	{
		this.m_changeHappened = true;
		this.m_gestionnaireReseau.deplacerNoeud(noeud, positionX, positionY);
	}
	
	public void modifierPositionPreciseNoeud(float positionX, float positionY){
		
		Noeud noeud = m_etat.reqNoeudSelectione();
		if(noeud != null)
		{
			this.m_gestionnaireReseau.modifierPositionPreciseNoeud(noeud, positionX, positionY);
		}
		this.m_changeHappened = true;
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
			this.supprimer_noeud(noeud);
			
		}

		else 
		{
			Arc arc = m_etat.reqArcSelectione();
			this.supprimer_arc(arc);
			
		}
	}
	
	public void supprimer_noeud(Noeud noeud)
	{
		if (noeud != null) 
		{
			if (noeud.isEnAttente())
			{
				this.m_gestionnaireUrgence.enleverUrgenceAuNoeud(noeud);
			}
			this.m_gestionnaireReseau.enleverNoeud(noeud);	
			this.m_changeHappened = true;
		}
	}
	public void supprimer_arc(Arc arc)
	{
		if (arc != null) 
		{
			
			this.m_gestionnaireReseau.enleverArc(arc);
			this.m_changeHappened = true;
		}
	}
	public String reqPositionDescription(int posX, int posY)
	{
		return m_etat.reqPositionDescription(posX, posY);
	}
	public String reqPositionString(int posX, int posY) {

		return this.m_gestionnaireReseau.reqPositionString(posX, posY);
	}
	public Position reqPositionEnMetre(int posX, int posY)
	{
		return this.m_gestionnaireReseau.reqPositionEnMetre(new Position(posX, posY));
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
	
	public GestionnaireUrgence reqGestionnaireUrgence()
	{
		return this.m_gestionnaireUrgence;
	}
	public GestionnaireResultat reqGestionnaireResultats()
	{
		return this.m_gestionnaireResultat;
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
	public void supprimerUrgence() {
		
		this.m_gestionnaireUrgence.enleverUrgenceAuNoeud(m_etat.reqNoeudSelectione());
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
	
	
	
	public void declencherUrgence(float tempsDeclenchement)
	{
		Noeud noeud = m_etat.reqNoeudSelectione();
		
		if(noeud != null && noeud.isFree())
		{
			this.m_gestionnaireUrgence.ajouterUrgence(noeud, Math.round(tempsDeclenchement*60*1000));
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



	public void enregistrer(File file) {
	
		Enregistreur.enregistrer(file, this);
		m_currentFile = file;
	}
	public void enregistrer()
	{
		Enregistreur.enregistrer(m_currentFile, this);
	}
	public void loader (File file)
	{
		Enregistreur.Enregistrable enregistrable = Enregistreur.load(file);
		this.m_parametres = enregistrable.parametres;
		this.enSimulation = enregistrable.enSimulation;
		this.m_changeHappened = enregistrable.m_changeHappened;
		this.m_etat = enregistrable.etat;
		this.m_gestionnaireReseau = enregistrable.gestionnaireReseau;
		this.m_gestionnaireResultat = enregistrable.gestionnaireResultat;
		this.m_gestionnaireUrgence = enregistrable.gestionnaireUrgence;
		this.m_vehicule = enregistrable.vehicule;
		this.m_currentFile = file;
		
	}

	

	
	public void resetAll()
	{
		effacerToutesLesUrgences();
		effacerToutReseau();
		m_vehicule.reset();
		Clock.reset();
		
	}

	public Parametres reqParametres() {
		
		return m_parametres;
	}



	public Etat reqEtat() {
		
		return m_etat;
	}



	public Vehicule reqVehicule() {
		
		return m_vehicule;
	}


	public boolean existeFile() {
		
		return m_currentFile != null;
	}




}
