package presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.ComponentOrientation;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
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
import java.util.ArrayList;

public class InterfaceGraphique extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel m_cadreGestionSImu;
	private Menu menu;
	private CarteGraphique m_carteGraphique;
	private JPanel m_panneauEdition;

	private JPanel m_outilPanel;
	private JTextField textZoom;
    private static Simulateur m_simulateur;
    private Afficheur m_afficheur;
    private ArrayList<JButton> m_listeEditButtons;

    private ParametrePanel m_parametrePanel;

    private static String ADD_PARAMETRES = "Paramètres de Simulation";
    private static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	private static  String ADD_ARC_STRING = "Ajouter Arc";
	private static  String PUT_VEHICULE = "Placer Vehicule";
	private static String SELECTEUR_SOURIS = "Selectionner/Déplacer";
	public static String SHOW_OUTILS = "Outils";
	private static String SAVE = "SAVE";
	private static String UNDO = "UNDO";
	private static String REDO = "REDO";
	private static String ADD_URGENCE = "Ajouter Urgence";
	private static String PLAY = "Plays";
	private static String PAUSE = " Pause";
	private static String TERMINER = "Terminer";

	private static int WIDTH_ICON = 40;
	private static int HEIGHT_ICON = 40;

	private ImageIcon iconNoeud;
	private ImageIcon iconVehicule;
	private ImageIcon iconSouris;
	private ImageIcon iconSettings;
	private ImageIcon iconArc;

	private ImageIcon iconUrgence;


	private ImageIcon iconPLAYS;
	private ImageIcon iconPAUSE;
	private ImageIcon iconTERMINER;

	public InterfaceGraphique(Simulateur p_simulateur,
			Afficheur p_afficheurGraphique) {
		super("Intervensim");
		m_afficheur = p_afficheurGraphique;
		m_simulateur = p_simulateur;

		ImageIcon iconSave = reqResizedIcon(reqIcon(Default.SAVE_ICON_PATH), 20,20);
		ImageIcon iconUndo = reqResizedIcon(reqIcon(Default.UNDO_ICON_PATH), 20, 20);
		ImageIcon iconRedo = reqResizedIcon(reqIcon(Default.REDO_ICON_PATH), 20, 20);
		ImageIcon iconPlus = reqResizedIcon(reqIcon(Default.PLUS_ICON_PATH), 20, 20);
		ImageIcon iconMoins = reqResizedIcon(reqIcon(Default.MOINS_ICON_PATH), 20, 20);
		iconNoeud = reqIcon(Default.NOEUD_IMAGE_PATH);
		iconArc = reqIcon(Default.ARC_IMAGE_PATH);
		iconVehicule = reqIcon(Default.VEHICULE_IMAGE_PATH);
		iconSouris = reqIcon(Default.SOURIS_ICON_PATH);
		iconSettings = reqIcon(Default.SETTINGS_ICON_PATH);
		iconPAUSE = reqIcon(Default.PAUSE_IMAGE_PATH);
		iconPLAYS = reqIcon(Default.PLAYS_IMAGE_PATH);
		iconTERMINER = reqIcon(Default.TERMINER_IMAGE_PATH);
		iconUrgence = reqIcon(Default.URGENCE_IMAGE_PATH);

		
		m_listeEditButtons = new ArrayList<JButton>();
		
		// AJOUT DES BUTTONS DE LA BARRE D'OUTIL
		
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);
		toolbar.setFloatable(false);
		//toolbar.setBorder(new EmptyBorder(10, 10, 10, 890));
		JButton btnZoomMoins = new JButton(iconMoins);
		
		btnZoomMoins.setActionCommand(Default.ZOOMMOINS);
		btnZoomMoins.addActionListener(this);
	
		
		
		JButton btnZoomPlus = new JButton(iconPlus);
		
		btnZoomPlus.setActionCommand(Default.ZOOMPLUS);
		btnZoomPlus.addActionListener(this);
		
		
		textZoom = new JTextField("100%");

		//textZoom.setPreferredSize(new Dimension(10,10));
		textZoom.setEditable(false);
		//textZoom.setColumns(3);
		
	
		JButton btnSave = new JButton(iconSave);
		btnSave.setToolTipText("Enregistrer travail en cours");
		btnSave.setActionCommand(SAVE);
		
		
		JButton btnUndo = new JButton(iconUndo);
		btnUndo.setToolTipText("Annuler");
		btnUndo.setActionCommand(UNDO);
		
		
		JButton btnRedo = new JButton(iconRedo);
		btnRedo.setToolTipText("Recommencer");
		btnRedo.setActionCommand(REDO);
		
		JButton iconAjoutNoeud =new JButton(reqResizedIcon(iconNoeud, 20, 20));
		iconAjoutNoeud.setToolTipText("Placer des noeuds");
		iconAjoutNoeud.setActionCommand(ADD_NOEUD_STRING);
		//iconAjoutNoeud.setBorderPainted(false);
		//iconAjoutNoeud.setOpaque(false);
		//iconAjoutNoeud.setContentAreaFilled(false);
		
		m_listeEditButtons.add(iconAjoutNoeud);
		
		JButton iconAjoutArc = new JButton(reqResizedIcon(iconArc, 20, 20));
		iconAjoutArc.setToolTipText("Tracer des arcs");
		iconAjoutArc.setActionCommand(ADD_ARC_STRING);
		//iconAjoutArc.setBorderPainted(false);
		//iconAjoutArc.setOpaque(false);
		//iconAjoutArc.setContentAreaFilled(false);
		m_listeEditButtons.add(iconAjoutArc);
		
		JButton iconSelect = new JButton(reqResizedIcon(iconSouris, 20, 20));
		iconSelect.setToolTipText("Modifier et Déplacer des noeuds et des arcs");
		iconSelect.setActionCommand(SELECTEUR_SOURIS);
		//iconSelect.setBorderPainted(false);
		//iconSelect.setOpaque(false);
		//iconSelect.setContentAreaFilled(false);
		m_listeEditButtons.add(iconSelect);
		
		JButton iconAjoutVehicule = new JButton(reqResizedIcon(iconVehicule, 20, 20));
		iconAjoutVehicule.setToolTipText("Placer Véhicule d'urgence sur un port d'attache");
		iconAjoutVehicule.setActionCommand(PUT_VEHICULE);
		//iconAjoutVehicule.setBorderPainted(false);
		//iconAjoutVehicule.setOpaque(false);
		//iconAjoutVehicule.setContentAreaFilled(false);
		m_listeEditButtons.add(iconAjoutVehicule);
		
		JButton iconAddSettings = new JButton(reqResizedIcon(iconSettings, 20, 20));
		iconAddSettings.setToolTipText("Modifier les paramètres de la simulation");
		iconAddSettings.setActionCommand(ADD_PARAMETRES);
		//iconAddSettings.setBorderPainted(false);
		//iconAddSettings.setOpaque(false);
		//iconAddSettings.setContentAreaFilled(false);
		m_listeEditButtons.add(iconAddSettings);
		
		JToggleButton showOutils = new JToggleButton(SHOW_OUTILS);
		
		showOutils.setToolTipText("Afficher le volet Outils");
		showOutils.setFont(new Font("Tahoma", Font.PLAIN, 17));
		showOutils.setActionCommand(SHOW_OUTILS);
		showOutils.addActionListener(this);
		
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnSave);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnUndo);
		toolbar.add(Box.createRigidArea(new Dimension(5,0)));
		toolbar.add(btnRedo);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(iconSelect);
		toolbar.add(Box.createRigidArea(new Dimension(5,0)));
		toolbar.add(iconAjoutNoeud);
		toolbar.add(Box.createRigidArea(new Dimension(5,0)));
		toolbar.add(iconAjoutArc);
		toolbar.add(Box.createRigidArea(new Dimension(5,0)));
		toolbar.add(iconAjoutVehicule);
		toolbar.add(Box.createRigidArea(new Dimension(5,0)));
		toolbar.add(iconAddSettings);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnZoomMoins);
		toolbar.add(textZoom);
		toolbar.add(btnZoomPlus);
		toolbar.add(Box.createRigidArea(new Dimension(500,0)));
		toolbar.add(showOutils);
		toolbar.add(Box.createRigidArea(new Dimension(50,0)));
		for(JButton button: m_listeEditButtons){
			button.addActionListener(this);
		}
		
		getContentPane().add(toolbar, BorderLayout.NORTH);
		
		
		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		m_outilPanel= new JPanel();
		//m_outilPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		m_outilPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		getContentPane().add(m_outilPanel, BorderLayout.EAST);
		m_outilPanel.setVisible(false);
		m_panneauEdition = new JPanel(new GridLayout(5,1,0,5));
		m_panneauEdition.setBorder(new EmptyBorder(50, 0,0,0));
		  // buttons d'ÔøΩdition
	

		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		getContentPane().add(westPanel, BorderLayout.WEST);
		m_panneauEdition = new JPanel(new GridLayout(6, 1, 0, 5));
		
		// buttons d'ÔøΩdition

		JButton ajouterNoeudBouton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterNoeudBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterNoeudBouton.setIcon(iconNoeud);
		ajouterNoeudBouton.setIconTextGap(10);
		ajouterNoeudBouton.setPreferredSize(new Dimension(200, 50));
		ajouterNoeudBouton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudBouton.addActionListener(this);

		// Bouton ajouter arc
		JButton ajouterArcBouton = new JButton(ADD_ARC_STRING);
		ajouterArcBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterArcBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterArcBouton.setIcon(iconArc);
		ajouterArcBouton.setIconTextGap(10);
		ajouterArcBouton.setPreferredSize(new Dimension(200, 50));
		ajouterArcBouton.setActionCommand(ADD_ARC_STRING);
		ajouterArcBouton.addActionListener(this);

		// Bouton selectionner/deplacer
		JButton selectionnerBouton = new JButton(SELECTEUR_SOURIS);
		selectionnerBouton.setHorizontalAlignment(SwingConstants.LEFT);
		selectionnerBouton.setHorizontalTextPosition(SwingConstants.RIGHT);

		selectionnerBouton.setIcon(iconSouris);
		selectionnerBouton.setIconTextGap(10);

		selectionnerBouton.setPreferredSize(new Dimension(200, 50));
		selectionnerBouton.setActionCommand(SELECTEUR_SOURIS);
		selectionnerBouton.addActionListener(this);

		// Placer vehicule bouton
		JButton placerVehiculeBouton = new JButton(PUT_VEHICULE);
		placerVehiculeBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		placerVehiculeBouton.setHorizontalAlignment(SwingConstants.LEFT);

		placerVehiculeBouton.setIcon(iconVehicule);
		placerVehiculeBouton.setIconTextGap(10);
		placerVehiculeBouton.setPreferredSize(new Dimension(200, 50));
		placerVehiculeBouton.setActionCommand(PUT_VEHICULE);
		placerVehiculeBouton.addActionListener(this);

		// ajouter Urgence bouton
		JButton urgenceBouton = new JButton(ADD_URGENCE);
		urgenceBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		urgenceBouton.setHorizontalAlignment(SwingConstants.LEFT);

		urgenceBouton.setIcon(iconUrgence);
		urgenceBouton.setIconTextGap(10);
		urgenceBouton.setPreferredSize(new Dimension(200, 50));
		urgenceBouton.setActionCommand(ADD_URGENCE);
		urgenceBouton.addActionListener(this);

		// Set ParamÔøΩtres button
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
		m_panneauEdition.add(urgenceBouton);
		m_panneauEdition.add(placerVehiculeBouton);
		m_panneauEdition.add(setParametreBouton);

		m_outilPanel.add(m_panneauEdition, BorderLayout.CENTER);
		
		// TODO

		// Placer Bouton play
		JButton placerPlayBouton = new JButton(PLAY);
		placerPlayBouton.setIcon(iconPLAYS);
		placerPlayBouton.setIconTextGap(10);
		placerPlayBouton.setActionCommand(PLAY);
		placerPlayBouton.addActionListener(this);

		// Placer Bouton pause
		JButton boutonPause = new JButton(PAUSE);
		boutonPause.setIcon(iconPAUSE);
		boutonPause.setIconTextGap(10);
		boutonPause.setActionCommand(PAUSE);
		boutonPause.addActionListener(this);

		// Placer Bouton terminer
		JButton boutonterminer = new JButton(TERMINER);
		boutonterminer.setHorizontalTextPosition(SwingConstants.RIGHT);
		boutonterminer.setIcon(iconTERMINER);
		boutonterminer.setIconTextGap(1);

		boutonterminer.setActionCommand(TERMINER);
		boutonterminer.addActionListener(this);

		// bas de l'interfaceGraphique
		JToolBar SouthPanel = new JToolBar();
		SouthPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		getContentPane().add(SouthPanel, BorderLayout.SOUTH);
		m_cadreGestionSImu = new JPanel(new GridLayout(1, 1, 0, 2));

		m_cadreGestionSImu.add(placerPlayBouton);
		m_cadreGestionSImu.add(boutonPause);
		m_cadreGestionSImu.add(boutonterminer);

		// SouthPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		SouthPanel.add(m_cadreGestionSImu, BorderLayout.EAST);
		SouthPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		// TODO


		// Ajout de la carte graphique au centre
		m_carteGraphique = new CarteGraphique(m_afficheur, m_simulateur);

		JScrollPane scroller = new JScrollPane(m_carteGraphique);

		//scroller.setPreferredSize(new Dimension(Default.CARTE_WIDTH, Default.CARTE_HEIGHT));

		getContentPane().add(scroller);

		// Ajout du menu et de la barre des buttons
		menu = new Menu();
		this.setJMenuBar(menu);


		m_parametrePanel = new ParametrePanel(m_simulateur);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public ImageIcon reqIcon(String path) {

		ImageIcon icon = new ImageIcon(
				InterfaceGraphique.class.getResource(path));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(WIDTH_ICON, HEIGHT_ICON,
				Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		return icon;

	}

	public ImageIcon reqResizedIcon(ImageIcon icon, int width, int height){
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}
	
	public void rafraichirCarte() 
	{
		m_carteGraphique.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(ADD_NOEUD_STRING)) {
			m_simulateur.setEtatAjouterNoeud();
		} else if (command.equals(ADD_ARC_STRING)) {
			m_simulateur.setEtatAjouterArc();

		} else if (command.equals(SELECTEUR_SOURIS)) {
			m_simulateur.setEtatSelectioneur();
		} else if (command.equals(PUT_VEHICULE)) {
			m_simulateur.setEtatPlacerVehicule();
		}
		else if(command.equals(ADD_URGENCE))
		{
			m_simulateur.setEtatAjouterUregence();
		}

		else if (command.equals(ADD_PARAMETRES)) {
			int option = JOptionPane.showOptionDialog(this, m_parametrePanel,
					ADD_PARAMETRES, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE, iconSettings, null, null);
			if (option == JOptionPane.OK_OPTION) {
				m_simulateur.asgStrategie(m_parametrePanel.reqStrategie());
				m_simulateur.asgRetourPointAttache(m_parametrePanel
						.isRetourPointAttache());
				m_simulateur
						.asgMetreParStep(m_parametrePanel.reqMetreParStep());
				m_simulateur.asgVitesseVehicule(m_parametrePanel
						.reqVitesseVehicule());
			}

		}
		else if (command.equals(Default.ZOOMPLUS)) 
		{
			textZoom.setText(m_simulateur.augmenteZoom());
			m_carteGraphique.repaint();
			
		}
		else if (command.equals(Default.ZOOMMOINS))
		{
			textZoom.setText(m_simulateur.diminueZoom());
			
			m_carteGraphique.repaint();
			
		}
		else if(command.equals(SHOW_OUTILS)){
			m_outilPanel.setVisible(!m_outilPanel.isVisible());
		}
	}

}
