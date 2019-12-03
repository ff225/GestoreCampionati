package gui;

import javax.swing.JFrame;

import squadre.GestioneSquadre;

public class FrameCreaCampionato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameCreaCampionato(String titolo, GestioneSquadre gs) {
		// TODO Auto-generated constructor stub

		setTitle(titolo + " crea");
		add(new PanelCreaCampionato(this, gs));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
