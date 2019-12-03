package sport;

import javax.swing.JComboBox;

import calendario.Partita;
import squadre.Squadra;

/**
 * Classe astratta che definisce i metodi utili per ogni sport implementato.
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public abstract class Sport {

	/**
	 * Metodo utilizzato per verificare se la squadra in quella giornata sta
	 * riposando.
	 * 
	 * @param sqd1
	 * @param sqd2
	 * @return Vero: se la squadra riposa, falso altrimenti.
	 */
	protected boolean checkRiposo(Squadra sqd1, Squadra sqd2) {
		return (sqd1 == null || sqd2 == null);
	}

	/**
	 * Metodo utilizzato per assegnare i punti ad una squadra.
	 * 
	 * @param p          partita di cui vogliamo settare/resettare il punteggio
	 * @param rstPartita specifica se stiamo settando/resettando il punteggio
	 */
	public abstract void setPunteggio(Partita partita, boolean rstPartita);

	/**
	 * Metodo utilizzato per assegnare il risultato di una squadra.
	 * 
	 * @return Massimo numero di gol/set/punti effettuabili da una squadra.
	 * @see JComboBox
	 */
	public abstract int maxPunteggio();
}
