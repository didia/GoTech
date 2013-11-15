package domainePartie1;

import java.awt.event.MouseEvent;


import domainePartie1.Carte;
import domainePartie1.EtatDEdition;
import domainePartie1.EtatAjouterNoeud;
import domainePartie1.EtatAjouterArc;
import domainePartie1.Position;


public class Simulateur {
	
	private static Carte carte = new Carte();
	private EtatDEdition m_etat = null;
	
	public Simulateur() {

	}
	
	public Carte reqCarte() {
		return carte;
	}
	
	public void ajouterNoeud(int positionX, int positionY){
		carte.ajouterNoeud(new Position((float)positionX, (float)positionY));
	}
	public void ajouterArc(Noeud noeudSource, Noeud noeudDest){
		carte.ajouterArc(noeudSource, noeudDest);
	}
	public Noeud reqNoeud(int positionX, int positionY){
		return carte.reqNoeud(new Position((float)positionX, (float)positionY));
	}
	public void setEtatAjouterNoeud(){
		m_etat = new EtatAjouterNoeud(this);
	}
	public void setEtatAjouterArc(){
		m_etat = new EtatAjouterArc(this);
	}
	
	public void doEdition(MouseEvent e){
		
		if(m_etat != null)
		{
			
			m_etat.doAction(e);
		}
	}
	
		
	}

