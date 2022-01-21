package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.MyApp;
import model.BazaKatedri;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4070509246110827584L;

	public static MyFrame instance = null;

	public static void setInstance(MyFrame instance) {
		MyFrame.instance = instance;
	}

	private static boolean pretraga;


	private Toolbar toolbar;
	private MenuBar menu;
	private StatusBar statusBar;
	private static MyTab tabbedPane;
	private static JTable tabelaStduenti;
	private static Tabela tabelaPredmeta;
	private static Tabela tabelaProfesora;

	private JPanel panelGlavni;
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JPanel panelWest;
	private JPanel panelEast;

	private MyFrame() {
		MyApp.resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		pretraga = false;
		
		this.createToolbar();
		this.initialise();
		this.createStatusBar();
		this.createMenuBar();
		this.createTabbedPane();
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
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
	}

	public static MyFrame getInstance() {
		if (instance == null)
			instance = new MyFrame();

		return instance;
	}

	private void createToolbar() {

		this.toolbar = new Toolbar();
		this.add(this.toolbar, BorderLayout.NORTH);
	}

	private void createMenuBar() {

		this.menu = new MenuBar();
		this.setJMenuBar(this.menu);
	}

	private void createStatusBar() {

		statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
	}

	private void initialise() {
		setTitle(MyApp.resourceBundle.getString("naslovAplikacije"));
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		int screenHeight = screenSize.height;
		int screenWidith = screenSize.width;

		setSize((screenWidith / 4) * 3, (screenHeight / 4) * 3);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

		tabbedPane = new MyTab();

		ImageIcon iconStudenti = createImageIcon("icons" + File.separator + "studenti.png", true, 32, 32);
		tabelaStduenti = new Tabela(new AbstractTableModelStudenti());
		JScrollPane scrollPaneStudenti = new JScrollPane(tabelaStduenti);
		tabbedPane.addTab(MyApp.resourceBundle.getString("studenti"), iconStudenti, scrollPaneStudenti,MyApp.resourceBundle.getString("studenti"));

		ImageIcon iconProfesori = createImageIcon("icons" + File.separator + "profesori.png", true, 32, 32);
		tabelaProfesora = new Tabela(new AbstractTableModelProfesor());
		JScrollPane scrollPaneProfesori = new JScrollPane(tabelaProfesora);
		tabbedPane.addTab(MyApp.resourceBundle.getString("profesori"), iconProfesori, scrollPaneProfesori,MyApp.resourceBundle.getString("profesori"));

		ImageIcon iconPredmeti = createImageIcon("icons" + File.separator + "predmeti.png", true, 32, 32);
		tabelaPredmeta = new Tabela(new AbstractTableModelPredmeti());

		JScrollPane scrollPanePredmeti = new JScrollPane(tabelaPredmeta);
		tabbedPane.addTab(MyApp.resourceBundle.getString("predmeti"), iconPredmeti, scrollPanePredmeti, MyApp.resourceBundle.getString("predmeti"));

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				pretraga = false;
				statusBar.setAktivniTab(tabbedPane.getSelectedIndex());
				Toolbar.getSearchBar().setText("");
				azurirajPrikazStudenata();
				azurirajPrikazPredmeta();
				azurirajPrikazProfesora();
			}

		});

		this.panelGlavni.add(tabbedPane, BorderLayout.CENTER);

	}

	public void azurirajPrikazStudenata() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) tabelaStduenti.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public void azurirajPrikazPredmeta() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}

	public void azurirajPrikazProfesora() {
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) tabelaProfesora.getModel();
		model.fireTableDataChanged();
		validate();
	}

	protected static ImageIcon createImageIcon(String path, boolean scaleImage, int width, int height) {
		if (scaleImage) {
			// kopirano iz materijala sa vezbi
			ImageIcon imageIcon = new ImageIcon(path);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			return imageIcon;

		} else {
			return new ImageIcon(path);
		}
	}

	public static JTable getTabelaStduenti() {
		return tabelaStduenti;
	}

	public static Tabela getTabelaPredmeta() {
		return tabelaPredmeta;
	}

	public static Tabela getTabelaProfesora() {
		return tabelaProfesora;
	}

	public MyTab getTab() {
		return tabbedPane;
	}

	public boolean isPretraga() {
		return pretraga;
	}

	public void setPretraga(boolean isPretraga) {
		pretraga = isPretraga;
	}

	public void load() {
		BazaProfesora.getInstance().loadProfesora("profesori.txt");
		BazaKatedri.getInstance().loadKatedre("katedre.txt");
		BazaPredmeta.getInstance().loadPredmeti("predmeti.txt");
		BazaStudenata.getInstance().loadStudenti("studenti.txt");
		
		BazaPredmeta.getInstance().loadFix();
		BazaProfesora.getInstance().loadFix();
		BazaStudenata.getInstance().loadFix();
		BazaPredmeta.getInstance().loadFix2();
		
		azurirajPrikazStudenata();
		azurirajPrikazPredmeta();
		azurirajPrikazProfesora();
	};
	
	public void changeLanguage() {
		
		BazaStudenata.getInstance().izmeniJezikKolonaStudenti();
		BazaProfesora.getInstance().izmeniJezikKolonaProfesori();
		BazaPredmeta.getInstance().izmeniJezikKolonaPredmeti();
		BazaKatedri.getInstance().izmeniJezikKolonaKatedri();
		
	}
	
}