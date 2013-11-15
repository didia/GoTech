package mains;

import domainePartie1.*;

public class Main {

	 public static void main(String[] args) {
		
		 
		 StrategiePriorite uneStrategiePriorite = new StrategiePriorite();
		 StrategieAnciennete uneStrategieAnciennete = new StrategieAnciennete();
		 
		 uneStrategieAnciennete.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),2));
		 uneStrategieAnciennete.ajouterUrgence(new Urgence(new Noeud(new Position(4,8)),0));
		 uneStrategieAnciennete.ajouterUrgence(new Urgence(new Noeud(new Position(6,23)),1));
		 uneStrategieAnciennete.ajouterUrgence(new Urgence(new Noeud(new Position(3,1)),5));
		 uneStrategieAnciennete.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),3));

		 
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),2));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),2));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(4,8)),0));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(6,23)),1));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(3,1)),5));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),3));

		 System.out.println("Strategie Priorité");
		 System.out.println("la liste des priorité  des urgences selon la stregie priorité est");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("L'urgence actuelle est celle dont la priorité est :"+uneStrategiePriorite.reqUrgencActuelle().reqPriorite());
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des priorité  des urgences dejas traité  selon la stregie Ancienneté est");
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 
		 
		 System.out.println("Strategie Ancienneté");
		 System.out.println("la liste des priorité  des urgences selon la stregie Ancienneté est");
		 for(int i =0; i <uneStrategieAnciennete.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategieAnciennete.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("L'urgence actuelle est celle dont la priorité est :"+uneStrategieAnciennete.reqUrgencActuelle().reqPriorite());
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 System.out.println("la liste des priorité  des urgences dejas traité  selon la stregie Ancienneté est");
		 for(int i =0; i <uneStrategieAnciennete.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategieAnciennete.reqListerUrgencetraitee().get(i).reqPriorite());

		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
		 uneStrategieAnciennete.traiterUrgencAtuelle();
			
			 
	 }
}
