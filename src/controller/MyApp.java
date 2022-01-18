package controller;

import view.MyFrame;

public class MyApp {

	public static void main(String[] args) {
		MyFrame AppFrame = MyFrame.getInstance();
		AppFrame.setVisible(true);
		
		MyFrame.getTabelaProfesora().setAutoCreateRowSorter(true); //????????????? ok
		MyFrame.getTabelaPredmeta().setAutoCreateRowSorter(true);
	}

}

