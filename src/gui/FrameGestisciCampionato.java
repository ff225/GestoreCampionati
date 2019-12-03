package gui;

import javax.swing.JFrame;
import calendario.Calendario;
import squadre.GestioneSquadre;

public class FrameGestisciCampionato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameGestisciCampionato(GestioneSquadre gs, Calendario cal, String tipoSport) {

		setResizable(false);
		setTitle("Gestione Campionato di " + tipoSport);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new PanelGestisciCampionato(gs, cal));
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
		// TODO Auto-generated constructor stub
	}

}
