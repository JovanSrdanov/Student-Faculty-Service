package controller;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student;
import view.MyFrame;

public class StudentiController {
	private static StudentiController instance = null;

	public static StudentiController getInstance() {
		if (instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}

	private StudentiController() {
	}

	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		Object[] options = { "Da", "Ne" };
		int input = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete studenta?", "Potvrda",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

		if (input == 0) {
			// izmena modela
			Student s = BazaStudenata.getInstance().getRow(rowSelectedIndex);
			BazaStudenata.getInstance().izbrisiStudenta(s.getBrojIndexa());
			// azuriranje prikaza
			MyFrame.getInstance().azurirajPrikazProfesora(null, input);
		}

	}

	public void dodajStudenta() {

	}

	public void izmeniStudenta() {
	}

}
