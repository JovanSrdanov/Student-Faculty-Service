package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.MyApp;
import controller.PredmetiController;
import controller.ProfesorController;
import controller.StudentiController;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;


public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar() {

		JMenu file = new JMenu(MyApp.resourceBundle.getString("file"));
		file.setMnemonic(KeyEvent.VK_F);
		Icon icon = new ImageIcon();

		icon = new ImageIcon("icons" + File.separator + "new.png");
		JMenuItem miNew = new JMenuItem(MyApp.resourceBundle.getString("new"), icon);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
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

		icon = new ImageIcon("icons" + File.separator + "save.png");
		JMenuItem save = new JMenuItem(MyApp.resourceBundle.getString("save"), icon);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.setMnemonic(KeyEvent.VK_V);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fileName1 = "studenti.txt";
				String fileName2 = "profesori.txt";
				String fileName3 = "predmeti.txt";
				String fileName4 = "katedre.txt";
				BazaStudenata.getInstance().saveStudente(fileName1);
				BazaProfesora.getInstance().saveProfesore(fileName2);
				BazaPredmeta.getInstance().savePredmete(fileName3);
				BazaKatedri.getInstance().saveKatedre(fileName4);
				
				JOptionPane.showMessageDialog(null, "Uspesno sacuvano", "Poruka", JOptionPane.PLAIN_MESSAGE);
			}
		});

		JMenu open = new JMenu(MyApp.resourceBundle.getString("open"));
		open.setMnemonic(KeyEvent.VK_P);
		icon = new ImageIcon("icons" + File.separator + "open.png");
		open.setIcon(icon);

		icon = new ImageIcon("icons" + File.separator + "studenti.png");
		JMenuItem Studenti = new JMenuItem(MyApp.resourceBundle.getString("studenti"), icon);
		Studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		Studenti.setMnemonic(KeyEvent.VK_U);
		Studenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(0);
			}
		});

		icon = new ImageIcon("icons" + File.separator + "predmeti.png");
		JMenuItem Predmeti = new JMenuItem(MyApp.resourceBundle.getString("predmeti"), icon);
		Predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		Predmeti.setMnemonic(KeyEvent.VK_R);
		Predmeti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(2);
			}
		});

		icon = new ImageIcon("icons" + File.separator + "profesori.png");
		JMenuItem Profesori = new JMenuItem(MyApp.resourceBundle.getString("profesori"), icon);
		Profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		Profesori.setMnemonic(KeyEvent.VK_P);
		Profesori.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame.getInstance().getTab().setSelectedIndex(1);
			}
		});

		icon = new ImageIcon("icons" + File.separator + "katedra.png");
		JMenuItem Katedre = new JMenuItem(MyApp.resourceBundle.getString("katedre"), icon);
		Katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		Katedre.setMnemonic(KeyEvent.VK_K);

		Katedre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KatedraDijalog KD = new KatedraDijalog(null, MyApp.resourceBundle.getString("katedre"), true);
				KD.setLocationRelativeTo(MyFrame.getInstance());
				KD.setVisible(true);

			}
		});

		open.add(Studenti);
		open.addSeparator();
		open.add(Profesori);
		open.addSeparator();
		open.add(Predmeti);
		open.addSeparator();
		open.add(Katedre);

		icon = new ImageIcon("icons" + File.separator + "close.png");
		JMenuItem close = new JMenuItem(MyApp.resourceBundle.getString("close"), icon);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		close.setMnemonic(KeyEvent.VK_C);
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {  "Save", "Don't save", "Cancle"};
				int input = JOptionPane.showOptionDialog(null, "Da li zelite da sacuvate izmene?",  MyApp.resourceBundle.getString("potvrda"),
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

				if (input == 0) {
					String fileName1 = "studenti.txt";
					String fileName2 = "profesori.txt";
					String fileName3 = "predmeti.txt";
					String fileName4 = "katedre.txt";
					BazaStudenata.getInstance().saveStudente(fileName1);
					BazaProfesora.getInstance().saveProfesore(fileName2);
					BazaPredmeta.getInstance().savePredmete(fileName3);
					BazaKatedri.getInstance().saveKatedre(fileName4);
					
					System.exit(0);
		        }
				else if (input == 1) {
					System.exit(0);
		        }
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

		JMenu edit = new JMenu(MyApp.resourceBundle.getString("edit"));
		edit.setMnemonic(KeyEvent.VK_E);

		icon = new ImageIcon("icons" + File.separator + "editPom.png");
		JMenuItem editPom = new JMenuItem(MyApp.resourceBundle.getString("edit"), icon);
		editPom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
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
						JOptionPane.showMessageDialog(null, MyApp.resourceBundle.getString("izaberiRed"),
								MyApp.resourceBundle.getString("poruka"), JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 1) {
					// Profesor
					if (MyFrame.getTabelaProfesora().getSelectedRow() >= 0)
						ProfesorController.getInstance().izmeniProfesora();
					else
						JOptionPane.showMessageDialog(null, MyApp.resourceBundle.getString("izaberiRed"),
								MyApp.resourceBundle.getString("poruka"), JOptionPane.WARNING_MESSAGE);
				} else if (selectedTab == 2) {
					if (MyFrame.getTabelaPredmeta().getSelectedRow() >= 0)
						PredmetiController.getInstance().izmeniPredmet();
					else
						JOptionPane.showMessageDialog(null, MyApp.resourceBundle.getString("izaberiRed"),
								MyApp.resourceBundle.getString("poruka"), JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		icon = new ImageIcon("icons" + File.separator + "delete.png");
		JMenuItem delete = new JMenuItem(MyApp.resourceBundle.getString("delete"), icon);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		delete.setMnemonic(KeyEvent.VK_L);

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedTab = MyFrame.getInstance().getTab().getSelectedIndex();
				if (selectedTab == 0) {
					StudentiController.getInstance().izbrisiStudenta(MyFrame.getTabelaStduenti().getSelectedRow());
					if (MyFrame.getInstance().isPretraga()) {
						StudentiController.getInstance().pretraziStudente(Toolbar.getStaraPretraga());
					}
				} else if (selectedTab == 1) {
					ProfesorController.getInstance().izbrisiProfesora(MyFrame.getTabelaProfesora().getSelectedRow());
					if (MyFrame.getInstance().isPretraga()) {
						ProfesorController.getInstance().pretraziProfesore(Toolbar.getStaraPretraga());
					}
				} else if (selectedTab == 2) {
					PredmetiController.getInstance().izbrisiPredmet(MyFrame.getTabelaPredmeta().getSelectedRow());
					if (MyFrame.getInstance().isPretraga())
						PredmetiController.getInstance().pretraziPredmete(Toolbar.getStaraPretraga());
				}
			}
		});

		edit.add(editPom);
		edit.addSeparator();
		edit.add(delete);
		add(edit);

		JMenu help = new JMenu(MyApp.resourceBundle.getString("help"));
		help.setMnemonic(KeyEvent.VK_H);

		icon = new ImageIcon("icons" + File.separator + "helpPom.png");
		JMenuItem helpPom = new JMenuItem(MyApp.resourceBundle.getString("help"), icon);
		helpPom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		helpPom.setMnemonic(KeyEvent.VK_E);

		icon = new ImageIcon("icons" + File.separator + "about.png");
		JMenuItem about = new JMenuItem(MyApp.resourceBundle.getString("about"), icon);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		about.setMnemonic(KeyEvent.VK_B);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutDijalog AD = new AboutDijalog(null, MyApp.resourceBundle.getString("about"), true);
				AD.setLocationRelativeTo(MyFrame.getInstance());
				AD.setVisible(true);

				/*
				 * for(Student stud:BazaPredmeta.getInstance().getPredmeti().get(0).
				 * getSpisakStudenataKojiNisuPoloziliPredmet())
				 * System.out.println(stud.getIme());
				 * 
				 * System.out.println(
				 * "------------------------------------------------------------------------------------------"
				 * );
				 * 
				 * for(Student stud:BazaPredmeta.getInstance().getPredmeti().get(0).
				 * getSpisakStudenataKojiSuPoloziliPredmet()) System.out.println(stud.getIme());
				 */
			}

		});

		helpPom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog HD = new HelpDialog(null, MyApp.resourceBundle.getString("help"), false);
				HD.setLocationRelativeTo(MyFrame.getInstance());
				HD.setVisible(true);

			}
		});

		help.add(helpPom);
		help.addSeparator();
		help.add(about);
		add(help);

		JButton sr = new JButton();
		JButton en = new JButton();
		add(Box.createHorizontalGlue());

		icon = new ImageIcon("icons" + File.separator + "en.png");

		en.setBackground(Color.white);
		en.setPreferredSize(new Dimension(30, 30));
		en.setIcon(icon);

		icon = new ImageIcon("icons" + File.separator + "sr.png");
		sr.setBackground(Color.white);
		sr.setPreferredSize(new Dimension(30, 30));
		sr.setIcon(icon);

		sr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!Locale.getDefault().equals(new Locale("sr", "RS"))) {
					Locale.setDefault(new Locale("sr", "RS"));
					MyApp.resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources",
							new Locale("sr", "RS"));
					MyFrame.getInstance().changeLanguage();
					MyApp.reinitialize();
				}
			}
		});

		en.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!Locale.getDefault().equals(new Locale("en", "US"))) {
					Locale.setDefault(new Locale("en", "US"));
					MyApp.resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources",
							new Locale("en", "US"));
					MyFrame.getInstance().changeLanguage();
					MyApp.reinitialize();

				}

			}
		});

		add(sr);
		add(en);

	}

}