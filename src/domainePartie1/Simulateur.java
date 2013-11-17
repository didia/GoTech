package domainePartie1;

import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.event.MouseInputListener;





public class Simulateur implements MouseInputListener {
	
	private static Carte carte = new Carte();
    private static Vehicule m_vehicule = Vehicule.getInstance();
	private EtatDEdition m_etat = new EtatDEdition(this);
    
	
	public Simulateur() {
		

	}
	
	
	public Carte reqCarte() {
		return carte;
	}
	
	
	
	public void asgVehiculeUrgence(Noeud noeud){
		this.m_vehicule.asgPointAttache(noeud);
	}
	
	public Position reqPositionVehicule(){
		return this.m_vehicule.reqPosition();
	}
	
	
	public void ajouterNoeud(int positionX, int positionY){
		Position position = new Position((float)positionX, (float)positionY);
		if (carte.reqNoeud(position) == null){
			carte.ajouterNoeud(position);
		}
		
	}
	public void ajouterArc(Noeud noeudSource, Noeud noeudDest){
		carte.ajouterArc(noeudSource, noeudDest);
	}

	public Noeud reqNoeud(int positionX, int positionY){
		return carte.reqNoeud(new Position((float)positionX, (float)positionY));
	}
	
	public void deplacerNoeud(Noeud noeud, int positionX, int positionY){
		carte.deplacerNoeud(noeud, new Position((float)positionX, (float)positionY));
		
	}
	
	
	
	
	
	public Carte.Arc reqArc(int positionX, int positionY){
		return carte.reqArc(new Position((float)positionX, (float)positionY));
	}
	

	public boolean existeComponent(int positionX, int positionY){
		if(this.reqNoeud(positionX, positionY) != null || this.reqArc(positionX, positionY) != null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void supprimer_component(){
		
		Noeud noeud = m_etat.reqNoeudSelectione();
		if(noeud != null){
			System.out.println("Entrain de supprimer un noeud");
			carte.enleverNoeud(noeud);
		}
		else{
			Carte.Arc arc = m_etat.reqArcSelectione();
			if(arc != null){
				System.out.println("Entrain de supprimer un arc");
				carte.enleverArc(arc);
			}
		}
	}
	
	
	public void setEtatAjouterNoeud(){
		m_etat = new EtatAjouterNoeud(this);
	}
	public void setEtatAjouterArc(){
		m_etat = new EtatAjouterArc(this);
	}
	public void setEtatSelectioneur(){
		m_etat = new EtatModifierComponent(this);
	}
	public void setEtatPlacerVehicule(){
		m_etat = new EtatPlacerVehicule(this);
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

