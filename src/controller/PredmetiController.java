package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.MyFrame;
import view.PredmetDialog;

public class PredmetiController {

	private static PredmetiController instance = null;

	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}

	private PredmetiController() {
	}

	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		Object[] options = { "Da", "Ne" };
		int input = JOptionPane.showOptionDialog(null, "Da li ste sigurni da želite da obrišete predmet?", "Potvrda",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]); // ukro, link:
																										// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html

		if (input == 0) {
			// izmena modela
			Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			//izbrisati kod studenta
			for(Student student : BazaStudenata.getInstance().getStudenti()) {
				for(Ocena ocena : student.getSpisakNePolozenihIspita()) {
					if(ocena.getPredmet().getSifrPredmeta().equals(predmet.getSifrPredmeta())) {
						student.getSpisakNePolozenihIspita().remove(ocena);
						break;
					}
				}
				for(Ocena ocena : student.getSpisakPolozenihIspita()) {
					if(ocena.getPredmet().getSifrPredmeta().equals(predmet.getSifrPredmeta())) {
						student.getSpisakPolozenihIspita().remove(ocena);
						break;
					}
				}
			}
			//izbrisati kod prof
			for(Profesor prof : BazaProfesora.getInstance().getProfesori()) {
				for(Predmet pred : prof.getSpisakPredmetaNaKojimaJeProfesor()) {
					if(pred.getSifrPredmeta().equals(predmet.getSifrPredmeta())) {
						prof.getSpisakPredmetaNaKojimaJeProfesor().remove(predmet);
						break;
					}
				}
			}
			BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifrPredmeta());
			// azuriranje prikaza
			MyFrame.getInstance().azurirajPrikazPredmeta();
		}

	}

	public void dodajPredmet() {
		PredmetDialog predmetDialog = new PredmetDialog(null, "Dodavanje predmeta", true, 'u');
		predmetDialog.setLocationRelativeTo(MyFrame.getInstance());
		predmetDialog.setVisible(true);
	}
	
	public void izmeniPredmet() {
		PredmetDialog predmetDialog = new PredmetDialog(null, "Izmena predmeta", true, 'i');
		predmetDialog.setLocationRelativeTo(MyFrame.getInstance());
		predmetDialog.setVisible(true);
	}
	
	public void pretraziPredmete(String rec) {
		BazaPredmeta.getInstance().pretraziPredmete(rec);
		MyFrame.getInstance().azurirajPrikazPredmeta();
	}
	
}
