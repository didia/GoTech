package domainePartie1;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import domainePartie1.Carte;
import presentation.InterfaceGraphique;
import domainePartie1.Position;

public class Simulateur {
	
	private static Carte carte = new Carte();
	private static InterfaceGraphique interfaceGraphique = new InterfaceGraphique(carte);
	public Simulateur() {
		
		interfaceGraphique.ajouterCarteListener(new AjouterNoeudListener());
		
		
	}
	
	public class AjouterNoeudListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
				float positionX = (float) e.getX();
				float positionY = (float) e.getY();
			
				carte.ajouterNoeud(new Position(positionX, positionY));
				interfaceGraphique.rafraichirCarte();
				
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
