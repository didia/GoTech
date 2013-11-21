package domainePartie1;


import java.util.ArrayList;






public class Noeud implements Comparable<Noeud>
	//début classe noeud
	{

		
		private Position m_position;
		private float m_cout; // pour Dijkstra 
		private Arc m_predecesseur;
		private boolean m_etat;
		
		
		public Noeud()
		{
			this.m_cout = 0;
			this.m_position = new Position(0,0);
			this.m_etat = false;
			
		}
		
		public Noeud(Position pos)
		{
			this.m_position = pos;
			this.m_cout = 0;
			this.m_etat = false;
		}
		//Getters and setters noeuds
		public boolean reqEtat()
		{
			return this.m_etat;
		}
		public void setEtat(boolean a)
		{
			this.m_etat = a;
		}
		public Arc reqPredecesseur()
		{
			return this.m_predecesseur;
		}
		public void setPredecesseur(Arc arc)
		{
			this.m_predecesseur = arc;
		}
		

		public float reqCout()
		{
			return this.m_cout;
		}
		
		public void setCout(float r)
		{
			this.m_cout = r;
		}
		
		public Position reqPosition()
		{
			return this.m_position;
		}
		
		public void setPosition(Position nouvellePos)
		{
			m_position = nouvellePos;
		}
		//fin getters and setters noeuds



		@Override
		public int compareTo(Noeud n) {
			return m_position.compareTo(n.reqPosition());
		}
		
	
	
		
	}// fin classe noeud


