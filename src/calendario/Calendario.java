package calendario;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import squadre.Squadra;
import squadre.GestioneSquadre;

/**
 * Classe che implementa la creazione del calendario.
 * 
 * @author Francesco Franco
 *
 */
public class Calendario {
	private ArrayList<Squadra> squadre;
	private ArrayList<Partita[]> giornate;
	private int num_giornate;
	private int numero_squadre;

	/**
	 * Metodo costruttore. Inizializza l'ArrayList di squadre.
	 * 
	 * @param gs
	 * 
	 */
	public Calendario(GestioneSquadre gs) {
		// TODO Auto-generated constructor stub
		squadre = new ArrayList<Squadra>(gs.getAll());
		if (squadre.size() % 2 != 0) {
			File pathFoto = new File("Loghi/Default/default_logo" + gs.getSport().toString() + ".jpg");
			ImageIcon icona = new ImageIcon(pathFoto.toString());
			squadre.add(new Squadra(" ", " ", icona));
		}
		num_giornate = (squadre.size() - 1);
		numero_squadre = squadre.size();
		giornate = new ArrayList<Partita[]>(num_giornate);
		//System.out.println("Inizializzato");
	}

	/**
	 * Procedura che costruisce le giornate del campionato.
	 */
	public void AlgoritmoDiBerger() {

		/**
		 * Crea gli array per le due liste in casa e fuori.
		 */
		Squadra[] casa = new Squadra[numero_squadre / 2];
		Squadra[] trasferta = new Squadra[numero_squadre / 2];

		for (int i = 0; i < num_giornate; i++)
			giornate.add(new Partita[numero_squadre / 2]);

		for (int i = 0; i < numero_squadre / 2; i++) {
			casa[i] = squadre.get(i);
			trasferta[i] = squadre.get(numero_squadre - 1 - i);
		}

		for (int i = 0; i < num_giornate; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < numero_squadre / 2; j++)
					giornate.get(i)[j] = new Partita(casa[j], trasferta[j]);
			} else {
				for (int j = 0; j < numero_squadre / 2; j++)
					giornate.get(i)[j] = new Partita(trasferta[j], casa[j]);
			}
			Squadra pivot = casa[0];
			Squadra riporto = trasferta[trasferta.length - 1];

			trasferta = shiftRight(trasferta, casa[1]);
			casa = shiftLeft(casa, riporto);
			casa[0] = pivot;
		}

		Collections.shuffle(giornate);

		for (int i = 0; i < num_giornate; i++) {
			giornate.add(new Partita[numero_squadre / 2]);

			for (int j = 0; j < numero_squadre / 2; j++) {
				giornate.get((i + num_giornate))[j] = new Partita(giornate.get(i)[j].getTrasferta(),
						giornate.get(i)[j].getCasa());
			}
		}

	}

	/**
	 * Funzione utile per AlgoritmodiBerger
	 */
	private Squadra[] shiftLeft(Squadra[] data, Squadra add) {
		Squadra[] temp = new Squadra[data.length];
		for (int i = 0; i < data.length - 1; i++)
			temp[i] = data[i + 1];

		temp[data.length - 1] = add;
		return temp;
	}

	/**
	 * Funzione utile per AlgoritmodiBerger
	 */
	private Squadra[] shiftRight(Squadra[] data, Squadra add) {
		Squadra[] temp = new Squadra[data.length];
		for (int i = 1; i < data.length; i++) {
			temp[i] = data[i - 1];
		}
		temp[0] = add;
		return temp;
	}

	/**
	 * Metodo utile costruire il campionato quando caricato da file.
	 * 
	 * @param p        partita che vogliamo inserire.
	 * @param giornata che vogliamo modificare.
	 * @param partita  che vogliamo modificare.
	 */
	public void setPartita(Partita p, int giornata, int partita) {
		giornate.get(giornata)[partita] = p;
	}

	/**
	 * Funzione che imposta il numero di giornate del campionato.
	 * 
	 * @param giornate numero di giornate.
	 * @return il numero di giornate del campionato.
	 */
	public int setGiornate(int giornate) {
		return this.num_giornate = giornate;
	}

	/**
	 * Funzione che ritorna la partita selezionata.
	 * 
	 * @param giornata di campionato.
	 * @param partita  della giornata di campionato.
	 * @return Partita selezionata.
	 */
	public Partita getPartita(int giornata, int partita) {
		return giornate.get(giornata)[partita];
	}

	/**
	 * Funzione che ritorna il numero di giornate di campionato.
	 * 
	 * @return il numero di giornate di un campionato.
	 */
	public int getGiornate() {
		return giornate.size();
	}

	/**
	 * Funzione che ritorna il numero di partite di una giornata.
	 * 
	 * @return Numero di partite di una giornata.
	 */
	public int getNumPartite() {
		return numero_squadre / 2;
	}

	/**
	 * Metodo che cancella tutti i risultati inseriti.
	 * 
	 * @see Partita
	 */
	public void resetCalendario() {
		for (int i = 0; i < num_giornate; i++)
			for (int j = 0; j < numero_squadre / 2; j++)
				giornate.get(i)[j].resetPartite();
	}

}
