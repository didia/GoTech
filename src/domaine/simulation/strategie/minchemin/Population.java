package domaine.simulation.strategie.minchemin;

/*
* Population.java
* Manages a population of candidate tours
* Inspired from http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
*/


import java.util.ArrayList;

import domaine.reseau.Noeud;
import domaine.simulation.urgence.GestionnaireUrgence;
import domaine.simulation.urgence.Urgence;


public class Population {
	// Holds population of tours
    Tour[] tours;
   
    // Construct a population  
    public Population(int populationSize)
    {
    	tours = new Tour[populationSize];
    }
  
    public Population(int populationSize, ArrayList<Urgence> listeDesUrgences) {
    	
    		tours = new Tour[populationSize];
            // Loop and create individuals
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour(listeDesUrgences.size());
                newTour.generateIndividual(listeDesUrgences);
                saveTour(i, newTour);
            }
        
    }
    
    
    
    // Saves a tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    // Gets a tour from population
    public Tour getTour(int index) {
        return tours[index];
    }

    // Gets the best tour in the population
    public Tour getFittest(Noeud noeudActuel) {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
        	float distanceNoeudActuel = GestionnaireUrgence.reqCarte().trouverCout(noeudActuel, getTour(i).getUrgence(0).reqNoeudCible());
            if (fittest.getFitness(distanceNoeudActuel) <= getTour(i).getFitness(distanceNoeudActuel)) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return tours.length;
    }
}
