package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.MyApp;
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
		this.kolone.add(MyApp.resourceBundle.getString("ime"));
		this.kolone.add(MyApp.resourceBundle.getString("prezime"));
		this.kolone.add(MyApp.resourceBundle.getString("zvanje"));
		this.kolone.add(MyApp.resourceBundle.getString("email"));

	}
	
	public void izmeniJezikKolonaProfesori() {

		this.kolone.set(0, MyApp.resourceBundle.getString("ime"));
		this.kolone.set(1, MyApp.resourceBundle.getString("prezime"));
		this.kolone.set(2, MyApp.resourceBundle.getString("zvanje"));
		this.kolone.set(3, MyApp.resourceBundle.getString("email"));
		
	}

	private void initProfesore() {
		profesori = new ArrayList<Profesor>();
		profesoriPretraga = new ArrayList<Profesor>();

		/*Predmet p = new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, null, 6);
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		predmeti.add(p);

		profesori.add(new Profesor("Detlic", "Pera", LocalDate.now(),
				new Adresa("Jovana Jovanovica Zmaja", "123a", "Kikinda", "Srbija"), "23/23", "de.ste@gmail.com",
				new Adresa("ulicaKanc", "11", "Kikinda", "Srbija"), 123456789, Zvanje.REDOVNI_PROFESOR, 4, null));

		profesori.add(new Profesor("Rapajic", "Milan", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64", "rap.aja@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987654321, Zvanje.VANREDNI_PROFESOR, 69, predmeti));

		profesori.add(new Profesor("Jelicic", "peder", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381/232 64", "aaaa.aaaaaa@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987354321, Zvanje.DOCENT, 69, null));*/
		
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
		
		profesori.add(new Profesor("Nikolic", "Milos", LocalDate.parse("12.12.1965.", formater), nizAdr[1], "021/356-785", "milos.nikolic@mailinator.com", nizAdr[10], 123123123, Zvanje.REDOVNI_PROFESOR, 30, null));
		profesori.add(new Profesor("Mirkovic", "Nikola", LocalDate.parse("01.01.1978.", formater), nizAdr[2], "021/368-456", "nikola.mirkovic@mailinator.com", nizAdr[10], 321321321, Zvanje.REDOVNI_PROFESOR, 22, null));
		profesori.add(new Profesor("Petkovic", "Ilija", LocalDate.parse("03.09.1988.", formater), nizAdr[3], "021/215-314", "ilija.petkovic@mailinator.com", nizAdr[10], 456456456, Zvanje.VANREDNI_PROFESOR, 22, null));
		profesori.add(new Profesor("Petrovic", "Mitar", LocalDate.parse("25.07.1976.", formater), nizAdr[4], "021/884-640", "mitar.petrovic@mailinator.com", nizAdr[10], 789789789, Zvanje.VANREDNI_PROFESOR, 27, null));
		profesori.add(new Profesor("Micic", "Vasa", LocalDate.parse("14.02.1970.", formater), nizAdr[5], "021/212-114", "vasa.micic@mailinator.com", nizAdr[10], 100100144, Zvanje.DOCENT, 24, null));
		profesori.add(new Profesor("Miletic", "Srdjan", LocalDate.parse("20.04.1966.", formater), nizAdr[6], "021/978-225", "srdjan.miletic@mailinator.com", nizAdr[10], 200020244, Zvanje.DOCENT, 31, null));
		profesori.add(new Profesor("Mihajlovic", "Branislav", LocalDate.parse("28.06.1980.", formater), nizAdr[7], "021/778-323", "branislav.mihajlovic@mailinator.com", nizAdr[10], 559585632, Zvanje.REDOVNI_PROFESOR, 13, null));
		profesori.add(new Profesor("Marković", "Marko", LocalDate.parse("31.01.1985.", formater), nizAdr[8], "021/899-659", "marko.markovic@mailinator.com", nizAdr[10], 334968855, Zvanje.REDOVNI_PROFESOR, 17, null));
		profesori.add(new Profesor("Milaković", "Miloš", LocalDate.parse("21.09.1975.", formater), nizAdr[9], "021/122-326", "milos.milakovic@mailinator.com", nizAdr[10], 730703654, Zvanje.VANREDNI_PROFESOR, 12, null));
		profesori.add(new Profesor("Bratić", "Lazar", LocalDate.parse("13.11.1973.", formater), nizAdr[10], "021/156-326", "lazar.bratic@mailinator.com", nizAdr[10], 600378644, Zvanje.VANREDNI_PROFESOR, 3, null));
		profesori.add(new Profesor("Dražić", "Ljeposava", LocalDate.parse("11.08.1964.", formater), nizAdr[11], "021/888-156", "ljeposava.drazic@mailinator.com", nizAdr[10], 158496152, Zvanje.DOCENT, 31, null));
		profesori.add(new Profesor("Dragić", "Miroljub", LocalDate.parse("02.03.1959.", formater), nizAdr[12], "021/456-125", "miroljub.dragic@mailinator.com", nizAdr[10], 777348595, Zvanje.DOCENT, 42, null));
		profesori.add(new Profesor("Rekavić", "Bogdan", LocalDate.parse("23.06.1977.", formater), nizAdr[6], "021/886-455", "bogdan.rekavic@mailinator.com", nizAdr[10], 721254363, Zvanje.VANREDNI_PROFESOR, 18, null));
		profesori.add(new Profesor("Milić", "Stanka", LocalDate.parse("03.03.1991.", formater), nizAdr[3], "021/945-155", "stanka.milic@mailinator.com", nizAdr[10], 225533448, Zvanje.DOCENT, 7, null));
		profesori.add(new Profesor("Vuković", "Milica", LocalDate.parse("18.10.1967.", formater), nizAdr[8], "021/746-659", "milica.vukovic@mailinator.com", nizAdr[10], 111555888, Zvanje.VANREDNI_PROFESOR, 14, null));
		profesori.add(new Profesor("Mišić", "Miša", LocalDate.parse("20.10.1969.", formater), nizAdr[1], "021/489-326", "misa.misic@mailinator.com", nizAdr[10], 300300344, Zvanje.DOCENT, 19, null));
		profesori.add(new Profesor("Maricić", "Branko", LocalDate.parse("18.01.1973.", formater), nizAdr[2], "021/487-265", "branko.maricic@mailinator.com", nizAdr[10], 400400444, Zvanje.DOCENT, 22, null));
		profesori.add(new Profesor("Lukovic", "Branislav", LocalDate.parse("08.04.1982.", formater), nizAdr[3], "021/159-478", "branislav.lukovic@mailinator.com", nizAdr[10], 500500544, Zvanje.REDOVNI_PROFESOR, 9, null));
		profesori.add(new Profesor("Obradović", "Branimir", LocalDate.parse("07.01.1979.", formater), nizAdr[1], "021/922-333", "branimir.obradovic@mailinator.com", nizAdr[10], 600600644, Zvanje.DOCENT, 17, null));
*/
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
				//i.setSpisakPredmetaNaKojimaJeProfesor(spisakPredmetaNaKojimaJeProfesor);
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
	
	public void saveProfesore(String fileName) {
		try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);
            
            output.writeObject(profesori);

            output.close();
        }

        catch (Exception e1) {
            e1.getStackTrace();
        }
	}

	public void loadProfesora(String fileName) {
		try {
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);

			@SuppressWarnings("unchecked")
			ArrayList<Profesor> priv = (ArrayList<Profesor>) objStream.readObject();
			profesori = priv;

			objStream.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}

	}
	
	public void loadFix() {
		for(Predmet predmetIzListeSvih : BazaPredmeta.getInstance().getPredmeti()) {
			for(Profesor profIzListeSvih : profesori) {
				if(predmetIzListeSvih.getPredmetniProfesor() != null && predmetIzListeSvih.getPredmetniProfesor().equals(profIzListeSvih)) {
					predmetIzListeSvih.setPredmetniProfesor(profIzListeSvih);
				}
			}
		}
		
	}
}
