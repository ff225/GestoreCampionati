package sport;

import javax.swing.JComboBox;
import calendario.Partita;
import squadre.Squadra;

/**
 * <h1>Estende la classe {@link Sport} definisce i metodi utili per gestire un
 * campionato di Calcio.</h1>
 * 
 * @version 1.0
 * @author Francesco Franco
 *
 */
public class Calcio extends Sport {

	public Calcio() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Metodo utilizzato per assegnare i punti ad una squadra.
	 * 
	 * <br>
	 * Data una partita:</br>
	 * <br>
	 * <h1>case 1:</h1> Vittoria a squadra casa. </br>
	 * <br>
	 * <h1>case 2:</h1> Vittoria a casa trasferta.</br>
	 * <br>
	 * <h1>case 3:</h1> Pareggio.</br>
	 * 
	 * @param p: partita di cui vogliamo settare/resettare il punteggio.
	 * @param rstPartita: specifica se stiamo settando/resettando il punteggio.
	 */
	@Override
	public void setPunteggio(Partita p, boolean rstPartita) {
		// TODO Auto-generated method stub
		// Squadra casa = gs.cercaSquadra(cal.getPartita(g, p).getCasa().getNomeSqd());
		// Squadra trasf = gs.cercaSquadra(cal.getPartita(g,
		// p).getTrasferta().getNomeSqd());

		// System.out.println("valore rPunteggio: " + rPunteggio);
		// System.out
		//System.out.println("esito partita: " + p.getEsito());
		if (checkRiposo(p.getCasa(), p.getTrasferta()))
			return;
		Squadra casa = p.getCasa();
		Squadra trasferta = p.getTrasferta();
		switch (p.getEsito()) {

		case 1:
			casa.setPunti(3, rstPartita);

			casa.setVittoria(rstPartita);
			trasferta.setSconfitta(rstPartita);
			// System.out.println(gs.cercaSquadra(casa.getNomeSqd()).getPunti());
			break;
		case 2:

			trasferta.setPunti(3, rstPartita);

			casa.setSconfitta(rstPartita);
			trasferta.setVittoria(rstPartita);

			break;
		case 3:
			casa.setPunti(1, rstPartita);
			trasferta.setPunti(1, rstPartita);

			casa.setPareggio(rstPartita);
			trasferta.setPareggio(rstPartita);
			break;
		}
	}

	/**
	 * Definisce il numero massimo di gol.
	 * 
	 * @return Massimo numero di gol effettuabili da una squadra.
	 * @see JComboBox
	 */
	@Override
	public int maxPunteggio() {
		// TODO Auto-generated method stub
		return 20;
	}

}
