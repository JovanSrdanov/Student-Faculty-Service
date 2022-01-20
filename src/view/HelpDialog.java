package view;

import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HelpDialog  extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532094756704393899L;
	public HelpDialog(Frame owner, String title, boolean modal) {
		
		super(owner, title, modal);
		setSize(900, 350);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		String s = "<html>Pomoc:\r\n"
				+ "Entiteti se mogu dodati, izmeniti i obrisati pomocu klika na odgovarajuce dugmice u toolbar sekciji, pomocu klika na odgovarajuci meni u glavnom meniju, pomocu dole navedenih mnemonika i akceleratora\r\n"
				+ "\r\n"
				+ "Prilikom popunjavanja svih polja za izmenu ili unos podataka, moraju sva polja zadovoljati svoja ogranicenja, inace dugme za potvrdu ostaje onemoguceno.\r\n"
				+ "\r\n"
				+ "Mnemonici:\r\n"
				+ "ALT + F : Otvara fajl meni\r\n"
				+ "\r\n"
				+ "ALT + W : Pozicionira se na meni stavku za pravljenje novog entiteta\r\n"
				+ "ALT + V : Pozicionira se na meni stavku za cuvanje podataka	\r\n"
				+ "ALT + P : Otvara meni za selekciju prikaza entiteta (Studenti, Profesori, Predmeti, Katedre)\r\n"
				+ "ALT + C : Pozicionira se na meni stavku za zatvaranje aplikacije\r\n"
				+ "\r\n"
				+ "ALT + U : Pozicionira se na meni stavku za prikaz studenata dok se nalazimo u meni stavki za prikaz entiteta\r\n"
				+ "ALT + P : Pozicionira se na meni stavku za prikaz profesora dok se nalazimo u meni stavki za prikaz entiteta\r\n"
				+ "ALT + R : Pozicionira se na meni stavku za prikaz predmeta dok se nalazimo u meni stavki za prikaz entiteta\r\n"
				+ "ALT + K : Pozicionira se na meni stavku za prikaz katedri dok se nalazimo u meni stavki za prikaz entiteta\r\n"
				+ "\r\n"
				+ "ALT + E : Otvara meni za izmenu\r\n"
				+ "\r\n"
				+ "ALT + D : Pozicionira se na meni stavku za izmenu entiteta\r\n"
				+ "ALT + L : Pozicionira se na meni stavku za brisanje entiteta\r\n"
				+ "\r\n"
				+ "ALT + H : Otvara meni za pomoc\r\n"
				+ "\r\n"
				+ "ALT + D : Pozicionira se na meni stavku za pomoc\r\n"
				+ "ALT + B : Pozicionira se na meni stavku za pomoc\r\n"
				+ "\r\n"
				+ "Akceleratori:\r\n"
				+ "\r\n"
				+ "CTRL + N : Dodavanje novog entiteta\r\n"
				+ "CTRL + S : Cuvanje podataka\r\n"
				+ "CTRL + Z : Zatvaranje aplikacije\r\n"
				+ "\r\n"
				+ "CTRL + T : Prikaz tabele studenata\r\n"
				+ "CTRL + Q : Prikaz tabele profesora\r\n"
				+ "CTRL + M : Prikaz tabele predmeta\r\n"
				+ "CTRL + o : Prikaz tabele katedri\r\n"
				+ "\r\n"
				+ "CTRL + G : Izmena entiteta\r\n"
				+ "CTRL + Y : Brisanje entiteta\r\n"
				+ "\r\n"
				+ "CTRL + I : Prikaz pomoci\r\n"
				+ "CTRL + X : Prikaz infromacija o aplikaciji\r\n"
				+ "</hhml>";
				
		
		JLabel t = new JLabel(s,SwingConstants.LEFT);
		
		centerPanel.add(t);
		
		

		this.add(centerPanel);
		
	}
}
