package presentation;

import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


import presentation.VehiculeGraphique;
import domainePartie1.Carte.*;


public class CarteGraphique extends JPanel {
	
	private static final String NOEUD_IMAGE_PATH = "/images/NoeudBleu.ico";
	
	private static final String VEHICULE_IMAGE_PATH = "/images/VehiculeUrgence.ico";
	
	private List<NoeudGraphique> m_listeNoeuds = new ArrayList<>();
	private List<ArcGraphique> m_listeArcs = new ArrayList<>();
	private VehiculeGraphique m_vehicule = null;
	
	private Image m_imageDeFond = null;
	private Image m_imageDeNoeud;
    private Image m_ImageDeVehicule;
	
	public CarteGraphique() {
		
		try {
			m_imageDeNoeud = ImageIO.read(new File(NOEUD_IMAGE_PATH));
			m_ImageDeVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
    
	public void ajouterNoeud( noeud){
		m_listeNoeuds.add(new NoeudGraphique(noeud, m_imageDeNoeud));
		
		
		
	}
}
