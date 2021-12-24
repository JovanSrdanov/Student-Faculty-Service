package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4070509246110827584L;

	public static MyFrame instance = null;

	private Toolbar toolbar;
	private MenuBar menu;
	private MyTab tabbedPane;
	private JPanel panelGlavni;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelPROBA;

	private MyFrame() {
		this.createToolbar();
		this.initialise();
		this.createMenuBar();
		this.createTabbedPane();
	}

	// Singleton
	public static MyFrame getInstance() {
		if (instance == null)
			instance = new MyFrame();

		return instance;
	}

	private void createToolbar() {
		// Toolbar
		this.toolbar = new Toolbar();
		this.add(this.toolbar, BorderLayout.NORTH);
	}

	private void createMenuBar() {
		// Menu bar
		this.menu = new MenuBar();
		this.setJMenuBar(this.menu);
	}

	private void initialise() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		int screenHeight = screenSize.height;
		int screenWidith = screenSize.width;

		setSize((screenWidith / 4) * 3, (screenHeight / 4) * 3);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Color color = new Color(0, 95, 105);

		this.panelGlavni = new JPanel();
		this.panelGlavni.setBackground(color);
		this.panelGlavni.setLayout(new BorderLayout());

		this.panelNorth = new JPanel();
		this.panelNorth.setBackground(color);
		this.panelNorth.setPreferredSize(new Dimension(50, 50));

		this.panelSouth = new JPanel();
		this.panelSouth.setBackground(color);
		this.panelSouth.setPreferredSize(new Dimension(50, 50));

		this.panelWest = new JPanel();
		this.panelWest.setBackground(color);
		this.panelWest.setPreferredSize(new Dimension(75, 75));

		this.panelEast = new JPanel();
		this.panelEast.setBackground(color);
		this.panelEast.setPreferredSize(new Dimension(75, 75));

		this.panelGlavni.add(panelNorth, BorderLayout.NORTH);
		this.panelGlavni.add(panelSouth, BorderLayout.SOUTH);
		this.panelGlavni.add(panelWest, BorderLayout.WEST);
		this.panelGlavni.add(panelEast, BorderLayout.EAST);

		this.add(this.panelGlavni, BorderLayout.CENTER);

	}

	private void createTabbedPane() {

		this.tabbedPane = new MyTab();

		ImageIcon iconStudenti = createImageIcon("icons/studenti.png", true, 32, 32);
		JPanel tabelaStduenti = new JPanel();
		tabelaStduenti.setBackground(Color.red);
		tabbedPane.addTab("Studenti", iconStudenti, tabelaStduenti, "Prikaz studenata");

		ImageIcon iconProfesori = createImageIcon("icons/profesori.png", true, 32, 32);
		JPanel tabelaProfesori= new JPanel();
		tabelaProfesori.setBackground(Color.green);
		tabbedPane.addTab("Profesori", iconProfesori, tabelaProfesori, "Prikaz profseora");

		ImageIcon iconPredmeti = createImageIcon("icons/predmeti.png", true, 32, 32);
		JPanel tabelaPredmeti = new JPanel();
		tabelaPredmeti.setBackground(Color.cyan);
		tabbedPane.addTab("Predmeti", iconPredmeti, tabelaPredmeti, "Prikaz predmeta");

		this.panelGlavni.add(this.tabbedPane, BorderLayout.CENTER);
	}


	protected static ImageIcon createImageIcon(String path, boolean scaleImage, int width, int height) {
		if (scaleImage) {

			ImageIcon imageIcon = new ImageIcon(path);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			return imageIcon;

		} else {
			return new ImageIcon(path);
		}
	}

}
