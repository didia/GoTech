package domainePartie1;
import java.util.List;
public class Itineraire {

	private List<Arc> listeArcs;
	private float longueur;
	
	//constructeur 
	public Itineraire(List<Arc> p_listeArcs)
	{
		this.longueur = 0;
		this.listeArcs = p_listeArcs;
	}
	
	public float calculerLongueur()
	{
		return this.longueur;
	}
	public List<Arc> reqListeArcs(){
		return this.listeArcs;
	}
}

