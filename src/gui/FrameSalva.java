package gui;

import javax.swing.JFrame;

import squadre.GestioneSquadre;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class FrameSalva extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FrameSalva(GestioneSquadre gs) {

		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setTitle("Salva");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrameSalva.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		add(new PanelSalva(this, gs));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
	}

}
