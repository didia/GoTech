package domainePartie1;
import java.util.Timer;
import java.util.List;
public class Urgence {
	private  Timer heuredebut; 
	private Timer duree;
	private Noeud noeudCible;
	private List<Integer> priorite;
	
	public Timer geqDuree()
	{
		return this.duree;
	}
	
	public Timer geqHeureDebut()
	{
		return this.heuredebut;
	}
}
