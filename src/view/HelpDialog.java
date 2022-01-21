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
		String RS = "<html>Pomoć: <br/>"
				+ "Entiteti se mogu dodati, izmeniti i obrisati pomoću klika na odgovarajuće dugmiće u toolbar sekciji, pomoću klika na odgovarajući  <br/>"
				+ "meni u glavnom meniju, pomoću dole navedenih mnemonika i akceleratora, prilikom izmene i brisanja mora da se selektuje entitet  <br/>"
				+ "nad kojim se vrši izmena <br/>" + " <br/>"
				+ "Prilikom popunjavanja svih polja za izmenu ili unos podataka, moraju sva polja zadovoljati svoja ograničenja i biti unešena,  <br/>"
				+ "inače dugme za potvrdu ostaje onemogućeno. <br/>" + " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ "Studenti: <br/>" + "Informacije --- <br/>" + "Ime i prezime nemaju specijalna ograničenja <br/>"
				+ "Datum se mora uneti u formatu DD.MM.GGGG. <br/>"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,država <br/>" + "Za telefon nema ograničenja <br/>"
				+ "EMail adrese mora sadržati niz karaktera, pa tačku, pa niz karaktera pa @, pa niz karaktera pa tačku pa opet niz karaktera <br/>"
				+ "Broj indexa se unosi u formatu xx yyy/zzzz gde je xx smer, yyy broj indexa a zzzz godina upisa <br/>"
				+ "Godina upisa mora biti broj <br/>" + " <br/>" + "Položeni predmeti --- <br/>"
				+ "Za poništavanje ocene, mora ocena prvo biti označena i onda se mora uraditi potvrđivanje poništavanja ocene <br/>"
				+ " <br/>" + "Nepoloženi predmeti --- <br/>"
				+ "Klikom na dugme Dodaj se mogu dodati iz predmeti iz liste koje student može da sluša <br/>"
				+ "koji nisu ni u položenim ni u nepoloženim predmetima  <br/>"
				+ "Dugme obriši briše označen predmeta <br/>"
				+ "Dugme Polaganje otvara novi dijalog gde unosimo ocenu i datum ispita označenog predmeta <br/>"
				+ "Ocena je broj, datum je u formatu DD.MM.GGGG. <br/>" + "  <br/>" + " <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>" + " <br/>" + "Ključ studenta : Indeks<br/>"
				+ "<br/>" + "Pretraga studenta se vrši na tri načina:<br/>" + "1 reč : prezime<br/>"
				+ "2 reči : prezime,ime<br/>" + "3 reči : index, prezime, ime<br/>" + "reči se odvajaju zarezima<br/>"
				+ "<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>" + "Profesori: <br/>" + "Informacije --- <br/>"
				+ "Ime i prezime nemaju specijalna ograničenja <br/>"
				+ "Datum se mora uneti u formatu DD.MM.GGGG. <br/>"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,država <br/>" + "Za telefon nema ograničenja <br/>"
				+ "Za broj lične karte mora tačno 9 brojeva <br/>" + "Za godine staža mora broj <br/>"
				+ "EMail adrese mora sadržati niz karaktera, pa tačku, pa niz karaktera pa @, pa niz karaktera pa tačku pa opet niz karaktera <br/>"
				+ " <br/>" + "Predaje --- <br/>"
				+ "Može se dodati predmet koji taj profesor već ne predaje iz liste predmeta <br/>"
				+ "Ako već postoji profesor na tom predmetu, onda se taj stari ukloni i postavi novi<br/>"
				+ "Može se ukloniti predmet ako se označi i klikne dugme ukloni predmet <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>" + " <br/>" + "<br/>"
				+ "Ključ profesora : broj lične karte<br/>" + "<br/>" + "Pretraga profesora se vrši na dva načina:<br/>"
				+ "1 reč : prezime<br/>" + "2 reči : prezime, ime<br/>" + "reči se odvajaju zarezima<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>" + "Predmeti: <br/>"
				+ "Šifra predmeta se sastoji iz jednog ili 2 slova nakon čega slede 1 ili 2 broja <br/>"
				+ "Naziv predmeta nema specijalna ograničenja <br/>" + "ESPB mora biti ceo broj <br/>" + " <br/>"
				+ "Ako nema predmetnog profesora pritiskom na dugme + se dodaje profesor na predmet i odmah se ta informacija sačuva <br/>"
				+ "+ postane onemogućeno za stisnuti, - postaje omogućeno <br/>"
				+ "Ako ima predmetnog profesora pritiskom na dugme - se uklanja profesor sa predmeta odmah se ta informacija sačuva <br/>"
				+ "- postane onemogućeno za stisnuti, + postaje omogućeno <br/>" + "<br/>" + " <br/>"
				+ "Klikom na dugme potvrda se vrši uspešna izmena <br/>" + "<br/>"
				+ "Ključ predmeta : Šifra predmeta<br/>" + "<br/>" + "Pretraga predmeta se vrši na dva načina:<br/>"
				+ "1 reč : naziv<br/>" + "2 reći : naziv predmeta, šifra<br/>" + "reči se odvajaju zarezima<br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>" + "Katedre: <br/>"
				+ "Otvaranjem prozora katedri moguće je samo videti tabelarni prikaz postaviti novog šefa katedre <br/>"
				+ " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>" + "Mnemonici: <br/>" + "ALT + F : Otvara fajl meni <br/>"
				+ "ALT + W : Pozicionira se na meni stavku za pravljenje novog entiteta <br/>"
				+ "ALT + V : Pozicionira se na meni stavku za čuvanje podataka  <br/>"
				+ "ALT + P : Otvara meni za selekciju prikaza entiteta (Studenti, Profesori, Predmeti, Katedre) <br/>"
				+ "ALT + C : Pozicionira se na meni stavku za zatvaranje aplikacije <br/>"
				+ "ALT + U : Pozicionira se na meni stavku za prikaz studenata dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + P : Pozicionira se na meni stavku za prikaz profesora dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + R : Pozicionira se na meni stavku za prikaz predmeta dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + K : Pozicionira se na meni stavku za prikaz katedri dok se nalazimo u meni stavki za prikaz entiteta <br/>"
				+ "ALT + E : Otvara meni za izmenu <br/>"
				+ "ALT + D : Pozicionira se na meni stavku za izmenu entiteta <br/>"
				+ "ALT + L : Pozicionira se na meni stavku za brisanje entiteta <br/>"
				+ "ALT + H : Otvara meni za pomoć <br/>" + "ALT + D : Pozicionira se na meni stavku za pomoć <br/>"
				+ "ALT + B : Pozicionira se na meni stavku za pomoć <br/>" + " <br/>"
				+ "---------------------------------------------------------------------------------------------------------------------------------- <br/>"
				+ " <br/>" + "Akceleratori: <br/>" + "CTRL + N : Dodavanje novog entiteta <br/>"
				+ "CTRL + S : Čuvanje podataka <br/>" + "CTRL + Z : Zatvaranje aplikacije <br/>"
				+ "CTRL + T : Prikaz tabele studenata <br/>" + "CTRL + Q : Prikaz tabele profesora <br/>"
				+ "CTRL + M : Prikaz tabele predmeta <br/>" + "CTRL + o : Prikaz tabele katedri <br/>"
				+ "CTRL + G : Izmena entiteta <br/>" + "CTRL + Y : Brisanje entiteta <br/>"
				+ "CTRL + I : Prikaz pomoći <br/>" + "CTRL + X : Prikaz infromacija o aplikaciji </html>";

		String EN = "en";
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
