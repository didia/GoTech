package presentation;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentation.IconicButton.*;
import java.awt.event.MouseListener;

import domainePartie1.Carte;

import presentation.CarteGraphique;
import presentation.AfficheurGraphique;
public class InterfaceGraphique extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CarteGraphique m_carteGraphique;
    private AfficheurGraphique m_afficheurGraphique;

	public InterfaceGraphique(Carte carte) {
		
		super("Intervensim");
		m_afficheurGraphique = new AfficheurGraphique();
		m_carteGraphique = new CarteGraphique(m_afficheurGraphique, carte);
		
		getContentPane().add(m_carteGraphique, BorderLayout.CENTER);
		

	}
	
	public void ajouterCarteListener(MouseListener listener){
		m_carteGraphique.addMouseListener(listener);
	}
	
	public void rafraichirCarte() {
		m_carteGraphique.repaint();
	}
}
