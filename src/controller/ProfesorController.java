package controller;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import view.MyFrame;
import view.PredmetDialog;
import view.ProfesorDialog;

public class ProfesorController {
	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController( ) {}
	
	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		
		Object[] options = {"Da",
	            "Ne"};
		int input = JOptionPane.showOptionDialog(null,
				"Da li ste sigurni da želite da obrišete profesora?",
						"Potvrda",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[1]); //ukro, link: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		
		if(input == 0) {
			// izmena modela
	    	Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
	    	BazaProfesora.getInstance().izbrisiProfesor(profesor.getBrojLicneKarte());
			// azuriranje prikaza
			MyFrame.getInstance().azurirajPrikazProfesora(null, input);
		}
		
	}
	
	public void dodajProfesora() {
		ProfesorDialog profesorDialog = new ProfesorDialog(null, "Titl", true, 'u');
		profesorDialog.setLocationRelativeTo(MyFrame.getInstance());
		profesorDialog.setVisible(true);
	}
	
	public void izmeniProfesora() {
		ProfesorDialog profesorDialog = new ProfesorDialog(null, "Titl", true, 'i');
		profesorDialog.setLocationRelativeTo(MyFrame.getInstance());
		profesorDialog.setVisible(true);
	}
}
