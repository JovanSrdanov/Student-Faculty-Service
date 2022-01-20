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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Semestar;

public class PredmetDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3432403525611046701L;
	private JButton okBtn;
	private JButton cancleBtn;
	private char tip;
	private JTextField sifraPredmetaTxt;
	private JTextField nazivPredmetaTxt;
	private JComboBox<String> godinaPredmetaCB;
	private JComboBox<String> semestarPredmetaCB;
	private JTextField ESPBPredmetaTxt;
	private static JTextField profesorPredmetaTxt;
	private static JButton btnPlus;
	private static JButton btnMinus;
	private String trenutnaSifraPredmeta;

	private static Predmet selectedPredmet;

	public PredmetDialog(Frame owner, String title, boolean modal, char t) {
		super(owner, title, modal);
		setSize(600, 400);
		tip = t;
		trenutnaSifraPredmeta = "";
		
		///////////////////////////////////////////////////

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		Dimension dimLabela = new Dimension(280, 20);
		Dimension dimTextBox = new Dimension(280, 20);

		JPanel sifraPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel sifraPredmetaLbl = new JLabel("Šifra predmeta:");
		sifraPredmetaLbl.setPreferredSize(dimLabela);
		sifraPredmetaTxt = new JTextField();
		sifraPredmetaTxt.setPreferredSize(dimTextBox);
		sifraPredmetaPnl.add(sifraPredmetaLbl);
		sifraPredmetaPnl.add(sifraPredmetaTxt);

		JPanel nazivPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nazivPredmetaLbl = new JLabel("Naziv predmeta:");
		nazivPredmetaLbl.setPreferredSize(dimLabela);
		nazivPredmetaTxt = new JTextField();
		nazivPredmetaTxt.setPreferredSize(dimTextBox);
		nazivPredmetaPnl.add(nazivPredmetaLbl);
		nazivPredmetaPnl.add(nazivPredmetaTxt);

		JPanel godinaPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel godinaPredmetaLbl = new JLabel("Godina na kojoj se predaje predmet:");
		godinaPredmetaLbl.setPreferredSize(dimLabela);
		String[] godine = { "1. (PRVA)", "2. (DRUGA)", "3. (TREĆA)", "4. (ČETVRTA)" };
		godinaPredmetaCB = new JComboBox<String>(godine);
		godinaPredmetaCB.setPreferredSize(dimTextBox);
		godinaPredmetaPnl.add(godinaPredmetaLbl);
		godinaPredmetaPnl.add(godinaPredmetaCB);

		JPanel semestarPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel semestarPredmetaLbl = new JLabel("Semestar u kom se predaje predmet:");
		semestarPredmetaLbl.setPreferredSize(dimLabela);
		String[] sem = { "ZIMSKI", "LETNJI" };
		semestarPredmetaCB = new JComboBox<String>(sem);
		semestarPredmetaCB.setPreferredSize(dimTextBox);
		semestarPredmetaPnl.add(semestarPredmetaLbl);
		semestarPredmetaPnl.add(semestarPredmetaCB);

		JPanel ESPBPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel ESPBPredmetaLbl = new JLabel("ESPB:");
		ESPBPredmetaLbl.setPreferredSize(dimLabela);
		ESPBPredmetaTxt = new JTextField();
		ESPBPredmetaTxt.setPreferredSize(dimTextBox);
		ESPBPredmetaPnl.add(ESPBPredmetaLbl);
		ESPBPredmetaPnl.add(ESPBPredmetaTxt);

		JPanel profesorPredmetaPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel profesorPredmetaLbl = new JLabel("Profesor:");
		profesorPredmetaLbl.setPreferredSize(dimLabela);
		profesorPredmetaTxt = new JTextField();
		profesorPredmetaTxt.setPreferredSize(new Dimension(200, 20));
		profesorPredmetaTxt.setEditable(false);
		profesorPredmetaPnl.add(profesorPredmetaLbl);
		profesorPredmetaPnl.add(profesorPredmetaTxt);

		btnPlus = new JButton("+");
		btnMinus = new JButton("-");
		btnMinus.setEnabled(false);
		profesorPredmetaPnl.add(btnPlus);
		profesorPredmetaPnl.add(btnMinus);

		JPanel btnPnl = new JPanel();
		okBtn = new JButton("Potvrda");
		okBtn.setEnabled(false);
		cancleBtn = new JButton("Odustani");
		btnPnl.add(okBtn);
		btnPnl.add(cancleBtn);

		dodajFocusListener(sifraPredmetaTxt);
		dodajFocusListener(nazivPredmetaTxt);
		dodajFocusListener(ESPBPredmetaTxt);

		int rowSelectedIndex = MyFrame.getTabelaPredmeta().getSelectedRow();
		if (tip == 'i' && rowSelectedIndex >= 0) {
			okBtn.setEnabled(true);
			// Predmet p = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			int a = MyFrame.getTabelaPredmeta().convertRowIndexToModel(rowSelectedIndex);
			Predmet p = BazaPredmeta.getInstance().getRow(a);
			// System.out.println("Klikno " + rowSelectedIndex + " Konvert " + a);
			selectedPredmet = p;

			sifraPredmetaTxt.setText(selectedPredmet.getSifrPredmeta());
			nazivPredmetaTxt.setText(p.getNazivPredmeta());
			ESPBPredmetaTxt.setText(Integer.toString(p.getBrojESPBBodova()));
			godinaPredmetaCB.setSelectedIndex(p.getGodinaStudijaUKojojSePredmetIzvodi() - 1);

			int semestarIndex = 0;
			if (p.getSemestar() == Semestar.ZIMSKI)
				semestarIndex = 0;
			else
				semestarIndex = 1;

			trenutnaSifraPredmeta = p.getSifrPredmeta();

			semestarPredmetaCB.setSelectedIndex(semestarIndex);

			azurirajProf();
		}

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okBtn.setEnabled(proveraUpis(tip));
				if (proveraUpis(tip)) {
					String sifraP = sifraPredmetaTxt.getText();

					String nazivP = nazivPredmetaTxt.getText();
					int brojESPB = Integer.parseInt(ESPBPredmetaTxt.getText());

					Semestar s;
					if (semestarPredmetaCB.getSelectedIndex() == 0)
						s = Semestar.ZIMSKI;
					else
						s = Semestar.LETNJI;

					int god = godinaPredmetaCB.getSelectedIndex() + 1;

					if (tip == 'u') {
						BazaPredmeta.getInstance().dodajPredmet(sifraP, nazivP, s, god, null, brojESPB);
					}

					if (tip == 'i') {
						BazaPredmeta.getInstance().izmeniPredmet(sifraP, nazivP, s, god, null, brojESPB,
								trenutnaSifraPredmeta);
						// STRAHINJA PAZI NA OVO !!!!!!!!!!!! pazio ja al kasno jbg
				}

					MyFrame.getInstance().azurirajPrikazPredmeta();
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

		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Dijalog nov
				DodavnjaProfesoraPredmetu dialog = new DodavnjaProfesoraPredmetu(null, "Dodavnaje profesora", true);
				dialog.setVisible(true);
			}

		});

		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
					if (p.getBrojLicneKarte() == selectedPredmet.getPredmetniProfesor().getBrojLicneKarte()) {
						p.getSpisakPredmetaNaKojimaJeProfesor().remove(selectedPredmet);
					}
				}
				selectedPredmet.setPredmetniProfesor(null);
				azurirajProf();
			}

		});

		centerPanel.add(sifraPredmetaPnl);
		centerPanel.add(nazivPredmetaPnl);
		centerPanel.add(godinaPredmetaPnl);
		centerPanel.add(semestarPredmetaPnl);
		centerPanel.add(ESPBPredmetaPnl);

		if (tip == 'i') {

			centerPanel.add(profesorPredmetaPnl);

		}

		centerPanel.add(btnPnl);
		this.add(centerPanel);

	}

	private boolean proveraUpis(char tipA) {
		if (tipA == 'u' && existsBySifra(sifraPredmetaTxt.getText()))
			return false;

		if (tipA == 'i' && !trenutnaSifraPredmeta.equals(sifraPredmetaTxt.getText())) {
			if (existsBySifra(sifraPredmetaTxt.getText()))
				return false;
		}

		if (nazivPredmetaTxt.getText().isBlank()) {
			return false;
		}

		if (!sifraPredmetaTxt.getText().matches("[A-Za-z]+[1-9][0-9]*")) {
			return false;
		}

		if (!ESPBPredmetaTxt.getText().matches("[1-9][0-9]*")) {
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

	private boolean existsBySifra(String sifra) {
		for (Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if (p.getSifrPredmeta().equals(sifra))
				return true;
		}
		return false;
	}

	public static void azurirajProf() {
		if (selectedPredmet.getPredmetniProfesor() != null) {
			btnMinus.setEnabled(true);
			btnPlus.setEnabled(false);
			profesorPredmetaTxt.setText(selectedPredmet.getPredmetniProfesor().getIme() + " "
					+ selectedPredmet.getPredmetniProfesor().getPrezime());
		} else {
			profesorPredmetaTxt.setText("");
			btnMinus.setEnabled(false);
			btnPlus.setEnabled(true);
		}
	}

	public static Predmet getSelectedPredmet() {
		return selectedPredmet;
	}

}
