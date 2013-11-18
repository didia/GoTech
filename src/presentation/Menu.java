package presentation;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;


public class Menu extends JMenuBar 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7636066535711462799L;
	//Menus
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuEdition = new JMenu("Edition");
	private JMenu menuAide = new JMenu("Aide");
	
	//Menu Items
	private JMenuItem itemEnregistrer = new JMenuItem("Enregistrer");
	private JMenuItem itemEnregistrerSous = new JMenuItem("Enregistrer sous");
	private JMenuItem itemAnnuler = new JMenuItem("Annuler");
	private JMenuItem itemRestaurer = new JMenuItem("Restaurer");
	private JMenuItem itemNouveauProjet = new JMenuItem("Nouveau Projet");
	private JMenuItem itemOuvrirProjet = new JMenuItem("Ouvrir Projet");
	private JMenuItem itemGlossaire = new JMenuItem("Glossaire");
	

	//Constructeur
	public Menu() 
	{
		//Set Accelerators
		itemEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemAnnuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		itemRestaurer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		itemOuvrirProjet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		itemNouveauProjet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		//Set Mnemonics
		menuFichier.setMnemonic('F');
		menuEdition.setMnemonic('E');
		
		//Menu Fichier
		this.menuFichier.add(itemNouveauProjet);
		this.menuFichier.add(itemOuvrirProjet);
		this.menuFichier.addSeparator();
		this.menuFichier.add(itemEnregistrer);
		this.menuFichier.add(itemEnregistrerSous);
	
		//Menu Edition
		this.menuEdition.add(itemAnnuler);
		this.menuEdition.add(itemRestaurer);
		
		//Menu Aide
		this.menuAide.add(itemGlossaire);
		
		
		//Ajout au menu
		this.add(menuFichier);
		this.add(menuEdition);
		this.add(menuAide);
	}
}