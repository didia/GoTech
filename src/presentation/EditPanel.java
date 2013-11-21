package presentation;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import domainePartie1.Simulateur;
import javax.swing.ImageIcon;

import java.awt.Image;
import javax.swing.SwingConstants;

public class EditPanel extends JPanel implements ActionListener{

	public static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	public static  String ADD_ARC_STRING = "Ajouter Arc";
	public static  String PUT_VEHICULE = "Placer Vehicule";
	public static String SELECTEUR_SOURIS = "Selectionner/Déplacer";
	public static String ADD_PARAMETRES = "Paramètres de Simulation";
	
	public static int WIDTH_ICON = 40;
	public static int HEIGHT_ICON = 40;
	
	private JButton ajouterNoeudBouton;
	private JButton ajouterArcBouton;
	private JButton placerVehiculeBouton;
	private	JButton selectionnerBouton;
	private JButton setParametreBouton;
	
	private static Simulateur m_simulateur;
	
	public EditPanel(Simulateur simulateur)
	{
		m_simulateur = simulateur;
		
		setBorder(new EmptyBorder(100, 10, 10, 10) );
		
		//Bouton ajouter noeud
		ajouterNoeudBouton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudBouton.setPreferredSize(new Dimension(200, 50));
		ajouterNoeudBouton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudBouton.addActionListener(this);
		
		//Bouton ajouter arc
		ajouterArcBouton = new JButton(ADD_ARC_STRING);
		ajouterArcBouton.setPreferredSize(new Dimension(200 ,50));
		ajouterArcBouton.setActionCommand(ADD_ARC_STRING);
		ajouterArcBouton.addActionListener(this);
		
		//Bouton selectionner/deplacer
		selectionnerBouton = new JButton(SELECTEUR_SOURIS );
		selectionnerBouton.setHorizontalAlignment(SwingConstants.LEFT);
		selectionnerBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		ImageIcon icon = new ImageIcon(EditPanel.class.getResource("/images/souris.png"));
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( WIDTH_ICON, HEIGHT_ICON,  Image.SCALE_SMOOTH) ;  
		icon = new ImageIcon( newimg );
		selectionnerBouton.setIcon(icon);
		selectionnerBouton.setIconTextGap(10);
		
		selectionnerBouton.setPreferredSize(new Dimension(200 ,50));
		selectionnerBouton.setActionCommand(SELECTEUR_SOURIS );
		selectionnerBouton.addActionListener(this);
		
		// Bouton selectionner paramètres
		setParametreBouton = new JButton(ADD_PARAMETRES);
		setParametreBouton.setPreferredSize(new Dimension(200, 50));
		setParametreBouton.setActionCommand(ADD_PARAMETRES);
		setParametreBouton.addActionListener(this);
		
		//Placer vehicule bouton
		placerVehiculeBouton = new JButton(PUT_VEHICULE);
		placerVehiculeBouton.setHorizontalTextPosition(SwingConstants.RIGHT);
		placerVehiculeBouton.setHorizontalAlignment(SwingConstants.LEFT);
		icon = new ImageIcon(EditPanel.class.getResource("/images/VehiculeUrgence.png"));
		img = icon.getImage() ; 
		newimg = img.getScaledInstance( WIDTH_ICON, HEIGHT_ICON,  Image.SCALE_SMOOTH) ; 
		icon = new ImageIcon( newimg );
		placerVehiculeBouton.setIcon(icon);
		placerVehiculeBouton.setIconTextGap(10);
		placerVehiculeBouton.setPreferredSize(new Dimension(200,50));
		placerVehiculeBouton.setActionCommand(PUT_VEHICULE);
		placerVehiculeBouton.addActionListener(this);
		
		
		//Panneau d'editions
		JPanel editButtons= new JPanel(new GridLayout(4,1,0,5)); 
		editButtons.add(selectionnerBouton);
		editButtons.add(ajouterNoeudBouton);
		editButtons.add(ajouterArcBouton);
		editButtons.add(placerVehiculeBouton);
		
		add(editButtons, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
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
	}
}
