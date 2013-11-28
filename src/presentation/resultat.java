package presentation;

import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import domainePartie1.Simulateur;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class resultat extends JPanel{
private static Simulateur m_simulateur;
	
private JPanel m_resulataPanel = new JPanel();
private JTextArea m_resultat = new JTextArea();
private JTextField  m_tempsAtenteMoyen;
private JTextField m_distanceTotaleParcourue;
private JLabel lblDistanceTotaleParcourue;
private JLabel lblResultatsDeLa;

public resultat (Simulateur simulateur)
{
		
	setLayout(null);
	
	JLabel lblTempsDattenteMoyen = new JLabel("Temps d'attente moyen :");
	lblTempsDattenteMoyen.setBounds(12, 33, 160, 36);
	add(lblTempsDattenteMoyen);
	
	m_tempsAtenteMoyen = new JTextField();
	m_tempsAtenteMoyen.setBounds(178, 40, 69, 22);
	add(m_tempsAtenteMoyen);
	m_tempsAtenteMoyen.setColumns(10);
	
	m_distanceTotaleParcourue = new JTextField();
	m_distanceTotaleParcourue.setColumns(10);
	m_distanceTotaleParcourue.setBounds(178, 124, 69, 22);
	add(m_distanceTotaleParcourue);
	
	lblDistanceTotaleParcourue = new JLabel("Distance Totale Parcourue :");
	lblDistanceTotaleParcourue.setBounds(12, 120, 160, 30);
	add(lblDistanceTotaleParcourue);
	
	lblResultatsDeLa = new JLabel("Resultats de la Simulation");
	lblResultatsDeLa.setBounds(54, 0, 160, 23);
	add(lblResultatsDeLa);
	m_simulateur = simulateur;
	
}


}
