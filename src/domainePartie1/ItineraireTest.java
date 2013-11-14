package domainePartie1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ItineraireTest {

	@Test
	public void test() {


		Carte uneCarte = new Carte();
		//Noeud noeud =  uneCarte.new Noeud();
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
//			uneItineraire.asgLongueur(longueur);
			fail("test");
			
//			//assertTrue(longueur == uneItineraire.reqLongueur());
			System.out.println(listeArc.size());

	}

}
