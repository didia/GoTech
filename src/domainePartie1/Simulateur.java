package domainePartie1;



import domainePartie1.Carte;

import domainePartie1.Position;

public class Simulateur {
	
	private static Carte carte = new Carte();
	
	public Simulateur() {

	}
	
	public Carte reqCarte() {
		return carte;
	}
	
	public void ajouterNoeud(int positionX, int positionY){
		carte.ajouterNoeud(new Position((float)positionX, (float)positionY));
	}
	
	
		
	}

