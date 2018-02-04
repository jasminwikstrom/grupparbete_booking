package AdminApplikation.Gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import AdminApplikation.BestBookingAppEver;

public class GUI extends JPanel {

	private static final long serialVersionUID = -4676218230574341917L;
	public static final int WIDTH = 600, HEIGHT = 500;
	public static final String TITLE = "Best booking app ever";
	
	public static final Color Background = new Color(200,200,200);
	public static final Color BackgroundC = new Color(255,255,255);
	public static final Color ForegroundC = new Color(0,0,0);
	
	private JPanel MainPanel;
	private BestBookingAppEver BBAE;
	
	public GUI(BestBookingAppEver BBAE ){
		this.BBAE = BBAE;
	}
	
	public void initPages(){
		BBAE.getPages();
		setupPage();
	}
	
	public void setupPage(){
		MainPanel = this.BBAE.getPages().startPage();
		
		setLayout(new BorderLayout());
		setBackground(Background);
		add(MainPanel, BorderLayout.CENTER);
			
		new Window(TITLE, WIDTH, HEIGHT, this);
	}
	
	public void swapPage(JPanel p){
		remove(MainPanel);
		MainPanel = p;
		add(MainPanel);
		validate();
		repaint();
	}
	
}
