package Testes;
import domainePartie1.Carte;
import domainePartie1.Itineraire;
import domainePartie1.Noeud;


import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;



public class ItineraireTest {

	@Test
	//test du constructeur
	public void testItineraire() {
	
	Carte uneCarte = new Carte();
		Carte.Arc arc1 = uneCarte.new Arc();
		Carte.Arc arc2 = uneCarte.new Arc();
		Carte.Arc arc3 = uneCarte.new Arc();
		Carte.Arc arc5 = uneCarte.new Arc();
		ArrayList<Carte.Arc>listeArc = new ArrayList<Carte.Arc>();
		listeArc.add(arc1);
		listeArc.add(arc2);
		listeArc.add(arc3);
		listeArc.add(arc5);
		Itineraire uneItineraire = new Itineraire();
		float longueur = uneItineraire.calculerLongueur(listeArc);
		uneItineraire.asgLongueur(longueur);
		assertEquals(longueur, uneItineraire.reqLongueur(),0);
		
//		//assertTrue(longueur == uneItineraire.reqLongueur());
		System.out.println(listeArc.size());
		
		
	}

}
