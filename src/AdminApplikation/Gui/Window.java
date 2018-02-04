package AdminApplikation.Gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676594470460038564L;
	
	public Window(String title, int width, int height, JPanel gui){
		super(title);
		
		Dimension dim = new Dimension(width, height);
		
		gui.setPreferredSize(dim);
		gui.setMaximumSize(dim);
		gui.setMinimumSize(dim);
		add(gui);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
