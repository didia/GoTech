package domaine.simulateur;

import java.util.LinkedList;
import java.util.Queue;

public class EtatSimulateur {

	private  Queue<Simulateur> listeEtatSimu = new LinkedList<Simulateur>();
	
	private  Queue<Simulateur> listeEtatsuivantSimu = new LinkedList<Simulateur>();
	
	public Queue<Simulateur> reqListeEtatSimu()
	{
		return this.listeEtatSimu;
	}
	public void ajouterEtatSimu (Simulateur simu)
	{
		this.listeEtatSimu.add(simu);
	}
	
	public void asgListeEtatsimu(Queue<Simulateur>  laNouvelleListe)
	{
		this.listeEtatSimu = laNouvelleListe;
	}
	
	public Queue<Simulateur> reqListeEtatsuivantSimu()
	{
		return this.listeEtatsuivantSimu;
	}
	public void ajouterEtatsuivantSimu (Simulateur simu)
	{
		this.listeEtatsuivantSimu.add(simu);
	}
	
	public void asgListeEtatsuivantsimu(Queue<Simulateur>  laNouvelleListe)
	{
		this.listeEtatsuivantSimu = laNouvelleListe;
	}
	
}
