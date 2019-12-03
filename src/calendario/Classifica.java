package calendario;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import squadre.GestioneSquadre;
import squadre.Squadra;

/**
 * Classe che implementa la creazione e la stampa della classifica.
 * 
 * @author Francesco Franco
 *
 */
public class Classifica implements Comparable<Squadra> {

	private ArrayList<Squadra> squadre;

	/**
	 * Metodo costruttore.
	 * 
	 * @param gs
	 * 
	 */
	public Classifica(GestioneSquadre gs) {
		// TODO Auto-generated constructor stub

		squadre = new ArrayList<Squadra>(gs.getAll());
	}

	/**
	 * Metodo utile per generare la classifica.
	 * 
	 * @see Comparable
	 */
	public void generaClassifica() {
		squadre.sort(Comparator.comparing(Squadra::getPunti).reversed());
	}

	/**
	 * Metodo che stampa la classifica.
	 * 
	 * @param model implementazione della tabella.
	 * @param table tabella vera e propria.
	 */
	public void stampaClassifica(DefaultTableModel model, JTable table) {
		int i = 1;
		for (Squadra squadra : squadre) {
			//System.out.println(squadra.getNomeSqd() + " " + squadra.getPunti());
			model.addRow(new Object[] { i + ")", squadra.getNomeSqd(), squadra.getPunti() });
			i++;
		}
	}

	@Override
	public int compareTo(Squadra o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
