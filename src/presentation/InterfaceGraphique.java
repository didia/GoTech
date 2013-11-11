package presentation;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import presentation.IconicButton.*;

import presentation.CarteGraphique;
public class InterfaceGraphique extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CarteGraphique m_carteGraphique;

	public InterfaceGraphique() {
		super("Intervensim");
		
		m_carteGraphique = new CarteGraphique();
		getContentPane().add(m_carteGraphique, BorderLayout.CENTER);
		

	}
}
