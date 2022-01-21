package view;

import java.awt.Frame;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.MyApp;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532094756704393899L;

	public static HelpDialog instance = null;

	public static HelpDialog getInstance() {
		if (instance == null)
			instance = new HelpDialog(null, MyApp.resourceBundle.getString("help"), false);

		return instance;

	}

	private JLabel t;

	public void azurirajDijalog() {
		
		String RS = "<html>"
				+ "Pomoć: <br/>"
				+ "Entiteti se mogu dodati, izmeniti i obrisati pomoću klika na odgovarajuće dugmiće u toolbar sekciji, pomoću klika na odgovarajući  <br/>"
				+ "meni u glavnom meniju, pomoću dole navedenih mnemonika i akceleratora, prilikom izmene i brisanja mora da se selektuje entitet  <br/>"
				+ "nad kojim se vrši izmena <br/>"
				+ " <br/>"
				+ "Prilikom popunjavanja svih polja za izmenu ili unos podataka, moraju sva polja zadovoljati svoja ograničenja i biti unešena,  <br/>"
				+ "inače dugme za potvrdu ostaje onemogućeno. <br/>"
				+ " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ "Studenti: <br/>"
				+ "Informacije --- <br/>"
				+ "Ime i prezime nemaju specijalna ograničenja <br/>"
				+ "Datum se mora uneti u formatu DD.MM.GGGG. <br/>"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,država <br/>"
				+ "Za telefon nema ograničenja <br/>"
				+ "EMail adrese mora sadržati niz karaktera, pa tačku, pa niz karaktera pa @, pa niz karaktera pa tačku pa opet niz karaktera <br/>"
				+ "Broj indexa se unosi u formatu xx yyy/zzzz gde je xx smer, yyy broj indexa a zzzz godina upisa <br/>"
				+ "Godina upisa mora biti broj <br/>"
				+ " <br/>"
				+ "Položeni predmeti --- <br/>"
				+ "Za poništavanje ocene, mora ocena prvo biti označena i onda se mora uraditi potvrđivanje poništavanja ocene <br/>"
				+ " <br/>"
				+ "Nepoloženi predmeti --- <br/>"
				+ "Klikom na dugme Dodaj se mogu dodati predmeti iz liste predmeta koje student može da sluša<br/>"
				+ "koji nisu ni u položenim ni u nepoloženim predmetima  <br/>"
				+ "Dugme obriši briše označen predmeta <br/>"
				+ "Dugme Polaganje otvara novi dijalog gde unosimo ocenu i datum ispita označenog predmeta <br/>"
				+ "Ocena je broj, datum je u formatu DD.MM.GGGG. <br/>"
				+ "  <br/>"
				+ " <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>"
				+ " <br/>"
				+ "Ključ studenta : Indeks<br/>"
				+ "<br/>"
				+ "Pretraga studenta se vrši na tri načina:<br/>"
				+ "1 reč : prezime<br/>"
				+ "2 reči : prezime,ime<br/>"
				+ "3 reči : index, prezime, ime<br/>"
				+ "reči se odvajaju zarezima<br/>"
				+ "<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>"
				+ "Profesori: <br/>"
				+ "Informacije --- <br/>"
				+ "Ime i prezime nemaju specijalna ograničenja <br/>"
				+ "Datum se mora uneti u formatu DD.MM.GGGG. <br/>"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,država <br/>"
				+ "Za broj telefona nema ograničenja <br/>"
				+ "Broj lične karte mora biti broj od tačno 9 cifara<br/>"
				+ "Godine staža moraju biti broj <br/>"
				+ "e-Mail adresa mora sadržati niz karaktera, pa tačku, pa niz karaktera pa @, pa niz karaktera pa tačku pa opet niz karaktera <br/>"
				+ " <br/>"
				+ "Predaje --- <br/>"
				+ "Može se dodati predmet koji taj profesor već ne predaje iz liste predmeta <br/>"
				+ "Ako već postoji profesor na tom predmetu, onda se taj stari ukloni i postavi novi<br/>"
				+ "Može se ukloniti predmet ako se označi i klikne dugme ukloni predmet <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>"
				+ " <br/>"
				+ "<br/>"
				+ "Ključ profesora : broj lične karte<br/>"
				+ "<br/>"
				+ "Pretraga profesora se vrši na dva načina:<br/>"
				+ "1 reč : prezime<br/>"
				+ "2 reči : prezime, ime<br/>"
				+ "reči se odvajaju zarezima<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>"
				+ "Predmeti: <br/>"
				+ "Šifra predmeta se sastoji iz jednog ili 2 slova nakon čega slede 1 ili 2 broja <br/>"
				+ "Naziv predmeta nema specijalna ograničenja <br/>"
				+ "ESPB mora biti ceo broj <br/>"
				+ " <br/>"
				+ "Ako nema predmetnog profesora pritiskom na dugme + se dodaje profesor na predmet i odmah se ta informacija sačuva <br/>"
				+ "+ postane onemogućeno za stisnuti, - postaje omogućeno <br/>"
				+ "Ako ima predmetnog profesora pritiskom na dugme - se uklanja profesor sa predmeta odmah se ta informacija sačuva <br/>"
				+ "- postane onemogućeno za stisnuti, + postaje omogućeno <br/>"
				+ "<br/>"
				+ " <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>"
				+ "<br/>"
				+ "Ključ predmeta : Šifra predmeta<br/>"
				+ "<br/>"
				+ "Pretraga predmeta se vrši na dva načina:<br/>"
				+ "1 reč : naziv<br/>"
				+ "2 reći : naziv predmeta, šifra<br/>"
				+ "reči se odvajaju zarezima<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>"
				+ "Katedre: <br/>"
				+ "Otvaranjem prozora katedri moguće je samo videti tabelarni prikaz postaviti novog šefa katedre <br/>"
				+ " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>"
				+ "Mnemonici: <br/>"
				+ "ALT + F : Otvara fajl meni <br/>"
				+ "ALT + W : Pozicionira se na meni stavku za pravljenje novog entiteta <br/>"
				+ "ALT + V : Pozicionira se na meni stavku za čuvanje podataka  <br/>"
				+ "ALT + P : Otvara meni za selekciju prikaza entiteta (Studenti, Profesori, Predmeti, Katedre) <br/>"
				+ "ALT + C : Pozicionira se na meni stavku za zatvaranje aplikacije <br/>"
				+ "ALT + U : Pozicionira se na meni stavku za prikaz studenata dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + P : Pozicionira se na meni stavku za prikaz profesora dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + M : Pozicionira se na meni stavku za prikaz predmeta dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + K : Pozicionira se na meni stavku za prikaz katedri dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + E : Otvara meni za izmenu <br/>"
				+ "ALT + D : Pozicionira se na meni stavku za izmenu entiteta <br/>"
				+ "ALT + L : Pozicionira se na meni stavku za brisanje entiteta <br/>"
				+ "ALT + H : Otvara meni za pomoć <br/>"
				+ "ALT + E : Pozicionira se na meni stavku za pomoć <br/>"
				+ "ALT + B : Pozicionira se na meni stavku informacije<br/>"
				+ " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>"
				+ "Akceleratori: <br/>"
				+ "CTRL + N : Dodavanje novog entiteta <br/>"
				+ "CTRL + S : Čuvanje podataka <br/>"
				+ "CTRL + Z : Zatvaranje aplikacije <br/>"
				+ "CTRL + T : Prikaz tabele studenata <br/>"
				+ "CTRL + Q : Prikaz tabele profesora <br/>"
				+ "CTRL + M : Prikaz tabele predmeta <br/>"
				+ "CTRL + O : Prikaz tabele katedri <br/>"
				+ "CTRL + G : Izmena entiteta <br/>"
				+ "CTRL + Y : Brisanje entiteta <br/>"
				+ "CTRL + U : Prikaz pomoći <br/>"
				+ "CTRL + I : Prikaz infromacija o aplikaciji </html>";

		String EN = "<html>Help:<br/>"
				+ "Entities can be added, modified and deleted by clicking on the appropriate buttons in the toolbar section, by clicking on the appropriate<br/>"
				+ "menu in the main menu, using the mnemonics and accelerators below, the entity must be selected when changing and deleting it.<br/>"
				+ " <br/>"
				+ "When filling in all fields for editing or entering data, all fields must meet certain requirements and be entered,<br/>"
				+ "otherwise the confirmation button remains disabled.<br/>"
				+ " <br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ "The student:<br/>"
				+ "Information ---<br/>"
				+ "Name and surname have no special restrictions<br/>"
				+ "The date must be entered in the format DD.MM.YYYY.<br/>"
				+ "The address must be entered in the format: street, number, city, country<br/>"
				+ "There are no restrictions for the phone<br/>"
				+ "Email addresses must contain a string of characters, then a period, then a string of characters, then @, then a string of characters, then a period, then again, a string of characters<br/>"
				+ "The index number is entered in the format xx yyy / zzzz where xx is the course, yyy is the index number and zzzz is the year of enrollment<br/>"
				+ "The year of enrollment must be a number<br/>"
				+ " <br/>"
				+ "Passed subjects ---<br/>"
				+ "To cancel a grade, the grade must first be selected and then a confirmation of the grade cancellation must be done<br/>"
				+ " <br/>"
				+ "Unpassed subjects ---<br/>"
				+ "By clicking the Add button, you can add course to a student<br/>"
				+ "which are neither in passed nor in unposted subjects<br/>"
				+ "The delete button deletes the marked items<br/>"
				+ "The Passing button opens a new dialog where we enter the grade and exam date of the marked subject<br/>"
				+ "The grade is a number, the date is in the format DD.MM.YYYY.<br/>"
				+ "  <br/>"
				+ " <br/>"
				+ "Clicking on the confirmation button confirms the change<br/>"
				+ " <br/>"
				+ "Student Key: Index<br/>"
				+ "<br/>"
				+ "Student search is performed in three ways:<br/>"
				+ "1 word: surname<br/>"
				+ "2 words: last name, first name<br/>"
				+ "3 words: index, last name, first name<br/>"
				+ "words are separated by commas<br/>"
				+ "<br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ " <br/>"
				+ "Teachers:<br/>"
				+ "Information ---<br/>"
				+ "Name and surname have no special restrictions<br/>"
				+ "The date must be entered in the format DD.MM.YYYY.<br/>"
				+ "The address must be entered in the format: street, number, city, country<br/>"
				+ "There is no restriction for the phone number<br/>"
				+ "There must be exactly 9 numbers for the ID card number<br/>"
				+ "For years of service the number must be<br/>"
				+ "e-mail addresse must contain a string of characters, then a period, then a string of characters, then @, then a string of characters, then a period, then again, a string of characters<br/>"
				+ " <br/>"
				+ "Teaches ---<br/>"
				+ "A subject that that professor does not already teach from the list of subjects can be added<br/>"
				+ "If there is already a professor in that subject, then that old one is removed and a new one is set<br/>"
				+ "An item can be removed by checking and clicking the remove item button<br/>"
				+ "Clicking on the confirmation button makes a successful change<br/>"
				+ " <br/>"
				+ "<br/>"
				+ "Professor's key: ID number<br/>"
				+ "<br/>"
				+ "The search for professors is done in two ways:<br/>"
				+ "1 word: surname<br/>"
				+ "2 words: last name, first name<br/>"
				+ "words are separated by commas<br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ " <br/>"
				+ "Subjects:<br/>"
				+ "The subject id consists of one or 2 letters followed by 1 or 2 numbers<br/>"
				+ "The name of the subject has no special restrictions<br/>"
				+ "The ECTS must be an integer<br/>"
				+ " <br/>"
				+ "If there is no subject professor, pressing the + button adds a professor to the subject and the information is saved immediately<br/>"
				+ "+ becomes disabled, - becomes enabled<br/>"
				+ "If subject professor exist, pressing the - button the professor is removed from the subject, that information is saved immediately<br/>"
				+ "- becomes disabled, + becomes enabled<br/>"
				+ "<br/>"
				+ " <br/>"
				+ "Clicking on the confirmation button confirms change<br/>"
				+ "<br/>"
				+ "Subject Key: Subject id<br/>"
				+ "<br/>"
				+ "The search for items is done in two ways:<br/>"
				+ "1 word: name<br/>"
				+ "2 words: subject name, id<br/>"
				+ "words are separated by commas<br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ " <br/>"
				+ "Departments:<br/>"
				+ "By opening the department window, it is only possible to see the tabular view of the appointment of a new head of the department<br/>"
				+ " <br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ " <br/>"
				+ "Mnemonics:<br/>"
				+ "ALT + F: Opens the file menu<br/>"
				+ "ALT + W: Positions to the menu item for creating a new entity<br/>"
				+ "ALT + V: Positions to the menu item for saving the data<br/>"
				+ "ALT + P: Opens the menu for selecting entity display (Students, Professors, Courses, Departments)<br/>"
				+ "ALT + C: Positions the menu item to close the application<br/>"
				+ "ALT + U: Positions on the student display menu item while in the entity display item menu<br/>"
				+ "ALT + P: Positions on the menu item to display the professor while we are in the menu item to display the entity<br/>"
				+ "ALT + M: Positions on the menu item to display the item while we are in the menu item to display the entity<br/>"
				+ "ALT + K: Positions on the menu item to display chairs while we are in the menu item to display the entity<br/>"
				+ "ALT + E: Opens the edit menu<br/>"
				+ "ALT + D: Positions to the menu item for changing entity<br/>"
				+ "ALT + L: Positions to the menu item for deliting entity<br/>"
				+ "ALT + H: Opens the help menu<br/>"
				+ "ALT + E: The help item is positioned on the menu for help<br/>"
				+ "ALT + B: The help item is positioned on the menu for about<br/>"
				+ "<br/>"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>"
				+ "<br/>"
				+ "Accelerators:<br/>"
				+ "CTRL + N: Add a new entity<br/>"
				+ "CTRL + S: Save data<br/>"
				+ "CTRL + Z: Close the application<br/>"
				+ "CTRL + T: Display the student table<br/>"
				+ "CTRL + Q: Display the professor table<br/>"
				+ "CTRL + M: Display the subject table<br/>"
				+ "CTRL + o: Display the departments table<br/>"
				+ "CTRL + G: Edit entity<br/>"
				+ "CTRL + Y: Delete entity<br/>"
				+ "CTRL + U: Display help<br/>"
				+ "CTRL + I: View application information<br/>"
				+ "</html>";
	

		String kraj;

		if (!Locale.getDefault().equals(new Locale("sr", "RS")))
			kraj = EN;
		else
			kraj = RS;

		t.setText(kraj);

	}

	private HelpDialog(Frame owner, String title, boolean modal) {

		super(owner, title, modal);
		setSize(900, 900);
		setLocationRelativeTo(null);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		t = new JLabel("", SwingConstants.LEFT);
		azurirajDijalog();
		JScrollPane scrollPane = new JScrollPane(t);
		centerPanel.add(scrollPane);
		this.add(centerPanel);

	}
}
