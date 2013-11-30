package domainePartie1;


import javax.swing.event.MouseInputListener;

public interface Etat extends MouseInputListener {
		// my abstract Etat classe
	public Arc reqArcSelectione();
	public Noeud reqNoeudSelectione();
	public String reqPositionDescription(int posX, int posY);
}
