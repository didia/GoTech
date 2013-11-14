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
import domainePartie1.Simulateur;

import presentation.CarteGraphique;
import presentation.AfficheurGraphique;
public class InterfaceGraphique extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CarteGraphique m_carteGraphique;
   

	public InterfaceGraphique(Simulateur p_simulateur, AfficheurGraphique p_afficheurGraphique ) {
		
		super("Intervensim");
		
		m_carteGraphique = new CarteGraphique(p_afficheurGraphique, carte);
		
		getContentPane().add(m_carteGraphique, BorderLayout.CENTER);
		setPreferredSize(new Dimension(800, 400));
		setLocation(300, 200);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

	}
	
	public void ajouterCarteListener(MouseListener listener){
		m_carteGraphique.addMouseListener(listener);
	}
	
	public void rafraichirCarte() {
		m_carteGraphique.repaint();
	}
}
