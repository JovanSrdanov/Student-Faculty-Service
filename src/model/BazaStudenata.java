package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudenata() {

		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEX");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");

	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		Student pom1 = new Student("Srdanov", "Jovan", LocalDate.now(), null, 38106354, "nekimail", "ra-145-2019", 2019, 3,
				Status.BUDŽET, 8.5, null, null);
		Student pom2 = new Student("Erakovic", "Strahinja", LocalDate.now(), null, 38146454, "nekimail1", "ra-146-2018",
				2018, 4, Status.BUDŽET, 8.4, null, null);
		Student pom3 = new Student("Prezimenic", "Imenko", LocalDate.now(), null, 38656454, "nekimail2", "ra-147-2018", 2017,
				5, Status.BUDŽET, 8.5, null, null);
		Student pom4 = new Student("JaoDokleVise", "NMG", LocalDate.now(), null, 38107554, "nekimail3", "ra-148-2016", 2016,
				6, Status.SAMOFINANRSIRANJE, 8.2, null, null);
		Student pom5 = new Student("Kovačević", "Dragoslava", LocalDate.now(), null, 38107552, "nekimail3", "ra-22-2019", 2019,
				3, Status.SAMOFINANRSIRANJE, 8.2, null, null);
		this.studenti.add(pom1);
		this.studenti.add(pom2);
		this.studenti.add(pom3);
		this.studenti.add(pom4);
		this.studenti.add(pom5);

	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student s = this.studenti.get(row);
		switch (column) {
		case 0:
			return s.getBrojIndexa();
		case 1:
			return s.getIme();
		case 2:
			return s.getPrezime();
		case 3:
			return Long.toString(s.getTrenutnaGodinaStudija());
		case 4:
			return s.getStatus().toString();
		case 5:
			return Double.toString(s.getProsecnaOcena());
		default:
			return null;
		}
	}

	public void dodajStudnetne(Student s) {
		this.studenti.add(s);
	}

	public void izbrisiStudenta(String id) {
		for (Student s : studenti) {
			if (s.getBrojIndexa().equals(id)) {
				studenti.remove(s);
				break;
			}
		}
	}

	public void izmeniIgraca(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja,
			int kontaktTelefon, String eMailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija,
			Status status, double prosecnaOcena) {
		for (Student s : studenti) {
			if (s.getBrojIndexa().equals(brojIndexa)) {
				s.setPrezime(prezime);
				s.setIme(ime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(kontaktTelefon);
				s.seteMailAdresa(eMailAdresa);
				s.setGodinaUpisa(godinaUpisa);
				s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				s.setStatus(status);

			}
		}
	}

}
