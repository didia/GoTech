package domaine.simulateur.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import domaine.reseau.GestionnaireReseau;
import domaine.simulateur.Parametres;
import domaine.simulateur.Simulateur;
import domaine.simulateur.Vehicule;
import domaine.simulateur.etat.Etat;
import domaine.simulation.resultat.GestionnaireResultat;
import domaine.simulation.urgence.GestionnaireUrgence;

public class Enregistreur {

	
	public static Enregistrable load(File file)
	{
		 try{
			   FileInputStream fis = new FileInputStream(file);
			   ObjectInputStream ois = new ObjectInputStream(fis);
			   Enregistrable enregistrable =  (Enregistrable)ois.readObject();
			   
			   ois.close();
			   
			   return enregistrable;

		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   }
	}
	public static void enregistrer(File file, Simulateur simulateur)
	{
		
		try {

			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(new Enregistrable(simulateur));

			oos.close();
			System.out.println("Done enregistrée");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static class Enregistrable implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public final GestionnaireReseau gestionnaireReseau;
		public final Vehicule vehicule;
		public final GestionnaireResultat gestionnaireResultat;
		public final GestionnaireUrgence gestionnaireUrgence;
		public final Etat etat;
		public final Parametres parametres;
		public final boolean m_changeHappened;
		public final boolean enSimulation;
		
		
		public Enregistrable(Simulateur simulateur) 
		{
			this.enSimulation = simulateur.isEnSimulation();
			this.m_changeHappened = simulateur.hasChangeHappened();
			this.gestionnaireResultat = simulateur.reqGestionnaireResultats();
			this.gestionnaireUrgence = simulateur.reqGestionnaireUrgence();
			this.parametres = simulateur.reqParametres();
			this.etat = simulateur.reqEtat();
			this.gestionnaireReseau = simulateur.reqGestionnaireReseau();
			this.vehicule = simulateur.reqVehicule();
		}
		
	}
}
