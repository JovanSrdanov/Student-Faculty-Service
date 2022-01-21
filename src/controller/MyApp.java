package controller;

import java.awt.Point;
import java.util.Comparator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.TableRowSorter;

import view.AbstractTableModelPredmeti;
import view.AbstractTableModelStudenti;
import view.MyFrame;

public class MyApp {

	private static MyFrame AppFrame;
	private static Point location;
	public static ResourceBundle resourceBundle;
	

	public static void main(String[] args) {
		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", new Locale("en", "US"));
		
		AppFrame = MyFrame.getInstance();
		AppFrame.setVisible(true);
		postaviKomparatore();
		MyFrame.getInstance().load();
		

	}

	private static void postaviKomparatore() {
		MyFrame.getTabelaProfesora().setAutoCreateRowSorter(true);

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

		sorter.setComparator(5, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				double broj1 = Double.parseDouble(o1);
				double broj2 = Double.parseDouble(o2);

				if (broj1 > broj2)
					return 1;
				else if (broj1 < broj2)
					return -1;
				else
					return 0;
			}

		});

		TableRowSorter<AbstractTableModelPredmeti> sorterPredmeta = new TableRowSorter<AbstractTableModelPredmeti>(
				new AbstractTableModelPredmeti());
		MyFrame.getTabelaPredmeta().setRowSorter(sorterPredmeta);

		sorterPredmeta.setComparator(0, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] predmet1 = o1.split("(?<=\\D)(?=\\d)");
				String[] predmet2 = o2.split("(?<=\\D)(?=\\d)");

				int broj1 = Integer.parseInt(predmet1[1]);
				int broj2 = Integer.parseInt(predmet2[1]);

				if (predmet1[0].compareTo(predmet2[0]) != 0)
					return predmet1[0].compareTo(predmet2[0]);
				else if (broj1 > broj2)
					return 1;
				else if (broj1 < broj2)
					return -1;
				else
					return 0;
			}

		});

		sorterPredmeta.setComparator(2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				int broj1 = Integer.parseInt(o1);
				int broj2 = Integer.parseInt(o2);

				if (broj1 > broj2)
					return 1;
				else if (broj1 < broj2)
					return -1;
				else
					return 0;
			}

		});
	}

	public static void reinitialize() {
		int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
		location = MyFrame.getInstance().getLocation();
		// AppFrame.setVisible(false);
		AppFrame.dispose();
		MyFrame.setInstance(null);
		
		AppFrame = MyFrame.getInstance();
		MyFrame.getInstance().setLocation(location);
		AppFrame.setVisible(true);
		postaviKomparatore();
		
		MyFrame.getInstance().getTab().setSelectedIndex(selectedTab);

	}

}
