package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.MyFrame;
import view.ProfesorDialog;

public class ProfesorController {
	private static ProfesorController instance = null;

	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

	private ProfesorController() {
	}

	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		Object[] options = { MyApp.resourceBundle.getString("yes"), MyApp.resourceBundle.getString("no") };
		int input = JOptionPane.showOptionDialog(null, MyApp.resourceBundle.getString("pitanjeZaBrisanje"),  MyApp.resourceBundle.getString("potvrda"),
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]); // ukro, link:
																										// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html

		if (input == 0) {
			// izmena modela
			Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);

			// brisanje kod predmeta
			for (Predmet pred : BazaPredmeta.getInstance().getPredmeti()) {
				if (pred.getPredmetniProfesor() != null && pred.getPredmetniProfesor().getBrojLicneKarte() == profesor.getBrojLicneKarte()) {
					pred.setPredmetniProfesor(null);
				}
			}

			BazaProfesora.getInstance().izbrisiProfesor(profesor.getBrojLicneKarte());
			// azuriranje prikaza
			MyFrame.getInstance().azurirajPrikazProfesora();
		}

	}

	public void dodajProfesora() {
		ProfesorDialog profesorDialog = new ProfesorDialog(null,  MyApp.resourceBundle.getString("dodavanjeProfesora"), true, 'u');
		profesorDialog.setLocationRelativeTo(MyFrame.getInstance());
		profesorDialog.setVisible(true);
	}

	public void izmeniProfesora() {
		ProfesorDialog profesorDialog = new ProfesorDialog(null,  MyApp.resourceBundle.getString("izmeniProfesora"), true, 'i');
		profesorDialog.setLocationRelativeTo(MyFrame.getInstance());
		profesorDialog.setVisible(true);
	}

	public void pretraziProfesore(String rec) {
		BazaProfesora.getInstance().pretraziProfesore(rec);
		MyFrame.getInstance().azurirajPrikazProfesora();
	}
}
