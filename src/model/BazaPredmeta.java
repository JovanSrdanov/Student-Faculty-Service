package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.MyApp;
import view.MyFrame;

public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private List<Predmet> predmeti;
	private List<Predmet> predmetiPretraga;
	private List<String> kolone;

	private BazaPredmeta() {

		initPredmete();

		this.kolone = new ArrayList<String>();
		this.kolone.add( MyApp.resourceBundle.getString("sifra"));
		this.kolone.add( MyApp.resourceBundle.getString("nazivP"));
		this.kolone.add( MyApp.resourceBundle.getString("espb"));
		this.kolone.add( MyApp.resourceBundle.getString("godIzvod"));
		this.kolone.add( MyApp.resourceBundle.getString("semestar"));

		
	}

	private void initPredmete() {
		predmeti = new ArrayList<Predmet>();
		predmetiPretraga = new ArrayList<Predmet>();
		/*
		 * Profesor p = new Profesor("Rapajic", "Milan", LocalDate.of(1980, 3, 13), new
		 * Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64",
		 * "rap.aja@uns.ac.rs", new Adresa("Ulicica", "22", "Novi Sad", "Srbija"),
		 * 987654321, Zvanje.VANREDNI_PROFESOR, 69, null);
		 * 
		 * predmeti.add(new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, p, 6));
		 * predmeti.add(new Predmet("p2", "Operativni sistemi", Semestar.LETNJI, 2,
		 * null, 7));
		 */
/*
		predmeti.add(new Predmet("p1", "osnove programiranja", Semestar.ZIMSKI, 1, null, 7));
		predmeti.add(new Predmet("p2", "statistika", Semestar.LETNJI, 3, null, 8));
		predmeti.add(new Predmet("p3", "algoritmi i strukture podataka", Semestar.LETNJI, 2, null, 9));
		predmeti.add(new Predmet("p4", "LPRS", Semestar.ZIMSKI, 3, null, 7));
		predmeti.add(new Predmet("p5", "matematika", Semestar.LETNJI, 1, null, 11));
		predmeti.add(new Predmet("p6", "xml i web servisi", Semestar.LETNJI, 4, null, 6));
		predmeti.add(new Predmet("p7", "Metode optimizacije", Semestar.ZIMSKI, 3, null, 6));
		predmeti.add(new Predmet("p8", "osnove elektortehnike", Semestar.LETNJI, 1, null, 11));
		predmeti.add(new Predmet("p9", "Sociologija", Semestar.ZIMSKI, 1, null, 10));
		predmeti.add(new Predmet("p10", "Filozofija", Semestar.ZIMSKI, 1, null, 4));
		predmeti.add(new Predmet("p11", "ORT", Semestar.LETNJI, 2, null, 7));
		predmeti.add(new Predmet("p12", "NANS", Semestar.LETNJI, 2, null, 5));
		predmeti.add(new Predmet("p13", "Organizacija podataka", Semestar.ZIMSKI, 2, null, 7));
		predmeti.add(new Predmet("p14", "Baze podataka", Semestar.ZIMSKI, 2, null, 6));
		predmeti.add(new Predmet("p15", "paralelno programiranje", Semestar.ZIMSKI, 2, null, 8));
		predmeti.add(new Predmet("p16", "konkurentno programiranje", Semestar.LETNJI, 2, null, 9));
		predmeti.add(new Predmet("p17", "Operativni sistemi", Semestar.LETNJI, 2, null, 8));
		predmeti.add(new Predmet("p18", "Algebra", Semestar.ZIMSKI, 1, null, 15));
		predmeti.add(new Predmet("p19", "Diskretna matematika", Semestar.LETNJI, 3, null, 14));
		predmeti.add(new Predmet("ps20", "Upravljacki sistemi", Semestar.LETNJI, 3, null, 8));
		predmeti.add(new Predmet("ps21", "Osnovi elektronike", Semestar.ZIMSKI, 2, null, 7));
		predmeti.add(new Predmet("ps22", "Slucajni procesi", Semestar.LETNJI, 4, null, 9));
		predmeti.add(new Predmet("ps23", "Racunarstvo visokih performansi", Semestar.LETNJI, 4, null, 10));
		predmeti.add(new Predmet("p24", "Analiza 1", Semestar.ZIMSKI, 1, null, 20));
		predmeti.add(new Predmet("it25", "Informaciona bezbednost", Semestar.LETNJI, 4, null, 9));
		predmeti.add(new Predmet("it26", "Elektronsko placanje", Semestar.ZIMSKI, 3, null, 8));
		predmeti.add(new Predmet("it27", "Distribuirani sistemi", Semestar.LETNJI, 4, null, 6));
		predmeti.add(new Predmet("p28", "Projektovanje softvera", Semestar.ZIMSKI, 3, null, 5));
		predmeti.add(new Predmet("p29", "Informacioni sistemi", Semestar.ZIMSKI, 4, null, 6));
		predmeti.add(new Predmet("p30", "Masinsko ucenje", Semestar.LETNJI, 4, null, 7));
*/
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public List<Predmet> getPredmetiPretraga() {
		return predmetiPretraga;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		if (MyFrame.getInstance().isPretraga())
			return predmetiPretraga.get(rowIndex);
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet;

		if (MyFrame.getInstance().isPretraga()) {
			if (predmetiPretraga.isEmpty())
				return "";
			predmet = predmetiPretraga.get(row);
		} else
			predmet = predmeti.get(row);

		switch (column) {
		case 0:
			return predmet.getSifrPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getBrojESPBBodova());
		case 3:
			return Integer.toString(predmet.getGodinaStudijaUKojojSePredmetIzvodi());
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}

	public void dodajPredmet(String sifrPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBBodova) {
		this.predmeti.add(new Predmet(sifrPredmeta, nazivPredmeta, semestar, godinaStudijaUKojojSePredmetIzvodi,
				predmetniProfesor, brojESPBBodova));
	}

	public void izbrisiPredmet(String sifrPredmeta) {
		for (Predmet i : predmeti) {
			if (i.getSifrPredmeta().equals(sifrPredmeta)) {
				predmeti.remove(i);
				break;
			}
		}

	}

	public void izmeniPredmet(String sifrPredmeta, String nazivPredmeta, Semestar semestar,
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBBodova, String staraSifra) {
		for (Predmet i : predmeti) {
			if (i.getSifrPredmeta().equals(staraSifra)) {

				i.setSifrPredmeta(sifrPredmeta);
				i.setNazivPredmeta(nazivPredmeta);
				i.setSemestar(semestar);
				i.setGodinaStudijaUKojojSePredmetIzvodi(godinaStudijaUKojojSePredmetIzvodi);
				// i.setPredmetniProfesor(predmetniProfesor);
				i.setBrojESPBBodova(brojESPBBodova);

			}
		}
	}

	public void pretraziPredmete(String rec) {
		predmetiPretraga.clear();
		String naziv;
		String sifra;

		// naz,sifra
		if (rec.matches("[^,]+,[^,]+")) {
			String[] parts = rec.split(",");
			naziv = parts[0].trim();
			sifra = parts[1].trim();

			for (Predmet p : predmeti) {
				if (p.getNazivPredmeta().toUpperCase().contains(naziv.toUpperCase())
						&& p.getSifrPredmeta().toUpperCase().contains(sifra.toUpperCase())) {
					predmetiPretraga.add(p);
				}
			}
		}
		// naz
		if (rec.matches("[^,]+")) {
			naziv = rec;

			for (Predmet p : predmeti) {
				if (p.getNazivPredmeta().toUpperCase().contains(naziv.toUpperCase())) {
					predmetiPretraga.add(p);
				}
			}
		}
	}

	public void savePredmete(String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeObject(predmeti);

			output.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}
	}

	public void loadPredmeti(String fileName) {
		try {
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);

			@SuppressWarnings("unchecked")
			ArrayList<Predmet> priv = (ArrayList<Predmet>) objStream.readObject();
			predmeti = priv;

			objStream.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}
	};

	public void loadFix() {
		for (Profesor clearProf : BazaProfesora.getInstance().getProfesori()) {
			clearProf.getSpisakPredmetaNaKojimaJeProfesor().clear();
		}

		for (Predmet predmet : predmeti) {
			for (Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
				if (predmet.getPredmetniProfesor() != null && predmet.getPredmetniProfesor().equals(profesor))
					profesor.getSpisakPredmetaNaKojimaJeProfesor().add(predmet);
			}
		}
	}
	
	public void loadFix2() {
		for(Predmet sviPred : predmeti) {
			sviPred.getSpisakStudenataKojiNisuPoloziliPredmet().clear();
			sviPred.getSpisakStudenataKojiSuPoloziliPredmet().clear();
		}
		
		for(Student sviStud : BazaStudenata.getInstance().getStudenti()) {
			for(Ocena o : sviStud.getSpisakNePolozenihIspita()) {
				for(Predmet sviPred : predmeti) {
					if(o.getPredmet().equals(sviPred)) {
						sviPred.getSpisakStudenataKojiNisuPoloziliPredmet().add(sviStud);
					}
				}
			}
			for(Ocena o : sviStud.getSpisakPolozenihIspita()) {
				for(Predmet sviPred : predmeti) {
					if(o.getPredmet().equals(sviPred)) {
						sviPred.getSpisakStudenataKojiSuPoloziliPredmet().add(sviStud);
					}
				}
			}
		}
	}

	public void izmeniJezikKolonaPredmeti() {
		this.kolone.set(0, MyApp.resourceBundle.getString("sifra"));
		this.kolone.set(1, MyApp.resourceBundle.getString("nazivP"));
		this.kolone.set(2, MyApp.resourceBundle.getString("espb"));
		this.kolone.set(3, MyApp.resourceBundle.getString("godIzvod"));
		this.kolone.set(4, MyApp.resourceBundle.getString("semestar"));

	}

}
