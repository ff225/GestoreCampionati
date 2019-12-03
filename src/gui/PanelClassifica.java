package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import calendario.Classifica;
import squadre.GestioneSquadre;

import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class PanelClassifica extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Classifica classifica;

	public PanelClassifica(GestioneSquadre gs) {
		// TODO Auto-generated constructor stub

		classifica = new Classifica(gs);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		String[] columnNames = { "Posizione", "Squadra", "Punti" };
		Object[][] data = {};
		classifica.generaClassifica();
		model = new DefaultTableModel(data, columnNames);
		classifica.stampaClassifica(model, table);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);

	}

}
