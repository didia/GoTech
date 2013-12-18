package presentation;



import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domaine.simulation.resultat.Resultats;
import domaine.simulateur.Clock;
import domaine.simulateur.Parametres;
import domaine.simulateur.Simulateur;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class StatPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 4389804890212885041L;
		private JLabel textField;
		private JEditorPane paramField;

		private Simulateur m_simulateur;
		
		
//		private  Queue<Simulateur> listeEtatSimu = m_simulateur.reqEtatSimu().reqListeEtatSimu();
		
		public StatPanel(Simulateur simulateur){
			
			this.m_simulateur = simulateur;
			textField = new JLabel(Clock.stringVersion());
			textField.setVerticalAlignment(SwingConstants.BOTTOM);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
			
			paramField = new JEditorPane();
			paramField.setBackground(null);
			paramField.setContentType("text/html");
			paramField.setOpaque(true);
			
			
			
			JPanel fields = new JPanel(new GridLayout(2,1,0,0));
			fields.add(paramField);
			fields.add(textField);
			
			
			
			add(fields, BorderLayout.NORTH);
			
			
			
			this.updateParametres();
			
			
		}
		
		public String getResultat(){
			String statistiques = "";
			
			Resultats resultats = m_simulateur.reqResultats();
			if(resultats != null){
		
				statistiques +=
					"<center><u><h1> Statistiques </h1></u></center>"+
					"<table>" +
					"<tr style=\"color:blue;font-size:14px\">" +
					"<td><b>Distance parcourue:</b></td>: <td>"+resultats.getDistanceParcourue() +"</td>" +
					"</tr>" +
					"<tr style=\"color:blue;font-size:14px\"><td><b>Temps moyen d'attente</b></td>: <td >" + resultats.gettempsDattente() +"</td>" +
					"</tr> " +
					"<tr style=\"color:green\">" +
					"<td ><b>Urgences traitées:</b></td>: <td>"+m_simulateur.reqGestionnaireUrgence().reqNombreUrgenceTraitee() +"</td>" +
					"</tr>" +
					"<tr style=\"color:red\">" +
					"<td><b>Urgences restantes:</b></td>: <td>"+m_simulateur.reqGestionnaireUrgence().reqNombreUrgenceNonTraitee() +"</td>" +
					"</tr>" +
					"<br/>" +
					"</table>"
					;
			
		
		}
			return statistiques;
		}
		
		public String updateParametres()
		{	
			textField.setText(Clock.stringVersion());
			String parametres = "<html><body style=\" background-color:transparent;\">";
			Parametres params = m_simulateur.reqParametres();
			String retourPointAttache;
			if(params.reqRetourPointAttache())
			{
				retourPointAttache = "Oui";
			}
			else
			{
				retourPointAttache = "Non";
			}
			parametres +=
						"<center><u><h1> Paramètres </h1></center></u>"+
						"<table>" +
						"<tr>" +
						"<td><b>Stratégie actuelle:</b></td>: <td>"+m_simulateur.reqStrategieCourante() +"</td>" +
						"</tr>" +
						"<tr>" +
						"<td><b>Retour point d'attache:</b></td>: <td>"+retourPointAttache+"</td>" +
						"</tr>" +
						"<tr>" +
						"<td><b>Temps traitement:</b></td>: <td>"+params.reqTempsTraitement()+" minutes</td>" +
						"</tr>" +
						"<tr><td><b>Vitesse vehicule: </b></td>: <td>" + params.reqVitesseVehicule()+" km/h</td>" +
						"</tr> <br/>" +
						"</table>" + "<br/><br/>" + getResultat() +
						
						"<body></html>";
			
			
			
			this.paramField.setText(parametres);
			
			return parametres;
			
		}
		public String getComparedResults()
		{
			ArrayList<Resultats> listeResultats = m_simulateur.reqGestionnaireResultats().reqLatestResultats();
			String comparedResults = "<html><body style=\" background-color:transparent;\">";
			
			comparedResults += "<center><u><h1> Comparaison des statistiques </h1></u></center>"+
					"<table>" +
					"<th>";
					for(int i =0; i<listeResultats.size(); i++)
					{
						comparedResults += "<td><h2>Simulation "+Integer.toString(i+1)+"</h2></td>";
					}
			 
			comparedResults += "</th><tr><td><b>Stratégie employée</b></td>";
			for(Resultats resultat : listeResultats)
			 {
				comparedResults += "<td>"+resultat.reqStrategie() +"</td>";
					
			 }
			comparedResults += "</tr><td><b>Retourne au point d'attache?</b></td>";
			for(Resultats resultat : listeResultats)
			 {
				comparedResults += "<td>"+resultat.retournePointAttache() +"</td>";
					
			 }
			comparedResults += "</tr><tr><td><b>Distance parcourue</b></td>";
			 for(Resultats resultat : listeResultats)
			 {
				comparedResults += "<td style=\"color:blue;font-size:14px\">"+resultat.getDistanceParcourue() +"</td>";
					
			 }
			 comparedResults += "</tr><tr><td><b>Temps moyen d'attente</b></td>";
			 for(Resultats resultat : listeResultats)
			 {
				comparedResults +="<td style=\"color:blue;font-size:14px\">" + resultat.gettempsDattente() +"</td>";
			 }
			 comparedResults += "</tr><tr><td ><b>Urgences traitées:</b></td>";
			 for(Resultats resultat : listeResultats)
			 {
				comparedResults += " <td style=\"color:green\">"+resultat.reqNombreUrgenceTraitee() +"</td>";
			 }	
			 
			comparedResults += "</table></body></html>";
			return comparedResults;
			 
		}
}
