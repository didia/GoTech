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

public class EditPanel extends JPanel implements ActionListener{

	public static  String ADD_NOEUD_STRING = "Ajouter Noeuds";
	public static  String ADD_ARC_STRING = "Ajouter Arc";
	public static  String PUT_VEHICULE = "Placer Vehicule d'urgence";
	
	private  JButton ajouterNoeudButton;
	private  JButton ajouterArcButton;
	private  JButton placerVehiculeButton;
	
	public EditPanel(){
		
		
		setBorder(new EmptyBorder(150, 10, 10, 10) );
		
		JButton ajouterNoeudButton = new JButton(ADD_NOEUD_STRING);
		ajouterNoeudButton.setPreferredSize(new Dimension(200, 50));
		
		JButton ajouterArcButton = new JButton(ADD_ARC_STRING);
		ajouterArcButton.setPreferredSize(new Dimension(200 ,50));
		
		JButton placerVehiculeButton = new JButton(PUT_VEHICULE);
		placerVehiculeButton.setPreferredSize(new Dimension(200,50));
		
		JPanel editButtons= new JPanel(new GridLayout(3,1,0,5)); 
		editButtons.add(ajouterNoeudButton);
		editButtons.add(ajouterArcButton);
		editButtons.add(placerVehiculeButton);
		add(editButtons, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
		

}
