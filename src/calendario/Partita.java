package calendario;

import java.io.Serializable;

import squadre.Squadra;

/**
 * Classe che implementa i metodi per gestire una partita.
 * 
 * @author Francesco Franco
 *
 */
public class Partita implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Squadra casa;
	private Squadra trasferta;
	private Risultato risultato;

	/**
	 * Metodo costruttore.
	 * 
	 * @param sqd1 squadra1 della partita.
	 * @param sqd2 squadra2 della partita.
	 * @see Squadra
	 */
	public Partita(Squadra sqd1, Squadra sqd2) {
		// TODO Auto-generated constructor stub
		this.setCasa(sqd1);
		this.setTrasferta(sqd2);
	}

	/**
	 * Metodo per conoscere la squadra che gioca in casa.
	 * 
	 * @return Squadra che gioca in casa
	 * @see Squadra
	 */
	public Squadra getCasa() {
		return casa;
	}

	/**
	 * Metodo che imposta la squadra che gioca in casa.
	 * 
	 * @param casa squadra in casa.
	 * @see Squadra
	 */
	public void setCasa(Squadra casa) {
		this.casa = casa;
	}

	/**
	 * Metodo per conoscere la squadra che gioca in trasferta.
	 * 
	 * @return Squadra che gioca in trasferta.
	 * @see Squadra
	 */
	public Squadra getTrasferta() {
		return trasferta;
	}

	/**
	 * Metodo che imposta la squadra che gioca in trasferta.
	 * 
	 * @param trasferta squadra in trasferta.
	 * @see Squadra
	 */
	public void setTrasferta(Squadra trasferta) {
		this.trasferta = trasferta;
	}

	/**
	 * Metodo utile per conoscere l'esito di una partita.
	 * 
	 * @return l'esito della partita.
	 * @see Risultato
	 */
	public int getEsito() {
		if (risultato == null)
			return -1;
		return risultato.esito();
	}

	/**
	 * Metodo per impostare il risultato in una partita.
	 * 
	 * @param rCasa     risultato squadra casa.
	 * @param rTrasf    risultato squadra trasferta.
	 * @param isDefault boolean per conoscere se stiamo settando/resettando il
	 *                  risultato.
	 * @see Risultato
	 */
	public void setRisulato(int rCasa, int rTrasf, boolean isDefault) {
		risultato = new Risultato(rCasa, rTrasf, isDefault);
	}

	/**
	 * Metodo che ritorna il risultato di una partita.
	 * 
	 * @return Risultato partita.
	 * @see Risultato
	 */
	public Risultato getRisultato() {
		return risultato;
	}

	/**
	 * Metodo utilizzato per resettare il risultato delle partite.
	 * 
	 * @see Risultato
	 */
	public void resetPartite() {
		risultato = null;
		casa.setPunti(-1, true);
		trasferta.setPunti(-1, true);
	}

}
