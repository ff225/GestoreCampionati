package gui;

import java.io.File;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import calendario.Calendario;
import calendario.SalvaCaricaCampionato;
import squadre.GestioneSquadre;
import squadre.SalvaCaricaSquadre;

public class Worker extends SwingWorker<Integer, Void> {

	private FrameProgressBar fbb;
	private File pathSquadre, pathCampionato;
	private GestioneSquadre gs;
	private Calendario cal;
	private SalvaCaricaCampionato scc;
	private SalvaCaricaSquadre scs;

	public Worker(FrameProgressBar fpb, File pathSquadre, File pathCampionato, GestioneSquadre gs, Calendario cal) {
		// TODO Auto-generated constructor stub
		fbb = fpb;
		this.pathSquadre = pathSquadre;
		this.pathCampionato = pathCampionato;
		this.gs = gs;
		this.cal = cal;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		// TODO Auto-generated method stub

		int i = 1;
		try {
			if (pathSquadre != null) {
				scs = new SalvaCaricaSquadre();
				scs.deserializza(pathSquadre, gs);
			} else {
				scc = new SalvaCaricaCampionato();
				scc.deserializza(pathCampionato, cal, gs);
			}
		} catch (Exception e1) {

			// TODO Auto-generated catch block
			if (e1 instanceof ClassNotFoundException)
				JOptionPane.showMessageDialog(new JFrame(), "File non trovato", "Errore", JOptionPane.ERROR_MESSAGE);
			if (e1 instanceof InputMismatchException)
				JOptionPane.showMessageDialog(new JFrame(), "Impossibile caricare il file", "Errore",
						JOptionPane.ERROR_MESSAGE);

			cancel(true);
			fbb.dispose();
			System.exit(-1);

		}
		while (!isCancelled() && i < 10) {
			Thread.sleep(500);
			// System.out.println("Ciao");
			i++;
			setProgress(i * 10);
		}
		return null;
	}

	@Override
	protected void done() {

		fbb.dispose();
		if (pathSquadre != null)
			new FrameCreaCampionato(gs.getSport().toString(), gs);
		else
			new FrameGestisciCampionato(gs, scc.getCalendario(), gs.getSport().toString());
	}
}
