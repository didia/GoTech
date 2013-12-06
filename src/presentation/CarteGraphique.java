package presentation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.event.MouseInputListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

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




public class CarteGraphique extends JPanel implements MouseInputListener, ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8252994439567196555L;
	private final Afficheur m_afficheur;
	private static Simulateur m_simulateur;
	private JScrollPane viewport;

	private static final String SUPPRIMER_NOEUD = "Supprimer";
	private static final String MODIFIER_POSITION = "modifier";
	

	// Constructeur
	public CarteGraphique(Afficheur afficheurGraphique,
			Simulateur p_simulateur) {
		
		m_simulateur = p_simulateur;
		this.m_afficheur = afficheurGraphique;

		setPreferredSize(new Dimension(Default.CARTE_WIDTH, Default.CARTE_HEIGHT));
		//setBorder(new EmptyBorder(Default.BORDER_SIZE, Default.BORDER_SIZE, Default.BORDER_SIZE, Default.BORDER_SIZE) );

		// setBorder(new EmptyBorder(Default.BORDER_SIZE, Default.BORDER_SIZE,
		// Default.BORDER_SIZE, Default.BORDER_SIZE) );

		setBackground(Color.WHITE);
		setVisible(true);
		setOpaque(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		
		this.viewport = (JScrollPane)getParent();
        JPopupMenu noeudPopup = new JPopupMenu();
		JMenuItem supprimerItem = new JMenuItem("Supprimer");
		JMenuItem modifierPosItem = new JMenuItem("Modifier Position");
		supprimerItem.setActionCommand(SUPPRIMER_NOEUD);
		modifierPosItem.setActionCommand(MODIFIER_POSITION);
		modifierPosItem.addActionListener(this);
		supprimerItem.addActionListener(this);
		
		noeudPopup.add(modifierPosItem);
		noeudPopup.add(supprimerItem);

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


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(SUPPRIMER_NOEUD))
		{
			m_simulateur.supprimer_component();
			 this.repaint();
		}
		//TODO
		if(command.equals(MODIFIER_POSITION)){
			AddMapPanel mapPanel = new AddMapPanel(m_simulateur);
			int option = JOptionPane.showOptionDialog(this, mapPanel, "Spécifier longueur et la largeur du", 
					JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, 
					null, null, null);
			if (option == JOptionPane.OK_OPTION) {
        		
        		
	            m_simulateur.modifierPositionPreciseNoeud(mapPanel.reqLargeurMap(), mapPanel.reqLongueurMap());
	            this.repaint();
        	}
		}
		
		
	}
	
		
}


    		
