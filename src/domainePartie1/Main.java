package domainePartie1;


import java.util.ArrayList;

import javax.swing.SwingUtilities;

import presentation.InterfaceGraphique;
import presentation.Afficheur;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 SwingUtilities.invokeLater(new Runnable() {
//
//	      @Override
//	      public void run() {
//	    	  new InterfaceGraphique(new Simulateur(), new Afficheur());
//	      }
//		 });
//		
		
		Urgence unrgenc1 = new Urgence(new Noeud(new Position(2,4)),10);
		Urgence unrgenc2 = new Urgence(new Noeud(new Position(3,4)),1);
		Urgence unrgenc3 = new Urgence(new Noeud(new Position(1,6)),8);
		Urgence unrgenc5 = new Urgence(new Noeud(new Position(5,8)),6);
		
		
		ArrayList<Urgence> liste = new ArrayList<Urgence>();
		ArrayList<Urgence> list2 = new ArrayList<Urgence>();
		StrategiePriorite  stra  = new StrategiePriorite(liste, list2);
		stra.ajouterUrgence(unrgenc1);
		stra.ajouterUrgence(unrgenc2);
		stra.ajouterUrgence(unrgenc3);
		stra.ajouterUrgence(unrgenc5);
		
		for (int i = 0 ; i< stra.reqListeUrgence().size(); ++i)
			System.out.println(liste.get(i));
	}
	

}
