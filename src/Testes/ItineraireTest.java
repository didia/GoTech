package Testes;
import domainePartie1.Carte;
import domainePartie1.Itineraire;
import domainePartie1.Carte.Arc;
import domainePartie1.Carte.Noeud;
import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;



public class ItineraireTest {

	@Test
	//test du constructeur
	public void testItineraire() {
	
	Carte uneCarte = new Carte();
	Noeud noeud =  uneCarte.new Noeud();
	Arc arc1 = uneCarte.new Arc();
		Arc arc2 = new Arc(5);
		Arc arc3 = new Arc(123);
		Arc arc5 = new Arc(8);
		ArrayList<Arc>listeArc = new ArrayList<Arc>();
		listeArc.add(arc1);
		listeArc.add(arc2);
		listeArc.add(arc3);
		listeArc.add(arc5);
		Itineraire uneItineraire = new Itineraire();
		float longueur = uneItineraire.calculerLongueur(listeArc);
//		uneItineraire.asgLongueur(longueur);
		fail("test");
		
//		//assertTrue(longueur == uneItineraire.reqLongueur());
		System.out.println(listeArc.size());
		
		
	}

}
