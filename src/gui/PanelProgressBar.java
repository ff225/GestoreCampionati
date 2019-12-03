package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JProgressBar;

import calendario.Calendario;
import squadre.GestioneSquadre;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;

public class PanelProgressBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Worker wk;
	private FrameProgressBar fpb;
	private JProgressBar jpb;
	private File pathSquadre, pathCampionato;
	private GestioneSquadre gs;
	private Calendario cal;

	public PanelProgressBar(FrameProgressBar fpb, File pathSquadre, File pathCampionato, GestioneSquadre gs,
			Calendario cal) {
		this.fpb = fpb;
		this.pathSquadre = pathSquadre;
		this.pathCampionato = pathCampionato;
		this.gs = gs;
		this.cal = cal;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JProgressBar progressBar = new JProgressBar();
		jpb = progressBar;
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.ipadx = 2;
		gbc_progressBar.gridheight = 2;
		gbc_progressBar.gridwidth = 5;
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 0;
		add(progressBar, gbc_progressBar);

		carica();
	}

	private void carica() {
		MonitorProgresso monitor = new MonitorProgresso(jpb);
		wk = new Worker(fpb, pathSquadre, pathCampionato, gs, cal);
		wk.addPropertyChangeListener(monitor);
		wk.execute();

	}
}
