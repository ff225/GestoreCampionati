package gui;

import javax.swing.JPanel;

import squadre.GestioneSquadre;
import squadre.Squadra;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;

public class PanelInfoSquadra extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxSquadre;
	private JButton btnCerca;
	private JButton btnAnnulla;
	private GestioneSquadre gs;
	private FrameInfoSquadra fis;

	public PanelInfoSquadra(FrameInfoSquadra fis, GestioneSquadre gs) {
		this.gs = gs;
		this.fis = fis;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblNomeSquadra = new JLabel("Nome squadra:");
		GridBagConstraints gbc_lblNomeSquadra = new GridBagConstraints();
		gbc_lblNomeSquadra.anchor = GridBagConstraints.EAST;
		gbc_lblNomeSquadra.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeSquadra.gridx = 2;
		gbc_lblNomeSquadra.gridy = 1;
		add(lblNomeSquadra, gbc_lblNomeSquadra);

		comboBoxSquadre = new JComboBox<String>();
		stampaSquadre(comboBoxSquadre);
		comboBoxSquadre.addActionListener(this);
		GridBagConstraints gbc_comboBoxSquadre = new GridBagConstraints();
		gbc_comboBoxSquadre.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSquadre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSquadre.gridx = 3;
		gbc_comboBoxSquadre.gridy = 1;
		add(comboBoxSquadre, gbc_comboBoxSquadre);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnnulla.gridx = 2;
		gbc_btnAnnulla.gridy = 2;
		add(btnAnnulla, gbc_btnAnnulla);

		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(this);
		GridBagConstraints gbc_btnCerca = new GridBagConstraints();
		gbc_btnCerca.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerca.gridx = 3;
		gbc_btnCerca.gridy = 2;
		add(btnCerca, gbc_btnCerca);
		// TODO Auto-generated constructor stub
	}

	private void stampaSquadre(JComboBox<String> comboBoxSquadre2) {
		// TODO Auto-generated method stub
		for (Squadra squadra : gs.getAll()) {
			comboBoxSquadre2.addItem(squadra.getNomeSqd());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String pulsante = e.getActionCommand();

		switch (pulsante) {
		case "Cerca":
			Squadra squadra = gs.cercaSquadra((String) comboBoxSquadre.getSelectedItem());

			JOptionPane.showMessageDialog(new JFrame(),
					"Squadra: " + squadra.getNomeSqd() + "\nCitta': " + squadra.getCittaSqd() + "\nV: "
							+ squadra.getVittoria() + ", P: " + squadra.getPareggio() + ", S: "
							+ squadra.getSconfitta(),
					"Informazioni squadra", JOptionPane.INFORMATION_MESSAGE, squadra.getIcona());
			fis.dispose();
			break;
		case "Annulla":
			fis.dispose();
			break;

		default:
			break;
		}
	}

}
