package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import calendario.Calendario;

public class FrameStampaCalendario {
	public FrameStampaCalendario(Calendario cal, String nSquadra, Integer giornata) {
		// TODO Auto-generated constructor stub

		JFrame frame = new JFrame("Stampa calendario");
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

		// Create and set up the content pane.
		frame.add(new PanelStampaCalendario(cal, nSquadra, giornata));

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
