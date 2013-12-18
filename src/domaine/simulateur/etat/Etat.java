package domaine.simulateur.etat;

import java.io.Serializable;

import domaine.reseau.Arc;
import domaine.reseau.Noeud;

import javax.swing.event.MouseInputListener;

public interface Etat extends MouseInputListener, Serializable{
		// my abstract Etat classe
	public Arc reqArcSelectione();
	public Noeud reqNoeudSelectione();
	public String reqPositionDescription(int posX, int posY);
	public void cancel();
}
