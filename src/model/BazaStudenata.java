package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import view.MyFrame;

public class BazaStudenata {

	private static BazaStudenata instance = null;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}

	private List<Student> studenti;
	private List<Student> studentiPretraga;
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
		this.studentiPretraga = new ArrayList<Student>();

		Adresa a = new Adresa("Novosadska", "3", "Zrenjanin", "Srbija");
		Student pom1 = new Student("Srdanov", "Jovan", LocalDate.now(), a, "5/55523", "jovan.s@gmail.com",
				"RA 145/2019", 2019, 3, Status.BUDŽET, 0, null, null);
		Student pom2 = new Student("Erakovic", "Strahinja", LocalDate.now(), a, "555/523", "strahinja.e@gmail.com",
				"RA 146/2018", 2018, 3, Status.BUDŽET, 0, null, null);
		Student pom3 = new Student("Prezimenic", "Imenko", LocalDate.now(), a, "55552/3", "imenko.p@yahoo.com",
				"SW 147/2017", 2017, 3, Status.BUDŽET, 0, null, null);
		Student pom4 = new Student("Strasno", "Uzas", LocalDate.now(), a, "555/323", "mjau.mmm@gmail.com",
				"SW 148/2016", 2016, 2, Status.SAMOFINANRSIRANJE, 0, null, null);
		Student pom5 = new Student("Kovačević", "Dragoslava", LocalDate.now(), a, "555/5523",
				"dragoslava.kov@gmail.com", "RA 22/2019", 2019, 3, Status.SAMOFINANRSIRANJE, 0, null, null);

		Profesor p = new Profesor("Milan", "Rapajic", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64", "rap.aja@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987654321, Zvanje.VANREDNI_PROFESOR, 69, null);

		Predmet pp = new Predmet("e55", "Baze podataka 2", Semestar.ZIMSKI, 3, p, 6); // gej

		Ocena o = new Ocena(pom1, pp, 5, LocalDate.now());

		ArrayList<Ocena> heheheh = new ArrayList<Ocena>();
		heheheh.add(o);

		pom1.setSpisakNePolozenihIspita(heheheh);

		Ocena op = new Ocena(pom1, pp, 10, LocalDate.now());
		ArrayList<Ocena> zaPolozene = new ArrayList<Ocena>();
		zaPolozene.add(op);
		pom2.setSpisakPolozenihIspita(zaPolozene);

		this.studenti.add(pom1);
		this.studenti.add(pom2);
		this.studenti.add(pom3);
		this.studenti.add(pom4);
		this.studenti.add(pom5);

	}

	public List<Student> getStudenti() {
		if (MyFrame.getInstance().isPretraga())
			return studentiPretraga;
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
		if (MyFrame.getInstance().isPretraga())
			return studentiPretraga.get(rowIndex);
		return studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student s;

		if (MyFrame.getInstance().isPretraga())
			s = studentiPretraga.get(row);
		else
			s = studenti.get(row);

		this.sracunajProsek(s);

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
			Status status, String stariIndex) {
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
				// s.setSpisakNePolozenihIspita(null);
				// s.setSpisakPolozenihIspita(null);

			}
		}
	}

	public void pretraziStudente(String rec) {
		studentiPretraga.clear();
		String ime;
		String prezime;
		String index;

		if (rec.matches("[^,]+")) {
			prezime = rec;

			for (Student s : studenti) {
				if (s.getPrezime().toUpperCase().contains(prezime.toUpperCase())) {
					studentiPretraga.add(s);
				}
			}

		}

		if (rec.matches("[^,]+,[^,]+")) {
			String[] parts = rec.split(",");
			prezime = parts[0].trim();
			ime = parts[1].trim();

			for (Student s : studenti) {
				if (s.getPrezime().toUpperCase().contains(prezime.toUpperCase())
						&& s.getIme().toUpperCase().contains(ime.toUpperCase())) {
					studentiPretraga.add(s);
				}
			}
		}

		if (rec.matches("[^,]+,[^,]+,[^,]+")) {
			String[] parts = rec.split(",");
			prezime = parts[0].trim();
			ime = parts[1].trim();
			index = parts[2].trim();

			for (Student s : studenti) {
				if (s.getPrezime().toUpperCase().contains(prezime.toUpperCase())
						&& s.getIme().toUpperCase().contains(ime.toUpperCase())
						&& s.getBrojIndexa().toUpperCase().contains(index.toUpperCase())) {
					studentiPretraga.add(s);
				}
			}
		}

	}

	private void sracunajProsek(Student s) {
		ArrayList<Ocena> ocene = s.getSpisakPolozenihIspita();

		Double avgOcn = 0.0;

		Double sumaO = 0.0;

		if (ocene != null) {
			for (Ocena o : ocene) {
				sumaO = o.getBrojcanaVrednostOcene() + sumaO;
			}
		}

		if (ocene.size() != 0)
			avgOcn = sumaO / ocene.size();

		s.setProsecnaOcena(avgOcn);
	}
	
	public void saveStudente(String fileName) {
		try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);
            
            output.writeObject(studenti);

            output.close();
        }

        catch (Exception e1) {
            e1.getStackTrace();
        }
	}
	
	public void loadStudenti(String fileName) {
		try {

			// Reads data using the ObjectInputStream
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);

			@SuppressWarnings("unchecked")
			ArrayList<Student> priv = (ArrayList<Student>) objStream.readObject();
			studenti = priv;

			objStream.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}

	};

	
}
