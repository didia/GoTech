package domainePartie1;

import domainePartie1.Simulateur;
import presentation.InterfaceGraphique;
import presentation.AfficheurGraphique;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new InterfaceGraphique(new Simulateur(), new AfficheurGraphique());

	}

}
