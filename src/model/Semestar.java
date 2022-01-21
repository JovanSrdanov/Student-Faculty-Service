package model;

import controller.MyApp;

public enum Semestar {

	ZIMSKI("zimski"), LETNJI("letnji");

	String string;

	Semestar(String string) {
		this.string = string;
	}
	
	@Override
	public String toString() {
		return MyApp.resourceBundle.getString(string);
		
	}

}
