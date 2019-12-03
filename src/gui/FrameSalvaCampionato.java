package gui;

import java.awt.Toolkit;
//import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;

import calendario.Calendario;
import squadre.GestioneSquadre;

public class FrameSalvaCampionato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameSalvaCampionato(Calendario cal, GestioneSquadre gs) {
		// TODO Auto-generated constructor stub

		//setModalExclusionType(ModalExclusionType.);
		setAlwaysOnTop(true);
		setTitle("Salva");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrameSalva.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		add(new PanelSalvaCampionato(this, cal, gs));
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
	}
}
