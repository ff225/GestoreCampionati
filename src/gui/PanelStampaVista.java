package gui;

import javax.swing.JPanel;

import calendario.Calendario;
import calendario.StampaPartite;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelStampaVista extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private StampaPartite sp;
	private DefaultTableModel model;

	public PanelStampaVista(Calendario cal, String text, Integer giornata) {
		// TODO Auto-generated constructor stub

		String[] columnNames = { "Giornata", "Partita", "Casa", "Trasferta", "Esito" };
		Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);

		sp = new StampaPartite(cal, model);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblGiornata = new JLabel("Giornata:");
		GridBagConstraints gbc_lblSquadra = new GridBagConstraints();
		gbc_lblSquadra.insets = new Insets(0, 0, 5, 5);
		gbc_lblSquadra.gridx = 1;
		gbc_lblSquadra.gridy = 0;
		add(lblGiornata, gbc_lblSquadra);

		JLabel valGiornata = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		add(valGiornata, gbc_label_1);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);
		if (giornata != null) {
			valGiornata.setText(giornata.toString());
			sp.stampaGiornata(giornata - 1);
		}
		JLabel lblSquadra = new JLabel("Squadra:");
		GridBagConstraints gbc_lblGiornata = new GridBagConstraints();
		gbc_lblGiornata.anchor = GridBagConstraints.WEST;
		gbc_lblGiornata.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiornata.gridx = 1;
		gbc_lblGiornata.gridy = 1;
		add(lblSquadra, gbc_lblGiornata);

		JLabel valSquadra = new JLabel("");
		valSquadra.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		add(valSquadra, gbc_label);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 5;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);
		if (text != null) {
			valSquadra.setText(text.toUpperCase());
			sp.stampaPerSquadra(text);
		}
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.gridwidth = 5;
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 3;
		add(horizontalStrut, gbc_horizontalStrut);
	}
}
