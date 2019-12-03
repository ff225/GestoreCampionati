package gui;

import javax.swing.JFrame;

import squadre.GestioneSquadre;

public class FrameInfoSquadra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameInfoSquadra(GestioneSquadre gs) {

		// TODO Auto-generated constructor stub
		setResizable(false);
		setTitle("Informazioni squadra");
		getContentPane().add(new PanelInfoSquadra(this, gs));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
