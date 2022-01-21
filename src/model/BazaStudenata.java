package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controller.MyApp;
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

		
		this.kolone.add(MyApp.resourceBundle.getString("index"));
		this.kolone.add(MyApp.resourceBundle.getString("ime"));
		this.kolone.add(MyApp.resourceBundle.getString("prezime"));
		this.kolone.add(MyApp.resourceBundle.getString("godina_studija"));
		this.kolone.add(MyApp.resourceBundle.getString("status"));
		this.kolone.add(MyApp.resourceBundle.getString("prosek"));

	}

	public void izmeniJezikKolonaStudenti() {

		this.kolone.set(0, MyApp.resourceBundle.getString("index"));
		this.kolone.set(1, MyApp.resourceBundle.getString("ime"));
		this.kolone.set(2, MyApp.resourceBundle.getString("prezime"));
		this.kolone.set(3, MyApp.resourceBundle.getString("godina_studija"));
		this.kolone.set(4, MyApp.resourceBundle.getString("status"));
		this.kolone.set(5, MyApp.resourceBundle.getString("prosek"));
	}

	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		this.studentiPretraga = new ArrayList<Student>();

		/*
		 * Adresa a = new Adresa("Novosadska", "3", "Zrenjanin", "Srbija"); Student pom1
		 * = new Student("Srdanov", "Jovan", LocalDate.now(), a, "5/55523",
		 * "jovan.s@gmail.com", "RA 145/2019", 2019, 3, Status.BUDŽET, 0, null, null);
		 * Student pom2 = new Student("Erakovic", "Strahinja", LocalDate.now(), a,
		 * "555/523", "strahinja.e@gmail.com", "RA 146/2018", 2018, 3, Status.BUDŽET, 0,
		 * null, null); Student pom3 = new Student("Prezimenic", "Imenko",
		 * LocalDate.now(), a, "55552/3", "imenko.p@yahoo.com", "SW 147/2017", 2017, 3,
		 * Status.BUDŽET, 0, null, null); Student pom4 = new Student("Strasno", "Uzas",
		 * LocalDate.now(), a, "555/323", "mjau.mmm@gmail.com", "SW 148/2016", 2016, 2,
		 * Status.SAMOFINANRSIRANJE, 0, null, null); Student pom5 = new
		 * Student("Kovačević", "Dragoslava", LocalDate.now(), a, "555/5523",
		 * "dragoslava.kov@gmail.com", "RA 22/2019", 2019, 3, Status.SAMOFINANRSIRANJE,
		 * 0, null, null);
		 * 
		 * Profesor p = new Profesor("Milan", "Rapajic", LocalDate.of(1980, 3, 13), new
		 * Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64",
		 * "rap.aja@uns.ac.rs", new Adresa("Ulicica", "22", "Novi Sad", "Srbija"),
		 * 987654321, Zvanje.VANREDNI_PROFESOR, 69, null);
		 * 
		 * Predmet pp = new Predmet("e55", "Baze podataka 2", Semestar.ZIMSKI, 3, p, 6);
		 * // gej
		 * 
		 * Ocena o = new Ocena(pom1, pp, 5, LocalDate.now());
		 * 
		 * ArrayList<Ocena> heheheh = new ArrayList<Ocena>(); heheheh.add(o);
		 * 
		 * pom1.setSpisakNePolozenihIspita(heheheh);
		 * 
		 * Ocena op = new Ocena(pom1, pp, 10, LocalDate.now()); ArrayList<Ocena>
		 * zaPolozene = new ArrayList<Ocena>(); zaPolozene.add(op);
		 * pom2.setSpisakPolozenihIspita(zaPolozene);
		 * 
		 * this.studenti.add(pom1); this.studenti.add(pom2); this.studenti.add(pom3);
		 * this.studenti.add(pom4); this.studenti.add(pom5);
		 */
		
