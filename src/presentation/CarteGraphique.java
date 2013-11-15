package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


import domainePartie1.Position;
import domainePartie1.Simulateur;
import presentation.Afficheur;


public class CarteGraphique extends JPanel implements MouseListener{
	
	
	private final Afficheur m_afficheur;
	private final Simulateur m_simulateur;
	
	
	
	public CarteGraphique(Afficheur afficheurGraphique, Simulateur p_simulateur) {
		
		this.m_simulateur = p_simulateur;
		this.m_afficheur = afficheurGraphique;
		
		setBackground(Color.WHITE);
		setVisible(true);
		addMouseListener(this);
		}
		
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		m_afficheur.afficherCarte(g, this.m_simulateur.reqCarte());
	
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
		m_simulateur.doEdition(e);
		
		this.repaint();
		
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
    		

		
		
	

