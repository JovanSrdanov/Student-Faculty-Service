package model;

import controller.MyApp;

public enum Status {

	BUDŽET("budzet"), SAMOFINANSIRANJE("samofinansiranje");
	
	String string;

	Status(String string) {
		this.string = string;
	}
	@Override
	public String toString() {
		return MyApp.resourceBundle.getString(string);
		
	}

}
