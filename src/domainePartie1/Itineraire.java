package domainePartie1;
import java.util.ArrayList;
public class Itineraire {

	private ArrayList<Carte.Arc> m_listeArcs;
	private float m_longueur;
	
	// constructeur sans parametre
	public Itineraire ()
	{
		this.m_longueur = 0;
		this.m_listeArcs = new ArrayList<Carte.Arc>();
	}
	//constructeur avec parametre
	public Itineraire(ArrayList<Carte.Arc> p_listeArcs)
	{
		this.m_longueur = 0;
		this.m_listeArcs = p_listeArcs;
	}
	
	public float reqLongueur()
	{
		return this.m_longueur;
	}
	
	public void asgLongueur( float longueur)
	{
		this.m_longueur = longueur;
	}
	public ArrayList<Carte.Arc> reqListeArcs(){
		return this.m_listeArcs;
	}
	
	public float calculerLongueur(ArrayList<Carte.Arc> listeArcs) {
		float longueur = 0;
		for (int i = 0; i <listeArcs.size(); ++i) {
			longueur += listeArcs.get(i).reqLongueur();
		}
		return longueur;
	}

}

