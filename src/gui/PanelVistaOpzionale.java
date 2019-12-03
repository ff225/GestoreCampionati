package gui;

import javax.swing.JPanel;

import calendario.Calendario;
import squadre.GestioneSquadre;
import squadre.Squadra;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class PanelVistaOpzionale extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chckbxGiornata;
	private JComboBox<Integer> comboBoxGiornate;
	private JButton btnAnnulla;
	private JButton btnConferma;
	private FrameVistaOpzionale fvo;
	private Calendario cal;
	private JComboBox<String> comboBoxSquadre;
	private GestioneSquadre gs;

	public PanelVistaOpzionale(FrameVistaOpzionale frameVistaOpzionale, GestioneSquadre gs, Calendario cal) {
		this.fvo = frameVistaOpzionale;
		this.cal = cal;
		this.gs = gs;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridwidth = 4;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblSquadra = new JLabel("Squadra:");
		GridBagConstraints gbc_lblSquadra = new GridBagConstraints();
		gbc_lblSquadra.anchor = GridBagConstraints.EAST;
		gbc_lblSquadra.insets = new Insets(0, 0, 5, 5);
		gbc_lblSquadra.gridx = 1;
		gbc_lblSquadra.gridy = 1;
		add(lblSquadra, gbc_lblSquadra);

		comboBoxSquadre = new JComboBox<String>();
		getSquadre();
		comboBoxSquadre.addActionListener(this);
		GridBagConstraints gbc_comboBoxSquadre = new GridBagConstraints();
		gbc_comboBoxSquadre.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSquadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSquadre.gridx = 2;
		gbc_comboBoxSquadre.gridy = 1;
		add(comboBoxSquadre, gbc_comboBoxSquadre);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 3;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);

		chckbxGiornata = new JCheckBox("giornata");
		chckbxGiornata.addActionListener(this);
		GridBagConstraints gbc_chckbxGiornata = new GridBagConstraints();
		gbc_chckbxGiornata.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGiornata.gridx = 1;
		gbc_chckbxGiornata.gridy = 2;
		add(chckbxGiornata, gbc_chckbxGiornata);

		comboBoxGiornate = new JComboBox<Integer>();
		numGiornate();
		comboBoxGiornate.setEnabled(false);
		GridBagConstraints gbc_comboBoxGiornate = new GridBagConstraints();
		gbc_comboBoxGiornate.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxGiornate.gridx = 2;
		gbc_comboBoxGiornate.gridy = 2;
		add(comboBoxGiornate, gbc_comboBoxGiornate);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulla.gridx = 1;
		gbc_btnAnnulla.gridy = 3;
		add(btnAnnulla, gbc_btnAnnulla);

		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConferma.gridx = 2;
		gbc_btnConferma.gridy = 3;
		add(btnConferma, gbc_btnConferma);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 4;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 4;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
		// TODO Auto-generated constructor stub
	}

	private void getSquadre() {
		// TODO Auto-generated method stub
		for (Squadra squadra : gs.getAll()) {
			comboBoxSquadre.addItem(squadra.getNomeSqd());
		}
	}

	private void numGiornate() {
		// TODO Auto-generated method stub
		for (int i = 0; i < cal.getGiornate(); i++)
			comboBoxGiornate.addItem(i + 1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String pulsante = e.getActionCommand();
		switch (pulsante) {
		case "giornata":
			if (comboBoxSquadre.isEnabled()) {
				comboBoxSquadre.setEnabled(false);
				comboBoxGiornate.setEnabled(true);
			} else {
				comboBoxSquadre.setEnabled(true);
				comboBoxGiornate.setEnabled(false);
			}

			break;
		case "Conferma":
			if (comboBoxSquadre.isEnabled())
				new FrameStampaVista(cal, comboBoxSquadre.getSelectedItem().toString(), (Integer) null);
			else
				new FrameStampaVista(cal, null, (Integer) comboBoxGiornate.getSelectedItem());
			break;

		case "Annulla":
			fvo.dispose();
			break;
		default:
			break;
		}

	}
}
