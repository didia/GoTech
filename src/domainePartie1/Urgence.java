package domainePartie1;
import java.util.Timer;
public class Urgence {
	private static Urgence m_urgence = new Urgence();
	private  Timer m_heuredebut; 
	private Timer m_duree;
	private static Noeud m_noeudCible;
	private int m_priorite; // de 0 a 5
	public static Timer dureeUrgence;
	
	public Urgence()
	{
		this.m_noeudCible = new Noeud();
		this.m_priorite = 5;
	}
	public Urgence(Noeud p_NoeudCible, int p_priorite)
	{
		this.m_noeudCible = p_NoeudCible;
		this.m_priorite = p_priorite;
		
	}
	
	// le vehicule elle même
	public static Urgence getInstance()
	{
		return m_urgence;
	}
	
	public Timer reqDuree()
	{
		return this.m_duree;
	}
	
	public Timer reqHeureDebut()
	{
		return this.m_heuredebut;
	}
	
	public int reqPriorite()
	{
		return this.m_priorite;
	}
	
	public Noeud reqNoeudCible()
	{
		return this.m_noeudCible;
	}
	
	public void asgNoeudCible(Noeud noeud)
	{
		this.m_noeudCible = noeud;
	
	}
}
