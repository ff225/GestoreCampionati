package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import squadre.GestioneSquadre;
import java.awt.Dialog.ModalExclusionType;

public class FrameAggiungiSqd extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameAggiungiSqd(GestioneSquadre gs, JTextField numSqd, DefaultTableModel model) {

		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Aggiungi squadra");
		setResizable(false);
		add(new PanelAggiungiSquadra(this, gs, numSqd, model));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

}
