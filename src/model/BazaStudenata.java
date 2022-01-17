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
		
		
		
		
		Adresa a = new Adresa("Novosadska","3", "Zrenjanin", "Srbija");
		Student pom1 = new Student("Srdanov", "Jovan", LocalDate.now(), a, "5/55523", "jovan.s@gmail.com", "RA 145/2019",
				2019, 3, Status.BUDŽET, 0, null, null);
		Student pom2 = new Student("Erakovic", "Strahinja", LocalDate.now(), a, "555/523", "strahinja.e@gmail.com",
				"RA 146/2018", 2018, 3, Status.BUDŽET, 0, null, null);
		Student pom3 = new Student("Prezimenic", "Imenko", LocalDate.now(), a, "55552/3", "imenko.p@yahoo.com",
				"SW 147/2017", 2017, 3, Status.BUDŽET, 0, null, null);
		Student pom4 = new Student("Strasno", "Uzas", LocalDate.now(), a, "555/323", "mjau.mmm@gmail.com", "SW 148/2016",
				2016, 2, Status.SAMOFINANRSIRANJE, 0, null, null);
		Student pom5 = new Student("Kovačević", "Dragoslava", LocalDate.now(), a, "555/5523", "dragoslava.kov@gmail.com",
				"RA 22/2019", 2019, 3, Status.SAMOFINANRSIRANJE, 0, null, null);
	
	
		Profesor p = new Profesor("Milan", "Rapajic", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64", "rap.aja@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987654321, Zvanje.VANREDNI_PROFESOR, 69, null);
		
		Predmet pp =new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, p, 6);
		
		Ocena o = new Ocena(pom1, pp, 8,LocalDate.now());
		
		ArrayList<Ocena> heheheh= new ArrayList<Ocena>(); 
		heheheh.add(o);
		
		pom1.setSpisakNePolozenihIspita(heheheh);
		
		Ocena op = new Ocena(pom1, pp, 10,LocalDate.now());
		ArrayList<Ocena> zaPolozene= new ArrayList<Ocena>(); 
		zaPolozene.add(op);
		pom2.setSpisakPolozenihIspita(zaPolozene);
		
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
			String kontaktTelefon, String eMailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija,
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
