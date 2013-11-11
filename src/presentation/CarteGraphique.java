package presentation;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;

import presentation.NoeudGraphique;
import presentation.ArcGraphique;
import presentation.VehiculeGraphique;
import java.awt.Image;

public class CarteGraphique extends JPanel {
	
	private List<NoeudGraphique> m_listeNoeuds = new ArrayList<>();
	private List<ArcGraphique> m_listeArcs = new ArrayList<>();
	private VehiculeGraphique m_vehicule = null;
	private Image m_imageDeFond = null;
	
	public CarteGraphique() {
		// TODO Auto-generated constructor stub
	}

}
