package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import calendario.Calendario;
import squadre.GestioneSquadre;

public class FrameScegliVistaStampa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameScegliVistaStampa(GestioneSquadre gs, Calendario cal) {
		// TODO Auto-generated constructor stub
		setTitle("Stampa per:");
		add(new PanelScegliVistaStampa(this, gs, cal));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
