package domaine.simulation.strategie.minchemin;

/*
* Tour.java
* Stores a candidate tour
* Inspired from http://www.theprojectspot.com/tutorial-post/applying-a-genetic-algorithm-to-the-travelling-salesman-problem/5
*/


import java.util.ArrayList;
import java.util.Collections;

import domaine.reseau.Noeud;

	public class Tour{

	    // Holds our tour of cities
	    private ArrayList<Noeud> tour = new ArrayList<Noeud>();
	    // Cache
	    private double fitness = 0;
	    private int distance = 0;
	    
	    // Constructs a blank tour
	    public Tour(int nombreDesNoeuds){
	        for (int i = 0; i < nombreDesNoeuds; i++) {
	            tour.add(null);
	        }
	    }
	    
	    public Tour(ArrayList<Noeud> tour){
	        this.tour = tour;
	    }

	    // Creates a random individual
	    public void generateIndividual(ArrayList<Noeud> listeDesNoeuds) {
	        // Loop through all our destination cities and add them to our tour
	        for (int cityIndex = 0; cityIndex < listeDesNoeuds.size(); cityIndex++) {
	          setNoeud(cityIndex, listeDesNoeuds.get(cityIndex));
	        }
	        // Randomly reorder the tour
	        Collections.shuffle(tour);
	    }

	    // Gets a city from the tour
	    public Noeud getNoeud(int tourPosition) {
	        return tour.get(tourPosition);
	    }

	    // Sets a city in a certain position within a tour
	    public void setNoeud(int tourPosition, Noeud noeud) {
	        tour.set(tourPosition, noeud);
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
	    
	    // Gets the total distance of the tour
	    public int getDistance(){
	        if (distance == 0) {
	            int tourDistance = 0;
	            // Loop through our tour's cities
	            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
	                // Get city we're travelling from
	                Noeud fromCity = getNoeud(cityIndex);
	                // City we're travelling to
	                Noeud destinationCity;
	                // Check we're not on our tour's last city, if we are set our 
	                // tour's final destination city to our starting city
	                if(cityIndex+1 < tourSize()){
	                    destinationCity = getNoeud(cityIndex+1);
	                }
	                else{
	                    destinationCity = getNoeud(0);
	                }
	                // Get the distance between the two cities
	                tourDistance += fromCity.cout(destinationCity);
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
	    public boolean containsCity(Noeud city){
	        return tour.contains(city);
	    }
	    
	    @Override
	    public String toString() {
	        String geneString = "|";
	        for (int i = 0; i < tourSize(); i++) {
	            geneString += getNoeud(i)+"|";
	        }
	        return geneString;
	    }
	}

