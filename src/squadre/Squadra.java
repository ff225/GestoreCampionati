package squadre;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * <h1>Classe che implementa la struttura dati di una squadra.</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public class Squadra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeSqd;
	private String cittaSqd;
	private int punti;
	private int[] esito;
	private ImageIcon icona;

	/**
	 * Inizializza una nuova squadra.
	 * 
	 * @param nomeSqd   Nome squadra.
	 * @param cittaSqd  Provenienza squadra.
	 * @param imageIcon Simbolo della squadra.
	 */
	public Squadra(String nomeSqd, String cittaSqd, ImageIcon imageIcon) {
		// TODO Auto-generated constructor stub
		this.setNomeSqd(nomeSqd);
		this.setCittaSqd(cittaSqd);
		this.punti = 0;
		/**
		 *
		 * esito[0] = numero vittorie; esito[1] = numero pareggi; esito[2] = numero
		 * sconfitte;
		 * 
		 */
		this.esito = new int[3];
		this.esito[0] = 0;
		this.esito[1] = 0;
		this.esito[2] = 0;
		this.icona = imageIcon;
	}

	/**
	 * Metodo utilizzato per conoscere il nome della squadra.
	 * 
	 * @return Nome della squadra.
	 */
	public String getNomeSqd() {
		return nomeSqd;
	}

	/**
	 * Metodo utilizzato per settare il nome della squadra.
	 * 
	 * @param nomeSqd Nome squadra.
	 */
	public void setNomeSqd(String nomeSqd) {
		this.nomeSqd = nomeSqd;
	}

	/**
	 * Metodo utilizzato per conoscere la provenienza della squadra.
	 * 
	 * @return Provenienza squadra.
	 */
	public String getCittaSqd() {
		return cittaSqd;
	}

	/**
	 * Metodo utilizzato per settare la provenienza della squadra.
	 * 
	 * @param cittaSqd Nome della citta'.
	 */
	public void setCittaSqd(String cittaSqd) {
		this.cittaSqd = cittaSqd;
	}

	/**
	 * Metodo che restituisce l'icona assegnata ad una squadra.
	 * 
	 * @return Icona assegnata.
	 * @see ImageIcon
	 */
	public ImageIcon getIcona() {
		return icona;
	}

	/**
	 * Metodo che restituisce il numero di punti di una squadra.
	 * 
	 * @return Numero di punti.
	 */
	public int getPunti() {
		return punti;
	}

	/**
	 * Metodo utilizzato per incrementare/decrementare il numero di vittorie di una
	 * squadra.
	 * 
	 * @param rstPartita specifica se stiamo incrementando/decrementando il numero
	 *                   di vittorie.
	 */
	public void setVittoria(boolean rstPartita) {
		if (rstPartita)
			esito[0] -= 1;
		else
			esito[0] += 1;
	}

	/**
	 * Metodo utilizzato per incrementare/decrementare il numero di pareggi di una
	 * squadra.
	 * 
	 * @param rstPartita specifica se stiamo incrementando/decrementando il numero
	 *                   di pareggi.
	 */
	public void setPareggio(boolean rstPartita) {
		if (rstPartita)
			esito[1] -= 1;
		else
			esito[1] += 1;
	}

	/**
	 * Metodo utilizato per incrementare/decrementare il numero di sconfitte di una
	 * squadra.
	 * 
	 * @param rstPartita specifica se stiamo incrementando/decrementando il numero
	 *                   di sconfitte.
	 */
	public void setSconfitta(boolean rstPartita) {
		if (rstPartita)
			esito[2] -= 1;
		else
			esito[2] += 1;
	}

	/**
	 * Metodo utilizzato per conoscere il numero di vittore una squadra.
	 * 
	 * @return Numero di vittorie.
	 */
	public int getVittoria() {
		return esito[0];
	}

	/**
	 * Metodo utilizzato per conoscere il numero di pareggi di una squadra.
	 * 
	 * @return Numero di pareggi.
	 */
	public int getPareggio() {
		return esito[1];
	}

	/**
	 * Metodo utilizzato per conoscere il numero di sconfitte di una squadra.
	 * 
	 * @return Numero di sconfitte.
	 */
	public int getSconfitta() {
		return esito[2];
	}

	/**
	 * Metodo utilizzato per assegnare i punti.
	 * 
	 * @param punti      da assegnare/togliere.
	 * @param rstPartita specifica se stiamo assegnando o togliendo punti.
	 */
	public void setPunti(int punti, boolean rstPartita) {
		if (punti == -1) {
			this.punti = 0;
			esito[0] = 0;
			esito[1] = 0;
			esito[2] = 0;
			return;
		}
		if (rstPartita)
			this.punti -= punti;
		else
			this.punti += punti;
	}

	/**
	 * Metodo utilizzato per resettare i punti assegnati in una data partita.
	 * 
	 * @param punti da togliere ad una squadra.
	 */
	public void resetPunti(int punti) {
		this.punti -= punti;
	}

}
