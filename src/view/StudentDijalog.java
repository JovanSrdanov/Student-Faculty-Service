package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Adresa;

import model.BazaStudenata;
import model.Ocena;

import model.Status;
import model.Student;

public class StudentDijalog extends JDialog {

	private static final long serialVersionUID = -8238207988908904811L;
	private JTextField prezimeTxt;
	private JTextField imeTxt;
	private JTextField datumTxt;
	private JTextField adresaTxt;
	private JTextField telTxt;
	private JTextField eMailTxt;
	private JTextField brojIndexaTxt;
	private JTextField godinaUpisaTxt;
	private JComboBox<String> godinaStudijaCB;
	private JComboBox<String> nacinFinansiranjaCB;
	private JButton okBtn;
	private JButton cancleBtn;
	private char tip;
	private String trenutniBrojIndexa;
	private JTabbedPane zaSad;
	private StudentDijalog prozor;

	private static int sumaE;

	private static JLabel panProsOcLbl;
	private static JLabel panUkESPBLbl;

	private static Student selectedStudent;

	public static Student getSelectedStudent() {
		return selectedStudent;
	}

	private static ArrayList<String> kolone;
	private static ArrayList<String> kolonePolozeni;

	private static Tabela nepolozeniTabel;
	private static Tabela polozeniTabel;

