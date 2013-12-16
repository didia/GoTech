package domaine.simulation.strategie.minchemin;

/*
* Tour.java
* Stores a candidate tour
* Inspired from http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
*/


import java.util.ArrayList;
import java.util.Collections;

import domaine.simulation.urgence.Urgence;



	public class Tour{

	    // Holds our tour of cities
	    private ArrayList<Urgence> tour = new ArrayList<Urgence>();
	    
	    // Cache
	    private double fitness = 0;
	    private float distance = 0;
	    
	    // Constructs a blank tour
	    public Tour(int nombreDesUrgences){
	        for (int i = 0; i < nombreDesUrgences; i++) {
	            tour.add(null);
	            
	        }
	    }
	    
	    public Tour(ArrayList<Urgence> tour){
	        this.tour = tour;
	    }

	    // Creates a random individual
	    public void generateIndividual(ArrayList<Urgence> listeDesUrgences) {
	        // Loop through all our destination cities and add them to our tour
	        for (int cityIndex = 0; cityIndex < listeDesUrgences.size(); cityIndex++) {
	          setUrgence(cityIndex, listeDesUrgences.get(cityIndex));
	        }
	        // Randomly reorder the tour
	        Collections.shuffle(tour);
	    }

	    // Gets a city from the tour
	    public Urgence getUrgence(int tourPosition) {
	        return tour.get(tourPosition);
	    }
	    
	    // Removes a city from the tour
	    public void removeUrgence(int tourPosition){
	    	tour.remove(0);
	    }
	    public boolean isEmpty()
	    {
	    	return tour.isEmpty();
	    }
	    // Sets a city in a certain position within a tour
	    public void setUrgence(int tourPosition, Urgence Urgence) {
	        tour.set(tourPosition, Urgence);
	        // If the tours been altered we need to reset the fitness and distance
	        fitness = 0;
	        distance = 0;
	    }
	    
	    // Gets the tours fitness
	    public double getFitness() {
	        if (fitness == 0) {
	            fitness = 1/(double)getDistance();
	        }
	        return fitness;
	    }
	    
	    public double getFitness(float additionalDistance)
	    {
	    	if(fitness == 0)
	    	{
	    		fitness = 1/(double)(getDistance() + additionalDistance);
	    	}
	    	
	    	return fitness;
	    	
	    }
	    
	    // Gets the total distance of the tour
	    public float getDistance(){
	        if (distance == 0) {
	            float tourDistance = 0;
	            // Loop through our tour's cities
	            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
	                // Get city we're travelling from
	                Urgence fromCity = getUrgence(cityIndex);
	                // City we're travelling to
	                Urgence destinationCity;
	                // Check we're not on our tour's last city, if we are set our 
	                // tour's final destination city to our starting city
	                if(cityIndex+1 < tourSize()){
	                    destinationCity = getUrgence(cityIndex+1);
	                }
	                else{
	                    destinationCity = getUrgence(0);
	                }
	                // Get the distance between the two cities
	                tourDistance += GA.reqGps().trouverCout(fromCity.reqNoeudCible(), destinationCity.reqNoeudCible());
	            }
	            distance = tourDistance;
	        }
	        return distance;
	    }

	    // Get number of cities on our tour
	    public int tourSize() {
	        return tour.size();
	    }
	    
	    // Check if the tour contains a city
	    public boolean containsCity(Urgence city){
	        return tour.contains(city);
	    }
	    
	    @Override
	    public String toString() {
	        String geneString = "|";
	        for (int i = 0; i < tourSize(); i++) {
	            geneString += getUrgence(i)+"|";
	        }
	        return geneString;
	    }
	}

