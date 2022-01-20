package view;

import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class HelpDialog  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532094756704393899L;
	public HelpDialog(Frame owner, String title, boolean modal) {
		
		super(owner, title, modal);
		setSize(900, 900);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		String s = "<html>Pomoc:<br/>\r\n"
				+ "Entiteti se mogu dodati, izmeniti i obrisati pomocu klika na odgovarajuce dugmice u toolbar sekciji, pomocu klika na odgovarajuci <br/>\r\n"
				+ "meni u glavnom meniju, pomocu dole navedenih mnemonika i akceleratora, prilikom izmene i brisanja mora da se selektuje entitet <br/>\r\n"
				+ "nad kojim se vrsi izmena<br/>\r\n"
				+ "<br/>\r\n"
				+ "Prilikom popunjavanja svih polja za izmenu ili unos podataka, moraju sva polja zadovoljati svoja ogranicenja i biti unesena, <br/>\r\n"
				+ "inace dugme za potvrdu ostaje onemoguceno.<br/>\r\n"
				+ "<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "Studenti:<br/>\r\n"
				+ "Informacije ---<br/>\r\n"
				+ "Ime i prezime nemaju specijalna ogranicenja<br/>\r\n"
				+ "Datum se mora uneti u formatu DD.MM.GGGG.<br/>\r\n"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,drzava<br/>\r\n"
				+ "Za telefon nema ogranicenja<br/>\r\n"
				+ "EMail adrese mora sadrzati niz karaktera, pa tacku, pa niz karaktera pa @, pa niz karaktera pa tacku pa opet niz karaktera<br/>\r\n"
				+ "Broj indexa se unosi u formatu xx yyy/zzzz gde je xx smer, yyy broj indexa a zzzz godina upisa<br/>\r\n"
				+ "Godina upisa mora biti broj<br/>\r\n"
				+ "<br/>\r\n"
				+ "Polozeni predmeti ---<br/>\r\n"
				+ "Za ponistavanje ocene, mora ocena prvo biti oznacena i onda se mora uraditi potvrdjivanje ponistavanja ocene<br/>\r\n"
				+ "<br/>\r\n"
				+ "Nepolozeni predmeti ---<br/>\r\n"
				+ "Klikom na dugme Dodaj se mogu dodati iz predmeti iz liste koje student moze da slusa<br/>\r\n"
				+ "koji nisu ni u polozenim ni u nepolozenim predmetima <br/>\r\n"
				+ "Dugme obrisi brise oznacen predmeta<br/>\r\n"
				+ "Dugme Polaganje otvara novi dijalog gde unosimo ocenu i datum ispita oznacenog predmeta<br/>\r\n"
				+ "Ocena je broj, datum je u formatu DD.MM.GGGG.<br/>\r\n"
				+ " <br/>\r\n"
				+ "<br/>\r\n"
				+ "Klikom na dugme potvrda se vrsi uspesna izmena<br/>\r\n"
				+ "<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "<br/>\r\n"
				+ "Profesori:<br/>\r\n"
				+ "Informacije ---<br/>\r\n"
				+ "Ime i prezime nemaju specijalna ogranicenja<br/>\r\n"
				+ "Datum se mora uneti u formatu DD.MM.GGGG.<br/>\r\n"
				+ "Adresa se mora uneti u formatu : ulica,broj,grad,drzava<br/>\r\n"
				+ "Za telefon nema ogranicenja<br/>\r\n"
				+ "Za broj licne karte mora tacno 9 brojeva<br/>\r\n"
				+ "Za godine staza mora broj<br/>\r\n"
				+ "EMail adrese mora sadrzati niz karaktera, pa tacku, pa niz karaktera pa @, pa niz karaktera pa tacku pa opet niz karaktera<br/>\r\n"
				+ "<br/>\r\n"
				+ "Predaje ---<br/>\r\n"
				+ "Moze se dodati predmet koji taj profesor vec ne predaje iz liste predmeta<br/>\r\n"
				+ "Moze se ukloniti predmet ako se oznaci i klikne dugme ukloni predmet<br/>\r\n"
				+ "Klikom na dugme potvrda se vrsi uspesna izmena<br/>\r\n"
				+ "<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "<br/>\r\n"
				+ "Predmeti:<br/>\r\n"
				+ "Sifra predmeta se sastoji iz jednog ili 2 slova nakon cega slede 1 ili 2 broja<br/>\r\n"
				+ "Naziv predmeta nema specijalna ogranicenja<br/>\r\n"
				+ "ESPB mora biti ceo broj<br/>\r\n"
				+ "<br/>\r\n"
				+ "Ako nema predmetnog profesora pritiskom na dugme + se dodaje profesor na predmet i odmah se ta informacija sacuva<br/>\r\n"
				+ "+ postane onemoguceno za stisnuti, - postaje omoguceno<br/>\r\n"
				+ "Ako ima predmetnog profesora pritiskom na dugme - se uklanja profesor sa predmeta odmah se ta informacija sacuva<br/>\r\n"
				+ "- postane onemoguceno za stisnuti, + postaje omoguceno<br/>\r\n"
				+ "<br/>\r\n"
				+ "Klikom na dugme potvrda se vrsi uspesna izmena<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "<br/>\r\n"
				+ "Katedre:<br/>\r\n"
				+ "Otvaranjem prozora katedri moguce je samo videti tabelarni prikaz postaviti novog sefa katedre<br/>\r\n"
				+ "<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "<br/>\r\n"
				+ "Mnemonici:<br/>\r\n"
				+ "ALT + F : Otvara fajl meni<br/>\r\n"
				+ "ALT + W : Pozicionira se na meni stavku za pravljenje novog entiteta<br/>\r\n"
				+ "ALT + V : Pozicionira se na meni stavku za cuvanje podataka <br/>\r\n"
				+ "ALT + P : Otvara meni za selekciju prikaza entiteta (Studenti, Profesori, Predmeti, Katedre)<br/>\r\n"
				+ "ALT + C : Pozicionira se na meni stavku za zatvaranje aplikacije<br/>\r\n"
				+ "ALT + U : Pozicionira se na meni stavku za prikaz studenata dok se nalazimo u meni stavki za prikaz entiteta<br/>\r\n"
				+ "ALT + P : Pozicionira se na meni stavku za prikaz profesora dok se nalazimo u meni stavki za prikaz entiteta<br/>\r\n"
				+ "ALT + R : Pozicionira se na meni stavku za prikaz predmeta dok se nalazimo u meni stavki za prikaz entiteta<br/>\r\n"
				+ "ALT + K : Pozicionira se na meni stavku za prikaz katedri dok se nalazimo u meni stavki za prikaz entiteta<br/>\r\n"
				+ "ALT + E : Otvara meni za izmenu<br/>\r\n"
				+ "ALT + D : Pozicionira se na meni stavku za izmenu entiteta<br/>\r\n"
				+ "ALT + L : Pozicionira se na meni stavku za brisanje entiteta<br/>\r\n"
				+ "ALT + H : Otvara meni za pomoc<br/>\r\n"
				+ "ALT + D : Pozicionira se na meni stavku za pomoc<br/>\r\n"
				+ "ALT + B : Pozicionira se na meni stavku za pomoc<br/>\r\n"
				+ "<br/>\r\n"
				+ "----------------------------------------------------------------------------------------------------------------------------------<br/>\r\n"
				+ "<br/>\r\n"
				+ "Akceleratori:<br/>\r\n"
				+ "CTRL + N : Dodavanje novog entiteta<br/>\r\n"
				+ "CTRL + S : Cuvanje podataka<br/>\r\n"
				+ "CTRL + Z : Zatvaranje aplikacije<br/>\r\n"
				+ "CTRL + T : Prikaz tabele studenata<br/>\r\n"
				+ "CTRL + Q : Prikaz tabele profesora<br/>\r\n"
				+ "CTRL + M : Prikaz tabele predmeta<br/>\r\n"
				+ "CTRL + o : Prikaz tabele katedri<br/>\r\n"
				+ "CTRL + G : Izmena entiteta<br/>\r\n"
				+ "CTRL + Y : Brisanje entiteta<br/>\r\n"
				+ "CTRL + I : Prikaz pomoci<br/>\r\n"
				+ "CTRL + X : Prikaz infromacija o aplikaciji<br/>\r\n"
				+ "</html>";
				
		
		JLabel t = new JLabel(s,SwingConstants.LEFT);
		
		JScrollPane scrollPane= new JScrollPane(t);
		
		centerPanel.add(scrollPane);
		
		

		this.add(centerPanel);
		
	}
}
