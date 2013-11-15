package presentation;
import java.awt.*;
import javax.swing.*;

public class BarBoutons extends JToolBar {
	private JButton boutonNoeud;
	private JButton boutonArc;
	private JButton boutonVehicule;
	private JButton bouton4;
	private JButton boutonArreter;
	private JButton boutonLancer;
	private JButton boutonPlus;
	private JButton boutonMoins;
	
	public BarBoutons() {
		//Initialisation Bar Boutons
		this.setRollover(true);
		this.setFloatable(false);
		
		//Initialisation Boutons
		boutonNoeud = new JButton("Noeud");
		boutonNoeud.setFont(new Font("sans serif", Font.PLAIN, 22));
		boutonArc = new JButton("Arc");
		boutonArc.setFont(new Font("sans serif", Font.PLAIN, 22));
		boutonVehicule = new JButton("Vehicule");
		boutonVehicule.setFont(new Font("sans serif", Font.PLAIN, 22));
		bouton4 = new JButton("Noeud");	
		boutonArreter = new JButton("Arreter");
		boutonArreter.setFont(new Font("sans serif", Font.PLAIN, 22));
		boutonLancer = new JButton("Lancer");
		boutonLancer.setFont(new Font("sans serif", Font.PLAIN, 22));
		boutonPlus = new JButton("Plus");
		boutonPlus.setFont(new Font("sans serif", Font.PLAIN, 22));
		boutonMoins = new JButton("Moins");
		boutonMoins.setFont(new Font("sans serif", Font.PLAIN, 22));
	
	
		
		//Ajout boutons
		this.add(boutonNoeud);
		this.add(boutonArc);
		this.add(boutonVehicule);
		this.addSeparator();
		this.add(new JLabel("Zoom"));
		this.add(boutonPlus);
		this.add(boutonMoins);
		this.addSeparator();
		this.add(boutonLancer);
		this.add(boutonArreter);
	
	}
}