package mains;

import domainePartie1.*;

public class Main {

	 public static void main(String[] args) {
		
		 
		 StrategiePriorite uneStrategiePriorite = new StrategiePriorite();
		
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(3,1)),5));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),-1));

		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),2));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(2,4)),2));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(4,8)),5));
		 uneStrategiePriorite.ajouterUrgence(new Urgence(new Noeud(new Position(6,23)),89));
		 		 System.out.println("-------------------------------------------------------------");
		 System.out.println("Strategie Priorite");
		 
		 System.out.println("-------------------------------------------------------------");
			
		 System.out.println("la liste des priorites  des urgences selon la strategie Priorite est");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
			
		 System.out.println("L'urgence actuelle est celle dont la Priorite est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
			
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas traitee  selon la stregie Piorité est");
		
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		 

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
			 
	 }
}
