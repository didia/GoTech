package presentation;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


import domainePartie1.Default;
import domainePartie1.Simulateur;
import domainePartie1.Parametres;

import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.NumberFormat;

public class ParametrePanel extends JPanel {
	
	private static Simulateur m_simulateur;
	private JRadioButton rdbtnAncien;
	private JRadioButton rdbtnParProximit;
	private JRadioButton rdbtnCheminMinimum;
	private JFormattedTextField vitesseVehicule;
	private JFormattedTextField echelle;
	private JCheckBox chckbxRetourne;
	
	public ParametrePanel(Simulateur simulateur) {

		setMinimumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(500, 400));
		m_simulateur = simulateur;
		setLayout(null);
		

		JLabel lblStratgieDeSimulation = new JLabel("Strat�gie de simulation");
		lblStratgieDeSimulation.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblStratgieDeSimulation.setToolTipText("Choisissez une strat\u00E9gie de simulation");
		lblStratgieDeSimulation.setBounds(16, 26, 229, 34);
		add(lblStratgieDeSimulation);
		
		rdbtnAncien = new JRadioButton("Anciennet�");
		rdbtnAncien.setToolTipText("Les urgences sont trait�s par ordre d'anciennet�");
		rdbtnAncien.setBounds(37, 72, 166, 23);
		rdbtnAncien.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_ANC));
		add(rdbtnAncien);
		
		rdbtnParProximit = new JRadioButton("Proximit�");
		rdbtnParProximit.setToolTipText("Les urgences sont trait�es par ordre de proximitŽ");
		rdbtnParProximit.setBounds(37, 96, 177, 23);
		rdbtnParProximit.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_PROX));
		add(rdbtnParProximit);
		
		rdbtnCheminMinimum = new JRadioButton("Chemin Minimum");
		rdbtnCheminMinimum.setToolTipText("Les urgences sont trait�es de sorte � reduire le chemin parcouru");
		rdbtnCheminMinimum.setBounds(37, 117, 166, 23);
		rdbtnCheminMinimum.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_MIN));
		add(rdbtnCheminMinimum);
		
		final ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAncien);
		group.add(rdbtnParProximit);
		group.add(rdbtnCheminMinimum);
		
		JLabel lblVehiculeDurgence = new JLabel("Vehicule D'urgence");
		lblVehiculeDurgence.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblVehiculeDurgence.setBounds(16, 159, 205, 28);
		add(lblVehiculeDurgence);
		JLabel lblVitesseDuVhicule = new JLabel("Vitesse du v�hicule (Km/h) : ");
		lblVitesseDuVhicule.setBounds(37, 208, 185, 23);
		add(lblVitesseDuVhicule);
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(3);
		
		vitesseVehicule = new JFormattedTextField(numberFormat);
		vitesseVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitesseDuVhicule.setLabelFor(vitesseVehicule);
		vitesseVehicule.setText(Float.toString(m_simulateur.reqVitesseVehicule()));
		vitesseVehicule.setBounds(234, 208, 56, 23);
		add(vitesseVehicule);
		
		chckbxRetourne = new JCheckBox("Retour au point d'attache apr�s traitement des urgences");
		chckbxRetourne.setBounds(29, 243, 405, 23);
		chckbxRetourne.setSelected(m_simulateur.isretourPointAttache());
		add(chckbxRetourne);
		JLabel lblEchelle = new JLabel("Echelle de la carte");
		lblEchelle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblEchelle.setBounds(16, 286, 195, 27);
		add(lblEchelle);
		
		JLabel lblDistanceEntreDeux = new JLabel("Distance entre deux points de la grille (m) :");
		lblDistanceEntreDeux.setBounds(32, 338, 277, 16);
		add(lblDistanceEntreDeux);
		
		numberFormat.setMaximumFractionDigits(0);
		echelle = new JFormattedTextField(numberFormat);
		echelle.setHorizontalAlignment(SwingConstants.CENTER);
		echelle.setText(Integer.toString(m_simulateur.reqMetreParStep()));
		lblDistanceEntreDeux.setLabelFor(echelle);
		echelle.setBounds(321, 336, 47, 19);
		add(echelle);
		
		setVisible(true);
	}
	
	public String reqStrategie(){
		if(rdbtnParProximit.isSelected()){
			return Default.STRATEGIE_PROX;
		}
		else if (rdbtnCheminMinimum.isSelected()){
			return Default.STRATEGIE_MIN;
		}
		else{
			return Default.STRATEGIE_ANC;
		}
	}
	
	public boolean isRetourPointAttache(){
		return chckbxRetourne.isSelected();
	}
	public float reqVitesseVehicule(){
		return Float.parseFloat(vitesseVehicule.getText());
	}
	
	public int reqMetreParStep(){
		System.out.println(echelle.getText());
		return Integer.parseInt(echelle.getText());
	}
}
