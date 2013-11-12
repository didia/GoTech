package presentation;

import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;

import domainePartie1.Noeud;

public class NoeudGraphique extends JComponent {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -6704414755192970679L;
	private Noeud m_noeud ;
	private Image m_image;
	public NoeudGraphique(Noeud noeud, Image image) {
		super();
		m_noeud = noeud;
		m_image = image;
	}
    
	@Override
	public void paintComponent(Graphics g) {
	    g.drawImage(m_image, 0, 0, null);
	  }
}
