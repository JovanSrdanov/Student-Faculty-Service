package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controller.MyApp;

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
		this.kolone.add( MyApp.resourceBundle.getString("sifKat"));
		this.kolone.add( MyApp.resourceBundle.getString("nazKat"));
		this.kolone.add( MyApp.resourceBundle.getString("sefKat"));

	}
	
	public void izmeniJezikKolonaKatedri() {
		this.kolone.set(0, MyApp.resourceBundle.getString("sifKat"));
		this.kolone.set(1, MyApp.resourceBundle.getString("nazKat"));
		this.kolone.set(2, MyApp.resourceBundle.getString("sefKat"));
	
		
	};


	private void initBazaKatedri() {
		this.katedre = new ArrayList<Katedra>();

		/*Katedra pom1 = new Katedra("prnii", "PRIMENJENE RACUNARSKE NAUKE", null, null);
		Katedra pom2 = new Katedra("au", "Automatika", null, null);
		Katedra pom3 = new Katedra("rtrk", "Najveci ocaj od ljudi", null, null);

		Profesor p = new Profesor("LEGENDA", "KRALJ", null, null, null, null, null, 4, Zvanje.REDOVNI_PROFESOR, 4,
				null);
		Profesor p1 = new Profesor("AAAAAA", "za", null, null, null, null, null, 5, Zvanje.REDOVNI_PROFESOR, 5, null);
		Profesor p2 = new Profesor("EEEEEE", "asasa", null, null, null, null, null, 6, Zvanje.VANREDNI_PROFESOR, 6,
				null);
		Profesor p3 = new Profesor("OOOOO", "dsds", null, null, null, null, null, 7, Zvanje.REDOVNI_PROFESOR, 7, null);
		Profesor p4 = new Profesor("ASDASDASDAS", "dsds", null, null, null, null, null, 8, Zvanje.DOCENT, 8, null);

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
		this.katedre.add(pom3);*/
		
		
		/*katedre.add(new Katedra("e42", "Katedra za matematiku", null, null));
		katedre.add(new Katedra("e43", "Katedra za fiziku", null, null));
		katedre.add(new Katedra("e44", "Katedra za elektrotehniku", null, null));
		katedre.add(new Katedra("e45", "Katedra za primenjene računarske nauke", null, null));
		katedre.add(new Katedra("e46", "Katedra za informatiku", null, null));
		katedre.add(new Katedra("e47", "Katedra za automatiku", null, null));
		
		katedre.get(0).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(0));
		katedre.get(0).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(1));
		katedre.get(0).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(18));
		
		katedre.get(1).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(2));
		katedre.get(1).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(7));
		katedre.get(1).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(13));
		
		katedre.get(2).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(3));
		katedre.get(2).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(8));
		katedre.get(2).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(14));
		
		katedre.get(3).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(6));
		katedre.get(3).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(9));
		katedre.get(3).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(15));
		
		katedre.get(4).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(4));
		katedre.get(4).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(10));
		katedre.get(4).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(12));
		katedre.get(4).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(16));
		
		katedre.get(5).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(5));
		katedre.get(5).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(11));
		katedre.get(5).getSpisakProfesoraKojiSuNaKatedri().add(BazaProfesora.getInstance().getProfesori().get(17));*/


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
			return k.getSefKatedre().getIme() + "  " + k.getSefKatedre().getPrezime();

		default:
			return null;
		}
	}

	public void saveKatedre(String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream output = new ObjectOutputStream(file);

			output.writeObject(katedre);

			output.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}
	}

	public void loadKatedre(String fileName) {
		try {

			// Reads data using the ObjectInputStream
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);

			@SuppressWarnings("unchecked")
			ArrayList<Katedra> priv = (ArrayList<Katedra>) objStream.readObject();
			katedre = priv;

			objStream.close();
		}

		catch (Exception e1) {
			e1.getStackTrace();
		}

	}
	
	public void loadFix() {
		ArrayList<Profesor> realProf = new ArrayList<Profesor>();
		
		for(Katedra sveKat : katedre) {			
			for(Profesor profNaKat : sveKat.getSpisakProfesoraKojiSuNaKatedri()) {
				for(Profesor sviProf : BazaProfesora.getInstance().getProfesori()) {
					if(sviProf.equals(profNaKat)) {
						realProf.add(sviProf);
					}
				}
			}		
			sveKat.getSpisakProfesoraKojiSuNaKatedri().clear();
			ArrayList<Profesor> fakeProf = new ArrayList<Profesor>();
			fakeProf.addAll(realProf);
			sveKat.setSpisakProfesoraKojiSuNaKatedri(fakeProf);
			realProf.clear();
		}
		//Fix za sefove
		for(Katedra sveKat : katedre) {
			for(Profesor sviProf : BazaProfesora.getInstance().getProfesori()) {
				if(sveKat.getSefKatedre().equals(sviProf)) {
					sveKat.setSefKatedre(sviProf);
				}
			}
		}
	}


}
