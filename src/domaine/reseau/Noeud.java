/**
* Cette classe gere la position et les etats d'un noeud
*
* 
* @version 1.0
*
* @author GoTech
*
* 
*
*/


package domaine.reseau;








public class Noeud
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
		
		
		/**
		* Verifie si le noeud est en attente de traitement
		*
		*
		* @return vrai si il est en attente, faux sinon
		* 
	    */
		public boolean isEnAttente()
		{
			return this.en_attente;
		}
		
		/**
		* Verifie si le n'a aucune urgence associe
		*
		*
		* @return vrai si il est n'a aucune urgence associe, faux sinon
		* 
	    */
		public boolean isFree()
		{
			return !(this.en_attente || this.en_traitement);
		}
		
		/**
		* Verifie si le noeud a ete traitee
		*
		*
		* @return vrai si il a ete traitee, faux sinon
		* 
	    */
		public boolean isTraitee()
		{
			return this.traitee;
		}
		
		/**
		* Verifie si le noeud est en traitement presentement
		*
		*
		* @return vrai si le noeud est en traitement, faux sinon
		* 
	    */
		public boolean isEnTraitement()
		{
			return this.en_traitement;
		}
		
		
		/**
		* Met l'etat du noeud a "En attente", s'assure que seul cet etat est actif
		*
		* 
	    */
		public void setEnAttente()
		{
			this.en_attente = true;
			this.en_traitement = false;
			this.traitee = false;
		}
		
		/**
		* Met l'etat du noeud a "En traitement", s'assure que seul cet etat est actif
		*
		* 
	    */
		public void setEnTraitement()
		{
			this.en_traitement = true;
			this.en_attente = false;
			this.traitee =false;
		}
		
		/**
		* Met l'etat du noeud a "Traitee", s'assure que seul cet etat est actif
		*
		* 
	    */
		public void setTraitee()
		{
			this.en_traitement = false;
			this.en_attente = false;
			this.traitee = true;
		}
		
		/**
		* Retourne le predecesseur du noeud, trouver par l'algorithme de dijkstra
		*
		* @return le predecesseur du noeud
		* 
	    */
		public Noeud reqPredecesseur()
		{
			return this.m_predecesseur;
		}
		
		/**
		* Assigne le predecesseur au noeud traitee par l'algorithme
		* 
		* @param n, le noeud a traitee
		* 
	    */
		public void setPredecesseur(Noeud n)
		{
			this.m_predecesseur = n;
		}

		/**
		* Retourne le cout present du noeud
		*
		* @return le cout present du noeud
		* 
	    */
		public float reqCout()
		{
			return this.m_cout;
		}
		
		
		/**
		* Assigne le cout du noeud traitee par l'alrogithme
		*
		* @param r, le nouveau cout du noeud
		*
		* 
	    */
		public void setCout(float r)
		{
			this.m_cout = r;
		}
		
		
		/**
		* Retourne la position du noeud
		*
		* @return la position du noeud
		* 
	    */
		public Position reqPosition()
		{
			return this.m_position;
		}
		
		/**
		* Assigne la position au noeud
		*
		* @param nouvellePos, la nouvelle position du noeud
		*
		* 
	    */
		public void setPosition(Position nouvellePos)
		{
			m_position = nouvellePos;
		}

		
		
		public boolean equals(Noeud n) 
		{
			return n.reqPosition().equals(this.m_position);
		}
		
		/**
		* Reinitialise les Žtats du noeud.
		* 
	    */
		public void reset(){
			this.en_attente = false;
			this.en_traitement = false;
			this.traitee = false;
		}
	}


