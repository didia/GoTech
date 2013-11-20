package presentation;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import domainePartie1.Carte;
import domainePartie1.Noeud;
import domainePartie1.Position;
import domainePartie1.Carte.Arc;
import domainePartie1.Simulateur;

public class Afficheur {
	private static final String NOEUD_IMAGE_PATH = "/images/NoeudBleu.ico";
	private static final String VEHICULE_IMAGE_PATH = "src/images/VehiculeUrgence.png";
	private Image m_imageDeFond = null;
	private Image m_imageDeNoeud;
    private Image m_ImageDeVehicule;
    private static final int WIDTH_NOEUD = 20;
    private static final int HEIGHT_NOEUD = 20;
    
  
    
	public Afficheur() {
		
		try {
			//m_imageDeNoeud = ImageIO.read(new File(NOEUD_IMAGE_PATH));
			m_ImageDeVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void afficherReseau(Graphics g, Simulateur simulateur){
		Carte carte = simulateur.reqCarte();
		ArrayList<Noeud> listeDeNoeuds = carte.reqListeNoeuds();
		ArrayList<Arc> listeDeArcs = carte.reqListeArcs();
		this.afficherNoeuds(g, listeDeNoeuds);
		this.afficherArcs(g, listeDeArcs);
		this.afficherVehicule(g, simulateur.reqPositionVehicule());
		
		
	}
	
	public void afficherNoeuds(Graphics g, ArrayList<Noeud> listeDeNoeuds){
		Graphics2D g2d = (Graphics2D)g;
		for(Noeud noeud: listeDeNoeuds){
			Position position = noeud.reqPosition();
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - HEIGHT_NOEUD/2;
			
			Ellipse2D.Double circle = new Ellipse2D.Double(a, b, WIDTH_NOEUD, HEIGHT_NOEUD);
			g2d.fill(circle);
			

		}
		
	}
	
	public void afficherArcs(Graphics g, ArrayList<Arc> listeArcs){
		Graphics2D g2d = (Graphics2D)g;
		for(Carte.Arc arc:listeArcs){
			Position position1 = arc.reqNoeudSource().reqPosition();
			Position position2 = arc.reqNoeudDest().reqPosition();
			
			
			g2d.setStroke(new BasicStroke(3));
			g2d.draw(new Line2D.Double(position1.reqPositionX(), position1.reqPositionY(), 
					position2.reqPositionX(), position2.reqPositionY()));

			

		}
	
	}
	
	public void afficherVehicule(Graphics g, Position position){
		if(position != null){
			Graphics2D g2d = (Graphics2D)g;
			Image img = m_ImageDeVehicule.getScaledInstance( 40, 40,  Image.SCALE_SMOOTH) ; 
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - HEIGHT_NOEUD - 40;
			g2d.drawImage(img, (int)a, (int)b, 50, 50, null);
		}
		
		
	}
	
}