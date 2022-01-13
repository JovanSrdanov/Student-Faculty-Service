package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}

	private List<Predmet> predmeti;
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
		predmeti.add(new Predmet("e1", "Baze podataka 1", Semestar.ZIMSKI, 3, null, 6));
		predmeti.add(new Predmet("32", "Operativni sistemi", Semestar.LETNJI, 2, null, 7));

	}

	public List<Predmet> getPredmeti() {
		return predmeti;
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
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
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
			int godinaStudijaUKojojSePredmetIzvodi, Profesor predmetniProfesor, int brojESPBBodova) {
		for (Predmet i : predmeti) {
			if (i.getSifrPredmeta().equals(sifrPredmeta)) {
				i.setSifrPredmeta(sifrPredmeta);
				i.setNazivPredmeta(nazivPredmeta);
				i.setSemestar(semestar);
				i.setGodinaStudijaUKojojSePredmetIzvodi(godinaStudijaUKojojSePredmetIzvodi);
				i.setPredmetniProfesor(predmetniProfesor);
				i.setBrojESPBBodova(brojESPBBodova);

			}
		}
	}
}
