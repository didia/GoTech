package presentation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.Image;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;


import domaine.reseau.*;

import domaine.simulateur.Simulateur;
import domaine.simulateur.Default;

public class Afficheur
{

	private static final String VEHICULE_IMAGE_PATH = "src/"+ Default.VEHICULE_IMAGE_PATH;
	private static final String URGENCE_IMAGE_PATH = "src/"+ Default.URGENCE_IMAGE_PATH;
	
	private Image m_imageDeFond = null;
	private Image m_ImageDeVehicule;
	private Image m_ImageUrgence;
	private int WIDTH_NOEUD = Default.WIDTH_NOEUD;

	private static GestionnaireReseau m_gestionnaireReseau;
	private static float m_zoom;
	private int maxWidth = 0;
	private int maxHeight = 0;
	private boolean toggleUrgence = true;
	

	
	public Afficheur() 
	{
		try 
		{
			// m_imageDeNoeud = ImageIO.read(new File(NOEUD_IMAGE_PATH));
			m_ImageDeVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
			m_ImageUrgence = ImageIO.read(new File(URGENCE_IMAGE_PATH));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	public void afficherReseau(Graphics g, Simulateur simulateur, CarteGraphique carteGraphique) 
	{
		Carte carte = simulateur.reqCarte();
	
		m_gestionnaireReseau = simulateur.reqGestionnaireReseau();
		ArrayList<Noeud> listeDeNoeuds = carte.reqListeNoeuds();
		ArrayList<Arc> listeDeArcs = carte.reqListeArcs();
		m_zoom = simulateur.reqZoom(); 
		WIDTH_NOEUD = Math.round(Default.WIDTH_NOEUD * m_zoom);
		this.afficherCarte(g, carteGraphique);
	
		
		if(simulateur.isGrilleActive())
		{
			this.afficherGrille(g, carteGraphique);
		}
		
		this.afficherNoeuds(g, listeDeNoeuds);
		this.afficherArcs(g, listeDeArcs);
		
		if (simulateur.reqPositionVehicule() != null)
		{
			this.afficherVehicule(g, m_gestionnaireReseau.reqPositionEnPixel(simulateur.reqPositionVehicule()), simulateur.reqDirectionVehicule());
		}
		
		if (simulateur.reqPositionProchaineUrgence() != null)
		{
			
			this.afficherProchaineUrgence(g, simulateur.reqPositionProchaineUrgence());
		}
		
		
	}

	private void afficherCarte(Graphics g, CarteGraphique carteGraphique) 
	{
		this.m_imageDeFond = m_gestionnaireReseau.reqImageDeFond();
		if(this.m_imageDeFond != null)
		{
			
			afficherAvecImageDeFond(g, carteGraphique);
		}
		else
		{
			afficherSansImageDeFond(g, carteGraphique);
		}
		
		carteGraphique.revalidate();
		
	}

	private void afficherAvecImageDeFond(Graphics g, CarteGraphique carte){
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    BufferedImage img = (BufferedImage)m_imageDeFond;
	    float scale; 
	    if(m_zoom >= 1)
	    {
	    	scale = m_zoom;
	    }
	    else
	    {
	    	scale = 1;
	    }
	   
	    double imageWidth = scale * img.getWidth();
	    double imageHeight = scale * img.getHeight();
	    carte.setPreferredSize(new Dimension((int)Math.round(imageWidth),(int)Math.round(imageHeight)));
	    double x = (carte.getWidth() - imageWidth) / 2;
	    double y = (carte.getHeight() - imageHeight) / 2;
	    AffineTransform at = AffineTransform.getTranslateInstance(x, y);
	    at.scale(scale, scale);
	    g2.drawRenderedImage(img, at);
	}
	
	private void afficherSansImageDeFond(Graphics g, CarteGraphique carte){
		int newWidth;
		int newHeight;
		
		if (maxWidth > Default.CARTE_WIDTH) 
		{
			newWidth = maxWidth;
		}
		else 
		{
			newWidth = Default.CARTE_WIDTH;
		}
		
		if (maxHeight > Default.CARTE_HEIGHT) 
		{
			System.out.println("MaxHeight plus grand"); 

			newHeight = maxHeight;
		} 
		else 
		{
			newHeight = Default.CARTE_HEIGHT;
		}
		
		maxWidth = Default.CARTE_WIDTH;
		maxHeight = Default.CARTE_HEIGHT;

		carte.setPreferredSize(new Dimension(newWidth, newHeight));
	}
	private void afficherGrille(Graphics g, CarteGraphique carteGraphique) 
	{
		Graphics2D g2d = (Graphics2D) g;
		int width = carteGraphique.getWidth();
		int height = carteGraphique.getHeight();
		int pixel_per_step = Math.round(m_gestionnaireReseau.reqPixelParStep());
		
		for (int i = pixel_per_step; i < width; i += pixel_per_step)
		{
			for (int j = pixel_per_step; j < height; j += pixel_per_step)
			{
				g2d.setStroke(new BasicStroke(m_zoom));
				g2d.draw(new Line2D.Double(i, j, i, j));
			}
		}
	}

	
	private void afficherNoeuds(Graphics g, ArrayList<Noeud> listeDeNoeuds)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		for (Noeud noeud: listeDeNoeuds)
		{
			Position position = m_gestionnaireReseau.reqPositionEnPixel(noeud.reqPosition());

            if (position.reqPositionX() + m_gestionnaireReseau.reqPixelParStep()> maxWidth)
            {

            	maxWidth = Math.round(position.reqPositionX() + 3*m_gestionnaireReseau.reqPixelParStep());
            }
            
            if (position.reqPositionY() + m_gestionnaireReseau.reqPixelParStep() > maxHeight)
            {
            	maxHeight = Math.round(position.reqPositionY() + 3*m_gestionnaireReseau.reqPixelParStep());
            }
            
			double a = position.reqPositionX() - WIDTH_NOEUD/2;
			double b = position.reqPositionY() - WIDTH_NOEUD/2;
			
			//Change la couleur selon l'etat du noeud
			if (noeud.isEnAttente())
			{
				g2d.setColor(Color.RED);
			}
			else if (noeud.isTraitee())
			{
				g2d.setColor(Color.GREEN);
			}
			else if (noeud.isEnTraitement())
			{
				g2d.setColor(Color.YELLOW);
			}
			else 
			{
				g2d.setColor(Color.BLUE);
			}
			
			g2d.setStroke(new BasicStroke(m_zoom*7));
			Ellipse2D.Double circle = new Ellipse2D.Double(a, b, WIDTH_NOEUD, WIDTH_NOEUD);
			g2d.draw(circle);	
		}
	}
	
	
	private void afficherProchaineUrgence(Graphics g, Position position) 
	{
		position = m_gestionnaireReseau.reqPositionEnPixel(position);
		if (position != null && toggleUrgence) 
		{
			Graphics2D g2d = (Graphics2D) g;
			Image img = m_ImageUrgence.getScaledInstance(WIDTH_NOEUD, WIDTH_NOEUD, Image.SCALE_SMOOTH);
			double a = position.reqPositionX() - WIDTH_NOEUD / 2;
			double b = position.reqPositionY() - WIDTH_NOEUD;
			g2d.drawImage(img, (int) a, (int) b, 20, 20, null);
		}
		toggleUrgence = !toggleUrgence;
	}

	
	private void afficherArcs(Graphics g, ArrayList<Arc> listeArcs) 
	{
		Graphics2D g2d = (Graphics2D) g;
		
		for (Arc arc : listeArcs) 
		{
			Position source = m_gestionnaireReseau.reqPositionEnPixel(arc.reqNoeudSource().reqPosition());
			Position destination = m_gestionnaireReseau.reqPositionEnPixel(arc.reqNoeudDest().reqPosition());
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2 * m_zoom));
			g2d.draw(new Line2D.Double(source.reqPositionX(), source.reqPositionY(), destination.reqPositionX(), destination.reqPositionY()));
		}
	}
	
	
	private void afficherVehicule(Graphics g, Position position, double direction)
	{
		if (position != null) 
		{
			//position = m_gestionnaireReseau.reqPositionEnPixel(position);
			Graphics2D g2d = (Graphics2D) g;
			
			//Image img = m_ImageDeVehicule.;
			BufferedImage img = (BufferedImage)m_ImageDeVehicule;
			
			double a = position.reqPositionX() - WIDTH_NOEUD / 2;
			double b = position.reqPositionY() - WIDTH_NOEUD*2;
			
			double locationX = img.getWidth() / 2;
			double locationY = img.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(direction, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			

			// Drawing the rotated image at the required drawing locations
			
			g2d.drawImage(op.filter(img, null).getScaledInstance(WIDTH_NOEUD*2, WIDTH_NOEUD*2, Image.SCALE_SMOOTH), (int)a, (int)b,(WIDTH_NOEUD*2)+2,(WIDTH_NOEUD*2)+2, null);
			//g2d.drawImage(img, (int) a, (int) b, 50, 50, null);
			
					
		}
	}


}