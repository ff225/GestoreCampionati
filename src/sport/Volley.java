package sport;

import javax.swing.JComboBox;

import calendario.Partita;
import squadre.Squadra;

/**
 * <h1>Estende la classe {@link Sport} definisce i metodi utili per gestire un
 * campionato di Volley.</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public class Volley extends Sport {

	public Volley() {
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
	 *
	 * @param p          partita di cui vogliamo settare/resettare il punteggio.
	 * @param rstPartita specifica se stiamo settando/resettando il punteggio.
	 */
	@Override
	public void setPunteggio(Partita p, boolean rstPartita) {
		// TODO Auto-generated method stub
		if (checkRiposo(p.getCasa(), p.getTrasferta()))
			return;
		Squadra casa = p.getCasa();
		Squadra trasferta = p.getTrasferta();
		switch (p.getEsito()) {
		case 1:
			if (p.getRisultato().getEsitoTrasf() == 2) {
				casa.setPunti(2, rstPartita);
				trasferta.setPunti(1, rstPartita);
			} else
				casa.setPunti(3, rstPartita);

			casa.setVittoria(rstPartita);
			trasferta.setSconfitta(rstPartita);
			// System.out.println(gs.cercaSquadra(casa.getNomeSqd()).getPunti());
			break;
		case 2:
			if (p.getRisultato().getEsitoCasa() == 2) {
				trasferta.setPunti(2, rstPartita);
				casa.setPunti(1, rstPartita);
			} else
				trasferta.setPunti(3, rstPartita);

			casa.setSconfitta(rstPartita);
			trasferta.setVittoria(rstPartita);
			break;
		}

	}

	/**
	 * Definisce il massimo numero di set.
	 * 
	 * @return Massimo numero di set effettuabili da una squadra.
	 * @see JComboBox
	 */
	@Override
	public int maxPunteggio() {
		// TODO Auto-generated method stub
		return 3;
	}

}
