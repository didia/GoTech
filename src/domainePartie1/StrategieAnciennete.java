package domainePartie1;

import java.util.ArrayList;

public class StrategieAnciennete extends StrategieGestion {

	public StrategieAnciennete() {
		super();
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