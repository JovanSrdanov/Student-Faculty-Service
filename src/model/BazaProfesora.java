package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import view.MyFrame;

public class BazaProfesora {
	private static BazaProfesora instance = null;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}

	private ArrayList<Profesor> profesori;
	private ArrayList<Profesor> profesoriPretraga;

	private List<String> kolone;

	private BazaProfesora() {

		initProfesore();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Zvanje");
		this.kolone.add("E-mail adresa");

	}

	private void initProfesore() {
		profesori = new ArrayList<Profesor>();
		profesoriPretraga = new ArrayList<Profesor>();

		Predmet p = new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, null, 6);
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		predmeti.add(p);

		profesori.add(new Profesor("Detlic", "Pera", LocalDate.now(),
				new Adresa("Jovana Jovanovica Zmaja", "123a", "Kikinda", "Srbija"), "23/23", "de.ste@gmail.com",
				new Adresa("ulicaKanc", "11", "Kikinda", "Srbija"), 123456789, Zvanje.REDOVNI_PROFESOR, 69, null));

		profesori.add(new Profesor("Rapajic", "Milan", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64", "rap.aja@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987654321, Zvanje.VANREDNI_PROFESOR, 69, predmeti));

		profesori.add(new Profesor("Jelicic", "peder", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381/232 64", "aaaa.aaaaaa@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987354321, Zvanje.DOCENT, 69, null));

	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public ArrayList<Profesor> getProfesoriPretraga() {
		return profesoriPretraga;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		if (MyFrame.getInstance().isPretraga())
			return profesoriPretraga.get(rowIndex);
		return profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor;

		if (MyFrame.getInstance().isPretraga()) {
			if (profesoriPretraga.isEmpty())
				return "";
			profesor = profesoriPretraga.get(row);
		} else
			profesor = profesori.get(row);

		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getZvanje().toString();
		case 3:
			return profesor.geteMailAdresa();
		default:
			return null;
		}
	}

	public void dodajProfesor(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja,
			String kontaktTelefon, String eMailAdresa, Adresa adresaKancelarije, int brojLicneKarte, Zvanje zvanje,
			int godineStaza, ArrayList<Predmet> spisakPredmetaNaKojimaJeProfesor) {
		this.profesori.add(new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, eMailAdresa,
				adresaKancelarije, brojLicneKarte, zvanje, godineStaza, spisakPredmetaNaKojimaJeProfesor));
	}

	public void izbrisiProfesor(int brLicneProfesora) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte() == brLicneProfesora) {
				profesori.remove(p);
				break;
			}
		}

	}

	public void izmeniProfesor(String prezime, String ime, LocalDate datRodj, Adresa adresaStanovanja,
			String kontaktTelefon, String eMailAdresa, Adresa adresaKancelarije, int brojLicneKarte, Zvanje zvanje,
			int godineStaza, ArrayList<Predmet> spisakPredmetaNaKojimaJeProfesor, int trenutniBrLK) {
		for (Profesor i : profesori) {
			if (i.getBrojLicneKarte() == trenutniBrLK) {
				i.setBrojLicneKarte(brojLicneKarte);
				i.setPrezime(prezime);
				i.setIme(ime);
				i.setDatumRodjenja(datRodj);
				i.setAdresaStanovanja(adresaStanovanja);
				i.setKontaktTelefon(kontaktTelefon);
				i.seteMailAdresa(eMailAdresa);
				i.setAdresaKancelarije(adresaKancelarije);
				i.setBrojLicneKarte(brojLicneKarte);
				i.setZvanje(zvanje);
				i.setGodineStaza(godineStaza);
				i.setSpisakPredmetaNaKojimaJeProfesor(spisakPredmetaNaKojimaJeProfesor);
			}
		}
	}

	public void pretraziProfesore(String rec) {
		profesoriPretraga.clear();
		String ime;
		String prezime;

		// prz,ime
		if (rec.matches("[^,]+,[^,]+")) {
			String[] parts = rec.split(",");
			prezime = parts[0].trim();
			ime = parts[1].trim();

			for (Profesor p : profesori) {
				if (p.getPrezime().toUpperCase().contains(prezime.toUpperCase())
						&& p.getIme().toUpperCase().contains(ime.toUpperCase())) {
					profesoriPretraga.add(p);
				}
			}
		}
		// prz
		else if (rec.matches("[^,]+")) {
			prezime = rec;
			for (Profesor p : profesori) {
				if (p.getPrezime().toUpperCase().contains(prezime.toUpperCase())) {
					profesoriPretraga.add(p);
				}
			}
		}
	}

}
