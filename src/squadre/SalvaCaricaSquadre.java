package squadre;

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

/**
 * <h1>Classe che implementa il salvataggio/caricamento delle squadre su/da
 * file</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public class SalvaCaricaSquadre {

	private ArrayList<Squadra> squadre;
	private FileOutputStream fos = null;
	private ObjectOutputStream os = null;
	private FileInputStream fis = null;
	private ObjectInputStream is = null;

	public SalvaCaricaSquadre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo utilizzato per salvare le squadre su file
	 * 
	 * @param nomeFile file che conterra' le squadre
	 * @param gs       @see GestioneSquadre
	 *
	 */
	public void serializzazione(String nomeFile, GestioneSquadre gs) {
		String pathDir = System.getProperty("user.dir");
		pathDir = pathDir.replace("/bin", "");
		File dir = new File(pathDir + "/Sport/" + gs.getSport().toString() + "/Squadre");
		File f = new File(dir, nomeFile + gs.getSport().toString() + ".dat");
		squadre = new ArrayList<Squadra>(gs.getAll());

		try {
			fos = new FileOutputStream(f);
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Errore in fos");
		}

		try {
			os = new ObjectOutputStream(fos);
			os.writeObject(gs.getSport());
			os.writeObject(squadre);
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Errore in oos");
		}

	}

	/**
	 * 
	 * @param pathFile percorso verso il file contenente le squadre
	 * @param gs       @see GestioneSquadre
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void deserializza(File pathFile, GestioneSquadre gs) throws ClassNotFoundException {

		squadre = new ArrayList<Squadra>();

		try {
			fis = new FileInputStream(pathFile);
			if (!pathFile.toString().contains(gs.getSport().toString())) {
				JOptionPane.showMessageDialog(new JFrame(), "Impossibile caricare le squadre", "Errore",
						JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
		} catch (IOException e) {
			System.out.println("Errore in fis");
		}

		try {
			is = new ObjectInputStream(fis);
			Object sport = is.readObject();
			if (!(gs.getSport().toString().equals(sport.toString()))) {
				throw new InputMismatchException("Le squadre non sono dello sport " + gs.getSport().toString());
			}
			squadre = (ArrayList<Squadra>) is.readObject();
			is.close();

			for (Squadra squadra : squadre) {
				gs.aggiungiSqd(squadra);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
