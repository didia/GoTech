package presentation;
import javax.swing.*;

import domaine.simulateur.Default;


import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class Menu extends JMenuBar 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7636066535711462799L;
	private final InterfaceGraphique interfacePrincipale;
	//Menus
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuEdition = new JMenu("Edition");
	private JMenu menuStatistique = new JMenu("Statistiques");
	private JMenu menuAide = new JMenu("Aide");
	
	//Menu Items
	private JMenuItem itemEnregistrer = new JMenuItem("Enregistrer");
	private JMenuItem Montrer = new JMenuItem("Montrer");
	private JMenuItem itemEnregistrerSous = new JMenuItem("Enregistrer sous");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	private JMenuItem itemAnnuler = new JMenuItem("Annuler");
	private JMenuItem itemRestaurer = new JMenuItem("Restaurer");
	private JMenuItem itemNouveauProjet = new JMenuItem("Nouveau Projet");
	private JMenuItem itemOuvrirProjet = new JMenuItem("Ouvrir Projet");
	private JMenuItem itemGlossaire = new JMenuItem("Glossaire");
	private JMenuItem itemImporterImage = new JMenuItem("Importer Image");
	private ArrayList<JMenuItem> editMenus = new ArrayList<JMenuItem>();
	

	//Constructeur
	public Menu(InterfaceGraphique interfaceGraphique) 
	{
		this.interfacePrincipale = interfaceGraphique;
		//Set Accelerators
		itemAnnuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		itemAnnuler.addActionListener(this.interfacePrincipale);
		itemAnnuler.setActionCommand(Default.ANNULER);
		
		itemRestaurer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		itemRestaurer.setActionCommand(Default.RESTAURER);
		itemRestaurer.addActionListener(this.interfacePrincipale);
		
		itemEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemEnregistrer.setActionCommand(Default.ENREGISTRER);
		itemEnregistrer.addActionListener(this.interfacePrincipale);
		
		itemEnregistrerSous.setActionCommand(Default.ENREGISTRER_SOUS);
		itemEnregistrerSous.addActionListener(this.interfacePrincipale);
		
		itemOuvrirProjet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		itemOuvrirProjet.setActionCommand(Default.OUVRIR);
		itemOuvrirProjet.addActionListener(this.interfacePrincipale);
		
		itemNouveauProjet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		itemNouveauProjet.setActionCommand(Default.NOUVEAU);
		itemNouveauProjet.addActionListener(this.interfacePrincipale);
		
		itemQuitter.setActionCommand(Default.QUIT);
		itemQuitter.addActionListener(this.interfacePrincipale);
		
		itemImporterImage.setActionCommand(Default.IMPORTER_IMAGE);
		itemImporterImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		itemImporterImage.addActionListener(this.interfacePrincipale);
		//Set Mnemonics
		menuFichier.setMnemonic('F');
		menuEdition.setMnemonic('E');
		
		//Menu Fichier
		this.menuFichier.add(itemNouveauProjet);
		this.menuFichier.add(itemOuvrirProjet);
		this.menuFichier.addSeparator();
		this.menuFichier.add(itemEnregistrer);
		this.menuFichier.add(itemEnregistrerSous);
		this.menuFichier.addSeparator();
		this.menuFichier.add(itemQuitter);
	
		//Menu Edition
		this.menuEdition.add(itemAnnuler);
		this.menuEdition.add(itemRestaurer);
		this.menuEdition.addSeparator();
		this.menuEdition.add(itemImporterImage);
	
		//Menu Statistique
		this.menuStatistique.add(Montrer);
		
		//Menu Aide
		this.menuAide.add(itemGlossaire);
		
		
		
		//Ajout au menu
		this.add(menuFichier);
		this.add(menuEdition);
		this.add(menuStatistique);
		this.add(menuAide);
		
		
		//Ajouter les sous menus d'Ždition
		editMenus.add(itemImporterImage);
		
	}
	public void activateEditsMenus(){
		for(JMenuItem item: editMenus)
		{
			item.setEnabled(true);
		}
	}
	public void deActivateEditsMenus()
	{
		for(JMenuItem item: editMenus)
		{
			item.setEnabled(false);
		}
	}
}