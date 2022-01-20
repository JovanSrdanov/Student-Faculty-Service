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

	}

	private void initBazaKatedri() {
		this.katedre = new ArrayList<Katedra>();
		Katedra pom1 = new Katedra("prnii", "PRIMENJENE RACUNARSKE NAUKE", null, null);
		Katedra pom2 = new Katedra("au", "Automatika", null, null);
		Katedra pom3 = new Katedra("rtrk", "Najveci ocaj od ljudi", null, null);

		this.katedre.add(pom1);
		katedre.add(pom2);
		this.katedre.add(pom3);

	}

	public int getColumnCount() {
		return 2;
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

		default:
			return null;
		}
	}

}
