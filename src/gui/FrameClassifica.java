package gui;

import javax.swing.JFrame;

import squadre.GestioneSquadre;

public class FrameClassifica extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameClassifica(GestioneSquadre gs) {
		setTitle("Classifica");
		add(new PanelClassifica(gs));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
