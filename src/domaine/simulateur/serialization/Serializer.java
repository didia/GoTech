package domaine.simulateur.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import java.io.File;

import presentation.InterfaceGraphique;
import domaine.reseau.Arc;
import domaine.reseau.Carte;
import domaine.reseau.Noeud;
import domaine.simulateur.Simulateur;

public class Serializer {

	
	public void serializeCarte(Simulateur simulateur,
			InterfaceGraphique interfaceG) {

		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(interfaceG) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();

			try {

				FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fout);

				oos.writeObject(simulateur);

				oos.close();
				System.out.println("Done");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
