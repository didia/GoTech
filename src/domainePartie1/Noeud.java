package domainePartie1;


import java.util.ArrayList;






public class Noeud implements Comparable<Noeud>
	//début classe noeud
	{

		
		private Position m_position;
		private float m_cout; // pour Dijkstra 
		private Noeud m_predecesseur;
		private boolean en_attente;
		private boolean en_traitement;
		private boolean traitee;
		
		
		
		
		public Noeud(Position pos)
		{
			this.m_position = pos;
			this.m_cout = 0;
			this.en_attente = false;
			this.en_traitement = false;
			this.traitee = false;
		}
		public boolean isEnAttente(){
			return this.en_attente;
		}
		public boolean isFree(){
			return !(this.en_attente || this.en_traitement);
		}
		public boolean isTraitee(){
			return this.traitee;
		}
		public boolean isEnTraitement(){
			return this.en_traitement;
		}
		public void setEnAttente(){
			this.en_attente = true;
			this.en_traitement = false;
			this.traitee = false;
		}
		public void setEnTraitement(){
			this.en_traitement = true;
			this.en_attente = false;
			this.traitee =false;
		}
		public void setTraitee(){
			this.en_traitement = false;
			this.en_attente = false;
			this.traitee = true;
		}
		
		public Noeud reqPredecesseur()
		{
			return this.m_predecesseur;
		}
		public void setPredecesseur(Noeud n)
		{
			this.m_predecesseur = n;
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


