package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;

import calendario.Calendario;
import squadre.GestioneSquadre;
import squadre.Squadra;

import javax.swing.table.DefaultTableModel;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

import javax.swing.ImageIcon;

public class PanelCreaCampionato extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrameCreaCampionato fc;
	private JTextField numSqdInserite;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnInserisci;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalva;
	private JButton btnConferma;
	private GestioneSquadre gs;
	// private Calendario calendario;

	public PanelCreaCampionato(FrameCreaCampionato fc, GestioneSquadre gs) {
		this.gs = gs;
		this.fc = fc;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 4;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 0;
		add(horizontalStrut_1, gbc_horizontalStrut_1);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 2;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);

		btnInserisci = new JButton("Inserisci");
		btnInserisci.addActionListener(this);
		GridBagConstraints gbc_btnInserisci = new GridBagConstraints();
		gbc_btnInserisci.insets = new Insets(0, 0, 5, 5);
		gbc_btnInserisci.gridx = 1;
		gbc_btnInserisci.gridy = 1;
		add(btnInserisci, gbc_btnInserisci);

		btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(this);

		btnCancella = new JButton("Cancella");
		btnCancella.setIcon(new ImageIcon(
				PanelCreaCampionato.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		btnCancella.addActionListener(this);

		btnSalva = new JButton("Salva");
		btnSalva.setIcon(
				new ImageIcon(PanelCreaCampionato.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSalva.addActionListener(this);
		GridBagConstraints gbc_btnSalva = new GridBagConstraints();
		gbc_btnSalva.anchor = GridBagConstraints.SOUTH;
		gbc_btnSalva.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalva.gridx = 2;
		gbc_btnSalva.gridy = 1;
		add(btnSalva, gbc_btnSalva);
		GridBagConstraints gbc_btnCancella = new GridBagConstraints();
		gbc_btnCancella.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancella.gridx = 3;
		gbc_btnCancella.gridy = 1;
		add(btnCancella, gbc_btnCancella);
		GridBagConstraints gbc_btnModifica = new GridBagConstraints();
		gbc_btnModifica.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifica.gridx = 4;
		gbc_btnModifica.gridy = 1;
		add(btnModifica, gbc_btnModifica);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridheight = 2;
		gbc_verticalStrut.gridx = 5;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblNumeroSquadre = new JLabel("Numero squadre");
		GridBagConstraints gbc_lblNumeroSquadre = new GridBagConstraints();
		gbc_lblNumeroSquadre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroSquadre.gridx = 1;
		gbc_lblNumeroSquadre.gridy = 2;
		add(lblNumeroSquadre, gbc_lblNumeroSquadre);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridwidth = 4;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 3;
		add(horizontalStrut, gbc_horizontalStrut);

		String[] columnNames = { "Nome Squadra", "Città", "Sport" };

		Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);
		caricaSquadre();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusTraversalPolicyProvider(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setDefaultEditor(Object.class, null); // non permette la modifica delle celle nella tabella.
		scrollPane.setViewportView(table);
		table.getTableHeader();

		numSqdInserite = new JTextField();
		numSqdInserite.setHorizontalAlignment(SwingConstants.CENTER);
		numSqdInserite.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		numSqdInserite.setEditable(false);
		numSqdInserite.setText(Integer.toString(gs.getSize()));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		add(numSqdInserite, gbc_textField);
		numSqdInserite.setColumns(10);

		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConferma.gridx = 4;
		gbc_btnConferma.gridy = 5;
		add(btnConferma, gbc_btnConferma);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.gridwidth = 5;
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 6;
		add(horizontalStrut_2, gbc_horizontalStrut_2);

	}

	private void caricaSquadre() {
		// TODO Auto-generated method stub
		for (Squadra squadra : gs.getAll()) {
			model.addRow(new Object[] { squadra.getNomeSqd(), squadra.getCittaSqd(), gs.getSport() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String pulsante = e.getActionCommand();
		int riga = table.getSelectedRow();

		if ((pulsante.equals("Modifica") || pulsante.equals("Cancella")) && riga == -1) {
			JOptionPane.showMessageDialog(new JFrame(), "Devi selezionare una riga.", "Avviso",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		switch (pulsante) {
		case "Inserisci":
			new FrameAggiungiSqd(gs, numSqdInserite, model);
			break;

		case "Modifica":
			new FrameModificaSqd(gs, numSqdInserite, riga, model);
			break;

		case "Salva":
			if (gs.getSize() == 0)
				JOptionPane.showMessageDialog(new JFrame(), "Non ci sono squadre da salvare", "Avviso",
						JOptionPane.INFORMATION_MESSAGE);
			else
				new FrameSalva(gs);
			break;

		case "Cancella":
			gs.rimuoviSqd(table.getValueAt(riga, 0).toString().toUpperCase());
			model.removeRow(riga);
			numSqdInserite.setText(Integer.toString(gs.getSize()));
			break;

		case "Conferma":
			if (gs.getSize() < 3)
				JOptionPane.showMessageDialog(new JFrame(), "Impossibile creare un campionato con meno di 3 squadre",
						"Errore", JOptionPane.ERROR_MESSAGE);
			else {
				Calendario cal = null;
				new FrameGestisciCampionato(gs, cal, gs.getSport().toString().toLowerCase());
				fc.dispose();
			}
		default:
			break;
		}

	}

}
