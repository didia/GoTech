package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

//import changeable.UndoManagerDemo.UndoablePaintSquare;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import domaine.reseau.Carte;
import domaine.reseau.Carte;
import domaine.reseau.Noeud;
import domaine.simulateur.Default;
import domaine.simulateur.Simulateur;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

;

public class InterfaceGraphique extends JFrame implements ActionListener,
		ChangeListener, WindowListener {

	/**
         * 
         */
	private static final long serialVersionUID = 1L;

	private Timer m_timer;
	private Timer result_timer;

	private static Simulateur m_simulateur;
	private static Carte carteTemp;
	private CarteGraphique m_carteGraphique;// m_carteGraphique
	private Afficheur m_afficheur;
	private ArrayList<JButton> m_listeEditButtons;

	private JPanel m_panneauEdition;
	private JPanel m_outilPanel;
	private StatPanel m_resultPanel;
	private ParametrePanel m_parametrePanel;
	private Menu m_menu;

	private JTextField textZoom;
	private JButton playBouton;
	private JButton iconPlaySim;
	private JButton iconStopSim;
	private JButton iconResetSim;
	protected JButton btnUndo;
	protected JButton btnRedo;
	private JSlider vitesseSim;
	final JFileChooser fc = new JFileChooser();

	private static String ADD_PARAMETRES = "Param�tres de Simulation";
	private static String ADD_NOEUD_STRING = "Ajouter Noeuds";
	private static String ADD_ARC_STRING = "Ajouter Arc";
	private static String RAPID_EDIT_STRING = "Editer rapidement";
	private static String PUT_VEHICULE = "Placer Vehicule";
	private static String CLEAR_ALL = "Effacer le R�seau";
	private static String CLEAR_ALL_URGENCE = "Effacer Toutes les urgences";
	private static String SELECTEUR_SOURIS = "Selectionner/D�placer";
	private static String SHOW_OUTILS = "Outils";
	private static String SHOW_GRILLE = "Grille";

	ImageIcon iconUndo = reqResizedIcon(reqIcon(Default.UNDO_ICON_PATH), 20, 20);
	ImageIcon iconRedo = reqResizedIcon(reqIcon(Default.REDO_ICON_PATH), 20, 20);
	protected static Stack<Carte> listeInstanceCarte = new Stack<Carte>();
	private static Stack<Carte> listeInstanceCarteanterieur = new Stack<Carte>();

	protected UndoManager undoManager = new UndoManager();

	// TODO fin
	private static String UNDO = "UNDO";
	private static String REDO = "REDO";
	private static String ADD_URGENCE = "Ajouter Urgence";
	private static String PLAY = "Lancer simulation";
	private static String RESUME = "Reprendre Simulation";
	private static String PAUSE = " Pause";
	private static String TERMINER = "Terminer";
	private static String RECOMMENCER = "Recommencer Simulation";

	// Taille boutons
	private static int WIDTH_ICON = 40;
	private static int HEIGHT_ICON = 40;

	// Icon pour boutons
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
		// Initialisation
		super("Intervensim");
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		this.setSize(xSize, ySize);
		// TODO
		m_afficheur = p_afficheurGraphique;
		m_simulateur = p_simulateur;
		carteTemp = new Carte(m_simulateur.reqCarte());

		//
		// System.out.println(m_simulateur.reqCarte()
		// .reqListeNoeuds().size());
		// System.out.println(listeInstanceCarte.element().reqListeNoeuds().size());
		//
		//
		ImageIcon iconSave = reqResizedIcon(reqIcon(Default.SAVE_ICON_PATH),
				20, 20);
		ImageIcon iconUndo = reqResizedIcon(reqIcon(Default.UNDO_ICON_PATH),
				20, 20);
		ImageIcon iconRedo = reqResizedIcon(reqIcon(Default.REDO_ICON_PATH),
				20, 20);
		ImageIcon iconPlus = reqResizedIcon(reqIcon(Default.PLUS_ICON_PATH),
				20, 20);
		ImageIcon iconMoins = reqResizedIcon(reqIcon(Default.MOINS_ICON_PATH),
				20, 20);
		ImageIcon iconGrille = reqResizedIcon(
				reqIcon(Default.GRILLE_ICON_PATH), 20, 20);
		ImageIcon iconRapide = reqResizedIcon(
				reqIcon(Default.ERAPIDE_IMAGE_PATH), 20, 20);
		ImageIcon iconRESET = reqResizedIcon(reqIcon(Default.RESET_IMAGE_PATH),
				20, 20);
		ImageIcon iconCLEAR = reqResizedIcon(reqIcon(Default.CLEAR_ICON_PATH),
				20, 20);
		ImageIcon iconCLEAR_URGENCE = reqResizedIcon(
				reqIcon(Default.CLEAR_URGENCE_ICON_PATH), 20, 20);
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
		// toolbar.setBorder(new EmptyBorder(10, 10, 10, 890));
		JButton btnZoomMoins = new JButton(iconMoins);

		btnZoomMoins.setActionCommand(Default.ZOOMMOINS);
		btnZoomMoins.addActionListener(this);

		JButton btnZoomPlus = new JButton(iconPlus);

		btnZoomPlus.setActionCommand(Default.ZOOMPLUS);
		btnZoomPlus.addActionListener(this);

		textZoom = new JTextField("100%");

		textZoom.setPreferredSize(new Dimension(50, 10));
		textZoom.setMinimumSize(new Dimension(50, 10));
		textZoom.setEditable(false);

		JButton btnSave = new JButton(iconSave);
		btnSave.setToolTipText("Enregistrer travail en cours");
		btnSave.setActionCommand(Default.ENREGISTRER);
		btnSave.addActionListener(this);

		btnUndo = new JButton(iconUndo);// TODO
		btnUndo.setToolTipText("Annuler");
		btnUndo.setActionCommand(Default.ANNULER);
		btnUndo.addActionListener(this);
		m_listeEditButtons.add(btnUndo);
		btnUndo.setEnabled(false);

		btnRedo = new JButton(iconRedo);
		btnRedo.setToolTipText("Recommencer");
		btnRedo.setActionCommand(Default.RESTAURER);
		btnRedo.addActionListener(this);
		m_listeEditButtons.add(btnRedo);
		btnRedo.setEnabled(false);

		JButton iconAjoutNoeud = new JButton(reqResizedIcon(iconNoeud, 20, 20));
		iconAjoutNoeud.setToolTipText("Placer des noeuds");
		iconAjoutNoeud.setActionCommand(ADD_NOEUD_STRING);
		iconAjoutNoeud.addActionListener(this);
		m_listeEditButtons.add(iconAjoutNoeud);

		JButton iconAjoutArc = new JButton(reqResizedIcon(iconArc, 20, 20));
		iconAjoutArc.setToolTipText("Tracer des arcs");
		iconAjoutArc.setActionCommand(ADD_ARC_STRING);
		iconAjoutArc.addActionListener(this);
		m_listeEditButtons.add(iconAjoutArc);

		JButton iconERapid = new JButton(iconRapide);
		iconERapid.setToolTipText("Edition rapide");
		iconERapid.setActionCommand(RAPID_EDIT_STRING);
		iconERapid.addActionListener(this);
		m_listeEditButtons.add(iconERapid);

		JButton iconSelect = new JButton(reqResizedIcon(iconSouris, 20, 20));
		iconSelect
				.setToolTipText("Modifier et D�placer des noeuds et des arcs");
		iconSelect.setActionCommand(SELECTEUR_SOURIS);
		iconSelect.addActionListener(this);
		m_listeEditButtons.add(iconSelect);

		JButton iconClear = new JButton(iconCLEAR);
		iconClear.setToolTipText("Effacer Tout");
		iconClear.setActionCommand(CLEAR_ALL);
		iconClear.addActionListener(this);
		m_listeEditButtons.add(iconClear);

		JButton iconClearUrgence = new JButton(iconCLEAR_URGENCE);
		iconClearUrgence.setToolTipText("Effacer Toutes les urgences");
		iconClearUrgence.setActionCommand(CLEAR_ALL_URGENCE);
		iconClearUrgence.addActionListener(this);
		m_listeEditButtons.add(iconClearUrgence);

		JButton iconAjoutVehicule = new JButton(reqResizedIcon(iconVehicule,
				20, 20));
		iconAjoutVehicule
				.setToolTipText("Placer V�hicule d'urgence sur un port d'attache");
		iconAjoutVehicule.setActionCommand(PUT_VEHICULE);
		iconAjoutVehicule.addActionListener(this);
		m_listeEditButtons.add(iconAjoutVehicule);

		JButton iconAddSettings = new JButton(reqResizedIcon(iconSettings, 20,
				20));
		iconAddSettings
				.setToolTipText("Modifier les param�tres de la simulation");
		iconAddSettings.setActionCommand(ADD_PARAMETRES);
		iconAddSettings.addActionListener(this);
		m_listeEditButtons.add(iconAddSettings);

		JToggleButton showOutils = new JToggleButton(SHOW_OUTILS);
		showOutils.setToolTipText("Afficher le volet Outils");
		showOutils.setFont(new Font("Tahoma", Font.PLAIN, 17));
		showOutils.setActionCommand(SHOW_OUTILS);
		showOutils.addActionListener(this);

		JToggleButton showGrille = new JToggleButton(iconGrille);
		showGrille.setToolTipText("Afficher la grille");
		showGrille.setActionCommand(SHOW_GRILLE);
		showGrille.addActionListener(this);
		showGrille.setSelected(true);
		iconPlaySim = new JButton(reqResizedIcon(iconPLAYS, 20, 20));
		iconPlaySim.setPressedIcon(reqResizedIcon(iconPAUSE, 20, 20));
		iconPlaySim.setToolTipText("Lancer la simulation");
		iconPlaySim.setActionCommand(PLAY);
		iconPlaySim.addActionListener(this);

		iconResetSim = new JButton(reqResizedIcon(iconRESET, 20, 20));
		iconResetSim.setPressedIcon(reqResizedIcon(iconRESET, 20, 20));
		iconResetSim.setEnabled(false);
		iconResetSim.setToolTipText("Recommencer la simulation");
		iconResetSim.setActionCommand(RECOMMENCER);
		iconResetSim.addActionListener(this);

		iconStopSim = new JButton(reqResizedIcon(iconTERMINER, 20, 20));
		iconStopSim.setPressedIcon(reqResizedIcon(iconTERMINER, 20, 20));
		iconStopSim.setEnabled(false);
		iconStopSim.setToolTipText("Terminer la simulation");
		iconStopSim.setActionCommand(TERMINER);
		iconStopSim.addActionListener(this);

		JButton iconAjoutUrgence = new JButton(reqResizedIcon(iconUrgence, 20,
				20));
		iconAjoutUrgence.setToolTipText("Ajouter des urgences");
		iconAjoutUrgence.setActionCommand(ADD_URGENCE);
		iconAjoutUrgence.addActionListener(this);

		vitesseSim = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
		vitesseSim.addChangeListener(this);

		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnSave);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnUndo);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(btnRedo);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(iconSelect);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconAjoutNoeud);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconAjoutArc);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconERapid);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconClear);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(iconAjoutUrgence);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconClearUrgence);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconAjoutVehicule);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconAddSettings);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(iconPlaySim);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(vitesseSim);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconResetSim);
		toolbar.add(Box.createRigidArea(new Dimension(5, 0)));
		toolbar.add(iconStopSim);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(btnZoomMoins);
		toolbar.add(textZoom);
		toolbar.add(btnZoomPlus);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		toolbar.add(showGrille);
		toolbar.add(new JSeparator(SwingConstants.VERTICAL));
		// toolbar.add(Box.createRigidArea(new Dimension(500,0)));
		toolbar.add(showOutils, BorderLayout.EAST);
		toolbar.add(Box.createRigidArea(new Dimension(100, 0)));

		getContentPane().add(toolbar, BorderLayout.NORTH);

		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		m_resultPanel = new StatPanel(m_simulateur);
		// m_outilPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		m_resultPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
				Color.BLACK));
		getContentPane().add(m_resultPanel, BorderLayout.WEST);
		m_resultPanel.setVisible(false);

		// DROITE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		m_outilPanel = new JPanel();
		// m_outilPanel.setBorder(new EmptyBorder(100, 10, 10, 10));
		m_outilPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
				Color.BLACK));
		getContentPane().add(m_outilPanel, BorderLayout.EAST);
		m_outilPanel.setVisible(false);
		m_panneauEdition = new JPanel(new GridLayout(5, 1, 0, 5));
		m_panneauEdition.setBorder(new EmptyBorder(50, 0, 0, 0));
		// buttons d'�dition

		// GAUCHE DE L'INTERFACE GRAPHIQUE, BUTTONS D'EDITION
		m_panneauEdition = new JPanel(new GridLayout(7, 1, 0, 5));

		// buttons d'�dition
		JButton ajouterNoeudBouton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterNoeudBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterNoeudBouton.setIcon(iconNoeud);
		ajouterNoeudBouton.setIconTextGap(10);
		ajouterNoeudBouton.setPreferredSize(new Dimension(200, 50));
		ajouterNoeudBouton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudBouton.addActionListener(this);
		m_listeEditButtons.add(ajouterNoeudBouton);

		// Bouton ajouter arc
		JButton ajouterArcBouton = new JButton(ADD_ARC_STRING);
		ajouterArcBouton.setHorizontalAlignment(SwingConstants.LEFT);
		ajouterArcBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ajouterArcBouton.setIcon(iconArc);
		ajouterArcBouton.setIconTextGap(10);
		ajouterArcBouton.setPreferredSize(new Dimension(200, 50));
		ajouterArcBouton.setActionCommand(ADD_ARC_STRING);
		ajouterArcBouton.addActionListener(this);
		m_listeEditButtons.add(ajouterArcBouton);

		// Bouton selectionner/deplacer
		JButton selectionnerBouton = new JButton(SELECTEUR_SOURIS);
		selectionnerBouton.setHorizontalAlignment(SwingConstants.LEFT);
		selectionnerBouton.setHorizontalTextPosition(SwingConstants.RIGHT);

		selectionnerBouton.setIcon(iconSouris);
		selectionnerBouton.setIconTextGap(10);

		selectionnerBouton.setPreferredSize(new Dimension(200, 50));
		selectionnerBouton.setActionCommand(SELECTEUR_SOURIS);
		selectionnerBouton.addActionListener(this);
		m_listeEditButtons.add(selectionnerBouton);
		// Placer vehicule bouton
		JButton placerVehiculeBouton = new JButton(PUT_VEHICULE);
		placerVehiculeBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		placerVehiculeBouton.setHorizontalAlignment(SwingConstants.LEFT);

		placerVehiculeBouton.setIcon(iconVehicule);
		placerVehiculeBouton.setIconTextGap(10);
		placerVehiculeBouton.setPreferredSize(new Dimension(200, 50));
		placerVehiculeBouton.setActionCommand(PUT_VEHICULE);
		placerVehiculeBouton.addActionListener(this);
		m_listeEditButtons.add(placerVehiculeBouton);
		// ajouter Urgence bouton
		JButton urgenceBouton = new JButton(ADD_URGENCE);
		urgenceBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		urgenceBouton.setHorizontalAlignment(SwingConstants.LEFT);

		urgenceBouton.setIcon(iconUrgence);
		urgenceBouton.setIconTextGap(10);
		urgenceBouton.setPreferredSize(new Dimension(200, 50));
		urgenceBouton.setActionCommand(ADD_URGENCE);
		urgenceBouton.addActionListener(this);

		// Set Param�tres button
		JButton setParametreBouton = new JButton(ADD_PARAMETRES);
		setParametreBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		setParametreBouton.setHorizontalAlignment(SwingConstants.LEFT);

		setParametreBouton.setIcon(iconSettings);
		setParametreBouton.setIconTextGap(10);
		setParametreBouton.setPreferredSize(new Dimension(200, 50));
		setParametreBouton.setActionCommand(ADD_PARAMETRES);
		setParametreBouton.addActionListener(this);
		m_listeEditButtons.add(setParametreBouton);

		playBouton = new JButton(PLAY);
		playBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		playBouton.setHorizontalAlignment(SwingConstants.LEFT);
		playBouton.setIcon(iconPLAYS);
		playBouton.setIconTextGap(10);
		playBouton.setPreferredSize(new Dimension(200, 50));
		playBouton.setActionCommand(PLAY);
		playBouton.addActionListener(this);

		JButton resultButton = new JButton("Afficher les resultats");
		resultButton.setPreferredSize(new Dimension(200, 50));
		resultButton.setActionCommand("SHOW");
		resultButton.addActionListener(this);

		m_panneauEdition.add(selectionnerBouton);
		m_panneauEdition.add(ajouterNoeudBouton);
		m_panneauEdition.add(ajouterArcBouton);
		m_panneauEdition.add(urgenceBouton);
		m_panneauEdition.add(placerVehiculeBouton);
		m_panneauEdition.add(setParametreBouton);
		m_panneauEdition.add(playBouton);

		m_outilPanel.add(m_panneauEdition, BorderLayout.CENTER);

		// Ajout de la carte graphique au centre

		m_carteGraphique = new CarteGraphique(m_afficheur, m_simulateur);

		JScrollPane scroller = new JScrollPane(m_carteGraphique);

		// scroller.setPreferredSize(new Dimension(Default.CARTE_WIDTH,
		// Default.CARTE_HEIGHT));

		getContentPane().add(scroller);

		m_carteGraphique.addMouseListener(new MouseAdapter() {// TODO
					public void mousePressed(MouseEvent e) {
						if (!carteTemp.equals(m_simulateur.reqCarte())) {
							System.out
									.println("la carte est identique a la precendante");

							listeInstanceCarte.add(carteTemp);

							undoManager
									.undoableEditHappened(new UndoableEditEvent(
											m_carteGraphique,
											new UndoableAffiche(m_simulateur
													.reqCarte(),
													listeInstanceCarte)));

							btnUndo.setEnabled(undoManager.canUndo());
							btnRedo.setEnabled(undoManager.canRedo());
							carteTemp = new Carte(m_simulateur.reqCarte());
						}
					}

				});

		// Ajout du menu et de la barre des buttons
		m_menu = new Menu(this);
		this.setJMenuBar(m_menu);

		m_parametrePanel = new ParametrePanel(m_simulateur);

		// REACTION TO ESCAPE KEY
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("ESCAPE"), "myAction");
		getRootPane().getActionMap().put("myAction", new AbstractAction() {

			private static final long serialVersionUID = 2539830789858791855L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				m_simulateur.cancelState();
				m_carteGraphique.repaint();

			}
		});
		// Ajout du Timer
		m_timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_simulateur.deplacerVehiculeUrgence(50);
				m_carteGraphique.repaint();

			}
		});

		result_timer = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				m_resultPanel.afficherResultat();

			}
		});

		pack();
		
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

	public ImageIcon reqResizedIcon(ImageIcon icon, int width, int height) {
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	public void rafraichirCarte() {
		m_carteGraphique.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(ADD_NOEUD_STRING)) {
			m_simulateur.setEtatAjouterNoeud();

		} else if (command.equals(ADD_ARC_STRING)) {
			m_simulateur.setEtatAjouterArc();
		} else if (command.equals(RAPID_EDIT_STRING)) {
			m_simulateur.setEtatEditionRapide();
		} else if (command.equals(SELECTEUR_SOURIS)) {
			m_simulateur.setEtatSelectioneur();
		} else if (command.equals(PUT_VEHICULE)) {
			m_simulateur.setEtatPlacerVehicule();
			btnUndo.setEnabled(false);
			btnRedo.setEnabled(false);
		} else if (command.equals(ADD_URGENCE)) {
			m_simulateur.setEtatAjouterUregence();
			btnUndo.setEnabled(false);
			btnRedo.setEnabled(false);
		} else if (command.equals(CLEAR_ALL)){
			int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment tout effacer?");
			if(option == JOptionPane.YES_OPTION)
			{
				m_simulateur.effacerToutReseau();
				m_carteGraphique.repaint();
			}
		}else if (command.equals(CLEAR_ALL_URGENCE)){
			int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment effacer toutes les urgences?");
			if(option == JOptionPane.YES_OPTION)
			{
				m_simulateur.effacerToutesLesUrgences();
				m_carteGraphique.repaint();
			}
		}else if (command.equals(ADD_PARAMETRES)) {
		
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
				m_simulateur.asgTempsTraitement(m_parametrePanel
						.reqTempsTraitement());
				m_simulateur
						.asgEchelleTemps(m_parametrePanel.reqEchelleTemps());
			}
		} else if (command.equals(Default.ZOOMPLUS)) {
			textZoom.setText(m_simulateur.augmenteZoom());
			m_carteGraphique.repaint();
		} else if (command.equals(Default.ZOOMMOINS)) {
			textZoom.setText(m_simulateur.diminueZoom());

			m_carteGraphique.repaint();
		} else if (command.equals(SHOW_OUTILS)) {
			m_outilPanel.setVisible(!m_outilPanel.isVisible());
		} else if (command.equals(SHOW_GRILLE)) {
			m_simulateur.toggleGrille();
			m_carteGraphique.repaint();
		} else if (command.equals("SHOW")) {
			JOptionPane.showMessageDialog(this, m_simulateur.reqResults());
		} else if (command.equals(PLAY)) {
			m_timer.start();
			result_timer.start();
			m_resultPanel.setVisible(true);
			for (JButton button : this.m_listeEditButtons) {
				button.setEnabled(false);
			}
			m_menu.deActivateEditsMenus();
			this.buttonToPlay();
			this.iconStopSim.setEnabled(true);
			this.iconResetSim.setEnabled(true);

			m_simulateur.lancerSimulation();
		} else if (command.equals(RESUME)) {
			m_timer.start();
			this.playBouton.setIcon(iconPAUSE);
			this.playBouton.setPressedIcon(iconPLAYS);
			this.playBouton.setActionCommand(PAUSE);
			this.iconPlaySim.setIcon(reqResizedIcon(iconPAUSE, 20, 20));
			this.iconPlaySim.setPressedIcon(reqResizedIcon(iconPLAYS, 20, 20));
			this.iconPlaySim.setActionCommand(PAUSE);
		} else if (command.equals(PAUSE)) {
			m_timer.stop();
			this.buttonToPause();
		}else if(command.equals(RECOMMENCER)){
			m_simulateur.restartSimulation();
		}else if (command.equals(TERMINER)) {
		
			m_timer.stop();
			result_timer.stop();

			for (JButton button : this.m_listeEditButtons) {
				button.setEnabled(true);
			}
			m_menu.activateEditsMenus();
			this.playBouton.setPressedIcon(iconPAUSE);
			this.playBouton.setIcon(iconPLAYS);
			this.playBouton.setActionCommand(PLAY);
			this.iconPlaySim.setPressedIcon(reqResizedIcon(iconPAUSE, 20, 20));
			this.iconPlaySim.setIcon(reqResizedIcon(iconPLAYS, 20, 20));
			this.iconPlaySim.setActionCommand(PLAY);
			this.iconStopSim.setEnabled(false);
			this.iconResetSim.setEnabled(false);
			this.btnRedo.setEnabled(false);
			this.btnUndo.setEnabled(false);
			
			m_simulateur.terminerSimulation();
			JOptionPane.showOptionDialog(this, m_resultPanel,
					"Resultats de la Simulation", JOptionPane.OK_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, null, null);
			
			m_carteGraphique.repaint();

		}

		 else if(command.equals(Default.ENREGISTRER))
		  {
			  if(m_simulateur.existeFile()){
				  m_simulateur.enregistrer();
			  }
			  else
			  {
				  enregistrerSous();
			  }
		  }
		else if(command.equals(Default.NOUVEAU))
		{
				
				  if(m_simulateur.hasChangeHappened())
				  {
					  int option = JOptionPane.showConfirmDialog(this, "Voulez-vous enregistrere les modifications?");
						if(option == JOptionPane.YES_OPTION)
						{
							
							if(m_simulateur.existeFile()){
								  m_simulateur.enregistrer();
							  }
							  else
							  {
								  enregistrerSous();
							  }
						}
				  }
					  
				  m_simulateur.resetAll();;
				  
				  if(m_simulateur.isEnSimulation())
				  {
					  m_resultPanel.setVisible(true);
						for (JButton button : this.m_listeEditButtons) {
							button.setEnabled(false);
						}
						m_menu.deActivateEditsMenus();
						
						this.iconStopSim.setEnabled(true);
						this.iconResetSim.setEnabled(true);
						this.buttonToPause();
				  }
				  m_carteGraphique.repaint();
		  }else if(command.equals(Default.ENREGISTRER_SOUS))
		  {
			  enregistrerSous();
		  }
		 
		else if(command.equals(Default.OUVRIR))
				{
			  JFileChooser fileChooser = new JFileChooser();
			  int returnVal = fileChooser.showOpenDialog(this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  m_simulateur.loader(file);
				  if(m_simulateur.isEnSimulation())
				  {
					  m_resultPanel.setVisible(true);
						for (JButton button : this.m_listeEditButtons) {
							button.setEnabled(false);
						}
						m_menu.deActivateEditsMenus();
						
						this.iconStopSim.setEnabled(true);
						this.iconResetSim.setEnabled(true);
						this.buttonToPause();
				  }
				  m_carteGraphique.repaint();
		  }
				}
		
		else if (command.equals(Default.IMPORTER_IMAGE)) {
			int returnVal = fc.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String km = JOptionPane.showInputDialog(this, "À combien de Km correspond le plus long coté de votre carte dans la vie réelle?");
				if(km != null)
				{
					
				
					File file = fc.getSelectedFile();
					m_simulateur.initialiseMap(file, Float.parseFloat(km));
					
					m_carteGraphique.repaint();
				}

			}
		}
		else if(command.equals(Default.ANNULER))
		{
			annuler();
		}
		else if(command.equals(Default.RESTAURER))
		{
			restaurer();
		}
		else if (command.equals(Default.QUIT)) 
		{
			quitter();
		
		}
	}

	public void buttonToPlay() {
		this.playBouton.setIcon(iconPAUSE);
		this.playBouton.setPressedIcon(iconPLAYS);
		this.playBouton.setActionCommand(PAUSE);
		this.iconPlaySim.setIcon(reqResizedIcon(iconPAUSE, 20, 20));
		this.iconPlaySim.setPressedIcon(reqResizedIcon(iconPLAYS, 20, 20));
		this.iconPlaySim.setActionCommand(PAUSE);

	}

	public void enregistrerSous() {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			m_simulateur.enregistrer(file);
		}
	}
	
	public void enregistrer()
	{
		 if(m_simulateur.existeFile()){
			  m_simulateur.enregistrer();
		  }
		  else
		  {
			  enregistrerSous();
		  }
	}

	public void buttonToPause() {
		this.playBouton.setIcon(iconPLAYS);
		this.playBouton.setPressedIcon(iconPAUSE);
		this.playBouton.setActionCommand(RESUME);
		this.iconPlaySim.setIcon(reqResizedIcon(iconPLAYS, 20, 20));
		this.iconPlaySim.setPressedIcon(reqResizedIcon(iconPAUSE, 20, 20));

		this.iconPlaySim.setActionCommand(RESUME);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		m_simulateur.ajusteVitesseSimulation((int) source.getValue());

	}

	public void annuler() {

		if (!listeInstanceCarte.isEmpty()) {
			try {

				undoManager.undo();

				if (listeInstanceCarteanterieur.size() <= 5)
					listeInstanceCarteanterieur.add(listeInstanceCarte.peek());

				m_simulateur.asgCarte(listeInstanceCarte.pop());
				m_simulateur.cancelState();

			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			m_carteGraphique.repaint();
			btnUndo.setEnabled(undoManager.canUndo());
			btnRedo.setEnabled(undoManager.canRedo());
		}
	}
	
	public void quitter() {
		if(m_simulateur.hasChangeHappened())
		{
			int option = JOptionPane.showConfirmDialog(this, "Voulez-vous enregistrere les modifications?");
			if(option == JOptionPane.YES_OPTION)
			{
				enregistrer();
			}
			else if(option == JOptionPane.NO_OPTION)
			{
				this.dispose();
			}
			
				
		}
		else
		{
			this.dispose();
		}
		
	
	}
	public void restaurer() {
		if (!listeInstanceCarteanterieur.isEmpty()) {

			try {
				undoManager.redo();

				m_simulateur.asgCarte(listeInstanceCarteanterieur.peek());
				listeInstanceCarte.add(listeInstanceCarteanterieur.pop());
				m_simulateur.cancelState();

			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			m_carteGraphique.repaint();
			btnUndo.setEnabled(undoManager.canUndo());
			btnRedo.setEnabled(undoManager.canRedo());
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		quitter();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}