package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.event.MouseInputListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import domaine.reseau.Carte;
import domaine.reseau.Carte;
import domaine.simulateur.Default;
import domaine.simulateur.Simulateur;
import presentation.Afficheur;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Vector;

public class CarteGraphique extends JPanel implements MouseInputListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8252994439567196555L;
	private final Afficheur m_afficheur;
	private static Simulateur m_simulateur;
	private JScrollPane viewport;
	private static final String SUPPRIMER_NOEUD = "Supprimer";
		
	// Constructeur
	public CarteGraphique(Afficheur afficheurGraphique,
			Simulateur p_simulateur) {
		m_simulateur = p_simulateur;
		this.m_afficheur = afficheurGraphique;
		final CarteGraphique mycarte = this;
		setPreferredSize(new Dimension(Default.CARTE_WIDTH,
				Default.CARTE_HEIGHT));
		// setBorder(new EmptyBorder(Default.BORDER_SIZE, Default.BORDER_SIZE,
		// Default.BORDER_SIZE, Default.BORDER_SIZE) );
		setBackground(Color.WHITE);
		setVisible(true);
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		this.viewport = (JScrollPane) getParent();
		JPopupMenu noeudPopup = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Supprimer");
		menuItem.setActionCommand(SUPPRIMER_NOEUD);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_simulateur.supprimer_component();
				mycarte.repaint();
			}
		});

		noeudPopup.add(menuItem);
		addPopup(this, noeudPopup);
		ToolTipManager.sharedInstance().registerComponent(this);
	}

	@Override
	public String getToolTipText(MouseEvent event) {
		return m_simulateur.reqPositionDescription(event.getX(), event.getY());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		m_afficheur.afficherReseau(g, m_simulateur, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		m_simulateur.mouseClicked(e);
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		m_simulateur.mouseEntered(e);
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		m_simulateur.mouseExited(e);
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		m_simulateur.mousePressed(e);

		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		m_simulateur.mouseReleased(e);
		this.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		m_simulateur.mouseDragged(e);
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		m_simulateur.mouseMoved(e);
		this.repaint();
	}

	
	private static void addPopup(final Component component, final JPopupMenu popup) {

	component.addMouseListener(new MouseAdapter() {
	public void mousePressed(MouseEvent e) {     
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
				
				
			}


			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
					
				}
				
			}

			private void showMenu(MouseEvent e) {
				if (m_simulateur.existeComponent(e.getX(), e.getY()) == true) {
					popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
			}
		});
	}

	public JScrollPane getViewport() {
		// TODO Auto-generated method stub
		return this.viewport;
	}

}
