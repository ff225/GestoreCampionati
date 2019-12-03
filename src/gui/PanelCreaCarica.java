package gui;

import javax.swing.JPanel;

import calendario.Calendario;
import squadre.GestioneSquadre;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

import javax.swing.Box;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class PanelCreaCarica extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnCreaCampionato;
	private JButton btnCaricaSquadre;
	private JButton btnCaricaCampionato;
	private FrameCreaCarica fcc;
	private GestioneSquadre gs;
	private Calendario cal;

	public PanelCreaCarica(FrameCreaCarica fcc, GestioneSquadre gs) {

		this.fcc = fcc;
		this.gs = gs;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 1;
		gbc_horizontalStrut_2.gridy = 0;
		add(horizontalStrut_2, gbc_horizontalStrut_2);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 2;
		add(horizontalStrut_1, gbc_horizontalStrut_1);

		btnCreaCampionato = new JButton("Crea campionato");
		btnCreaCampionato.addActionListener(this);
		GridBagConstraints gbc_btnCreaCampionato = new GridBagConstraints();
		gbc_btnCreaCampionato.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreaCampionato.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreaCampionato.gridx = 1;
		gbc_btnCreaCampionato.gridy = 3;
		add(btnCreaCampionato, gbc_btnCreaCampionato);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridheight = 5;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		btnCaricaSquadre = new JButton("Carica squadre");
		btnCaricaSquadre.addActionListener(this);
		GridBagConstraints gbc_btnCaricaSquadre = new GridBagConstraints();
		gbc_btnCaricaSquadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCaricaSquadre.insets = new Insets(0, 0, 5, 5);
		gbc_btnCaricaSquadre.gridx = 1;
		gbc_btnCaricaSquadre.gridy = 4;
		add(btnCaricaSquadre, gbc_btnCaricaSquadre);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 6;
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);

		btnCaricaCampionato = new JButton("Carica campionato");
		btnCaricaCampionato.addActionListener(this);
		GridBagConstraints gbc_btnCaricaCampionato = new GridBagConstraints();
		gbc_btnCaricaCampionato.insets = new Insets(0, 0, 5, 5);
		gbc_btnCaricaCampionato.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCaricaCampionato.gridx = 1;
		gbc_btnCaricaCampionato.gridy = 5;
		add(btnCaricaCampionato, gbc_btnCaricaCampionato);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 6;
		add(horizontalStrut, gbc_horizontalStrut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pulsantePremuto = e.getActionCommand();

		switch (pulsantePremuto) {
		case "Crea campionato":
			new FrameCreaCampionato(gs.getSport().toString(), gs);
			fcc.dispose();
			break;
		case "Carica squadre":
			File pathSquadra = null;
			String getDir = System.getProperty("user.dir");
			getDir = getDir.replace("/bin", "");
			// System.out.println(getDir);
			final File pathDirectory = new File(getDir + "/Sport/" + gs.getSport().toString() + "/Squadre/");
			// System.out.println(pathDirectory.toString());
			JFileChooser fc = new JFileChooser(pathDirectory);

			int returnVal = fc.showOpenDialog(PanelCreaCarica.this);
			if (returnVal == JFileChooser.APPROVE_OPTION)
				pathSquadra = fc.getSelectedFile();

			if (pathSquadra != null) {
				new FrameProgressBar(pathSquadra, null, gs, null);
				fcc.dispose();
			}

			break;
		case "Carica campionato": {
			File pathCampionato = null;
			String getHome = System.getProperty("user.dir");
			getHome = getHome.replace("/bin", "");
			// System.out.println(getHome);
			final File pathDirectory1 = new File(getHome + "/Sport/" + gs.getSport().toString() + "/Campionati/");
			// System.out.println(pathDirectory1.toString());
			JFileChooser fc1 = new JFileChooser(pathDirectory1);

			int returnVal1 = fc1.showOpenDialog(PanelCreaCarica.this);
			if (returnVal1 == JFileChooser.APPROVE_OPTION) {
				pathCampionato = fc1.getSelectedFile();
			}

			if (pathCampionato != null) {
				new FrameProgressBar(null, pathCampionato, gs, cal);
				fcc.dispose();

			}
		}
			break;

		default:
			System.exit(-1);

		}

	}

}
