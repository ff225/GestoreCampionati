package gui;

public class Main {
	private static void createAndShowGUI() {
		new FrameScegliSport();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
