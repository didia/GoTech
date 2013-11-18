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
import domainePartie1.Default;

public class Afficheur 
{
	private static final String NOEUD_IMAGE_PATH = Default.NOEUD_IMAGE_PATH;
	private static final String VEHICULE_IMAGE_PATH = Default.VEHICULE_IMAGE_PATH;
	private Image m_imageDeFond = null;
	private Image m_imageDeNoeud;
    private Image m_ImageDeVehicule;
    private static final int WIDTH_NOEUD = Default.WIDTH_NOEUD;
    private static final int HEIGHT_NOEUD = Default.HEIGHT_NOEUD;
    
  
    
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
	
	public void afficherReseau(Graphics g, Simulateur simulateur)
	{
		Carte carte = simulateur.reqCarte();
		ArrayList<Noeud> listeDeNoeuds = carte.reqListeNoeuds();
		ArrayList<Arc> listeDeArcs = carte.reqListeArcs();
		
		this.afficherNoeuds(g, listeDeNoeuds);
		this.afficherArcs(g, listeDeArcs);
		this.afficherVehicule(g, simulateur.reqPositionVehicule());	
	}
	
	public void afficherNoeuds(Graphics g, ArrayList<Noeud> listeDeNoeuds)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		for (int i=0; i<listeDeNoeuds.size(); i++)
		{
			Position position = listeDeNoeuds.get(i).reqPosition();
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - HEIGHT_NOEUD/2;
			
			Ellipse2D.Double circle = new Ellipse2D.Double(a, b, WIDTH_NOEUD, HEIGHT_NOEUD);
			g2d.fill(circle);
		}	
	}
	
	public void afficherArcs(Graphics g, ArrayList<Arc> listeArcs)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		for (int i=0; i<listeArcs.size(); i++)
		{
			Position source = listeArcs.get(i).reqNoeudSource().reqPosition();
			Position destination = listeArcs.get(i).reqNoeudDest().reqPosition();
			
			g2d.setStroke(new BasicStroke(3));
			g2d.draw(new Line2D.Double(source.reqPositionX(), source.reqPositionY(), destination.reqPositionX(), destination.reqPositionY()));
		}
	}
	
	public void afficherVehicule(Graphics g, Position position)
	{
		if (position != null)
		{
			Graphics2D g2d = (Graphics2D)g;
			Image img = m_ImageDeVehicule.getScaledInstance( 20, 20,  Image.SCALE_SMOOTH) ; 
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - 2*HEIGHT_NOEUD;
			g2d.drawImage(img, (int)a, (int)b, 50, 50, null);
		}	
	}
}