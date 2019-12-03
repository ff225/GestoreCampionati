package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import calendario.Calendario;
import squadre.GestioneSquadre;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class PanelAggiungiRisultato extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrameAggiungiRisultato far;
	private GestioneSquadre gs;
	private Calendario cal;
	private DefaultTableModel model;
	private int riga;
	private int giornata;
	private int partita;
	private JComboBox<Integer> comboBoxCasa;
	private JComboBox<Integer> comboBoxTrasf;
	private JButton btnConferma;
	private JButton btnAnnulla;

	public PanelAggiungiRisultato(FrameAggiungiRisultato far, Calendario cal, GestioneSquadre gs, int riga,
			DefaultTableModel model) {
		// TODO Auto-generated constructor stub

		this.far = far;
		this.cal = cal;
		this.gs = gs;
		this.model = model;
		this.riga = riga;
		giornata = (int) model.getValueAt(riga, 0) - 1;
		partita = (int) model.getValueAt(riga, 1) - 1;
		GridBagLayout gridBagLayout = new GridBagLayout();

		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridheight = 3;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblSqdCasa = new JLabel(cal.getPartita(giornata, partita).getCasa().getNomeSqd() + ": ");
		lblSqdCasa.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSqdCasa = new GridBagConstraints();
		gbc_lblSqdCasa.insets = new Insets(0, 0, 5, 5);
		gbc_lblSqdCasa.gridx = 1;
		gbc_lblSqdCasa.gridy = 1;
		add(lblSqdCasa, gbc_lblSqdCasa);

		comboBoxCasa = new JComboBox<Integer>();
		maxRisultato(comboBoxCasa);
		comboBoxCasa.addActionListener(this);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		add(comboBoxCasa, gbc_comboBox);

		JLabel lblSqdTrasf = new JLabel(cal.getPartita(giornata, partita).getTrasferta().getNomeSqd() + ": ");
		lblSqdTrasf.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSqdTrasf = new GridBagConstraints();
		gbc_lblSqdTrasf.insets = new Insets(0, 0, 5, 5);
		gbc_lblSqdTrasf.gridx = 1;
		gbc_lblSqdTrasf.gridy = 2;
		add(lblSqdTrasf, gbc_lblSqdTrasf);

		comboBoxTrasf = new JComboBox<Integer>();
		maxRisultato(comboBoxTrasf);
		comboBoxTrasf.addActionListener(this);

		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 2;
		add(comboBoxTrasf, gbc_comboBox_1);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 3;
		add(btnAnnulla, gbc_btnAnnulla);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 4;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 0;
		add(verticalStrut_1, gbc_verticalStrut_1);

		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.gridx = 3;
		gbc_btnConferma.gridy = 3;
		add(btnConferma, gbc_btnConferma);
	}

	private void maxRisultato(JComboBox<Integer> comboBox) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= gs.getMaxRisultato(); i++)
			comboBox.addItem(i);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object pulsante = e.getSource();

		if (pulsante == btnConferma) {
			Integer rCasa = (Integer) comboBoxCasa.getSelectedItem();
			Integer rTrasf = (Integer) comboBoxTrasf.getSelectedItem();
			if (gs.getSport().toString().equals("VOLLEY")
					&& (rCasa.equals(rTrasf) || !(rCasa.equals(3) || rTrasf.equals(3)))) {
				JOptionPane.showMessageDialog(new JFrame(), "Risultato non ammesso.", "Errore",
						JOptionPane.ERROR_MESSAGE);
			} else {
				cal.getPartita(giornata, partita).setRisulato(rCasa, rTrasf, false);
				gs.setPunti(cal.getPartita(giornata, partita), false);
				model.setValueAt(rCasa + " - " + rTrasf, riga, 4);
				far.dispose();
			}

		}

		if (pulsante == btnAnnulla)
			far.dispose();

	}

}
