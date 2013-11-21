package domainePartie1;


import presentation.InterfaceGraphique;
import presentation.Afficheur;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new InterfaceGraphique(new Simulateur(), new Afficheur());

		Noeud noeudactuVehicule = new Noeud( new Position(0,0));
		Noeud noeuddeUrgence = new Noeud(new Position(1, 2));
		Vehicule v = new Vehicule(noeudactuVehicule, 5 );
		
		Simulateur simu = new Simulateur();
		
		simu.declencherUrgence(noeuddeUrgence,1);
		
		
	}
	

}
