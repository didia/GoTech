package presentation;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class InterfaceGraphique extends JFrame {
	public InterfaceGraphique() {
		super("Intervensim");
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setMinimumSize(new Dimension(50, 50));
		panel_1.add(panel);
		
		JButton btnAjouterNoeud = new JButton("Ajouter Noeud");
		panel.add(btnAjouterNoeud);
		btnAjouterNoeud.setPreferredSize(new Dimension(103, 32));
		btnAjouterNoeud.setBackground(UIManager.getColor("Button.darkShadow"));
		
		JButton btnAjouterArc = new JButton("Ajouter Arc");
		panel.add(btnAjouterArc);
		
		JButton btnVehicule = new JButton("Vehicule");
		panel.add(btnVehicule);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnUrgence = new JButton("Urgence");
		panel_2.add(btnUrgence);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnFichier.add(mntmNouveau);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
