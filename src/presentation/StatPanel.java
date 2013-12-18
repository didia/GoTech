package presentation;



import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;

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
		private JLabel paramField;

		private Simulateur m_simulateur;
		private ArrayList<Resultats> listeResultats;
		
//		private  Queue<Simulateur> listeEtatSimu = m_simulateur.reqEtatSimu().reqListeEtatSimu();
		
		public StatPanel(Simulateur simulateur){
			
			this.m_simulateur = simulateur;
			textField = new JLabel(Clock.stringVersion());
			textField.setVerticalAlignment(SwingConstants.BOTTOM);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
			textField.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
			
			paramField = new JLabel();
			//paramField.setVerticalAlignment(SwingConstants.TOP);
			//paramField.setHorizontalAlignment(SwingConstants.CENTER);
			
			
			JPanel fields = new JPanel(new GridLayout(2,1,0,0));
			fields.add(paramField);
			fields.add(textField);
			
			
			
			add(fields, BorderLayout.NORTH);
			
			
			
			this.updateParametres();
			
			
		}
		
		public String getResultat(){
			String statistiques = "";
			listeResultats = m_simulateur.reqGestionnaireResultats().reqLatestResultats();
			Resultats resultats = m_simulateur.reqResultats();
			if(resultats != null){
		
				statistiques +=
					"<center><u><h3> Statistiques </h3></u></center>"+
					"<table>" +
					"<tr>" +
					"<td><b>Distance parcourue:</b><td>: <td>"+resultats.getDistanceParcourue() +"</td>" +
					"</tr>" +
					"<tr><td><b>Temps moyen d'attente</b></td>: <td>" + resultats.gettempsDattente() +"</td>" +
					"</tr> " +
					"<tr>" +
					"<td><b>Urgences traitées:</b><td>: <td>"+m_simulateur.reqGestionnaireUrgence().reqNombreUrgenceTraitee() +"</td>" +
					"</tr>" +
					"<tr>" +
					"<td><b>Urgences restantes:</b><td>: <td>"+m_simulateur.reqGestionnaireUrgence().reqNombreUrgenceNonTraitee() +"</td>" +
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
						"<center><u><h3> Paramètres </h3></center></u>"+
						"<table>" +
						"<tr>" +
						"<td><b>Stratégie actuelle:</b><td>: <td>"+m_simulateur.reqStrategieCourante() +"</td>" +
						"</tr>" +
						"<tr>" +
						"<td><b>Retour point d'attache:</b><td>: <td>"+retourPointAttache+"</td>" +
						"</tr>" +
						"<tr>" +
						"<td><b>Temps traitement:</b><td>: <td>"+params.reqTempsTraitement()+" minutes</td>" +
						"</tr>" +
						"<tr><td><b>Vitesse vehicule: </b></td>: <td>" + params.reqVitesseVehicule()+" km/h</td>" +
						"</tr> <br/>" +
						"</table>" + "<br/><br/>" + getResultat() +
						
						"<body></html>";
			
			
			
			this.paramField.setText(parametres);
			
			return parametres;
			
		}
}
