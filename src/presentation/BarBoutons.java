package presentation;
import java.awt.*;
import javax.swing.*;

import domainePartie1.Default;
import domainePartie1.Simulateur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarBoutons extends JToolBar {
	
	private JTextField textZoom;
	private static final String ZOOMMOINS = Default.ZOOMMOINS;
	private static final String ZOOMPLUS = Default.ZOOMPLUS;;
	private static CarteGraphique m_carte ;
	
	public BarBoutons(CarteGraphique carte) {
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		//Initialisation Bar Boutons
		this.setRollover(true);
		this.setFloatable(false);
		m_carte = carte;
		JButton btnZoomMoins = new JButton(ZOOMMOINS);
		btnZoomMoins.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnZoomMoins.setActionCommand(ZOOMMOINS);
		
		
		add(btnZoomMoins);
		
		textZoom = new JTextField();
		textZoom.setText("100%");
		textZoom.setEditable(false);
		
		add(textZoom);
		textZoom.setColumns(5);
		
		JButton btnZoomPlus = new JButton(ZOOMPLUS);
		btnZoomPlus.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnZoomPlus.setActionCommand(ZOOMPLUS);
	
		add(btnZoomPlus);
		
		//Initialisation Boutons
		
	
	}
}

