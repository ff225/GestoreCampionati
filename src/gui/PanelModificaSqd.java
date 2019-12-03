package gui;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import squadre.GestioneSquadre;
import squadre.Squadra;

public class PanelModificaSqd extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeSqd;
	private JTextField cittaSqd;
	private JButton btnAnnulla;
	private JButton btnConferma;
	private GestioneSquadre gs;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private FrameModificaSqd fms;
	private JTextField numSqd;
	private DefaultTableModel model;
	private Checkbox cbFoto;
	private Component horizontalStrut_1;
	private int riga;
	private File pathFoto;

	public PanelModificaSqd(FrameModificaSqd fms, GestioneSquadre gs, JTextField numSqdInserite, int riga,
			DefaultTableModel model) {
		// TODO Auto-generated constructor stub

		this.gs = gs;
		this.fms = fms;
		this.numSqd = numSqdInserite;
		this.model = model;
		this.riga = riga;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridwidth = 5;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 3;
		add(horizontalStrut, gbc_horizontalStrut);

		JLabel lblNomeSquadra = new JLabel("Nome squadra: ");
		GridBagConstraints gbc_lblNomeSquadra = new GridBagConstraints();
		gbc_lblNomeSquadra.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeSquadra.anchor = GridBagConstraints.EAST;
		gbc_lblNomeSquadra.gridx = 2;
		gbc_lblNomeSquadra.gridy = 4;
		add(lblNomeSquadra, gbc_lblNomeSquadra);

		nomeSqd = new JTextField();
		String nSqd = (String) model.getValueAt(riga, 0);
		nomeSqd.setText(nSqd);
		GridBagConstraints gbc_nomeSqd = new GridBagConstraints();
		gbc_nomeSqd.insets = new Insets(0, 0, 5, 5);
		gbc_nomeSqd.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomeSqd.gridx = 3;
		gbc_nomeSqd.gridy = 4;
		add(nomeSqd, gbc_nomeSqd);
		nomeSqd.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 5;
		add(verticalStrut, gbc_verticalStrut);

		JLabel lblCitt = new JLabel("Citt\u00E0:");
		GridBagConstraints gbc_lblCitt = new GridBagConstraints();
		gbc_lblCitt.anchor = GridBagConstraints.EAST;
		gbc_lblCitt.insets = new Insets(0, 0, 5, 5);
		gbc_lblCitt.gridx = 2;
		gbc_lblCitt.gridy = 5;
		add(lblCitt, gbc_lblCitt);

		cittaSqd = new JTextField();
		String cSqd = (String) model.getValueAt(riga, 1);
		cittaSqd.setText(cSqd);
		GridBagConstraints gbc_cittaSqd = new GridBagConstraints();
		gbc_cittaSqd.insets = new Insets(0, 0, 5, 5);
		gbc_cittaSqd.fill = GridBagConstraints.HORIZONTAL;
		gbc_cittaSqd.gridx = 3;
		gbc_cittaSqd.gridy = 5;
		add(cittaSqd, gbc_cittaSqd);
		cittaSqd.setColumns(10);

		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 3;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 4;
		gbc_verticalStrut_1.gridy = 4;
		add(verticalStrut_1, gbc_verticalStrut_1);

		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridheight = 7;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_2.gridx = 0;
		gbc_verticalStrut_2.gridy = 3;
		add(verticalStrut_2, gbc_verticalStrut_2);

		cbFoto = new Checkbox("Aggiungi foto");
		cbFoto.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String getHome = System.getProperty("user.dir");
				getHome = getHome.replace("/bin", "");
				final File pathDirectory = new File(getHome + "/Loghi/");
				// System.out.println("Questo è il Path:" + pathDirectory.toString());
				JFileChooser fc = new JFileChooser(pathDirectory);

				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				fc.setFileFilter(imageFilter);
				/*
				 * Importa tutti i suffissi di immagine
				 */

				int returnVal = fc.showOpenDialog(PanelModificaSqd.this);
				if (returnVal == JFileChooser.APPROVE_OPTION)
					pathFoto = fc.getSelectedFile();
				else
					pathFoto = null;

			}
		});
		GridBagConstraints gbc_cbFoto = new GridBagConstraints();
		gbc_cbFoto.insets = new Insets(0, 0, 5, 5);
		gbc_cbFoto.gridx = 3;
		gbc_cbFoto.gridy = 6;
		add(cbFoto, gbc_cbFoto);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		GridBagConstraints gbc_btnAnnulla = new GridBagConstraints();
		gbc_btnAnnulla.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulla.gridx = 2;
		gbc_btnAnnulla.gridy = 7;
		add(btnAnnulla, gbc_btnAnnulla);

		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.insets = new Insets(0, 0, 5, 5);
		gbc_btnConferma.gridx = 3;
		gbc_btnConferma.gridy = 7;
		add(btnConferma, gbc_btnConferma);

		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.fill = GridBagConstraints.BOTH;
		gbc_horizontalStrut_1.gridwidth = 5;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 8;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object pulsante = e.getSource();
		if (pulsante == btnConferma) {

			String nomeSquadra = (String) model.getValueAt(riga, 0);
			String nSqd = nomeSqd.getText();
			String citta = cittaSqd.getText();
			System.out.println("nSqd: " + nSqd +  "citta: " +  citta);
			/*
			 * if (nomeSqd.getText().isEmpty() || cittaSqd.getText().isEmpty()) {
			 * JOptionPane.showMessageDialog(new JFrame(), "Devi riempire tutti i campi.",
			 * "Avviso", JOptionPane.INFORMATION_MESSAGE); } else {
			 */
			if (pathFoto == null) {
				String getHome = System.getProperty("user.dir");
				getHome = getHome.replace("/bin", "");
				pathFoto = new File(getHome + "/Loghi/Default/default_logo" + gs.getSport().toString() + ".jpg");
			}
			if (!gs.modificaSqd(nomeSquadra.toUpperCase(), new Squadra(nSqd.toUpperCase(),
					citta.toUpperCase(), new ImageIcon(pathFoto.toString())))) {
				JOptionPane.showMessageDialog(new JFrame(),
						"La squadra che hai cercato di inserire è presente nel sistema.", "Errore",
						JOptionPane.ERROR_MESSAGE);
				// model.removeRow(model.getRowCount());
			} else {

				JOptionPane.showMessageDialog(new JFrame(), "Squadra modificata correttamente.", "Avviso",
						JOptionPane.INFORMATION_MESSAGE);

				nSqd = nomeSqd.getText().substring(0, 1).toUpperCase() + nomeSqd.getText().substring(1).toLowerCase();
				citta = cittaSqd.getText().substring(0, 1).toUpperCase()
						+ cittaSqd.getText().substring(1).toLowerCase();
				model.setValueAt(nSqd, riga, 0);
				model.setValueAt(citta, riga, 1);
				model.setValueAt(gs.getSport().toString(), riga, 2);
			}

			fms.dispose();
		}
		numSqd.setText(Integer.toString(gs.getSize()));

// }
		if (pulsante == btnAnnulla)
			fms.dispose();
	}

}
