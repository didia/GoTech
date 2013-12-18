package domaine.simulateur.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import presentation.InterfaceGraphique;
import domaine.reseau.Arc;
import domaine.reseau.Carte;
import domaine.reseau.Noeud;
import domaine.simulateur.Simulateur;

public class Deserializer {
	

	
  public void DeserializeCarte(Simulateur simulateur,InterfaceGraphique interfaceG){


	  JFileChooser fileChooser = new JFileChooser();
	  int returnVal = fileChooser.showOpenDialog(interfaceG);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
	
	   try{
		   FileInputStream fis = new FileInputStream(file);
		   ObjectInputStream ois = new ObjectInputStream(fis);
		   simulateur = (Simulateur)ois.readObject(); 
		   ois.close();

		System.out.println("Done");

	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
  }
}
}
