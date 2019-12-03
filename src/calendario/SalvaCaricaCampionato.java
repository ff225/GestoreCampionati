/**
 * 
 */
package calendario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import squadre.GestioneSquadre;
import squadre.Squadra;

/**
 * Classe per salvare/caricare un campionato su/da file.
 * 
 * @author Francesco Franco
 *
 */
public class SalvaCaricaCampionato {
	private Calendario cal;

	public SalvaCaricaCampionato() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param nomeFile file che conterra' il campionato
	 * @param sport    contiene il tipo di sport che stiamo salvando
	 * @param cal
	 * @param gs
	 */
	public void serializzazione(String nomeFile, String sport, Calendario cal, GestioneSquadre gs) {
		FileOutputStream fos = null;
		ObjectOutputStream os = null;
		int nGiornate = cal.getGiornate();
		int nPartite = cal.getNumPartite();
		String pathDir = System.getProperty("user.dir");
		pathDir = pathDir.replace("/bin", "");
		File dir = new File(pathDir + "/Sport/" + sport.toUpperCase() + "/Campionati/");
		File f = new File(dir, nomeFile + gs.getSport().toString() + ".dat");
		ArrayList<Squadra> squadre = null;
		try {
			fos = new FileOutputStream(f);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Errore in fos");
		}

		try {
			squadre = new ArrayList<Squadra>(gs.getAll());
			os = new ObjectOutputStream(fos);
			os.writeObject(gs.getSport());
			os.writeObject(squadre);
			os.writeInt(nGiornate);
			os.writeInt(nPartite);
			for (int i = 0; i < nGiornate; i++)
				for (int j = 0; j < nPartite; j++) {
					os.writeObject(cal.getPartita(i, j));
					System.out.println("ok");
				}
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO: handle exception
			//System.out.println("Errore in oos");
		}

	}

	/**
	 * 
	 * @param pathFile percorso verso il file contenente il campionato
	 * @param cal
	 * @param gs
	 * @throws ClassNotFoundException
	 * @throws InputMismatchException
	 */
	@SuppressWarnings("unchecked")
	public void deserializza(File pathFile, Calendario cal, GestioneSquadre gs)
			throws ClassNotFoundException, InputMismatchException {
		FileInputStream fis = null;
		ObjectInputStream is = null;
		ArrayList<Squadra> squadre = new ArrayList<Squadra>();
		try {
			fis = new FileInputStream(pathFile);
			// System.out.println("Val: " +
			// !pathFile.toString().contains(gs.getSport().toString()));
			if (!pathFile.toString().contains(gs.getSport().toString())) {
				JOptionPane.showMessageDialog(new JFrame(), "Impossibile caricare il campionato", "Errore",
						JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Errore in fos");
		}
		try {
			is = new ObjectInputStream(fis);
			Object sport = is.readObject();
			// System.out.println("gs:" + gs.getSport().toString() + "is " +
			// sport.toString());
			if (!(gs.getSport().toString().equals(sport.toString()))) {
				throw new InputMismatchException("Il campionato non è dello sport " + gs.getSport().toString());
			}
			squadre = (ArrayList<Squadra>) is.readObject();

			for (Squadra squadra : squadre) {
				gs.aggiungiSqd(squadra);
			}
			cal = new Calendario(gs);
			cal.AlgoritmoDiBerger();
			int giornate = is.readInt();
			int partite = is.readInt();

			Partita p = null;
			for (int i = 0; i < giornate; i++)
				for (int j = 0; j < partite; j++) {
					p = (Partita) is.readObject();
					// System.out
					// .println("Partita letta:" + p.getCasa().getNomeSqd() + "-" +
					// p.getTrasferta().getNomeSqd());
					cal.setPartita(p, i, j);
					// System.out.println("Partita stampata" + cal.getPartita(i,
					// j).getCasa().getNomeSqd() + "-"
					// + cal.getPartita(i, j).getTrasferta().getNomeSqd());
				}
			is.close();

			this.cal = cal;
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public Calendario getCalendario() {
		return cal;
	}

}
