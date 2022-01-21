package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6570050499440429636L;
	
	private String sifrPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudijaUKojojSePredmetIzvodi;
	private Profesor predmetniProfesor;
	private int brojESPBBodova;
	private ArrayList<Student> spisakStudenataKojiSuPoloziliPredmet;
	private ArrayList<Student> spisakStudenataKojiNisuPoloziliPredmet;

	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Predmet(String sifrPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudijaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor, int brojESPBBodova, ArrayList<Student> spisakStudenataKojiSuPoloziliPredmet,
			ArrayList<Student> spisakStudenataKojiNisuPoloziliPredmet) {
		super();
		this.sifrPredmeta = sifrPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPBBodova = brojESPBBodova;
		this.spisakStudenataKojiSuPoloziliPredmet = spisakStudenataKojiSuPoloziliPredmet;
		this.spisakStudenataKojiNisuPoloziliPredmet = spisakStudenataKojiNisuPoloziliPredmet;
	}

	public Predmet(String sifrPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudijaUKojojSePredmetIzvodi,
			Profesor predmetniProfesor, int brojESPBBodova) {
		super();
		this.sifrPredmeta = sifrPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPBBodova = brojESPBBodova;
		this.spisakStudenataKojiSuPoloziliPredmet = new ArrayList<Student>();
		this.spisakStudenataKojiNisuPoloziliPredmet = new ArrayList<Student>();
	}

	@Override
	public String toString() {
		return "Predmet [sifrPredmeta=" + sifrPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudijaUKojojSePredmetIzvodi=" + godinaStudijaUKojojSePredmetIzvodi + ", predmetniProfesor="
				+ predmetniProfesor + ", brojESPBBodova=" + brojESPBBodova + ", spisakStudenataKojiSuPoloziliPredmet="
				+ spisakStudenataKojiSuPoloziliPredmet + ", spisakStudenataKojiNisuPoloziliPredmet="
				+ spisakStudenataKojiNisuPoloziliPredmet + "]";
	}

	public String getSifrPredmeta() {
		return sifrPredmeta;
	}

	public void setSifrPredmeta(String sifrPredmeta) {
		this.sifrPredmeta = sifrPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return this.semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudijaUKojojSePredmetIzvodi() {
		return godinaStudijaUKojojSePredmetIzvodi;
	}

	public void setGodinaStudijaUKojojSePredmetIzvodi(int godinaStudijaUKojojSePredmetIzvodi) {
		this.godinaStudijaUKojojSePredmetIzvodi = godinaStudijaUKojojSePredmetIzvodi;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}

	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}

	public int getBrojESPBBodova() {
		return brojESPBBodova;
	}

	public void setBrojESPBBodova(int brojESPBBodova) {
		this.brojESPBBodova = brojESPBBodova;
	}

	public ArrayList<Student> getSpisakStudenataKojiSuPoloziliPredmet() {
		return spisakStudenataKojiSuPoloziliPredmet;
	}

	public void setSpisakStudenataKojiSuPoloziliPredmet(ArrayList<Student> spisakStudenataKojiSuPoloziliPredmet) {
		this.spisakStudenataKojiSuPoloziliPredmet = spisakStudenataKojiSuPoloziliPredmet;
	}

	public ArrayList<Student> getSpisakStudenataKojiNisuPoloziliPredmet() {
		return spisakStudenataKojiNisuPoloziliPredmet;
	}

	public void setSpisakStudenataKojiNisuPoloziliPredmet(ArrayList<Student> spisakStudenataKojiNisuPoloziliPredmet) {
		this.spisakStudenataKojiNisuPoloziliPredmet = spisakStudenataKojiNisuPoloziliPredmet;
	}
	
	@Override
    public boolean equals(Object o) {
		Predmet ppap = (Predmet) o;
		return this.sifrPredmeta.equals(ppap.getSifrPredmeta());
	}
}
