package gui;

import javax.swing.JFrame;

import squadre.GestioneSquadre;

public class FrameCreaCarica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameCreaCarica(String titolo, GestioneSquadre gs) {

		setTitle(titolo);
		setResizable(false);
		add(new PanelCreaCarica(this, gs));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
