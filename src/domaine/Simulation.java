package domainePartie1;

public class Simulation  implements Runnable {

	private static Simulateur simulateur;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		simulateur.lancerSimulation();
		//seter la position et et l'effecter au vehicule a temps reel
	}
	
}
