package presentation;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

import domainePartie1.Carte;
import domainePartie1.Noeud;
import domainePartie1.Position;

public class AfficheurGraphique {
	private static final String NOEUD_IMAGE_PATH = "/images/NoeudBleu.ico";
	private static final String VEHICULE_IMAGE_PATH = "/images/VehiculeUrgence.ico";
	private Image m_imageDeFond = null;
	private Image m_imageDeNoeud;
    private Image m_ImageDeVehicule;
    private static final int WIDTH_NOEUD = 2;
    private static final int HEIGHT_NOEUD = 2;
    
	public AfficheurGraphique() {
		
		try {
			m_imageDeNoeud = ImageIO.read(new File(NOEUD_IMAGE_PATH));
			m_ImageDeVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void afficherCarte(Graphics g, Carte carte){
		ArrayList<Noeud> listeDeNoeuds = carte.reqListeNoeuds();
		this.afficherNoeuds(g, listeDeNoeuds);
	}
	
	public void afficherNoeuds(Graphics g, ArrayList<Noeud> listeDeNoeuds){
		for(int i=0; i<listeDeNoeuds.size(); i++){
			Position position = listeDeNoeuds.get(i).reqPosition();
			g.fillOval(position.reqX(), position.reqY(),WIDTH_NOEUD,HEIGHT_NOEUD);

		}
	}
	
}