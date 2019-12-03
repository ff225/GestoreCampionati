package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import calendario.Calendario;

public class FrameStampaVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameStampaVista(Calendario cal, String text, Integer giornata) {
		// TODO Auto-generated constructor stub

		setTitle("Calendario");
		add(new PanelStampaVista(cal, text, giornata));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
