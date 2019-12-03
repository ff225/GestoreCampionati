package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import calendario.Calendario;
import calendario.StampaPartite;
import squadre.GestioneSquadre;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class PanelGestisciCampionato extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnAggiungiRisultato;
	private JButton btnRimuoviRisultato;
	private JButton btnRimuoviTutto;
	private JButton btnSalva;
	private JButton btnClassifica;
	private JButton btnStampaCalendario;
	private JButton btnVisualizzaPer;
	private Calendario calendario;
	private StampaPartite sp;
	private GestioneSquadre gs;
	private JButton btnInfoSquadra;

	public PanelGestisciCampionato(GestioneSquadre gs, Calendario calendario) {

		// calendario = new Calendario(gs);
		this.gs = gs;
		String[] columnNames = { "Giornata", "Partita", "Casa", "Trasferta", "Esito" };
		Object[][] data = {};
		model = new DefaultTableModel(data, columnNames);
		if (calendario != null) {
			//System.out.println("calendario is not null");
			this.calendario = calendario;
			sp = new StampaPartite(this.calendario, model);
		} else {
			//System.out.println("Calendario is null");
			this.calendario = new Calendario(gs);
			this.calendario.AlgoritmoDiBerger();
			sp = new StampaPartite(this.calendario, model);
			sp.setDefaultRisultato();
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 0;
		add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);

		btnAggiungiRisultato = new JButton("Aggiungi risultato");
		btnAggiungiRisultato.addActionListener(this);
		GridBagConstraints gbc_btnAggiungiRisultato = new GridBagConstraints();
		gbc_btnAggiungiRisultato.insets = new Insets(0, 0, 5, 5);
		gbc_btnAggiungiRisultato.gridx = 2;
		gbc_btnAggiungiRisultato.gridy = 1;
		add(btnAggiungiRisultato, gbc_btnAggiungiRisultato);

		btnSalva = new JButton("Salva");
		btnSalva.setIcon(new ImageIcon(
				PanelGestisciCampionato.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSalva.addActionListener(this);
		GridBagConstraints gbc_btnSalva = new GridBagConstraints();
		gbc_btnSalva.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalva.gridx = 3;
		gbc_btnSalva.gridy = 1;
		add(btnSalva, gbc_btnSalva);

		btnRimuoviTutto = new JButton("Rimuovi tutto");
		btnRimuoviTutto.setIcon(new ImageIcon(
				PanelGestisciCampionato.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnRimuoviTutto.addActionListener(this);
		GridBagConstraints gbc_btnRimuoviTutto = new GridBagConstraints();
		gbc_btnRimuoviTutto.insets = new Insets(0, 0, 5, 5);
		gbc_btnRimuoviTutto.gridx = 5;
		gbc_btnRimuoviTutto.gridy = 1;
		add(btnRimuoviTutto, gbc_btnRimuoviTutto);

		btnRimuoviRisultato = new JButton("Rimuovi risultato");
		btnRimuoviRisultato.addActionListener(this);
		GridBagConstraints gbc_btnRimuoviRisultato = new GridBagConstraints();
		gbc_btnRimuoviRisultato.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRimuoviRisultato.insets = new Insets(0, 0, 5, 5);
		gbc_btnRimuoviRisultato.gridx = 6;
		gbc_btnRimuoviRisultato.gridy = 1;
		add(btnRimuoviRisultato, gbc_btnRimuoviRisultato);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 8;
		gbc_verticalStrut_1.gridy = 1;
		add(verticalStrut_1, gbc_verticalStrut_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		sp.stampa();
		table = new JTable(model);
		table.setRowSelectionAllowed(true);
		table.setDefaultEditor(Object.class, null); // non permette la modifica delle celle nella tabella.
		// table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		// add(new JScrollPane(table));
		table.getTableHeader();

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 2;
		gbc_horizontalStrut_1.gridy = 3;
		add(horizontalStrut_1, gbc_horizontalStrut_1);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_3.gridx = 0;
		gbc_verticalStrut_3.gridy = 4;
		add(verticalStrut_3, gbc_verticalStrut_3);

		btnClassifica = new JButton("Classifica");
		btnClassifica.addActionListener(this);

		btnStampaCalendario = new JButton("Stampa calendario");
		btnStampaCalendario.addActionListener(this);
		GridBagConstraints gbc_btnStampaCalendario = new GridBagConstraints();
		gbc_btnStampaCalendario.insets = new Insets(0, 0, 0, 5);
		gbc_btnStampaCalendario.gridx = 2;
		gbc_btnStampaCalendario.gridy = 4;
		add(btnStampaCalendario, gbc_btnStampaCalendario);

		btnVisualizzaPer = new JButton("Visualizza per");
		btnVisualizzaPer.addActionListener(this);

		btnInfoSquadra = new JButton("Info squadra");
		btnInfoSquadra.addActionListener(this);
		GridBagConstraints gbc_btnInfoSquadra = new GridBagConstraints();
		gbc_btnInfoSquadra.insets = new Insets(0, 0, 0, 5);
		gbc_btnInfoSquadra.gridx = 3;
		gbc_btnInfoSquadra.gridy = 4;
		add(btnInfoSquadra, gbc_btnInfoSquadra);
		GridBagConstraints gbc_btnVisualizzaPer = new GridBagConstraints();
		gbc_btnVisualizzaPer.insets = new Insets(0, 0, 0, 5);
		gbc_btnVisualizzaPer.gridx = 5;
		gbc_btnVisualizzaPer.gridy = 4;
		add(btnVisualizzaPer, gbc_btnVisualizzaPer);
		GridBagConstraints gbc_btnClassifica = new GridBagConstraints();
		gbc_btnClassifica.insets = new Insets(0, 0, 0, 5);
		gbc_btnClassifica.gridx = 6;
		gbc_btnClassifica.gridy = 4;
		add(btnClassifica, gbc_btnClassifica);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 7;
		gbc_verticalStrut_2.gridy = 4;
		add(verticalStrut_2, gbc_verticalStrut_2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String pulsante = e.getActionCommand();
		//System.out.println(pulsante);

		int riga = table.getSelectedRow();

		if ((pulsante.equals("Aggiungi risultato") || pulsante.equals("Rimuovi risultato")) && riga == -1) {
			JOptionPane.showMessageDialog(new JFrame(), "Seleziona una riga", "Errore!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		switch (pulsante) {

		case "Aggiungi risultato":
			if (model.getValueAt(riga, 4).equals("Riposo"))
				JOptionPane.showMessageDialog(new JFrame(),
						"Impossibile inserire il risultato." + "\nLa squadra in questa giornata riposa.", "Avviso",
						JOptionPane.WARNING_MESSAGE);
			else {
				int giornata = (int) model.getValueAt(riga, 0) - 1;
				int partita = (int) model.getValueAt(riga, 1) - 1;
				if (calendario.getPartita(giornata, partita).getRisultato().getIsDefault())
					new FrameAggiungiRisultato(calendario, gs, riga, model);
				else
					JOptionPane.showMessageDialog(new JFrame(),
							"Impossibile modificare il risultato.\nRimuovi il risultato", "Avviso",
							JOptionPane.INFORMATION_MESSAGE);
			}
			/*
			 * if (!model.getValueAt(riga, 4).equals("0 - 0"))
			 * JOptionPane.showMessageDialog(new JFrame(),
			 * "Risultato già inserito. \nRimuovi risultato e riprova.", "Avviso",
			 * JOptionPane.ERROR_MESSAGE); else
			 */

			break;

		case "Rimuovi risultato":
			if (model.getValueAt(riga, 4).equals("Riposo")) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Impossibile cancellare il risultato."
								+ "\nLa squadra in questa giornata non ha ancora giocato o riposa.",
						"Avviso", JOptionPane.WARNING_MESSAGE);
				break;
			}
			int giornata = (int) model.getValueAt(riga, 0) - 1;
			int partita = (int) model.getValueAt(riga, 1) - 1;
			/*
			 * System.out.println("numero riga: " + riga); System.out.println(partita +
			 * " - " + giornata); System.out.println(calendario.getPartita(giornata,
			 * partita).getCasa().getNomeSqd()); // + " - " + // cal.getPartita(giornata,
			 * System.out.println(calendario.getNumPartite()); //
			 * partita).getTrasferta().getNomeSqd()); // cal.getPartita(giornata,
			 * partita).setRisulato(
			 * 
			 */
			if (calendario.getPartita(giornata, partita).getRisultato().getIsDefault())
				;
			else {
				gs.setPunti(calendario.getPartita(giornata, partita), true);
				calendario.getPartita(giornata, partita).setRisulato(0, 0, true);
				model.setValueAt("0 - 0", riga, 4);
			}
			// gs.setPunti(cal.getPartita(giornata, partita));

			break;

		case "Salva":
			new FrameSalvaCampionato(calendario, gs);
			break;

		case "Rimuovi tutto":
			sp.resetPartite();
			sp.setDefaultRisultato();
			break;

		case "Info squadra":
			new FrameInfoSquadra(gs);
			break;
		case "Stampa calendario":
			new FrameScegliVistaStampa(gs, calendario);
			break;
		case "Visualizza per":
			new FrameVistaOpzionale(gs, calendario);
			break;
		case "Classifica":
			new FrameClassifica(gs);
			break;

		default:
			break;
		}
	}

}