	public StudentDijalog(Frame owner, String title, boolean modal, char t) {
		super(owner, title, modal);
		setSize(520, 430);
		setLocationRelativeTo(owner);
		prozor = this;

		tip = t;
		trenutniBrojIndexa = "";

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		Dimension dimLabela = new Dimension(200, 20);
		Dimension dimTextBox = new Dimension(280, 20);

		JPanel przezimePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel przezimeLbl = new JLabel("Prezime:");
		przezimeLbl.setPreferredSize(dimLabela);
		prezimeTxt = new JTextField();
		prezimeTxt.setPreferredSize(dimTextBox);
		przezimePnl.add(przezimeLbl);
		przezimePnl.add(prezimeTxt);

		JPanel imePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeLbl = new JLabel("Ime:");
		imeLbl.setPreferredSize(dimLabela);
		imeTxt = new JTextField();
		imeTxt.setPreferredSize(dimTextBox);
		imePnl.add(imeLbl);
		imePnl.add(imeTxt);

		JPanel datPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datLbl = new JLabel("Datum rođenja (DD.MM.GGGG.):");
		datLbl.setPreferredSize(dimLabela);
		datumTxt = new JTextField();
		datumTxt.setPreferredSize(dimTextBox);
		datPnl.add(datLbl);
		datPnl.add(datumTxt);

		JPanel adrPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adrLbl = new JLabel("Adresa (ulica,broj,grad,drzava):");
		adrLbl.setPreferredSize(dimLabela);
		adresaTxt = new JTextField();
		adresaTxt.setPreferredSize(dimTextBox);
		adrPnl.add(adrLbl);
		adrPnl.add(adresaTxt);

		JPanel telPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telLbl = new JLabel("Telefon:");
		telLbl.setPreferredSize(dimLabela);
		telTxt = new JTextField();
		telTxt.setPreferredSize(dimTextBox);
		telPnl.add(telLbl);
		telPnl.add(telTxt);

		JPanel mailPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel mailLbl = new JLabel("eMail:");
		mailLbl.setPreferredSize(dimLabela);
		eMailTxt = new JTextField();
		eMailTxt.setPreferredSize(dimTextBox);
		mailPnl.add(mailLbl);
		mailPnl.add(eMailTxt);

		JPanel brojIndexaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel brojIndexaLbl = new JLabel("Broj indeksa (xx yyy/zzzz) :");
		brojIndexaLbl.setPreferredSize(dimLabela);
		brojIndexaTxt = new JTextField();
		brojIndexaTxt.setPreferredSize(dimTextBox);
		brojIndexaPnl.add(brojIndexaLbl);
		brojIndexaPnl.add(brojIndexaTxt);

		JPanel godinaUpisaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel godinaUpisaLbl = new JLabel("Godina upisa:");
		godinaUpisaLbl.setPreferredSize(dimLabela);
		godinaUpisaTxt = new JTextField();
		godinaUpisaTxt.setPreferredSize(dimTextBox);
		godinaUpisaPnl.add(godinaUpisaLbl);
		godinaUpisaPnl.add(godinaUpisaTxt);

		JPanel godinaStudijaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel godinaStudijaLbl = new JLabel("Trenutna godina studija:");
		godinaStudijaLbl.setPreferredSize(dimLabela);
		String[] stepenStudijaLista = { "1. (PRVA)", "2. (DRUGA)", "3. (TREĆA)", "4. (ČETVRTA)" };
		godinaStudijaCB = new JComboBox<String>(stepenStudijaLista);
		godinaStudijaCB.setPreferredSize(dimTextBox);
		godinaStudijaPnl.add(godinaStudijaLbl);
		godinaStudijaPnl.add(godinaStudijaCB);

		JPanel nacinFinansiranjaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nacinFinansiranjaLbl = new JLabel("Način finansiranja:");
		nacinFinansiranjaLbl.setPreferredSize(dimLabela);
		String[] nacinFinansiranjaLista = { "BUDŽET", "SAMOFINANSIRANJE" };
		nacinFinansiranjaCB = new JComboBox<String>(nacinFinansiranjaLista);
		nacinFinansiranjaCB.setPreferredSize(dimTextBox);
		nacinFinansiranjaPnl.add(nacinFinansiranjaLbl);
		nacinFinansiranjaPnl.add(nacinFinansiranjaCB);

		JPanel btnPnl = new JPanel();
		okBtn = new JButton("Potvrda");
		okBtn.setEnabled(false);

		cancleBtn = new JButton("Odustani");

		btnPnl.add(okBtn);
		btnPnl.add(cancleBtn);

		dodajFocusListener(prezimeTxt);
		dodajFocusListener(imeTxt);
		dodajFocusListener(datumTxt);
		dodajFocusListener(adresaTxt);
		dodajFocusListener(telTxt);
		dodajFocusListener(eMailTxt);
		dodajFocusListener(brojIndexaTxt);
		dodajFocusListener(godinaUpisaTxt);

		int rowSelectedIndex = MyFrame.getTabelaStduenti().getSelectedRow();

		if (tip == 'i' && rowSelectedIndex >= 0) {
			okBtn.setEnabled(true);
			kolone = new ArrayList<String>();
			kolone.add("Sifra predmeta");
			kolone.add("Naziv predmeta");
			kolone.add("espb");
			kolone.add("Godina studija");
			kolone.add("Semestar");

			kolonePolozeni = new ArrayList<String>();
			kolonePolozeni.add("Sifra predmeta");
			kolonePolozeni.add("Naziv predmeta");
			kolonePolozeni.add("ESPB");
			kolonePolozeni.add("OCENA");
			kolonePolozeni.add("DATUM");

			int a = MyFrame.getTabelaStduenti().convertRowIndexToModel(rowSelectedIndex);
			Student s = BazaStudenata.getInstance().getRow(a);

			selectedStudent = s;

			prezimeTxt.setText(selectedStudent.getPrezime());
			imeTxt.setText(selectedStudent.getIme());
			datumTxt.setText(selectedStudent.getDatumRodjenja().format(DateTimeFormatter.ofPattern("d.M.yyyy.")));
			adresaTxt.setText(selectedStudent.getAdresaStanovanja().toString());
			telTxt.setText(selectedStudent.getKontaktTelefon());
			eMailTxt.setText(selectedStudent.geteMailAdresa());
			brojIndexaTxt.setText(selectedStudent.getBrojIndexa());
			godinaUpisaTxt.setText(Integer.toString(selectedStudent.getGodinaUpisa()));
			godinaStudijaCB.setSelectedIndex(selectedStudent.getTrenutnaGodinaStudija() - 1);
			int statusIndex = 0;
			if (selectedStudent.getStatus() == Status.BUDŽET)
				statusIndex = 0;
			else
				statusIndex = 1;

			trenutniBrojIndexa = selectedStudent.getBrojIndexa();

			nacinFinansiranjaCB.setSelectedIndex(statusIndex);

		}

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okBtn.setEnabled(proveraUpis(tip));
				if (proveraUpis(tip)) {
					String ime = imeTxt.getText().trim();
					String prezime = prezimeTxt.getText().trim();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy.");
					LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);
					String[] deoAdr = adresaTxt.getText().split(",");
					Adresa adresaStanovanja = new Adresa(deoAdr[0].trim(), deoAdr[1].trim(), deoAdr[2].trim(),
							deoAdr[3].trim());
					String kontaktTelefon = telTxt.getText().trim();
					String eMailAdresa = eMailTxt.getText().trim();
					String brIndexa = brojIndexaTxt.getText().trim();
					int godinaUpisa = Integer.parseInt(godinaUpisaTxt.getText());
					int godinaStudija = godinaStudijaCB.getSelectedIndex() + 1;

					Status s;
					if (nacinFinansiranjaCB.getSelectedIndex() == 0)
						s = Status.BUDŽET;
					else
						s = Status.SAMOFINANRSIRANJE;

					if (tip == 'u') {
						Student pom = new Student(prezime, ime, datumRodj, adresaStanovanja, kontaktTelefon,
								eMailAdresa, brIndexa, godinaUpisa, godinaStudija, s, 0, null, null);
						BazaStudenata.getInstance().dodajStudnetna(pom);

					}
					if (tip == 'i') {

						BazaStudenata.getInstance().izmeniStudenta(prezime, ime, datumRodj, adresaStanovanja,
								kontaktTelefon, eMailAdresa, brIndexa, godinaUpisa, godinaStudija, s,
								trenutniBrojIndexa);

					}

					MyFrame.getInstance().azurirajPrikazStudenata();
					dispose();
				}

			}
		});

		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		centerPanel.add(przezimePnl);
		centerPanel.add(imePnl);
		centerPanel.add(datPnl);
		centerPanel.add(adrPnl);
		centerPanel.add(telPnl);
		centerPanel.add(mailPnl);
		centerPanel.add(brojIndexaPnl);
		centerPanel.add(godinaUpisaPnl);
		centerPanel.add(godinaStudijaPnl);
		centerPanel.add(nacinFinansiranjaPnl);
		centerPanel.add(btnPnl);

		if (tip == 'i') {
			zaSad = new JTabbedPane();
			zaSad.addTab("Informacije", centerPanel);

			JPanel panNepolozeni = new JPanel();
			panNepolozeni.setLayout(new BoxLayout(panNepolozeni, BoxLayout.Y_AXIS));
			JPanel panBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));

			nepolozeniTabel = new Tabela(new AbstractTableModelNepolozeni());
			JScrollPane scrollPaneNepolozeni = new JScrollPane(nepolozeniTabel);

			JButton addBtn = new JButton("Dodaj");
			JButton delBtn = new JButton("Obrisi");
			JButton polaganjeBtn = new JButton("Polaganje");

			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			addBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					DodavanjePredmetaStudentuDijalog dpsd = new DodavanjePredmetaStudentuDijalog(null, "Dodavanje",
							true);
					dpsd.setLocationRelativeTo(prozor);

					dpsd.setVisible(true);

				}
			}

			);

			polaganjeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int rowSelectedIndex = nepolozeniTabel.getSelectedRow();
					if (rowSelectedIndex != -1) {
						Ocena o = selectedStudent.getSpisakNePolozenihIspita().get(rowSelectedIndex);
						PolaganjeDialog polaganjeDialog = new PolaganjeDialog(null, "Polaganje", true, o);
						polaganjeDialog.setLocationRelativeTo(prozor);
						polaganjeDialog.setVisible(true);
						if (o.getBrojcanaVrednostOcene() > 5) {
							selectedStudent.getSpisakPolozenihIspita().add(o);
							selectedStudent.getSpisakNePolozenihIspita().remove(o);
							StudentDijalog.azurirajPrikazNepolozenih();
							StudentDijalog.azurirajPrikazPolozenih();
						}
					}
				}
			});

			delBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int rowSelectedIndex = nepolozeniTabel.getSelectedRow();
					if (rowSelectedIndex != -1) {
						Object[] options = { "Da", "Ne" };
						int input = JOptionPane.showOptionDialog(null,
								"Da li ste sigurni da želite da obrišete predmet?", "Potvrda",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

						if (input == 0) {
							Ocena o = selectedStudent.getSpisakNePolozenihIspita().get(rowSelectedIndex);
							selectedStudent.getSpisakNePolozenihIspita().remove(o);
							StudentDijalog.azurirajPrikazNepolozenih();
						}
					}
				}

			});

			panBtn.add(addBtn);
			panBtn.add(delBtn);
			panBtn.add(polaganjeBtn);
			panNepolozeni.add(panBtn);
			panNepolozeni.add(scrollPaneNepolozeni);

			///////////////////////////////////////////

			JPanel panPolozeni = new JPanel();
			panPolozeni.setLayout(new BoxLayout(panPolozeni, BoxLayout.Y_AXIS));

			polozeniTabel = new Tabela(new AbstractTableModelPolozeni());
			JScrollPane scrollPanePolozeni = new JScrollPane(polozeniTabel);

			JPanel panPonisti = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JButton ponistiBtn = new JButton("Ponisti ocenu");
			ponistiBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int rowSelectedIndex = polozeniTabel.getSelectedRow();
					if (rowSelectedIndex != -1) {
						Object[] options = { "Da", "Ne" };
						int input = JOptionPane.showOptionDialog(null,
								"Da li ste sigurni da želite da ponistite ocenu?", "Potvrda", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
						if (input == 0) {
							Ocena o = selectedStudent.getSpisakPolozenihIspita().get(rowSelectedIndex);
							o.setBrojcanaVrednostOcene(5);
							o.setDatumPolaganjaIspita(null);
							selectedStudent.getSpisakNePolozenihIspita().add(o);
							selectedStudent.getSpisakPolozenihIspita().remove(o);
							StudentDijalog.azurirajPrikazNepolozenih();
							StudentDijalog.azurirajPrikazPolozenih();
							MyFrame.getInstance().azurirajPrikazStudenata();
						}
					}

				}
			});

			panPonisti.add(ponistiBtn);
			panPolozeni.add(panPonisti);
			panPolozeni.add(scrollPanePolozeni);

			JPanel panProsOc = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			JPanel panUkESPB = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			///
			panProsOcLbl = new JLabel();
			panUkESPBLbl = new JLabel();
			izracunajProsecnuOcenu();

			panProsOc.add(panProsOcLbl);
			panUkESPB.add(panUkESPBLbl);

			panPolozeni.add(panProsOc);
			panPolozeni.add(panUkESPB);

			zaSad.addTab("Položeni predmeti", panPolozeni);
			zaSad.addTab("Nepoloženi predmeti", panNepolozeni);
			this.add(zaSad);

		} else
			this.add(centerPanel);

	}

	private boolean proveraUpis(char tipA) {
		if (tipA == 'u' && existsByIndex(brojIndexaTxt.getText()))
			return false;

		if (tipA == 'i' && !trenutniBrojIndexa.equals(brojIndexaTxt.getText())) {
			if (existsByIndex(brojIndexaTxt.getText()))
				return false;
		}

		if (imeTxt.getText().isBlank()) {
			return false;
		}
		if (prezimeTxt.getText().isBlank()) {
			return false;
		}
		if (telTxt.getText().isBlank()) {
			return false;
		}
		if (!godinaUpisaTxt.getText().matches("[0-9]+")) {
			return false;
		}
		if (!eMailTxt.getText().matches("[^ ]+[.][^ ]+@[^ ]+[.][^ ]+")) {
			return false;
		}
		if (!adresaTxt.getText().matches(".+,[0-9]+[a-zA-Z]?,.+,.+")) {
			return false;
		}
		if (!datumTxt.getText().matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]")) {
			return false;
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy.");
				LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);
				if (datumRodj.isAfter(LocalDate.now())) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		if (!brojIndexaTxt.getText().matches("[A-Z]{2}[ ][1-9][0-9]{0,2}[/][1-9][0-9]{3}")) {
			return false;
		}

		return true;
	}

	private void dodajFocusListener(JTextField txt) {
		txt.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				okBtn.setEnabled(proveraUpis(tip));

			}

			@Override
			public void focusLost(FocusEvent e) {
				okBtn.setEnabled(proveraUpis(tip));

			}

		});

		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tip));

			}

			@Override
			public void keyPressed(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tip));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tip));

			}

		});
	}

	private boolean existsByIndex(String index) {
		for (Student p : BazaStudenata.getInstance().getStudenti()) {
			if (p.getBrojIndexa().equals(index))
				return true;
		}
		return false;
	}

	public static String getValueAt(int rowIndex, int columnIndex) {
		if (selectedStudent.getSpisakNePolozenihIspita() == null)
			return null;

		Ocena ocena = selectedStudent.getSpisakNePolozenihIspita().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ocena.getPredmet().getSifrPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getBrojESPBBodova());
		case 3:
			return Integer.toString(ocena.getPredmet().getGodinaStudijaUKojojSePredmetIzvodi());
		case 4:
			return ocena.getPredmet().getSemestar().toString();
		default:
			return null;
		}
	}

	public static String getColumnName(int column) {
		return kolone.get(column);
	}

	public static int getColumnCount() {
		return kolone.size();
	}

	public static int getRowCount() {
		if (selectedStudent.getSpisakNePolozenihIspita() == null)
			return 1;
		return selectedStudent.getSpisakNePolozenihIspita().size();
	}
