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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
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
<<<<<<< HEAD

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
=======
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
=======

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
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
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
<<<<<<< HEAD
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
<<<<<<< HEAD

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
<<<<<<< HEAD
=======
		 
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");
<<<<<<< HEAD
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
<<<<<<< HEAD
=======
		 
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
=======
		 

		 uneStrategiePriorite.traiterUrgencAtuelle();
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
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
<<<<<<< HEAD
<<<<<<< HEAD

		
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 
=======
		 

		 uneStrategiePriorite.traiterUrgencAtuelle();
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
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
<<<<<<< HEAD
		 
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
=======

		 uneStrategiePriorite.traiterUrgencAtuelle();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
		 System.out.println("la liste des Priorite  des urgences dejas Priorite  selon la strategie Priorité est");
			
		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
<<<<<<< HEAD
<<<<<<< HEAD
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		 System.out.println("L'urgence actuelle est celle dont la priorit� est :"+uneStrategiePriorite.urgenceActuelle().reqPriorite());
		 System.out.println("-------------------------------------------------------------");
		
		 uneStrategiePriorite.traiterUrgencAtuelle();

		 for(int i =0; i <uneStrategiePriorite.reqListerUrgencetraitee().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListerUrgencetraitee().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 System.out.println("la liste des priorites  des urgences mise a jour apres le traitement  d'une urgence ");
		 for(int i =0; i <uneStrategiePriorite.reqListeUrgence().size(); ++i)
			 System.out.println(uneStrategiePriorite.reqListeUrgence().get(i).reqPriorite());
		 System.out.println("-------------------------------------------------------------");

		 uneStrategiePriorite.traiterUrgencAtuelle();
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
=======
>>>>>>> 5caaa27ef93d235c7ed066b5abb1c3b0a445dc95
		 uneStrategiePriorite.traiterUrgencAtuelle();
		 uneStrategiePriorite.traiterUrgencAtuelle();
			 
	 }
}
