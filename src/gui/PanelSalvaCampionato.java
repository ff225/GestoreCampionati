package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calendario.Calendario;
import calendario.SalvaCaricaCampionato;
import squadre.GestioneSquadre;

public class PanelSalvaCampionato extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeFile;
	private JButton btnConferma;
	private JButton btnAnnulla;
	private Calendario cal;
	private FrameSalvaCampionato fsc;
	private GestioneSquadre gs;

	public PanelSalvaCampionato(FrameSalvaCampionato frameSalvaCampionato, Calendario cal, GestioneSquadre gs) {
		// TODO Auto-generated constructor stub

		this.fsc = frameSalvaCampionato;
		this.cal = cal;
		this.gs = gs;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblSalvaConNome = new JLabel("Salva con nome: ");
		GridBagConstraints gbc_lblSalvaConNome = new GridBagConstraints();
		gbc_lblSalvaConNome.anchor = GridBagConstraints.EAST;
		gbc_lblSalvaConNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalvaConNome.gridx = 1;
		gbc_lblSalvaConNome.gridy = 1;
		add(lblSalvaConNome, gbc_lblSalvaConNome);

		nomeFile = new JTextField();
		GridBagConstraints gbc_nomeFile = new GridBagConstraints();
		gbc_nomeFile.insets = new Insets(0, 0, 5, 5);
		gbc_nomeFile.gridx = 2;
		gbc_nomeFile.gridy = 1;
		add(nomeFile, gbc_nomeFile);
		nomeFile.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 2;
		add(verticalStrut, gbc_verticalStrut);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 2;
		add(btnAnnulla, gbc_btnAnnulla);

		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConferma.gridx = 2;
		gbc_btnConferma.gridy = 2;
		add(btnConferma, gbc_btnConferma);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 3;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 3;
		gbc_verticalStrut_1.gridy = 0;
		add(verticalStrut_1, gbc_verticalStrut_1);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 3;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object pulsante = e.getSource();

		if (pulsante == btnConferma && nomeFile.getText().isEmpty())
			JOptionPane.showMessageDialog(new JFrame(), "Inserisci nome del file", "Errore!",
					JOptionPane.ERROR_MESSAGE);
		else {
			SalvaCaricaCampionato scc = new SalvaCaricaCampionato();
			scc.serializzazione(nomeFile.getText(), gs.getSport().toString(), cal, gs);
			fsc.dispose();
		}

		if (pulsante == btnAnnulla)
			fsc.dispose();
	}
}
