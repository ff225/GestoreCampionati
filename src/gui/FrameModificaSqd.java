package gui;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import squadre.GestioneSquadre;

public class FrameModificaSqd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameModificaSqd(GestioneSquadre gs, JTextField numSqdInserite, int riga, DefaultTableModel model) {
		// TODO Auto-generated constructor stub

		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Modifica squadra");
		add(new PanelModificaSqd(this, gs, numSqdInserite, riga, model));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
