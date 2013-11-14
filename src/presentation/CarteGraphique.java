package presentation;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import domainePartie1.Carte;
import presentation.AfficheurGraphique;


public class CarteGraphique extends JPanel {
	
	
	private final AfficheurGraphique afficheurGraphique;
	private final Carte carte;
	
	
	
	public CarteGraphique(AfficheurGraphique afficheurGraphique, Carte carte) {
		
		this.carte = carte;
		this.afficheurGraphique = afficheurGraphique;
		}
		
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		afficheurGraphique.afficherCarte(g, carte);
	
	}
	
}
    		
		
		
	

