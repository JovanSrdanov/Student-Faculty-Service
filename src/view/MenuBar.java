package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5511353684955783810L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		Icon icon = new ImageIcon("icons/file.png");
		file.setIcon(icon);

		icon = new ImageIcon("icons/new.png");
		JMenuItem miNew = new JMenuItem("New", icon);
		miNew.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.ALT_MASK));
		miNew.setMnemonic(KeyEvent.VK_W);

		icon = new ImageIcon("icons/save.png");
		JMenuItem save = new JMenuItem("Save", icon);
		save.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.ALT_MASK));
		save.setMnemonic(KeyEvent.VK_V);
		
		JMenu open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_P);
		icon = new ImageIcon("icons/open.png");
		open.setIcon(icon);

		icon = new ImageIcon("icons/studenti.png");
		JMenuItem Studenti = new JMenuItem("Studenti", icon);
		Studenti.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_T, ActionEvent.ALT_MASK));
		Studenti.setMnemonic(KeyEvent.VK_U);

		icon = new ImageIcon("icons/predmeti.png");
		JMenuItem Predmeti = new JMenuItem("Predmeti", icon);
		Predmeti.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_M, ActionEvent.ALT_MASK));
		Predmeti.setMnemonic(KeyEvent.VK_J);

		icon = new ImageIcon("icons/profesori.png");
		JMenuItem Profesori = new JMenuItem("Profesori", icon);
		Profesori.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.ALT_MASK));
		Profesori.setMnemonic(KeyEvent.VK_L);

		icon = new ImageIcon("icons/katedra.png");
		JMenuItem Katedre = new JMenuItem("Katedre", icon);
		Katedre.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.ALT_MASK));
		Katedre.setMnemonic(KeyEvent.VK_K);

		open.add(Studenti);
		open.addSeparator();
		open.add(Predmeti);
		open.addSeparator();
		open.add(Profesori);
		open.addSeparator();
		open.add(Katedre);

		icon = new ImageIcon("icons/close.png");
		JMenuItem close = new JMenuItem("Close", icon);
		close.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		close.setMnemonic(KeyEvent.VK_C);

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
		icon = new ImageIcon("icons/edit.png");
		edit.setIcon(icon);

		icon = new ImageIcon("icons/editPom.png");
		JMenuItem editPom = new JMenuItem("Edit", icon);
		editPom.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_G, ActionEvent.ALT_MASK));
		editPom.setMnemonic(KeyEvent.VK_D);


		icon = new ImageIcon("icons/delete.png");
		JMenuItem delete = new JMenuItem("Delete", icon);
		delete.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Y, ActionEvent.ALT_MASK));
		delete.setMnemonic(KeyEvent.VK_L);

		edit.add(editPom);
		edit.addSeparator();
		edit.add(delete);
		add(edit);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("icons/help.png");
		help.setIcon(icon);

		icon = new ImageIcon("icons/helpPom.png");
		JMenuItem helpPom = new JMenuItem("Help", icon);
		helpPom.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.ALT_MASK));
		helpPom.setMnemonic(KeyEvent.VK_E);

		icon = new ImageIcon("icons/about.png");
		JMenuItem about = new JMenuItem("About", icon);
		about.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.ALT_MASK));
		about.setMnemonic(KeyEvent.VK_B);

		help.add(helpPom);
		help.addSeparator();
		help.add(about);
		add(help);

	}

}
