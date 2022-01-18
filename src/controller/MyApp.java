package controller;

import java.util.Comparator;

import javax.swing.table.TableRowSorter;

import view.AbstractTableModelStudenti;
import view.MyFrame;

public class MyApp {

	public static void main(String[] args) {
		MyFrame AppFrame = MyFrame.getInstance();
		AppFrame.setVisible(true);

		MyFrame.getTabelaProfesora().setAutoCreateRowSorter(true);
		MyFrame.getTabelaPredmeta().setAutoCreateRowSorter(true);

		TableRowSorter<AbstractTableModelStudenti> sorter = new TableRowSorter<AbstractTableModelStudenti>(
				new AbstractTableModelStudenti());
		MyFrame.getTabelaStduenti().setRowSorter(sorter);

		sorter.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] parts1 = o1.split(" ");
				String[] parts2 = o2.split(" ");

				String[] brIdx1 = parts1[1].split("/");
				String[] brIdx2 = parts2[1].split("/");

				int broj1 = Integer.parseInt(brIdx1[0]);
				int broj2 = Integer.parseInt(brIdx2[0]);

				if (parts1[0].compareTo(parts2[0]) != 0)
					return parts1[0].compareTo(parts2[0]);
				else if (broj1 > broj2)
					return 1;
				else if (broj1 < broj2)
					return -1;
				else
					return 0;
				

			}

		});

	}

}
