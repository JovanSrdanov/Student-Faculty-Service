package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4298076840513347731L;
	private String sifraKatedre;
	private String nazivKatedre;
	private Profesor sefKatedre;
	private ArrayList<Profesor> spisakProfesoraKojiSuNaKatedri;

	@Override
	public String toString() {
		return "Katedra [sifraKatedre=" + sifraKatedre + ", nazivKatedre=" + nazivKatedre + ", sefKatedre=" + sefKatedre
				+ ", spisakProfesoraKojiSuNaKatedri=" + spisakProfesoraKojiSuNaKatedri + "]";
	}

	public String getSifraKatedre() {
		return sifraKatedre;
	}

	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}

	public String getNazivKatedre() {
		return nazivKatedre;
	}

	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}

	public Profesor getSefKatedre() {
		return sefKatedre;
	}

	public void setSefKatedre(Profesor sefKatedre) {
		this.sefKatedre = sefKatedre;
	}

	public ArrayList<Profesor> getSpisakProfesoraKojiSuNaKatedri() {
		return spisakProfesoraKojiSuNaKatedri;
	}

	public void setSpisakProfesoraKojiSuNaKatedri(ArrayList<Profesor> spisakProfesoraKojiSuNaKatedri) {
		this.spisakProfesoraKojiSuNaKatedri = spisakProfesoraKojiSuNaKatedri;
	}

	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sefKatedre,
			ArrayList<Profesor> spisakProfesoraKojiSuNaKatedri) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		if (spisakProfesoraKojiSuNaKatedri == null)
			this.spisakProfesoraKojiSuNaKatedri = new ArrayList<>();
		else
			this.spisakProfesoraKojiSuNaKatedri = spisakProfesoraKojiSuNaKatedri;

	}

	public Katedra() {
		super();
		// TODO Auto-generated constructor stub
	}

}
