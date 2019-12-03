package gui;

import java.awt.event.ActionListener;
import java.text.MessageFormat;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import calendario.Calendario;
import calendario.StampaPartite;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class PanelStampaCalendario extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private StampaPartite sp;

	public PanelStampaCalendario(Calendario cal, String nSquadra, Integer giornata) {
		String[] columnNames = { "Giornata", "Partita", "Casa", "Trasferta", "Esito" };
		Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);
		sp = new StampaPartite(cal, model);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		if (nSquadra != null)
			sp.stampaPerSquadra(nSquadra);
		else if (giornata != null)
			sp.stampaGiornata(giornata - 1);
		else
			sp.stampa();
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);

		JButton btnStampa = new JButton("Stampa");
		btnStampa.addActionListener(this);
		GridBagConstraints gbc_btnStampa = new GridBagConstraints();
		gbc_btnStampa.gridx = 0;
		gbc_btnStampa.gridy = 1;
		add(btnStampa, gbc_btnStampa);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent ignore) {
		// TODO Auto-generated method stub
		MessageFormat header = new MessageFormat("Calendario");
		try {
			table.print(JTable.PrintMode.FIT_WIDTH, header, null);
		} catch (java.awt.print.PrinterException e) {
			System.err.format("Cannot print %s%n", e.getMessage());
		}
	}

}
