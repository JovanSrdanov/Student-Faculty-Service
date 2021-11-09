package modelSistema;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student {

	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private Adresa adresaStanovanja;
	private int kontaktTelefon;
	private String eMailAdresa;
	private String brojIndexa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosecnaOcena;
	private ArrayList<Ocena> spisakPolozenihIspita;
	private ArrayList<Ocena> spisakNePolozenihIspita;

	public Student() {
		super();
	}

	public Student(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja, int kontaktTelefon,
			String eMailAdresa, String brojIndexa, int godinaUpisa, int trenutnaGodinaStudija, Status status,
			double prosecnaOcena, ArrayList<Ocena> spisakPolozenihIspita, ArrayList<Ocena> spisakNePolozenihIspita) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.eMailAdresa = eMailAdresa;
		this.brojIndexa = brojIndexa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPolozenihIspita = spisakPolozenihIspita;
		this.spisakNePolozenihIspita = spisakNePolozenihIspita;
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

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
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

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Ocena> getSpisakPolozenihIspita() {
		return spisakPolozenihIspita;
	}

	public void setSpisakPolozenihIspita(ArrayList<Ocena> spisakPolozenihIspita) {
		this.spisakPolozenihIspita = spisakPolozenihIspita;
	}

	public ArrayList<Ocena> getSpisakNePolozenihIspita() {
		return spisakNePolozenihIspita;
	}

	public void setSpisakNePolozenihIspita(ArrayList<Ocena> spisakNePolozenihIspita) {
		this.spisakNePolozenihIspita = spisakNePolozenihIspita;
	}

	@Override
	public String toString() {
		return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", eMailAdresa="
				+ eMailAdresa + ", brojIndexa=" + brojIndexa + ", godinaUpisa=" + godinaUpisa
				+ ", trenutnaGodinaStudija=" + trenutnaGodinaStudija + ", status=" + status + ", prosecnaOcena="
				+ prosecnaOcena + ", spisakPolozenihIspita=" + spisakPolozenihIspita + ", spisakNePolozenihIspita="
				+ spisakNePolozenihIspita + "]";
	}

}
