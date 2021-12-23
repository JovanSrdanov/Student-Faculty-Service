package model;

import java.util.ArrayList;

public class Profesor {

	private String prezime;
	private String ime;
	private Adresa adresaStanovanja;
	private int kontaktTelefon;
	private String eMailAdresa;
	private String brojIndexa;
	private Adresa adresaKancelarije;
	private int brojLicneKarte;
	private Zvanje zvanje;
	private int godineStaza;
	private ArrayList<Predmet> spisakPredmetaNaKojimaJeProfesor;

	public Profesor() {
		super();
	}

	public Profesor(String prezime, String ime, Adresa adresaStanovanja, int kontaktTelefon, String eMailAdresa,
			String brojIndexa, Adresa adresaKancelarije, int brojLicneKarte, Zvanje zvanje, int godineStaza,
			ArrayList<Predmet> spisakPredmetaNaKojimaJeProfesor) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.eMailAdresa = eMailAdresa;
		this.brojIndexa = brojIndexa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.spisakPredmetaNaKojimaJeProfesor = spisakPredmetaNaKojimaJeProfesor;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public int getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(int kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String geteMailAdresa() {
		return eMailAdresa;
	}

	public void seteMailAdresa(String eMailAdresa) {
		this.eMailAdresa = eMailAdresa;
	}

	public String getBrojIndexa() {
		return brojIndexa;
	}

	public void setBrojIndexa(String brojIndexa) {
		this.brojIndexa = brojIndexa;
	}

	public Adresa getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(Adresa adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public int getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(int brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}

	public ArrayList<Predmet> getSpisakPredmetaNaKojimaJeProfesor() {
		return spisakPredmetaNaKojimaJeProfesor;
	}

	public void setSpisakPredmetaNaKojimaJeProfesor(ArrayList<Predmet> spisakPredmetaNaKojimaJeProfesor) {
		this.spisakPredmetaNaKojimaJeProfesor = spisakPredmetaNaKojimaJeProfesor;
	}

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", adresaStanovanja=" + adresaStanovanja
				+ ", kontaktTelefon=" + kontaktTelefon + ", eMailAdresa=" + eMailAdresa + ", brojIndexa=" + brojIndexa
				+ ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte + ", zvanje="
				+ zvanje + ", godineStaza=" + godineStaza + ", spisakPredmetaNaKojimaJeProfesor="
				+ spisakPredmetaNaKojimaJeProfesor + "]";
	}

}
