package Testes;

import domainePartie1.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StrategiePrioriteTest {

	@Test
	public void testReqUrgencActuelle() {
		Noeud unNoeud1 = new Noeud();
		Noeud unNoeud2 = new Noeud();
		Noeud unNoeud3 = new Noeud();
		Noeud unNoeud4 = new Noeud();
		Urgence urgenceAajouter1 = new Urgence(unNoeud1, 1);
		Urgence urgenceAajouter2 = new Urgence(unNoeud2, 10);
		Urgence urgenceAajouter3 = new Urgence(unNoeud3, 5);
		Urgence urgenceAajouter4 = new Urgence(unNoeud4, 0);
		StrategiePriorite uneStrategie = new StrategiePriorite();

		uneStrategie.ajouterUrgence(urgenceAajouter1);
		uneStrategie.ajouterUrgence(urgenceAajouter4);
		uneStrategie.ajouterUrgence(urgenceAajouter2);
		uneStrategie.ajouterUrgence(urgenceAajouter3);
		
		//tester si l'urgence atuelle est celle avec la plus petite priorité
		assertEquals(uneStrategie.reqUrgencActuelle(),urgenceAajouter4);
			
	}

	@Test
	public void testStrategiePriorite() {
		
		StrategiePriorite uneStragiePriorite = new StrategiePriorite();
		assertEquals(0, uneStragiePriorite.reqListerUrgencetraitee().size());
	}	
	@Test
	public void testTraiterUrgenceActuelle()
	{
		Noeud unNoeud1 = new Noeud();
		Noeud unNoeud2 = new Noeud();
		
		Urgence urgenceAajouter1 = new Urgence(unNoeud1, 1);
		Urgence urgenceAajouter2 = new Urgence(unNoeud2, 10);
		StrategiePriorite uneStrategie = new StrategiePriorite();

		uneStrategie.ajouterUrgence(urgenceAajouter1);
		uneStrategie.ajouterUrgence(urgenceAajouter2);
		
		uneStrategie.traiterUrgenceActuelle();
		assertEquals(uneStrategie.reqListeUrgence().size(), 1);
		assertEquals(uneStrategie.reqListerUrgencetraitee().size(), 1);
		
	}
	
		
	@Test
	public void testAjouterUrgence() {
		Noeud unNoeud1 = new Noeud();
		Noeud unNoeud2 = new Noeud();
		Noeud unNoeud3 = new Noeud();
		Noeud unNoeud4 = new Noeud();
		Urgence urgenceAajouter1 = new Urgence(unNoeud1, 1);
		Urgence urgenceAajouter2 = new Urgence(unNoeud2, 10);
		Urgence urgenceAajouter3 = new Urgence(unNoeud3, 5);
		Urgence urgenceAajouter4 = new Urgence(unNoeud4, 0);
		StrategiePriorite uneStrategie = new StrategiePriorite();
		assertEquals( uneStrategie.reqListerUrgencetraitee().size() , 0);
		assertEquals(uneStrategie.reqListeUrgence().size(), 0) ;
		
		uneStrategie.ajouterUrgence(urgenceAajouter1);
		uneStrategie.ajouterUrgence(urgenceAajouter4);
		uneStrategie.ajouterUrgence(urgenceAajouter2);
		uneStrategie.ajouterUrgence(urgenceAajouter3);
		
		assertEquals(uneStrategie.reqListeUrgence().size(), 4);
		
		
		
		
	}

}
