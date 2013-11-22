package domainePartie1;

public class Simulation  implements Runnable {

	private static Simulateur simulateur;
	private Parametres m_parametre;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		simulateur.lancerSimulation();
		
	}
	
}
