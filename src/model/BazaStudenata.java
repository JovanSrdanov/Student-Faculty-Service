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
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		Adresa a = new Adresa("Novosadska", 4, "Zrenjanin", "Srbija");
		Student pom1 = new Student("Srdanov", "Jovan", LocalDate.now(), a, 38106354, "jovan@gmail.com", "ra-145-2019",
				2019, 3, Status.BUDŽET, 0, null, null);
		Student pom2 = new Student("Erakovic", "Strahinja", LocalDate.now(), a, 38146454, "strahinja@gmail.com",
				"ra-146-2018", 2018, 3, Status.BUDŽET, 0, null, null);
		Student pom3 = new Student("Prezimenic", "Imenko", LocalDate.now(), a, 38656454, "imenko@yahoo.com",
				"sw-147-2017", 2017, 3, Status.BUDŽET, 0, null, null);
		Student pom4 = new Student("Strasno", "Uzas", LocalDate.now(), a, 38107554, "mjau@gmail.com", "sw-148-2016",
				2016, 2, Status.SAMOFINANRSIRANJE, 0, null, null);
		Student pom5 = new Student("Kovačević", "Dragoslava", LocalDate.now(), a, 38107552, "dragoslava@gmail.com",
				"ra-22-2019", 2019, 3, Status.SAMOFINANRSIRANJE, 0, null, null);
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

	public void dodajStudnetna(Student s) {
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

	public void izmeniStudenta(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja,
			int kontaktTelefon, String eMailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija,
			Status status,String stariIndex) {
		for (Student s : studenti) {
			if (s.getBrojIndexa().equals(stariIndex)) {
				s.setBrojIndexa(brojIndexa);
				s.setPrezime(prezime);
				s.setIme(ime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(kontaktTelefon);
				s.seteMailAdresa(eMailAdresa);
				s.setGodinaUpisa(godinaUpisa);
				s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				s.setStatus(status);
				s.setSpisakNePolozenihIspita(null);
				s.setSpisakPolozenihIspita(null);

			}
		}
	}

}
