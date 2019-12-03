package gui;

import javax.swing.JFrame;

public class FrameScegliSport extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameScegliSport() {

		setResizable(false);
		add(new PanelScegliSport(this));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Scegli sport");

	}

}
