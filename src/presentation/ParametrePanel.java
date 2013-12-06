package presentation;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


import domaine.simulateur.Default;
import domaine.simulateur.Simulateur;


import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import java.awt.Font;




public class ParametrePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7963141367854789316L;
	private static Simulateur m_simulateur;
	private JRadioButton rdbtnAncien;
	private JRadioButton rdbtnParProximit;
	private JRadioButton rdbtnCheminMinimum;
	private JFormattedTextField vitesseVehicule;
	private JFormattedTextField echelle;
	private JCheckBox chckbxRetourne;
	private JFormattedTextField tempsTraitement;
	private JFormattedTextField echelleTemps;
	
	class FiltreEntier extends DocumentFilter {
		   @Override
		   public void insertString(FilterBypass fb, int offset, String string,
		         AttributeSet attr) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.insert(offset, string);

		      if (test(sb.toString())) {
		         super.insertString(fb, offset, string, attr);
		      } else {
		    	  Toolkit.getDefaultToolkit().beep();
		      }
		   }

		   protected boolean test(String text) {
		      try {
		    	  if(text.isEmpty()){
		    		  return true;
		    	  }
		         Integer.parseInt(text);
		         return true;
		      } catch (NumberFormatException e) {
		    	 
		         return false;
		      }
		   }

		   @Override
		   public void replace(FilterBypass fb, int offset, int length, String text,
		         AttributeSet attrs) throws BadLocationException {

		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.replace(offset, offset + length, text);

		      if (test(sb.toString())) {
		         super.replace(fb, offset, length, text, attrs);
		      } else {
		    	  Toolkit.getDefaultToolkit().beep();
		      }

		   }

		   @Override
		   public void remove(FilterBypass fb, int offset, int length)
		         throws BadLocationException {
		      Document doc = fb.getDocument();
		      StringBuilder sb = new StringBuilder();
		      sb.append(doc.getText(0, doc.getLength()));
		      sb.delete(offset, offset + length);

		      if (test(sb.toString())) {
		         super.remove(fb, offset, length);
		      } else {
		    	  Toolkit.getDefaultToolkit().beep();
		      }

		   }
		}
		
		class FiltreDecimal extends FiltreEntier{
			@Override
			protected boolean test(String text){
				try {
					if(text.isEmpty()){
			    		  return true;
			    	  }
			         Float.parseFloat(text);
			         return true;
			      } catch (NumberFormatException e) {
			         return false;
			      }
			}
		}
	
	public ParametrePanel(Simulateur simulateur) {

		setMinimumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(523, 465));
		m_simulateur = simulateur;
		setLayout(null);

		JLabel lblStratgieDeSimulation = new JLabel("Strat�gie de simulation");
		lblStratgieDeSimulation.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblStratgieDeSimulation.setToolTipText("Choisissez une strat�gie de simulation");
		lblStratgieDeSimulation.setBounds(6, 26, 254, 34);
		add(lblStratgieDeSimulation);
		
		rdbtnAncien = new JRadioButton("Anciennet�");
		rdbtnAncien.setToolTipText("Les urgences sont trait�es par ordre d'anciennet�");
		rdbtnAncien.setBounds(6, 72, 166, 23);
		rdbtnAncien.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_ANC));
		add(rdbtnAncien);
		
		rdbtnParProximit = new JRadioButton("Proximit�");
		rdbtnParProximit.setToolTipText("Les urgences sont trait�es par ordre de proximit�");
		rdbtnParProximit.setBounds(6, 97, 177, 23);
		rdbtnParProximit.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_PROX));
		add(rdbtnParProximit);
		
		rdbtnCheminMinimum = new JRadioButton("Chemin Minimum");
		rdbtnCheminMinimum.setToolTipText("Les urgences sont trait�es de sorte � reduire le chemin parcouru");
		rdbtnCheminMinimum.setBounds(6, 117, 166, 23);
		rdbtnCheminMinimum.setSelected(m_simulateur.isStrategieCourante(Default.STRATEGIE_MIN));
		add(rdbtnCheminMinimum);
		
		final ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAncien);
		group.add(rdbtnParProximit);
		group.add(rdbtnCheminMinimum);
		
		JLabel lblVehiculeDurgence = new JLabel("Vehicule D'urgence");
		lblVehiculeDurgence.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblVehiculeDurgence.setBounds(9, 152, 205, 28);
		add(lblVehiculeDurgence);
		JLabel lblVitesseDuVhicule = new JLabel("Vitesse du v�hicule (Km/h) : ");
		lblVitesseDuVhicule.setBounds(19, 192, 208, 23);
		add(lblVitesseDuVhicule);
		
		FiltreEntier filtreEntier = new FiltreEntier();
		FiltreDecimal filtreDecimal = new FiltreDecimal();

		
		vitesseVehicule = new JFormattedTextField();
		PlainDocument vVDoc = (PlainDocument) vitesseVehicule.getDocument();
		vVDoc.setDocumentFilter(filtreDecimal);
		vitesseVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitesseDuVhicule.setLabelFor(vitesseVehicule);
		vitesseVehicule.setText(Float.toString(m_simulateur.reqVitesseVehicule()));
		vitesseVehicule.setBounds(351, 191, 56, 23);
		add(vitesseVehicule);
		
		chckbxRetourne = new JCheckBox("Retour au point d'attache apr�s traitement des urgences");
		chckbxRetourne.setBounds(9, 255, 405, 23);
		chckbxRetourne.setSelected(m_simulateur.isretourPointAttache());
		add(chckbxRetourne);
		JLabel lblEchelle = new JLabel("Echelle de la carte");
		lblEchelle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblEchelle.setBounds(6, 290, 195, 27);
		add(lblEchelle);
		
		JLabel lblDistanceEntreDeux = new JLabel("Distance entre deux points de la grille (m) :");
		lblDistanceEntreDeux.setBounds(16, 329, 277, 16);
		add(lblDistanceEntreDeux);
		
		
		
		echelle = new JFormattedTextField();
		PlainDocument eDoc = (PlainDocument) echelle.getDocument();
		eDoc.setDocumentFilter(filtreEntier);
		echelle.setHorizontalAlignment(SwingConstants.CENTER);
		echelle.setText(Integer.toString(m_simulateur.reqMetreParStep()));
		lblDistanceEntreDeux.setLabelFor(echelle);
		echelle.setBounds(351, 327, 56, 19);
		add(echelle);
		
		JLabel lblNewLabel = new JLabel("Temps de traitement d'une urgence (minutes) :");
		lblNewLabel.setBounds(17, 227, 302, 16);
		add(lblNewLabel);
		
		tempsTraitement = new JFormattedTextField();
		PlainDocument tTDoc = (PlainDocument) tempsTraitement.getDocument();
		tTDoc.setDocumentFilter(filtreDecimal);
		tempsTraitement.setBounds(351, 221, 56, 28);
		tempsTraitement.setText(Float.toString(m_simulateur.reqTempsTraitement()));
		add(tempsTraitement);
		
		JLabel lblEchelleTemporelle = new JLabel("Echelle Temporelle");
		lblEchelleTemporelle.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 17));
		lblEchelleTemporelle.setBounds(6, 364, 195, 27);
		add(lblEchelleTemporelle);
		
		JLabel lblUneHeureDe = new JLabel("Une heure dans la simulation correspond �");
		lblUneHeureDe.setBounds(16, 403, 277, 16);
		add(lblUneHeureDe);
		
		echelleTemps = new JFormattedTextField();
		PlainDocument eTDoc = (PlainDocument) echelleTemps.getDocument();
		eTDoc.setDocumentFilter(filtreEntier);
		echelleTemps.setText(Integer.toString(m_simulateur.reqEchelleTemps()));
		echelleTemps.setHorizontalAlignment(SwingConstants.CENTER);
		echelleTemps.setBounds(290, 401, 65, 19);
		add(echelleTemps);
		
		JLabel lblSecondesEnRalit = new JLabel("secondes dans la réalité");
		lblSecondesEnRalit.setBounds(357, 403, 166, 16);
		add(lblSecondesEnRalit);
		
		
		setVisible(true);
	}
	
	public String reqStrategie()
	{
		if (rdbtnParProximit.isSelected())
		{
			return Default.STRATEGIE_PROX;
		}
		else if (rdbtnCheminMinimum.isSelected())
		{
			return Default.STRATEGIE_MIN;
		}
		else
		{
			return Default.STRATEGIE_ANC;
		}
	}
	
	public boolean isRetourPointAttache()
	{
		return chckbxRetourne.isSelected();
	}
	
	public float reqVitesseVehicule()
	{
		return Float.parseFloat(vitesseVehicule.getText());
	}
	
	public int reqMetreParStep()
	{

		return Integer.parseInt(echelle.getText());
	}
	public float reqTempsTraitement(){
		return Float.parseFloat(tempsTraitement.getText());
	}
	public int reqEchelleTemps(){
		
		return Integer.parseInt(echelleTemps.getText());
	}
}
