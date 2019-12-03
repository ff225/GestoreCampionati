package gui;

import javax.swing.JPanel;

import squadre.GestioneSquadre;
import squadre.TipoSport;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;

public class PanelScegliSport extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblQualeSportVuoi;
	private JButton btnCalcio;
	private JButton btnVolley;
	private JButton btnRugby;
	private FrameScegliSport fss;

	public PanelScegliSport(FrameScegliSport fss) {
		this.fss = fss;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblQualeSportVuoi = new JLabel("Quale sport vuoi gestire?");
		GridBagConstraints gbc_lblQualeSportVuoi = new GridBagConstraints();
		gbc_lblQualeSportVuoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblQualeSportVuoi.gridx = 4;
		gbc_lblQualeSportVuoi.gridy = 0;
		add(lblQualeSportVuoi, gbc_lblQualeSportVuoi);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 1;
		add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 2;
		add(verticalStrut_2, gbc_verticalStrut_2);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 2;
		add(verticalStrut_1, gbc_verticalStrut_1);

		btnCalcio = new JButton("Calcio");
		btnCalcio.addActionListener(this);
		GridBagConstraints gbc_btnCalcio = new GridBagConstraints();
		gbc_btnCalcio.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalcio.gridx = 3;
		gbc_btnCalcio.gridy = 2;
		add(btnCalcio, gbc_btnCalcio);

		btnVolley = new JButton("Volley");
		btnVolley.addActionListener(this);
		GridBagConstraints gbc_btnVolley = new GridBagConstraints();
		gbc_btnVolley.insets = new Insets(0, 0, 5, 5);
		gbc_btnVolley.gridx = 4;
		gbc_btnVolley.gridy = 2;
		add(btnVolley, gbc_btnVolley);

		btnRugby = new JButton("Rugby");
		btnRugby.addActionListener(this);
		GridBagConstraints gbc_btnRugby = new GridBagConstraints();
		gbc_btnRugby.insets = new Insets(0, 0, 5, 5);
		gbc_btnRugby.gridx = 5;
		gbc_btnRugby.gridy = 2;
		add(btnRugby, gbc_btnRugby);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 6;
		gbc_verticalStrut.gridy = 2;
		add(verticalStrut, gbc_verticalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 8;
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();

		switch (TipoSport.valueOf(action.toUpperCase())) {
		case CALCIO:
			fss.dispose();
			new FrameCreaCarica("Calcio", new GestioneSquadre(TipoSport.CALCIO));
			break;
		case VOLLEY:
			fss.dispose();
			new FrameCreaCarica("Volley", new GestioneSquadre(TipoSport.VOLLEY));
			break;
		case RUGBY:
			fss.dispose();
			new FrameCreaCarica("Rugby", new GestioneSquadre(TipoSport.RUGBY));
		default:
			break;
		}
	}

}
