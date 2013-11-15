package domainePartie1;

import java.util.ArrayList;

public class StrategiePriorite extends StrategieGestion {

	public StrategiePriorite() {
		super();
	}

	// l'urgence actuelle est la premiere de la liste desja triée
	public Urgence reqUrgencActuelle() {
		Urgence uneUrgence = this.reqListeUrgence().get(0);

		this.asgUrgenceAtuelle(uneUrgence);
		return uneUrgence;
	}

	public void traiterUrgenceActuelle() {
		if (this.reqListerUrgencetraitee().size() != 0) {
			Urgence urgence = this.reqUrgencActuelle();
			this.asgUrgenceAtuelle(urgence);
			this.traiterUrgencAtuelle();
		} else
			System.out.println("il ya plus d'ergence a Traiter");
	}

	// une fonction qui trie la liste des urgences passée en parametre
	public void trierListUrgence(ArrayList<Urgence> listUrgence) {
		for (int i = 0; i < listUrgence.size(); ++i) {
			for (int j = i + 1; j < listUrgence.size(); ++j) {
				if (listUrgence.get(i).reqPriorite() > listUrgence.get(j)
						.reqPriorite()) {
					Urgence urgenceTemp = listUrgence.get(i);
					listUrgence.set(i, listUrgence.get(j));
					listUrgence.set(j, urgenceTemp);

				}
			}
		}
	}

	// en ajoutant, on ordonne la liste selon la strategie priorité
	public void ajouterUrgence(Urgence urgenceAajouter) {
		ArrayList<Urgence> listTemp = this.reqListeUrgence();

		listTemp.add(urgenceAajouter);
		if (listTemp.size() > 1) {
			this.trierListUrgence(listTemp);

		}
		this.asgListUrgence(listTemp);
	}

}
