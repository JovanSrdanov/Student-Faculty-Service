package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.PredmetiController;
import controller.ProfesorController;
import controller.StudentiController;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		Icon icon = new ImageIcon();

		icon = new ImageIcon("icons/new.png");
		JMenuItem miNew = new JMenuItem("New", icon);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		miNew.setMnemonic(KeyEvent.VK_W);
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
					StudentiController.getInstance().dodajStudenta();
				} else if (selectedTab == 1) {
					// Profesor
					ProfesorController.getInstance().dodajProfesora();
				} else if (selectedTab == 2) {
					// Predmet
					PredmetiController.getInstance().dodajPredmet();
				}
			}
		});

		icon = new ImageIcon("icons/save.png");
		JMenuItem save = new JMenuItem("Save", icon);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		save.setMnemonic(KeyEvent.VK_V);

		JMenu open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_P);
		icon = new ImageIcon("icons/open.png");
		open.setIcon(icon);

		icon = new ImageIcon("icons/studenti.png");
		JMenuItem Studenti = new JMenuItem("Studenti", icon);
		Studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		Studenti.setMnemonic(KeyEvent.VK_U);
		Studenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(0);
			}
		});

		icon = new ImageIcon("icons/predmeti.png");
		JMenuItem Predmeti = new JMenuItem("Predmeti", icon);
		Predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		Predmeti.setMnemonic(KeyEvent.VK_J);
		Predmeti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(2);
			}
		});

		icon = new ImageIcon("icons/profesori.png");
		JMenuItem Profesori = new JMenuItem("Profesori", icon);
		Profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		Profesori.setMnemonic(KeyEvent.VK_L);
		Profesori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(1);
			}
		});

		icon = new ImageIcon("icons/katedra.png");
		JMenuItem Katedre = new JMenuItem("Katedre", icon);
		Katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		Katedre.setMnemonic(KeyEvent.VK_K);

		open.add(Studenti);
		open.addSeparator();
		open.add(Profesori);
		open.addSeparator();
		open.add(Predmeti);
		open.addSeparator();
		open.add(Katedre);

		icon = new ImageIcon("icons/close.png");
		JMenuItem close = new JMenuItem("Close", icon);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		close.setMnemonic(KeyEvent.VK_C);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		file.add(miNew);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(close);

		add(file);

		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);

		icon = new ImageIcon("icons/editPom.png");
		JMenuItem editPom = new JMenuItem("Edit", icon);
		editPom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));
		editPom.setMnemonic(KeyEvent.VK_D);
		editPom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					// Student
					if (MyFrame.getTabelaStduenti().getSelectedRow() >= 0)
						StudentiController.getInstance().izmeniStudenta();
					else
						JOptionPane.showMessageDialog(null, "Izaberi studenta za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 1) {
					// Profesor
					if (MyFrame.getTabelaProfesora().getSelectedRow() >= 0)
						ProfesorController.getInstance().izmeniProfesora();
					else
						JOptionPane.showMessageDialog(null, "Izaberi profesora za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 2) {
					if (MyFrame.getTabelaPredmeta().getSelectedRow() >= 0)
						PredmetiController.getInstance().izmeniPredmet();
					else
						JOptionPane.showMessageDialog(null, "Izaberi predmet za izmenu", "Poruka",
								JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		icon = new ImageIcon("icons/delete.png");
		JMenuItem delete = new JMenuItem("Delete", icon);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.ALT_MASK));
		delete.setMnemonic(KeyEvent.VK_L);

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					StudentiController.getInstance().izbrisiStudenta(MyFrame.getTabelaStduenti().getSelectedRow());
					if(MyFrame.getInstance().isPretraga()) {
						StudentiController.getInstance().pretraziStudente(Toolbar.getStaraPretraga());
					}
				} else if (selectedTab == 1) {
					ProfesorController.getInstance().izbrisiProfesora(MyFrame.getTabelaProfesora().getSelectedRow());
					if(MyFrame.getInstance().isPretraga()) {
						ProfesorController.getInstance().pretraziProfesore(Toolbar.getStaraPretraga());
					}
				} else if (selectedTab == 2) {
					PredmetiController.getInstance().izbrisiPredmet(MyFrame.getTabelaPredmeta().getSelectedRow());
					if(MyFrame.getInstance().isPretraga())
						PredmetiController.getInstance().pretraziPredmete(Toolbar.getStaraPretraga());
				}
			}
		});

		edit.add(editPom);
		edit.addSeparator();
		edit.add(delete);
		add(edit);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);

		icon = new ImageIcon("icons/helpPom.png");
		JMenuItem helpPom = new JMenuItem("Help", icon);
		helpPom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
		helpPom.setMnemonic(KeyEvent.VK_E);

		icon = new ImageIcon("icons/about.png");
		JMenuItem about = new JMenuItem("About", icon);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		about.setMnemonic(KeyEvent.VK_B);

		helpPom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		help.add(helpPom);
		help.addSeparator();
		help.add(about);
		add(help);

	}

}