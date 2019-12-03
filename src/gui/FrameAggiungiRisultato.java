package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import calendario.Calendario;
import squadre.GestioneSquadre;

public class FrameAggiungiRisultato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameAggiungiRisultato(Calendario cal, GestioneSquadre gs, int riga, DefaultTableModel model) {
		// TODO Auto-generated constructor stub

		int giornata = (int) model.getValueAt(riga, 0) - 1;
		int partita = (int) model.getValueAt(riga, 1) - 1;

		setTitle("Aggiungi risultato: " + cal.getPartita(giornata, partita).getCasa().getNomeSqd() + " - "
				+ cal.getPartita(giornata, partita).getTrasferta().getNomeSqd());
		add(new PanelAggiungiRisultato(this, cal, gs, riga, model));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

}
