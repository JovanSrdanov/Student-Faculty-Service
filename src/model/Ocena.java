package model;

import java.time.LocalDate;

public class Ocena {

	private Student studentKojiJePolozioIspit;
	private Predmet predmet;
	private int brojcanaVrednostOcene;
	private LocalDate datumPolaganjaIspita;

	@Override
	public String toString() {
		return "Ocena [studentKojiJePolozioIspit=" + studentKojiJePolozioIspit + ", predmet=" + predmet
				+ ", brojcanaVrednostOcene=" + brojcanaVrednostOcene + ", datumPolaganjaIspita=" + datumPolaganjaIspita
				+ "]";
	}

	public Ocena(Student studentKojiJePolozioIspit, Predmet predmet, int brojcanaVrednostOcene,
			LocalDate datumPolaganjaIspita) {
		super();
		this.studentKojiJePolozioIspit = studentKojiJePolozioIspit;
		this.predmet = predmet;
		this.brojcanaVrednostOcene = brojcanaVrednostOcene;
		this.datumPolaganjaIspita = datumPolaganjaIspita;

	}

	public Ocena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student getStudentKojiJePolozioIspit() {
		return studentKojiJePolozioIspit;
	}

	public void setStudentKojiJePolozioIspit(Student studentKojiJePolozioIspit) {
		this.studentKojiJePolozioIspit = studentKojiJePolozioIspit;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getBrojcanaVrednostOcene() {
		return brojcanaVrednostOcene;
	}

	public void setBrojcanaVrednostOcene(int brojcanaVrednostOcene) {
		this.brojcanaVrednostOcene = brojcanaVrednostOcene;
	}

	public LocalDate getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}

	public void setDatumPolaganjaIspita(LocalDate datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}

}
