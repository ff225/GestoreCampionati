package gui;

import java.io.File;

import javax.swing.JFrame;

import calendario.Calendario;
import squadre.GestioneSquadre;
import java.awt.Dialog.ModalExclusionType;


public class FrameProgressBar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameProgressBar(File pathSquadre, File pathCampionato, GestioneSquadre gs, Calendario cal) {
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Caricamento...");
		setSize(195, 99);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new PanelProgressBar(this, pathSquadre, pathCampionato, gs, cal));
		setLocationRelativeTo(null);
		pack();

		setVisible(true);
	}

}
