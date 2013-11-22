package presentation;

import javax.imageio.ImageIO;
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
import java.io.File;
import java.io.IOException;

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
  
    private static String ADD_PARAMETRES = "Paramètres de Simulation";
    private static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	private static  String ADD_ARC_STRING = "Ajouter Arc";
	private static  String PUT_VEHICULE = "Placer Vehicule";
	private static String SELECTEUR_SOURIS = "Selectionner/Déplacer";
	private static int WIDTH_ICON = 40;
	private static int HEIGHT_ICON = 40;
	
	private ImageIcon iconNoeud;
	private ImageIcon iconVehicule;
	private ImageIcon iconSouris;
	private ImageIcon iconSettings;
	private ImageIcon iconArc;
	

	public InterfaceGraphique(Simulateur p_simulateur, Afficheur p_afficheurGraphique) 
	{
		super("Intervensim");
		m_afficheur = p_afficheurGraphique;
		m_simulateur = p_simulateur;
		
		iconNoeud = reqIcon(Default.NOEUD_IMAGE_PATH);
		iconArc = reqIcon(Default.ARC_IMAGE_PATH);
		iconVehicule = reqIcon(Default.VEHICULE_IMAGE_PATH);
		iconSouris = reqIcon(Default.SOURIS_ICON_PATH);
		iconSettings = reqIcon(Default.SETTINGS_ICON_PATH);
		
		
		
		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		JPanel westPanel= new JPanel();
		westPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		getContentPane().add(westPanel, BorderLayout.WEST);
		m_panneauEdition = new JPanel(new GridLayout(5,1,0,5));
		  // buttons d'ÔøΩdition
		JButton ajouterNoeudBouton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterNoeudBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterNoeudBouton.setIcon(iconNoeud);
		ajouterNoeudBouton.setIconTextGap(10);
		ajouterNoeudBouton.setPreferredSize(new Dimension(200, 50));
		ajouterNoeudBouton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudBouton.addActionListener(this);

		//Bouton ajouter arc
		JButton ajouterArcBouton = new JButton(ADD_ARC_STRING);
		ajouterArcBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterArcBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterArcBouton.setIcon(iconArc);
		ajouterArcBouton.setIconTextGap(10);
		ajouterArcBouton.setPreferredSize(new Dimension(200 ,50));
		ajouterArcBouton.setActionCommand(ADD_ARC_STRING);
		ajouterArcBouton.addActionListener(this);
		
		//Bouton selectionner/deplacer
		JButton selectionnerBouton = new JButton(SELECTEUR_SOURIS );
		selectionnerBouton.setHorizontalAlignment(SwingConstants.LEFT);
		selectionnerBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		selectionnerBouton.setIcon(iconSouris);
		selectionnerBouton.setIconTextGap(10);
		
		selectionnerBouton.setPreferredSize(new Dimension(200 ,50));
		selectionnerBouton.setActionCommand(SELECTEUR_SOURIS );
		selectionnerBouton.addActionListener(this);
		
		
		
		//Placer vehicule bouton
		JButton placerVehiculeBouton = new JButton(PUT_VEHICULE);
		placerVehiculeBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		placerVehiculeBouton.setHorizontalAlignment(SwingConstants.LEFT);
		
		placerVehiculeBouton.setIcon(iconVehicule);
		placerVehiculeBouton.setIconTextGap(10);
		placerVehiculeBouton.setPreferredSize(new Dimension(200,50));
		placerVehiculeBouton.setActionCommand(PUT_VEHICULE);
		placerVehiculeBouton.addActionListener(this);
		
		// Set Paramètres button
		JButton setParametreBouton = new JButton(ADD_PARAMETRES);
		setParametreBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		setParametreBouton.setHorizontalAlignment(SwingConstants.LEFT);
		
		setParametreBouton.setIcon(iconSettings);
		setParametreBouton.setIconTextGap(10);
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
		
		

        
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public ImageIcon reqIcon(String path){
		
			ImageIcon icon = new ImageIcon(InterfaceGraphique.class.getResource(path));
			Image img = icon.getImage() ; 
			Image newimg = img.getScaledInstance( WIDTH_ICON, HEIGHT_ICON,  Image.SCALE_SMOOTH) ; 
			icon = new ImageIcon( newimg );
			return icon;
		
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
			int option = JOptionPane.showOptionDialog(this, m_parametrePanel, ADD_PARAMETRES,
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, iconSettings, null, null);
			if(option == JOptionPane.OK_OPTION){
				m_simulateur.asgStrategie(m_parametrePanel.reqStrategie());
				m_simulateur.asgRetourPointAttache(m_parametrePanel.isRetourPointAttache());
				m_simulateur.asgMetreParStep(m_parametrePanel.reqMetreParStep());
				m_simulateur.asgVitesseVehicule(m_parametrePanel.reqVitesseVehicule());
			}
			
		}
	}
		
	}

