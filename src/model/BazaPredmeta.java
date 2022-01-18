package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina na kojoj se predmet izvodi");
		this.kolone.add("Semestar na kojem se predmet izvodi");

	}

	private void initPredmete() {
		predmeti = new ArrayList<Predmet>();
		predmetiPretraga = new ArrayList<Predmet>();
		Profesor p = new Profesor("Rapajic", "Milan", LocalDate.of(1980, 3, 13),
				new Adresa("Tajna ulica", "2c", "Novi Sad", "Srbija"), "+381 64", "rap.aja@uns.ac.rs",
				new Adresa("Ulicica", "22", "Novi Sad", "Srbija"), 987654321, Zvanje.VANREDNI_PROFESOR, 69, null);

		predmeti.add(new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, p, 6));
		predmeti.add(new Predmet("32", "Operativni sistemi", Semestar.LETNJI, 2, null, 7));

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
}
