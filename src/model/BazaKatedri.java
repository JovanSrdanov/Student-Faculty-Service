package model;

import java.util.ArrayList;
import java.util.List;

public class BazaKatedri {

	private static BazaKatedri instance = null;

	public static BazaKatedri getInstance() {
		if (instance == null) {
			instance = new BazaKatedri();
		}
		return instance;
	}

	private ArrayList<Katedra> katedre;

	public ArrayList<Katedra> getKatedre() {
		return katedre;
	}

	public void setKatedre(ArrayList<Katedra> katedre) {
		this.katedre = katedre;
	}

	private List<String> kolone;

	private BazaKatedri() {

		initBazaKatedri();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra katedre");
		this.kolone.add("Naziv Katedre");
		this.kolone.add("Ime i prezime");

	}

	private void initBazaKatedri() {
		this.katedre = new ArrayList<Katedra>();
		
		
		Katedra pom1 = new Katedra("prnii", "PRIMENJENE RACUNARSKE NAUKE", null, null);
		Katedra pom2 = new Katedra("au", "Automatika", null, null);
		Katedra pom3 = new Katedra("rtrk", "Najveci ocaj od ljudi", null, null);
		
		Profesor p  = new Profesor("LEGENDA", "KRALJ", null, null, null, null, null, 4, Zvanje.REDOVNI_PROFESOR, 4, null);
		Profesor p1  = new Profesor("AAAAAA", "za", null, null, null, null, null, 5, Zvanje.REDOVNI_PROFESOR, 5, null);
		Profesor p2  = new Profesor("EEEEEE", "asasa", null, null, null, null, null, 6, Zvanje.VANREDNI_PROFESOR, 6, null);
		Profesor p3  = new Profesor("OOOOO", "dsds", null, null, null, null, null, 7, Zvanje.REDOVNI_PROFESOR, 7, null);
		Profesor p4  = new Profesor("ASDASDASDAS", "dsds", null, null, null, null, null, 8, Zvanje.DOCENT, 8, null);
		
		pom1.getSpisakProfesoraKojiSuNaKatedri().add(p);
		pom1.getSpisakProfesoraKojiSuNaKatedri().add(p1);
		pom1.getSpisakProfesoraKojiSuNaKatedri().add(p2);
		pom1.getSpisakProfesoraKojiSuNaKatedri().add(p3);
		pom1.getSpisakProfesoraKojiSuNaKatedri().add(p4);
		
		pom1.setSefKatedre(p2);
		pom2.setSefKatedre(p3);
		pom3.setSefKatedre(p4);

		this.katedre.add(pom1);
		katedre.add(pom2);
		this.katedre.add(pom3);

	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Katedra getRow(int rowIndex) {

		return katedre.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Katedra k;
		k = katedre.get(row);

		switch (column) {
		case 0:
			return k.getSifraKatedre();
		case 1:
			return k.getNazivKatedre();
		case 2:
			return k.getSefKatedre().getIme() + "  "+ k.getSefKatedre().getPrezime();

		default:
			return null;
		}
	}

}
