package domainePartie1;

import java.util.ArrayList;

public class StrategieAnciennete extends StrategieGestion {

	public StrategieAnciennete() {
		super();
	}

//TODO a revoir pour ANciennete seulement
	public void traiterUrgenceActuelle() {
		if (this.reqListeUrgence().size() != 0) {
			Urgence urgence = this.reqUrgencActuelle();
			this.asgUrgenceAtuelle(urgence);
			this.traiterUrgencAtuelle();
		} else
			System.out.println("il ya plus d'ergence a Traiter");
	}

	
	public Urgence reqUrgenceAcctuelle() // urgence actuelle est le premier sur
											// la liste
	{
		Urgence urgenceActuelle = this.reqListeUrgence().get(0);
		this.asgUrgenceAtuelle(urgenceActuelle);
		return urgenceActuelle;
	}

	public void ajouterUrgence(Urgence uneUrgence) {
		ArrayList<Urgence> listTempTriee = this.reqListeUrgence();

		listTempTriee.add(uneUrgence);

		this.asgListUrgence(listTempTriee);
	}

}