package calendario;

import javax.swing.table.DefaultTableModel;

/**
 * Classe che implementa la stampa delle partite.
 * 
 * @author Francesco Franco
 *
 */
public class StampaPartite {
	private Calendario cal;
	private DefaultTableModel model;

	/**
	 * Metodo costruttore.
	 * 
	 * @param cal   calendario attualmente utilizzato
	 * @param model implementazione della tabella.
	 */
	public StampaPartite(Calendario cal, DefaultTableModel model) {
		// TODO Auto-generated constructor stub
		this.cal = cal;
		this.model = model;
	}

	/**
	 * Imposta un risultato di default a tutte le partite.
	 */
	public void setDefaultRisultato() {
		for (int giornata = 0; giornata < cal.getGiornate(); giornata++) {
			for (int partita = 0; partita < cal.getNumPartite(); partita++) {
				cal.getPartita(giornata, partita).setRisulato(0, 0, true);
			}
		}
	}

	/**
	 * Stampa le partite a video.
	 */
	public void stampa() {
		for (int giornata = 0; giornata < cal.getGiornate(); giornata++) {
			for (int partita = 0; partita < cal.getNumPartite(); partita++) {

				String casa = cal.getPartita(giornata, partita).getCasa().getNomeSqd();
				String trasferta = cal.getPartita(giornata, partita).getTrasferta().getNomeSqd();
				int rCasa = cal.getPartita(giornata, partita).getRisultato().getEsitoCasa();
				int rTrasf = cal.getPartita(giornata, partita).getRisultato().getEsitoTrasf();

				//System.out.println("rCasa: " + rCasa + " - " + "rTrasf:" + rTrasf);
				if (casa.equals(" ") || trasferta.equals(" "))
					model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, "Riposo" });
				else {
					model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, rCasa + " - " + rTrasf });
				}
			}
		}
	}

	/**
	 * Stampa le partite per una data giornata
	 * 
	 * @param giornata di cui vogliamo conoscere le partite.
	 */
	public void stampaGiornata(int giornata) {
		if (giornata < 0 || giornata >= cal.getGiornate())
			return;

		for (int partita = 0; partita < cal.getNumPartite(); partita++) {
			String casa = cal.getPartita(giornata, partita).getCasa().getNomeSqd();
			String trasferta = cal.getPartita(giornata, partita).getTrasferta().getNomeSqd();
			int rCasa = cal.getPartita(giornata, partita).getRisultato().getEsitoCasa();
			int rTrasf = cal.getPartita(giornata, partita).getRisultato().getEsitoTrasf();

			// model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, rCasa
			// + " - " + rTrasf });
			if (casa.equals(" ") || trasferta.equals(" "))
				model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, "Riposo" });
			else {
				model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, rCasa + " - " + rTrasf });
			}
			/*
			 * System.out.println(cal.getPartita(giornata, partita).getCasa().getNomeSqd() +
			 * " - " + cal.getPartita(giornata, partita).getTrasferta().getNomeSqd());
			 */
		}
	}

	/**
	 * Stampa le partite per una data squadra.
	 * 
	 * @param squadra di cui vogliamo conoscere le partite.
	 */
	public void stampaPerSquadra(String squadra) {
		squadra = squadra.toUpperCase();

		for (int giornata = 0; giornata < cal.getGiornate(); giornata++) {
			for (int partita = 0; partita < cal.getNumPartite(); partita++) {
				String casa = cal.getPartita(giornata, partita).getCasa().getNomeSqd();
				String trasferta = cal.getPartita(giornata, partita).getTrasferta().getNomeSqd();
				int rCasa = cal.getPartita(giornata, partita).getRisultato().getEsitoCasa();
				int rTrasf = cal.getPartita(giornata, partita).getRisultato().getEsitoTrasf();

				if (casa.equals(squadra) || trasferta.equals(squadra))
					if (casa.equals(" ") || trasferta.equals(" "))
						model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, "Riposo" });
					else {
						model.addRow(
								new Object[] { giornata + 1, partita + 1, casa, trasferta, rCasa + " - " + rTrasf });
					}
				// model.addRow(new Object[] { giornata + 1, partita + 1, casa, trasferta, rCasa
				// + " - " + rTrasf });

			}
		}

	}

	/**
	 * Reset delle partite stampate a video.
	 */
	public void resetPartite() {
		//System.out.println("NUmero di righe: " + model.getRowCount());
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 4).equals("Riposo"))
				continue;
			else
				model.setValueAt("0 - 0", i, 4);
		}
		for (int i = 0; i < cal.getGiornate(); i++) {
			for (int j = 0; j < cal.getNumPartite(); j++) {
				cal.getPartita(i, j).resetPartite();

			}
		}
	}

}
