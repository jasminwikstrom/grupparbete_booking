package MedlemApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener{

	final JPanel menyPanel = new JPanel();
	final JButton loggaIn = new JButton("Logga in");
	final JButton bokaPass = new JButton("Boka pass");
	final JButton avbokaPass = new JButton("Avboka pass");
	boolean ärInloggad = false;

	public static final int WIDTH = 600, HEIGHT = 500;

		Controller cont = new Controller();

	public View(){
		add(menyPanel);

		menyPanel.add(loggaIn);
		menyPanel.add(avbokaPass);
		menyPanel.add(bokaPass);

		loggaIn.addActionListener(this);
		bokaPass.addActionListener(this);
		avbokaPass.addActionListener(this);

		bokaPass.setEnabled(false);
		avbokaPass.setEnabled(false);

		pack();
		menyPanel.setSize(WIDTH, HEIGHT);
		setLocation(500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton tempKnapp = (JButton) ae.getSource();
		if (tempKnapp.equals(loggaIn)) {
			ärInloggad = cont.loggaIN();
			if (ärInloggad == true) {
				loggaIn.setEnabled(false);
				bokaPass.setEnabled(true);
				avbokaPass.setEnabled(true);
			}
		}
		if(tempKnapp.equals(avbokaPass))	{
			cont.visaBokningar();
		}
		if(tempKnapp.equals(bokaPass))	{
			cont.listaTillgängligaPassFörBokning();
		}
	}
}
