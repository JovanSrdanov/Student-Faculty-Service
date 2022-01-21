package view;

import java.awt.Frame;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AboutDijalog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 706014951914755011L;

	public AboutDijalog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		setSize(900, 350);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		String RS = "<html>Verzija projekta: 1.0<br/>"
				+ "Naziv projekta : Studentska služba<br/>"
				+ "				 <br/>"
				+ "Aplikacija služi da simulira rad studentske službe<br/>"
				+ "Omogućeni su prikazi, unosi, izmene i brisanja podataka<br/>"
				+ "Kod svih entiteta je moguce uraditi unos, izmenu i brisanje osim kod katedre <br/>"
				+ "				 <br/>"
				+ "				 <br/>"
				+ "Kod studenta je uradjen prikaz položenih i nepoloženih predmeta, dodavanje i brisanje studenta sa predmeta kao i polaganje i poništavanje ocene<br/>"
				+ "Kod profesora je uradjen prikaz predmeta koji predaje, dodavanje predmeta i uklanjanje sa predmeta<br/>"
				+ "Kod predmeta je omogućeno dodavanje profesora na predmet<br/>"
				+ "Kod katedre je dozvoljeno samo postavljanje šefa katedre<br/>"
				+ "				 <br/>"
				+ "Autor 1: Jovan Srdanov RA 145/2019<br/>"
				+ "Zrenjanin 01.11.2000.<br/>"
				+ "				 <br/>"
				+ "Autor 2: Strahinja Eraković RA 152/2019<br/>"
				+ "Kikinda 22.01.2000.</html>";

		String EN = "<html>Project version: 1.0<br/>"
				+ "Project title: Student Service<br/>"
				+ "<br/>"
				+ "The application serves to simulate the work of the student service<br/>"
				+ "Views, entries, changes and deletions of data are enabled<br/>"
				+ "It is possible to enter, edit and delete all entities except the department<br/>"
				+ "<br/>"
				+ "<br/>"
				+ "The student has passed and unpassed courses, option to add and delete student's courses, as well as taking and nullify grades<br/>"
				+ "The professor has the subjects he teaches, option to add and remove the subject he teaches<br/>"
				+ "For subjects, it is possible to add and remove a professor to the subject<br/>"
				+ "In the case of the department, only the appointment of the department's chief is allowed<br/>"
				+ "<br/>"
				+ "Author 1: Jovan Srdanov RA 145/2019<br/>"
				+ "Zrenjanin 11/01/2000<br/>"
				+ "<br/>"
				+ "Author 2: Strahinja Eraković RA 152/2019<br/>"
				+ "Kikinda 22.01.2000. </html>";
		String kraj;

		if (!Locale.getDefault().equals(new Locale("sr", "RS")))
			kraj = EN;
		else
			kraj = RS;

		JLabel t = new JLabel(kraj, SwingConstants.LEFT);

		centerPanel.add(t);

		this.add(centerPanel);

	}
}
