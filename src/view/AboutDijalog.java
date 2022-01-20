package view;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 706014951914755011L;

	public AboutDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(800, 300);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		
		JLabel t1 = new JLabel("Verzija projekta: 1.0");
		JLabel t2 = new JLabel("Naziv projekta : Studentska sluzba");
		JLabel t3 = new JLabel("Aplikacija sluzi da simulira rad studentske sluzbe");
		JLabel t4 = new JLabel("Opis:");
		JLabel t5 = new JLabel("Omoguceni su prikazi, unosi, izmene i brisanja podataka");
		JLabel t6 = new JLabel("Kod svih entiteta je moguce uraditi unos, izmenu i brisanje osim kod katedre ");
		JLabel t7 = new JLabel("Kod studenta je uradjen prikaz polozenih i nepolozenih ispita, dovanje i brisanje studenta sa predmeta kao i polaganje i ponistavanje ocene");
		JLabel t8 = new JLabel("Kod profesora je uradjen prikaz predmeta koji predaje, dodavanje predmeta i uklanjanje sa predmeta");
		JLabel t9 = new JLabel("Kod predmeta je omoguceno dodavanje profesora na predmet");
		JLabel t10 = new JLabel("Kod katedre je dozvoljeno samo postavljanje sefa katedre");
		JLabel a11 = new JLabel("Autor 1: Jovan Srdanov RA 145/2019");
		JLabel a12 = new JLabel("Zrenjanin 01.11.2000.");
		JLabel a21 = new JLabel("Autor 2: Strahinja Erakovic RA 152/2019");
		JLabel a22 = new JLabel("Kikinda 22.01.2000.");
		
		t1.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		centerPanel.add(t1);
		centerPanel.add(t2);
		centerPanel.add(t3);
		centerPanel.add(t4);
		centerPanel.add(t5);
		centerPanel.add(t6);
		centerPanel.add(t7);
		centerPanel.add(t8);
		centerPanel.add(t9);
		centerPanel.add(t10);
		centerPanel.add(a11);
		centerPanel.add(a12);
		centerPanel.add(a21);
		centerPanel.add(a22);
		

		this.add(centerPanel);
		
		
	}
}
