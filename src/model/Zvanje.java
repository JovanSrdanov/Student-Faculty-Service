package model;

import controller.MyApp;

public enum Zvanje {

	REDOVNI_PROFESOR("redProf"), VANREDNI_PROFESOR("vanProf"), DOCENT("docent");

	String string;

	Zvanje(String string) {
		this.string = string;
	}
	
	@Override
	public String toString() {
		return MyApp.resourceBundle.getString(string);
		
	}

}