///////////////////////za polozene

	public static String getValueAtPolozeni(int rowIndex, int columnIndex) {
		if (selectedStudent.getSpisakPolozenihIspita() == null)
			return null;

		Ocena ocena = selectedStudent.getSpisakPolozenihIspita().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return ocena.getPredmet().getSifrPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getBrojESPBBodova());
		case 3:
			return Integer.toString(ocena.getBrojcanaVrednostOcene());
		case 4:
			return ocena.getDatumPolaganjaIspita().format(DateTimeFormatter.ofPattern("d.M.yyyy."));
		default:
			return null;
		}
	}

	public static String getColumnNamePolozeni(int column) {
		return kolonePolozeni.get(column);
	}

	public static int getColumnCountPolozeni() {
		return kolonePolozeni.size();
	}

	public static int getRowCountPolozeni() {
		if (selectedStudent.getSpisakPolozenihIspita() == null)
			return 1;
		return selectedStudent.getSpisakPolozenihIspita().size();
	}

	public static void azurirajPrikazNepolozenih() {
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) nepolozeniTabel.getModel();
		model.fireTableDataChanged();
		// validate();
	}

	public static void azurirajPrikazPolozenih() {
		AbstractTableModelPolozeni model = (AbstractTableModelPolozeni) polozeniTabel.getModel();
		model.fireTableDataChanged();
		izracunajProsecnuOcenu();
		// validate();
	}

	public static void izracunajProsecnuOcenu() {
		ArrayList<Ocena> ocene = selectedStudent.getSpisakPolozenihIspita();

		Double avgOcn = 0.0;

		sumaE = 0;
		Double sumaO = 0.0;

		if (ocene != null) {
			for (Ocena o : ocene) {

				sumaE = o.getPredmet().getBrojESPBBodova() + sumaE;
				sumaO = o.getBrojcanaVrednostOcene() + sumaO;

			}
		}

		if (ocene.size() != 0)
			avgOcn = sumaO / ocene.size();

		selectedStudent.setProsecnaOcena(avgOcn);

		panProsOcLbl.setText("Prosecna ocena: " + selectedStudent.getProsecnaOcena());
		panUkESPBLbl.setText("Ukupno espb: " + sumaE);
	}

}
