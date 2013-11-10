package domainePartie1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class StrategieGestion {

	private Queue<Urgence> m_listeUrgence ;
	private Urgence m_urgenceActuelle;
	private List<Urgence> m_listeUrgenceTraitee = new ArrayList<Urgence>();

	//constructeur par defaut 
	public StrategieGestion()
	{
		//TODO
	}

	public StrategieGestion(Queue<Urgence> p_listDesUrgence,
			Urgence p_urgenceActuelle, List<Urgence> p_listeUrgenceTraitee) {
		this.m_listeUrgence = p_listDesUrgence;
		this.m_urgenceActuelle = p_urgenceActuelle;
		this.m_listeUrgenceTraitee = p_listeUrgenceTraitee;
	}
	
	//retourne l'urgenc actuelle
	public Urgence reqUrgencActuelle() {
		return this.m_urgenceActuelle;
	}
	//determine si toute les urgence on été dejas traitées  ou pas 
	public boolean existeUrgenceNonTraitee() {

		if (this.m_listeUrgence.size() == this.m_listeUrgenceTraitee.size())
			return false;
		else
			return true;
	}
	
	//effectue les operation attendu sur une urgence
	public void traiterUrgencAtuelle()
	{
		
	}
	public Queue<Urgence> reqUrgenceNonTraitee()
	{
		return this.m_listeUrgence;
	}
}
