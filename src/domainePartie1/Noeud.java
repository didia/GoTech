package domainePartie1;

import java.util.ArrayList;

import domainePartie1.Carte.Arc;


public class Noeud {
	private Position m_position;
	private ArrayList<Arc> m_listeArcsAdjacents;
	private float m_cout; // pour Dijkstra 
	private Arc m_predecesseur;
	
	Noeud()
	{
		this.m_cout = 0;
		this.m_listeArcsAdjacents = new ArrayList<Arc>();
		this.m_position = new Position(0,0);
	}
	
	public Noeud(Position position){
		this.m_position = position;
		
	}
	
	Noeud(Position pos, ArrayList<Arc> listeArc,float cout, Arc pred)
	{
		
	}
	public Position reqPosition()
	{
		return this.m_position;
	}
	
	public void setPosition(Position nouvellePos)
	{
		m_position = nouvellePos;
	}


}
