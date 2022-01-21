package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import view.MyFrame;
import view.StudentDijalog;

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

		Object[] options = {  MyApp.resourceBundle.getString("yes"), MyApp.resourceBundle.getString("no")};
		int input = JOptionPane.showOptionDialog(null, MyApp.resourceBundle.getString("pitanjeZaBrisanje"),  MyApp.resourceBundle.getString("potvrda"),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

		if (input == 0) {
			// izmena modela
			Student s = BazaStudenata.getInstance().getRow(rowSelectedIndex);
			for(Predmet sviPredmeti : BazaPredmeta.getInstance().getPredmeti()) { 
						sviPredmeti.getSpisakStudenataKojiNisuPoloziliPredmet().remove(s);
						sviPredmeti.getSpisakStudenataKojiSuPoloziliPredmet().remove(s);
			}
			BazaStudenata.getInstance().izbrisiStudenta(s.getBrojIndexa());
			// azuriranje prikaza
			MyFrame.getInstance().azurirajPrikazStudenata();
		}

	}

	public void dodajStudenta() {
		StudentDijalog studentDijalog = new StudentDijalog(null, MyApp.resourceBundle.getString("dodavanjeStudenta"), true, 'u');
		studentDijalog.setLocationRelativeTo(MyFrame.getInstance());
		studentDijalog.setVisible(true);

	}

	public void izmeniStudenta() {
		StudentDijalog studentDijalog = new StudentDijalog(null, MyApp.resourceBundle.getString("izmeniStudenta"), true, 'i');
		studentDijalog.setLocationRelativeTo(MyFrame.getInstance());
		studentDijalog.setVisible(true);
	}
	
	public void pretraziStudente(String rec) {
		BazaStudenata.getInstance().pretraziStudente(rec);
		MyFrame.getInstance().azurirajPrikazStudenata();
	}
}
