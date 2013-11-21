package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import domainePartie1.Default;
import domainePartie1.Simulateur;
import java.awt.Dialog.ModalityType;

public class InterfaceGraphique extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarBoutons bar;
	private Menu menu;
	private CarteGraphique m_carteGraphique;
	private JPanel m_panneauEdition;
    private static Simulateur m_simulateur;
    private Afficheur m_afficheur;

    private ParametrePanel m_parametrePanel;
    private JOptionPane m_parametrePane;
  
    public static String ADD_PARAMETRES = "Param�tres de Simulation";
    public static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	public static  String ADD_ARC_STRING = "Ajouter Arc";
	public static  String PUT_VEHICULE = "Placer Vehicule";
	public static String SELECTEUR_SOURIS = "Selectionner/D�placer";
	public static int WIDTH_ICON = 40;
	public static int HEIGHT_ICON = 40;

	public InterfaceGraphique(Simulateur p_simulateur, Afficheur p_afficheurGraphique) 
	{
		super("Intervensim");
		m_afficheur = p_afficheurGraphique;
		m_simulateur = p_simulateur;
		
		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		JPanel westPanel= new JPanel();
		westPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		getContentPane().add(westPanel, BorderLayout.WEST);
		m_panneauEdition = new JPanel(new GridLayout(5,1,0,5));
		  // buttons d'�dition
		JButton ajouterNoeudBouton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudBouton.setPreferredSize(new Dimension(200, 50));
		ajouterNoeudBouton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudBouton.addActionListener(this);

		//Bouton ajouter arc
		JButton ajouterArcBouton = new JButton(ADD_ARC_STRING);
		ajouterArcBouton.setPreferredSize(new Dimension(200 ,50));
		ajouterArcBouton.setActionCommand(ADD_ARC_STRING);
		ajouterArcBouton.addActionListener(this);
		
		//Bouton selectionner/deplacer
		JButton selectionnerBouton = new JButton(SELECTEUR_SOURIS );
		selectionnerBouton.setHorizontalAlignment(SwingConstants.LEFT);
		selectionnerBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ImageIcon icon = new ImageIcon(InterfaceGraphique.class.getResource("/images/souris.png"));
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( WIDTH_ICON, HEIGHT_ICON,  Image.SCALE_SMOOTH) ;  
		icon = new ImageIcon( newimg );
		selectionnerBouton.setIcon(icon);
		selectionnerBouton.setIconTextGap(10);
		
		selectionnerBouton.setPreferredSize(new Dimension(200 ,50));
		selectionnerBouton.setActionCommand(SELECTEUR_SOURIS );
		selectionnerBouton.addActionListener(this);
		
		
		
		//Placer vehicule bouton
		JButton placerVehiculeBouton = new JButton(PUT_VEHICULE);
		placerVehiculeBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		placerVehiculeBouton.setHorizontalAlignment(SwingConstants.LEFT);
		icon = new ImageIcon(InterfaceGraphique.class.getResource("/images/VehiculeUrgence.png"));
		img = icon.getImage() ; 
		newimg = img.getScaledInstance( WIDTH_ICON, HEIGHT_ICON,  Image.SCALE_SMOOTH) ; 
		icon = new ImageIcon( newimg );
		placerVehiculeBouton.setIcon(icon);
		placerVehiculeBouton.setIconTextGap(10);
		placerVehiculeBouton.setPreferredSize(new Dimension(200,50));
		placerVehiculeBouton.setActionCommand(PUT_VEHICULE);
		placerVehiculeBouton.addActionListener(this);
		
		JButton setParametreBouton = new JButton(ADD_PARAMETRES);
		setParametreBouton.setPreferredSize(new Dimension(200, 50));
		setParametreBouton.setActionCommand(ADD_PARAMETRES);
		setParametreBouton.addActionListener(this);
		
		
		m_panneauEdition.add(selectionnerBouton);
		m_panneauEdition.add(ajouterNoeudBouton);
		m_panneauEdition.add(ajouterArcBouton);
		m_panneauEdition.add(placerVehiculeBouton);
		m_panneauEdition.add(setParametreBouton);
		
		westPanel.add(m_panneauEdition, BorderLayout.CENTER);
		
		
		// Ajout de la carte graphique au centre
		m_carteGraphique = new CarteGraphique(m_afficheur, m_simulateur);
		
		JScrollPane scroller = new JScrollPane(m_carteGraphique);
		scroller.setPreferredSize(new Dimension(Default.CARTE_WIDTH, Default.CARTE_HEIGHT));
		getContentPane().add(scroller);
	
		
		
		// Ajout du menu et de la barre des buttons
		menu = new Menu();
		this.setJMenuBar(menu);
		
		bar = new BarBoutons(m_carteGraphique, m_simulateur);
		getContentPane().add(bar, BorderLayout.NORTH);
		
		m_parametrePanel = new ParametrePanel(m_simulateur);
		
		
		// Ajout du Tabbed Pane des param�tres de simulation
		
		//JTabbedPane tabbedPane = new JTabbedPane();
		//JPanel parametrePanel = new ParametrePanel(m_simulateur);
        //tabbedPane.addTab("Param�tres de simulation", null,
                          //parametrePanel,
                         // "Param�tres de simulation"); //tooltip text
       
 
        //getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	
	public void rafraichirCarte() 
	{
		m_carteGraphique.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(ADD_NOEUD_STRING)) 
		{
			m_simulateur.setEtatAjouterNoeud();
		}
		else if (command.equals(ADD_ARC_STRING))
		{
			m_simulateur.setEtatAjouterArc();
			
		}
		else if (command.equals(SELECTEUR_SOURIS))
		{
			m_simulateur.setEtatSelectioneur();
		}
		else if(command.equals(PUT_VEHICULE))
		{
			m_simulateur.setEtatPlacerVehicule();
		}

		else if(command.equals(ADD_PARAMETRES)){
			JOptionPane.showOptionDialog(this, m_parametrePanel, ADD_PARAMETRES,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
		}
	}
		
	}

