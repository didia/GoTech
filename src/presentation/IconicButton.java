package presentation;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;



public class IconicButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IconicButton(String name,String iconPath){
		
		super(name);
		
		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		this.setIcon(new ImageIcon(InterfaceGraphique.class.getResource(iconPath)));
		
		this.setPreferredSize(new Dimension(103, 32));
		
		
	}

}
