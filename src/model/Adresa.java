package model;

public class Adresa {

	private String ulica;
	private String broj;
	private String Grad;
	private String Drzava;

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getGrad() {
		return Grad;
	}

	public void setGrad(String grad) {
		Grad = grad;
	}

	public String getDrzava() {
		return Drzava;
	}

	public void setDrzava(String drzava) {
		Drzava = drzava;
	}

	public Adresa(String ulica, String broj, String grad, String drzava) {
		super();
		this.ulica = ulica;
		this.broj = broj;
		Grad = grad;
		Drzava = drzava;
	}

	public Adresa() {
		super();
	}

	@Override
	public String toString() {
		return ulica + "," + broj + "," + Grad + "," + Drzava;
	}

}
