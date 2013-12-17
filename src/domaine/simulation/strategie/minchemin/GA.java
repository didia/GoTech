package domaine.simulation.strategie.minchemin;

import java.util.ArrayList;

import domaine.reseau.Carte;
import domaine.reseau.Noeud;
import domaine.simulation.urgence.GestionnaireUrgence;
import domaine.simulation.urgence.Urgence;



public class GA {
	
	/* GA parameters */
    private static final double mutationRate = 0.10;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    private static Carte m_gps = GestionnaireUrgence.reqCarte() ;
    
   
    
    public static Carte reqGps()
    {
    	return m_gps;
    }
    public static Tour getNextTour(ArrayList<Urgence> listeDesUrgences, Noeud noeudActuel){
    	Population pop = new Population(500, listeDesUrgences);
    	
    	pop = GA.evolvePopulation(pop, listeDesUrgences.size(), noeudActuel);
    	System.out.println("Initial distance: " + pop.getFittest(noeudActuel).getDistance());
        for (int i = 0; i < 500; i++) {
            pop = GA.evolvePopulation(pop, listeDesUrgences.size(), noeudActuel);
        }
        System.out.println("Final distance: " + pop.getFittest(noeudActuel).getDistance());
        return pop.getFittest(noeudActuel);
    }
    // Evolves a population over one generation
    public static Population evolvePopulation(Population pop, int sizechild, Noeud noeudActuel) {
        Population newPopulation = new Population(pop.populationSize());

        // Keep our best individual if elitism is enabled
        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveTour(0, pop.getFittest(noeudActuel));
            elitismOffset = 1;
        }

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Select parents
            Tour parent1 = tournamentSelection(pop, noeudActuel);
            Tour parent2 = tournamentSelection(pop, noeudActuel);
            // Crossover parents
            Tour child = crossover(parent1, parent2, sizechild);
            // Add child to new population
            newPopulation.saveTour(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Tour crossover(Tour parent1, Tour parent2, int sizechild) {
        // Create new child tour
        Tour child = new Tour(sizechild);

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.tourSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setUrgence(i, parent1.getUrgence(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setUrgence(i, parent1.getUrgence(i));
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < parent2.tourSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(parent2.getUrgence(i))) {
                // Loop to find a spare position in the child's tour
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    // Spare position found, add city
                    if (child.getUrgence(ii) == null) {
                        child.setUrgence(ii, parent2.getUrgence(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap mutation
    private static void mutate(Tour tour) {
        // Loop through tour cities
        for(int tourPos1=0; tourPos1 < tour.tourSize(); tourPos1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.tourSize() * Math.random());

                // Get the cities at target position in tour
                Urgence city1 = tour.getUrgence(tourPos1);
                Urgence city2 = tour.getUrgence(tourPos2);

                // Swap them around
                tour.setUrgence(tourPos2, city1);
                tour.setUrgence(tourPos1, city2);
            }
        }
    }

    // Selects candidate tour for crossover
    private static Tour tournamentSelection(Population pop, Noeud noeudActuel) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize);
        // For each place in the tournament get a random candidate tour and
        // add it
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveTour(i, pop.getTour(randomId));
        }
        // Get the fittest tour
        Tour fittest = tournament.getFittest(noeudActuel);
        return fittest;
    }
}
