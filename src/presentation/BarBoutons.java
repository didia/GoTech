package presentation;
import java.awt.*;
import javax.swing.*;

import domainePartie1.Default;
import domainePartie1.Simulateur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BarBoutons extends JToolBar implements ActionListener {
	
	private JTextField textZoom;
	
	private static final String ZOOMMOINS = Default.ZOOMMOINS;
	private static final String ZOOMPLUS = Default.ZOOMPLUS;
	private static CarteGraphique m_carte ;
	private static Simulateur m_simulateur;
	
	public BarBoutons(CarteGraphique carte, Simulateur simulateur) {
		//Initialisation Bar Boutons
		this.setRollover(true);
		this.setFloatable(false);
		m_carte = carte;
		m_simulateur = simulateur;
		JButton btnZoomMoins = new JButton(ZOOMMOINS);
		btnZoomMoins.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnZoomMoins.setActionCommand(ZOOMMOINS);
		btnZoomMoins.addActionListener(this);
		
		JButton button = new JButton("");
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(button);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		add(separator);
		
		
		add(btnZoomMoins);
		
		textZoom = new JTextField();
		textZoom.setText("100%");
		textZoom.setEditable(false);
		
		add(textZoom);
		textZoom.setColumns(5);
		
		JButton btnZoomPlus = new JButton(ZOOMPLUS);
		btnZoomPlus.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnZoomPlus.setActionCommand(ZOOMPLUS);
		btnZoomPlus.addActionListener(this);
		add(btnZoomPlus);
		
		//Initialisation Boutons
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		
	}

}

