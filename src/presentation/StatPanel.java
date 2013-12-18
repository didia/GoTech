package presentation;



import java.awt.BorderLayout;
import java.util.ArrayList;


import javax.swing.JEditorPane;
import javax.swing.JPanel;

import domaine.simulation.resultat.Resultats;
import domaine.simulateur.Simulateur;

public class StatPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 4389804890212885041L;
		private JEditorPane textField;
		private Simulateur m_simulateur;
		private ArrayList<Resultats> listeResultats;
		
//		private  Queue<Simulateur> listeEtatSimu = m_simulateur.reqEtatSimu().reqListeEtatSimu();
		
		public StatPanel(Simulateur simulateur){
			this.m_simulateur = simulateur;
			
			textField = new JEditorPane();
			
			textField.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
			textField.setEditable(false);
			add(textField,BorderLayout.CENTER);
			this.afficherResultat();
			
		}
		
		public void afficherResultat(){
			listeResultats = m_simulateur.reqGestionnaireResultats().reqLatestResultats();
			for (Resultats resultats : listeResultats)
			{
			if(resultats != null){
		
			String statistiques = "<html><body style=\"padding:10px; background-color:transparent;\">" +
					"<center><u><h3> Statistiques de Simulation </h3></center></u>"+
				
					"<table>" +
					"<tr>" +
					"<td><b>Strategie:</b><td>: <td>"+m_simulateur.reqStrategieCourante() +"</td>" +
					"</tr>" +
					"<tr>" +
					"<td><b>Nombre d'urgences traitées:</b><td>: <td>"+m_simulateur.reqGestionnaireUrgence().reqNombreUrgenceTraitee() +"</td>" +
					"</tr>" +
					"<tr>" +
					"<td><b>Distance Totale parcourue:</b><td>: <td>"+resultats.getDistanceParcourue() +"</td>" +
					"</tr>" +
					"<tr><td><b>Temps moyen d'attente</b></td>: <td>" + resultats.gettempsDattente() +"</td>" +
					"</tr> <br/>" +
					"</table>" +
					"<body></html>";
			this.updateTextField(statistiques);
			}
			}
			
		}
		public void updateTextField(String text){
			textField.setText(text);
		}
		
}