/*		
		Adresa[] nizAdr = new Adresa[13];
		nizAdr[0] = new Adresa("Šafarikova", "2", "Novi Sad", "Srbija");
		nizAdr[1] = new Adresa("Nikole Tesle", "56", "Novi Sad", "Srbija");
		nizAdr[2] = new Adresa("Bulevar Patrijaha Pavla", "3", "Beograd", "Srbija");
		nizAdr[3] = new Adresa("Stražilovska", "6a", "Novi Sad", "Srbija");
		nizAdr[4] = new Adresa("Nikole Pašića", "2d", "Kikinda", "Srbija");
		nizAdr[5] = new Adresa("Bulevar Kralja Petra", "22", "Niš", "Srbija");
		nizAdr[6] = new Adresa("Tolstojeva", "31", "Novi Sad", "Srbija");
		nizAdr[7] = new Adresa("Marićeva", "11", "Kragujevac", "Srbija");
		nizAdr[8] = new Adresa("Stražilovska", "3", "Beograd", "Srbija");
		nizAdr[9] = new Adresa("Nikole Pašića", "6a", "Novi Sad", "Srbija");
		nizAdr[10] = new Adresa("Bulevar Kralja Petra", "2d", "Niš", "Srbija");
		nizAdr[11] = new Adresa("Knez Mihajlova", "22", "Beograd", "Srbija");
		nizAdr[12] = new Adresa("Ulica", "0", "Grad", "Drzava");
		
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("d.M.yyyy.");
		studenti.add(new Student("Milosevic", "Marko", LocalDate.parse("12.03.2001.", formater), nizAdr[1], "021/333-555", "marko.milosevic@mailinator.com", "RA 2/2020", 2020, 1, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Milić", "Marija", LocalDate.parse("12.01.2000.", formater), nizAdr[2], "021/555-2222", "marija.milic@mailinator.com", "RA 3/2019", 2019, 2, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Nikolic", "Nikola", LocalDate.parse("30.08.2001.", formater), nizAdr[3], "021/135-463", "nikola.nikolic@mailinator.com", "RA 3/2017", 2017, 1, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Peric", "Pera", LocalDate.parse("07.06.1995.", formater), nizAdr[4], "021/903-463", "pera.peric@mailinator.com", "RA 134/2015", 2015, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Ilic", "Sofija", LocalDate.parse("06.05.1999.", formater), nizAdr[5], "021/731-067", "sofija.ilic@mailinator.com", "RA 5/2019", 2019, 3, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Lukic", "Martina", LocalDate.parse("16.05.1999.", formater), nizAdr[6], "011/4333-800", "martina.lukic@mailinator.com", "RA 8/2018", 2018, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Stojakovic", "Stojan", LocalDate.parse("19.10.2001.", formater), nizAdr[7], "011/3130-007", "stojan.stojakovic@mailinator.com", "RA 10/2017", 2017, 1, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Milanovic", "Milan", LocalDate.parse("02.11.2000.", formater), nizAdr[8], "015/313-061", "milan.milanovic@mailinator.com", "RA 12/2017", 2017, 2, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Milic", "Miroslav", LocalDate.parse("11.10.2000.", formater), nizAdr[9], "021/351-091", "miroslav.milic@mailinator.com", "RA 16/2019", 2019, 2, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Gojic", "Stefan", LocalDate.parse("01.05.1999.", formater), nizAdr[10], "015/324-500", "stefan.gojic@mailinator.com", "RA 21/2015", 2015, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Jokic", "Anastasija", LocalDate.parse("11.07.1999.", formater), nizAdr[11], "011/2333-900", "anastasija.jokic@mailinator.com", "RA 9/2020", 2020, 3, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Bogdanovic", "Bogdan", LocalDate.parse("23.07.1999.", formater), nizAdr[12], "021/231-231", "bogdan.bogdanovic@mailinator.com", "RA 4/2017", 2017, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Dabovic", "Ana", LocalDate.parse("12.12.2001.", formater), nizAdr[12], "014/303-007", "ana.dabovic@mailinator.com", "RA 30/2019", 2019, 1, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Mikic", "Mika", LocalDate.parse("05.11.2001.", formater), nizAdr[2], "015/101-909", "mika.mikic@mailinator.com", "RA 1/2020", 2020, 1, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Deretic", "Jovan", LocalDate.parse("10.09.1998.", formater), nizAdr[3], "002/200-300", "jovan.deretic@mailinator.com", "RA 11/2018", 2018, 4, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Miskovic", "Nikola", LocalDate.parse("03.08.1998.", formater), nizAdr[4], "022/123-456", "nikola.miskovic@mailinator.com", "RA 12/2018", 2018, 4, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Stojanovic", "Martin", LocalDate.parse("01.05.1998.", formater), nizAdr[12], "024/321-775", "martin.stojanovic@mailinator.com", "RA 13/2018", 2018, 4, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Novakovic", "Tomislav", LocalDate.parse("25.02.1996.", formater), nizAdr[6], "011/1188-379", "tomislav.novakovic@mailinator.com", "RA 14/2018", 2018, 4, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Ivic", "Lena", LocalDate.parse("11.05.1998.", formater), nizAdr[7], "024/333-555", "lena.ivic@mailinator.com", "RA 154/2016", 2016, 4, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Lazic", "Jovan", LocalDate.parse("22.01.2001.", formater), nizAdr[8], "025/1189-479", "jovan.lazic@mailinator.com", "RA 23/2020", 2020, 1, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Mikic", "Isidora", LocalDate.parse("31.12.2000.", formater), nizAdr[9], "011/1122-366", "isidora.mikic@mailinator.com", "RA 1/2019", 2019, 2, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Ilic", "Vladimir", LocalDate.parse("31.08.1998.", formater), nizAdr[10], "0211122-367", "vladimir.ilic@mailinator.com", "SW 4/2014", 2014, 4, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Alicic", "Mirko", LocalDate.parse("21.07.1999.", formater), nizAdr[11], "012/1122-368", "mirko.alicic@mailinator.com", "SW 17/2015", 2015, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Perković", "Milisav", LocalDate.parse("28.09.1998.", formater), nizAdr[12], "012/1122-369", "milisav.pejkovic@mailinator.com", "SW 17/2016", 2016, 4, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Djordjević", "Purisa", LocalDate.parse("29.02.2000.", formater), nizAdr[3], "011/1543-370", "purisa.djordjevic@mailinator.com", "SW 27/2018", 2018, 2, Status.BUDŽET, 0, null, null));
		studenti.add(new Student("Kovacević", "Mikica", LocalDate.parse("23.03.1999.", formater), nizAdr[5], "011/1992-371", "mikica.kovacevic@mailinator.com", "RA 226/2017", 2017, 3, Status.SAMOFINANSIRANJE, 0, null, null));
		studenti.add(new Student("Milić", "Miloš", LocalDate.parse("21.10.2001.", formater), nizAdr[2], "011/8172-372", "milos.milic@mailinator.com", "SW 12/2021", 2021, 1, Status.SAMOFINANSIRANJE, 0, null, null));
*/	
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
			prezime = parts[2].trim();
			ime = parts[1].trim();
			index = parts[0].trim();

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

	}

	public void loadFix() {
		for(Predmet sviPred : BazaPredmeta.getInstance().getPredmeti()) {
			for(Student studIzSpiskaNep : sviPred.getSpisakStudenataKojiNisuPoloziliPredmet()) {
				for(Student sviStud : studenti) {
					if(sviStud.equals(studIzSpiskaNep)) {
						for(Ocena o : sviStud.getSpisakNePolozenihIspita()) {
							o.setPredmet(sviPred);
						}
					}
				}
			}
			
			for(Student studIzSpiskaNep : sviPred.getSpisakStudenataKojiSuPoloziliPredmet()) {
				for(Student sviStud : studenti) {
					if(sviStud.equals(studIzSpiskaNep)) {
						for(Ocena o : sviStud.getSpisakPolozenihIspita()) {
							o.setPredmet(sviPred);
						}
					}
				}
			}
		}
	}

}
