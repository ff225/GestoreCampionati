package calendario;

import java.io.Serializable;

import sport.Calcio;
import sport.Rugby;
import sport.Sport;
import sport.Volley;

/**
 * Classe che implementa i metodi utili per settare il risultato di una partita.
 * 
 * @author Francesco Franco
 * @see Partita
 */
public class Risultato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int esitoCasa;
	private int esitoTrasf;
	private boolean isDefault;

	/**
	 * Metodo costruttore.
	 * 
	 * @param eCasa     esito squadra casa.
	 * @param eTrasf    esito squadra trasferta.
	 * @param isDefault valore boolean per conoscere se stiamo settando/resettando
	 *                  il risultato della partita.
	 */
	public Risultato(int eCasa, int eTrasf, boolean isDefault) {
		// TODO Auto-generated constructor stub
		setEsitoCasa(eCasa);
		setEsitoTrasf(eTrasf);
		setIsDefault(isDefault);
	}

	/**
	 * Metodo utile per conoscere l'esito della squadra in casa.
	 * 
	 * @return Esito squadra in casa.
	 */
	public int getEsitoCasa() {
		return esitoCasa;
	}

	/**
	 * Imposta l'esito della squadra in casa.
	 * 
	 * @param esitoCasa numero di gol/set/punti.
	 */
	public void setEsitoCasa(int esitoCasa) {
		this.esitoCasa = esitoCasa;
	}

	/**
	 * Metodo utile per conoscere l'esito della squadra in trasferta.
	 * 
	 * @return Esito della squadra in trasferta.
	 */
	public int getEsitoTrasf() {
		return esitoTrasf;
	}

	/**
	 * Imposta l'esito della squadra in trasferta.
	 * 
	 * @param esitoTrasf numero di gol/set/punti.
	 */
	public void setEsitoTrasf(int esitoTrasf) {
		this.esitoTrasf = esitoTrasf;
	}

	/**
	 * Imposta se il risultato inserito e' quello di default o dell'utente.
	 * 
	 * @param isDefault
	 */
	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * Metodo per conoscere se il risultato e' di default.
	 * 
	 * @return Vero: il risultato e' di default, falso: il risultato e' stato
	 *         inserito dall'utente.
	 */
	public boolean getIsDefault() {
		return isDefault;
	}

	/**
	 * Imposta l'esito della partita.
	 * 
	 * @return Case utile per l'assegnazione dei punteggi.
	 * @see Sport
	 * @see Calcio
	 * @see Volley
	 * @see Rugby
	 */
	public int esito() {
		if (esitoCasa > esitoTrasf)
			return 1;
		if (esitoCasa < esitoTrasf)
			return 2;
		return 3;
	}

}
