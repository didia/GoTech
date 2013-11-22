package domainePartie1;

import java.util.ArrayList;

public class StrategieAnciennete extends StrategieGestion {

	public StrategieAnciennete() {
		super();
	}


	
	public Urgence urgenceActuelle()
	{

		 try {
			    
			 
		Urgence	 uneUrgence = this.reqListeUrgence().get(0);
		this.asgUrgenceAtuelle(uneUrgence);
		 }
		 catch(NullPointerException e) 
			{
				System.out.println("Plus d'urgence en attente");
				
			}
		catch (IndexOutOfBoundsException e) {
		    System.out.println("il Y a plus d'urgence a traiter  :(");
		}
		 
		
		
		return this.reqUrgencActuelle();
	}


	public void traiterUrgenceActuelle() {
		if (this.existeUrgenceNonTraitee()) {
			Urgence urgence = this.reqUrgencActuelle();
			this.asgUrgenceAtuelle(urgence);
			this.traiterUrgencAtuelle();
		} else
			System.out.println("il ya plus d'ergence a Traiter");
	}

	public void ajouterUrgence(Urgence uneUrgence) { 

		ArrayList<Urgence> listTempTriee = new ArrayList<Urgence>();

		listTempTriee.add(uneUrgence);

		this.asgListUrgence(listTempTriee);
	}
	
	public String toString(){
		return Default.STRATEGIE_ANC;
	}

}