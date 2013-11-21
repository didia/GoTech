package presentation;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JViewport;

import domainePartie1.Carte;
import domainePartie1.Grille;
import domainePartie1.Noeud;
import domainePartie1.Position;
import domainePartie1.Arc;
import domainePartie1.Simulateur;
import domainePartie1.Default;

public class Afficheur 
{
	private static final String NOEUD_IMAGE_PATH = Default.NOEUD_IMAGE_PATH;
	private static final String VEHICULE_IMAGE_PATH = Default.VEHICULE_IMAGE_PATH;

	private Image m_imageDeFond = null;
	private Image m_imageDeNoeud;
    private Image m_ImageDeVehicule;
    private int WIDTH_NOEUD = Default.WIDTH_NOEUD;
   
    private static Grille m_grille;
    private static float m_zoom;
    private int maxWidth = 0;
    private int maxHeight = 0;
	public Afficheur() 
	{
		try 
		{
			//m_imageDeNoeud = ImageIO.read(new File(NOEUD_IMAGE_PATH));
			m_ImageDeVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		} 
	}
	
	
	public void afficherReseau(Graphics g, Simulateur simulateur, CarteGraphique carteGraphique)
	{
		Carte carte = simulateur.reqCarte();
		m_grille = simulateur.reqGrille();
		ArrayList<Noeud> listeDeNoeuds = carte.reqListeNoeuds();
		ArrayList<Arc> listeDeArcs = carte.reqListeArcs();
		m_zoom = simulateur.reqZoom();
		WIDTH_NOEUD = Math.round(Default.WIDTH_NOEUD * m_zoom);
		this.afficherNoeuds(g, listeDeNoeuds);
		this.afficherArcs(g, listeDeArcs);
		if(simulateur.reqPositionVehicule() != null)
		this.afficherVehicule(g, m_grille.reqPositionEnPixel(simulateur.reqPositionVehicule()));	
		this.afficherCarte(g, carteGraphique);
		this.afficherGrille(g, carteGraphique);
		
	}
	
	private void afficherCarte(Graphics g, CarteGraphique carteGraphique){
		int newWidth;
		int newHeight;
		System.out.println("1 ->" +maxWidth + " " + maxHeight);
		if(maxWidth > Default.CARTE_WIDTH){
			newWidth = maxWidth;
		}
		else{
			newWidth = Default.CARTE_WIDTH;
		}
		if(maxHeight > Default.CARTE_HEIGHT){
			System.out.println("MaxHeight plus grand");
			newHeight = maxHeight;
		}
		else{
			newHeight = Default.CARTE_HEIGHT;
			
		}
		maxWidth = Default.CARTE_WIDTH;
		maxHeight = Default.CARTE_HEIGHT;
		System.out.println(newWidth + " " + newHeight);
		
		carteGraphique.setPreferredSize(new Dimension(newWidth,newHeight));
		carteGraphique.revalidate();
	}
	private void afficherGrille(Graphics g, CarteGraphique carteGraphique){
		Graphics2D g2d = (Graphics2D)g;
		int width = carteGraphique.getWidth();
		int height = carteGraphique.getHeight();
		
		//carteGraphique.setPreferredSize(new Dimension(Math.round(Default.CARTE_WIDTH*m_zoom),Math.round(Default.CARTE_HEIGHT*m_zoom)));
		//carteGraphique.revalidate();
			
		for(int i = 0; i<width; i+=m_grille.reqPixelParStep()){
			for (int j =0; j<height; j+= m_grille.reqPixelParStep()){
				
				g2d.setStroke(new BasicStroke(m_zoom));
				g2d.draw(new Line2D.Double(i, j, i, j));
			}
		}
	}
	private void afficherNoeuds(Graphics g, ArrayList<Noeud> listeDeNoeuds)
	{
		Graphics2D g2d = (Graphics2D)g;
		

		for(Noeud noeud: listeDeNoeuds){
			Position position = m_grille.reqPositionEnPixel(noeud.reqPosition());
			//System.out.println("Noeud " + position.reqPositionX() + " " + position.reqPositionY());
            if(position.reqPositionX() > maxWidth){
            	maxWidth = (int)position.reqPositionX();
            }
            if(position.reqPositionY() > maxHeight){
            	
            	maxHeight = (int)position.reqPositionY();
            }
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - WIDTH_NOEUD/2;
			
			Ellipse2D.Double circle = new Ellipse2D.Double(a, b, WIDTH_NOEUD, WIDTH_NOEUD);
			g2d.fill(circle);
		}	
	}
	
	private void afficherArcs(Graphics g, ArrayList<Arc> listeArcs)
	{
		Graphics2D g2d = (Graphics2D)g;

		for(Arc arc:listeArcs){
			Position source = m_grille.reqPositionEnPixel(arc.reqNoeudSource().reqPosition());
			Position destination = m_grille.reqPositionEnPixel(arc.reqNoeudDest().reqPosition());
			

			g2d.setStroke(new BasicStroke(2*m_zoom));
			g2d.draw(new Line2D.Double(source.reqPositionX(), source.reqPositionY(), destination.reqPositionX(), destination.reqPositionY()));
		}
	}
	
	private void afficherVehicule(Graphics g, Position position)
	{
		if (position != null)
		{
			Graphics2D g2d = (Graphics2D)g;
			Image img = m_ImageDeVehicule.getScaledInstance( 40, 40,  Image.SCALE_SMOOTH) ; 
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - WIDTH_NOEUD - 40;
			g2d.drawImage(img, (int)a, (int)b, 50, 50, null);
		}	
	}
}