package sport;

import javax.swing.JComboBox;

import calendario.Partita;
import squadre.Squadra;

/**
 * <h1>Estende la classe {@link Sport} definisce i metodi utili per gestire un
 * campionato di Rugby.</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public class Rugby extends Sport {

	public Rugby() {
		// TODO Auto-generated constructor stub

		super();
	}

	/**
	 * Metodo utilizzato per assegnare i punti ad una squadra. <br>
	 * Data una partita:</br>
	 * <br>
	 * <h1>case 1:</h1> Vittoria a squadra casa</br>
	 * <br>
	 * <h1>case 2:</h1> Vittoria a casa trasferta</br>
	 * <br>
	 * <h1>case 3:</h1> Pareggio</br>
	 * 
	 * @param p          partita di cui vogliamo settare/resettare il punteggio.
	 * @param rstPartita specifica se stiamo settando/resettando il punteggio.
	 */
	@Override
	public void setPunteggio(Partita p, boolean rstPartita) {
		// TODO Auto-generated method stub
		int pc = p.getRisultato().getEsitoCasa();
		int pt = p.getRisultato().getEsitoTrasf();
		Squadra casa = p.getCasa();
		Squadra trasferta = p.getTrasferta();

		switch (p.getEsito()) {
		case 1:
			casa.setPunti(4, rstPartita);
			if ((pc - pt) < 8)
				trasferta.setPunti(1, rstPartita);

			casa.setVittoria(rstPartita);
			trasferta.setSconfitta(rstPartita);
			break;
		case 2:
			trasferta.setPunti(4, rstPartita);
			if ((pt - pc) < 8)
				casa.setPunti(1, rstPartita);

			casa.setSconfitta(rstPartita);
			trasferta.setVittoria(rstPartita);
			break;
		case 3:
			casa.setPunti(2, rstPartita);
			trasferta.setPunti(2, rstPartita);

			casa.setPareggio(rstPartita);
			trasferta.setPareggio(rstPartita);
		}

	}

	/**
	 * Definisce il numero massimo di punti.
	 * 
	 * @return Massimo numero di punti effettuabili da una squadra.
	 * @see JComboBox
	 */
	@Override
	public int maxPunteggio() {
		// TODO Auto-generated method stub
		return 100;
	}

}
