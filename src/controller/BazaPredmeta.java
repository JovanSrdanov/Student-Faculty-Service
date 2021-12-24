package controller;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import model.Predmet;
import model.Profesor;
import model.Semestar;


	public class BazaPredmeta {
		private static BazaPredmeta instance = null;
	
		public static BazaPredmeta getInstance() {
			if (instance == null) {
				instance = new BazaPredmeta();
			}
			return instance;
		}
		
	//private long generator;

	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta() {
		//generator = 0;
	
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
		predmeti.add(new Predmet(1, "Gej", Semestar.ZIMSKI, 1, null, 1));
		
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	/*private long generateId() {
		return ++generator;
	}*/

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
			return Integer.toString(predmet.getSifrPredmeta());
		case 1:
			return  predmet.getNazivPredmeta();
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

	public void dodajPredmet(int sifrPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudijaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor, int brojESPBBodova) {
		this.predmeti.add(new Predmet(sifrPredmeta, nazivPredmeta, semestar, godinaStudijaUKojojSePredmetIzvodi, predmetniProfesor, brojESPBBodova));
	}

	public void izbrisiPredmet(int sifrPredmeta) {
		for (Predmet i : predmeti) {
			if (i.getSifrPredmeta() == sifrPredmeta) {
				predmeti.remove(i);
				break;
			}
		}
	}

	public void izmeniPredmet(int sifrPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudijaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor, int brojESPBBodova) {
		for (Predmet i : predmeti) {
			if (i.getSifrPredmeta() == sifrPredmeta) {
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
