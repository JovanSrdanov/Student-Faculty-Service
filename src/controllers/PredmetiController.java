package controllers;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import baza.BazaPredmeta;
import gui.MyFrame;
import gui.PredmetDialog;
import modelSistema.Predmet;

public class PredmetiController {
	
	private static PredmetiController instance = null;
		
		public static PredmetiController getInstance() {
			if (instance == null) {
				instance = new PredmetiController();
			}
			return instance;
		}
		
	private PredmetiController( ) {}
	
	public void izbrisiPredmet(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	
    	Object[] options = {"Da",
                "Ne"};
    	int input = JOptionPane.showOptionDialog(null,
    			"Da li ste sigurni da želite da obrišete predmet?",
    					"Potvrda",
    					JOptionPane.YES_NO_OPTION,
    					JOptionPane.QUESTION_MESSAGE,
    					null,
    					options,
    					options[1]); //ukro, link: https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
    	
    	if(input == 0) {
    		// izmena modela
        	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
        	BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifrPredmeta());
    		// azuriranje prikaza
    		MyFrame.getInstance().azurirajPrikazPredmeta(null, rowSelectedIndex);
    	}
    	
    }
	
	public void dodajPredmet() {
		PredmetDialog predmetDialog = new PredmetDialog(null, "Titl", true);
		predmetDialog.setLocationRelativeTo(MyFrame.getInstance());
		predmetDialog.setVisible(true);
	}
}
