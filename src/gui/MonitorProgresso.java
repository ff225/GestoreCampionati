package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JProgressBar;

public class MonitorProgresso implements PropertyChangeListener {
	private JProgressBar barraAvanzamento;

	public MonitorProgresso(JProgressBar barra) {
		barraAvanzamento = barra;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String strPropertyName = evt.getPropertyName();
		if ("progress".equals(strPropertyName)) {
			barraAvanzamento.setIndeterminate(false);
			int progress = (Integer) evt.getNewValue();
			barraAvanzamento.setValue(progress);
		}
	}
}
