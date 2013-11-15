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

public class EditPanel extends JPanel implements ActionListener{

	public static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	public static  String ADD_ARC_STRING = "Ajouter Arc";
	public static  String PUT_VEHICULE = "Placer Vehicule d'urgence";
	
	private  JButton ajouterNoeudButton;
	private  JButton ajouterArcButton;
	private  JButton placerVehiculeButton;
	
	private static Simulateur m_simulateur;
	
	public EditPanel(Simulateur simulateur){
		
		m_simulateur = simulateur;
		
		setBorder(new EmptyBorder(150, 10, 10, 10) );
		
		JButton ajouterNoeudButton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudButton.setPreferredSize(new Dimension(200, 50));
		
		ajouterNoeudButton.setActionCommand(ADD_NOEUD_STRING);
		ajouterNoeudButton.addActionListener(this);
		
		JButton ajouterArcButton = new JButton(ADD_ARC_STRING);
		ajouterArcButton.setPreferredSize(new Dimension(200 ,50));
		ajouterArcButton.setActionCommand(ADD_ARC_STRING);
		ajouterArcButton.addActionListener(this);
		
		JButton placerVehiculeButton = new JButton(PUT_VEHICULE);
		placerVehiculeButton.setPreferredSize(new Dimension(200,50));
		placerVehiculeButton.setActionCommand(PUT_VEHICULE);
		placerVehiculeButton.addActionListener(this);
		
		JPanel editButtons= new JPanel(new GridLayout(3,1,0,5)); 
		editButtons.add(ajouterNoeudButton);
		editButtons.add(ajouterArcButton);
		editButtons.add(placerVehiculeButton);
		add(editButtons, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(ADD_NOEUD_STRING)) {
			m_simulateur.setEtatAjouterNoeud();
		}
		else if(command.equals(ADD_ARC_STRING)){
			m_simulateur.setEtatAjouterArc();
			
		}
		else if(command.equals(PUT_VEHICULE)){
			
		}
	}
		

}
