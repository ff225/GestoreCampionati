package squadre;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import calendario.Partita;
import sport.Calcio;
import sport.Rugby;
import sport.Sport;
import sport.Volley;

/**
 * <h1>Classe che implementa la gestione delle squadre.</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */

public class GestioneSquadre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Squadra> squadre;
	private TipoSport ts;
	private Sport sport;

	/**
	 * Inizializza la struttura dati e lo sport scelto.
	 * 
	 * @param ts {@link TipoSport}
	 */
	public GestioneSquadre(TipoSport ts) {
		// TODO Auto-generated constructor stub
		squadre = new HashMap<String, Squadra>();
		this.ts = ts;
		setSport();
	}

	/**
	 * Inizializza il tipo di sport che vogliamo gestire.
	 * 
	 * @param ts tipo di sport scelto.
	 */
	private void setSport() {
		switch (ts) {
		case CALCIO:
			sport = new Calcio();
			break;
		case VOLLEY:
			sport = new Volley();
			break;
		case RUGBY:
			sport = new Rugby();
			break;
		}
	}

	/**
	 * Metodo utilizzato per conoscere lo sport che stiamo gestendo.
	 * 
	 * @return @see Sport scelto.
	 */
	public TipoSport getSport() {
		return ts;
	}

	/**
	 * Aggiunge una squadra al campionato.
	 * 
	 * @param sqd la squadra che vogliamo aggiungere.
	 * @return Vero se la squadra e' stata inserita correttamente, falso altrimenti.
	 */
	public boolean aggiungiSqd(Squadra sqd) {
		if (squadre.containsKey(sqd.getNomeSqd()))
			return false;
		squadre.put(sqd.getNomeSqd(), sqd);
		return true;
	}

	/**
	 * Rimuove la squadra dal campionato.
	 * 
	 * @param nomeSqd nome squadra che vogliamo rimuovere.
	 * @return Vero se la squadra e' stata rimossa correttamente, falso altrimenti.
	 */
	public boolean rimuoviSqd(String nomeSqd) {
		if (!squadre.containsKey(nomeSqd))
			return false;
		squadre.remove(nomeSqd);
		return true;
	}

	/**
	 * Modifica le informazioni inserite per una squadra.
	 * 
	 * @param nomeSqd nome della squadra che vogliamo modificare.
	 * @param sqd     nuove informazioni.
	 * @return Squadra modificata.
	 */
	public boolean modificaSqd(String nomeSqd, Squadra sqd) {

		System.out.println("Modifca sqd: " + nomeSqd + " " + sqd.getNomeSqd());

		if (nomeSqd.equals(sqd.getNomeSqd())) {
			squadre.replace(sqd.getNomeSqd(), sqd);
			return true;
		} else if (squadre.containsKey(sqd.getNomeSqd()))
			return false;

		rimuoviSqd(nomeSqd);
		return aggiungiSqd(sqd);

	}

	/**
	 * Metodo che restituisce il numero di squadre inserite nel campionato.
	 * 
	 * @return Numero di squadre inserite
	 */
	public int getSize() {
		return squadre.size();
	}

	public Collection<Squadra> getAll() {
		return squadre.values();
	}

	/**
	 * Metodo che cerca una squadra dato il suo nome come parametro.
	 * 
	 * @param nomeSqd nome squadra che stiamo cercando.
	 * @return Se presente, restituisce le informazioni sulla squadra.
	 */
	public Squadra cercaSquadra(String nomeSqd) {
		return squadre.get(nomeSqd);
	}

	/**
	 * Metodo che assegna i punti ad una squadra.
	 * 
	 * @param partita    la partita di cui vogliamo settare/resettare i punti.
	 * @param rstPartita definisce se stiamo settando/resettando il punteggio di una
	 *                   partita.
	 */
	public void setPunti(Partita partita, boolean rstPartita) {
		sport.setPunteggio(partita, rstPartita);

	}

	/**
	 * Metodo che restituisce il numero di gol/set/punti possibili in una partita.
	 * 
	 * @return Numero massimo di gol/set/punti possibili in una partita.
	 */
	public int getMaxRisultato() {
		return sport.maxPunteggio();
	}

}
