package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Adresa;
import model.BazaProfesora;
import model.Profesor;
import model.Zvanje;

public class ProfesorDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5395350345430464127L;

	private JTextField imeTxt;
	private JTextField prezimeTxt;
	private JTextField adresaTxt;
	private JTextField telTxt;
	private JTextField eMailTxt;
	private JTextField adresaKancTxt;
	private JTextField brLicneTxt;
	private JComboBox<String> zvanjeCb;
	private JTextField godineStazaTxt;
	private JTextField datumTxt;
	private char tipAk;
	private int trenutniBrojLicneKarte;
	private JTabbedPane proferosTabbed;
	JButton okBtn;

	public ProfesorDialog(Frame owner, String title, boolean modal, char tipA) {
		super(owner, title, modal);
		setSize(550, 400);
		setLocationRelativeTo(owner);
		tipAk = tipA;
		trenutniBrojLicneKarte = 0;

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

		Dimension dim = new Dimension(280, 20);
		Dimension dim2 = new Dimension(200, 20);

		// ime
		JPanel imePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel imeLbl = new JLabel("Ime:");
		imeLbl.setPreferredSize(dim);

		imeTxt = new JTextField();
		imeTxt.setPreferredSize(dim2);

		imePnl.add(imeLbl);
		imePnl.add(imeTxt);

		// Prezime
		JPanel przPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel przLbl = new JLabel("Prezime:");
		przLbl.setPreferredSize(dim);

		prezimeTxt = new JTextField();
		prezimeTxt.setPreferredSize(dim2);

		przPnl.add(przLbl);
		przPnl.add(prezimeTxt);

		// Datum rodj
		JPanel datPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel datLbl = new JLabel("Datum rođenja (DD.MM.GGGG):");
		datLbl.setPreferredSize(dim);

		datumTxt = new JTextField();
		datumTxt.setPreferredSize(dim2);

		datPnl.add(datLbl);
		datPnl.add(datumTxt);

		// Adresa
		JPanel adrPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adrLbl = new JLabel("Adresa (ulica,broj,grad,država):");
		adrLbl.setPreferredSize(dim);

		adresaTxt = new JTextField();
		adresaTxt.setPreferredSize(dim2);

		adrPnl.add(adrLbl);
		adrPnl.add(adresaTxt);

		// Telefon
		JPanel telPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel telLbl = new JLabel("Telefon:");
		telLbl.setPreferredSize(dim);

		telTxt = new JTextField();
		telTxt.setPreferredSize(dim2);

		telPnl.add(telLbl);
		telPnl.add(telTxt);

		// Mail
		JPanel mailPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel mailLbl = new JLabel("eMail:");
		mailLbl.setPreferredSize(dim);

		eMailTxt = new JTextField();
		eMailTxt.setPreferredSize(dim2);

		mailPnl.add(mailLbl);
		mailPnl.add(eMailTxt);

		// Adresa kancelarije
		JPanel adrKncPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel adrKncLbl = new JLabel("Adresa kancelarije (ulica,broj,grad,država):");
		adrKncLbl.setPreferredSize(dim);

		adresaKancTxt = new JTextField();
		adresaKancTxt.setPreferredSize(dim2);

		adrKncPnl.add(adrKncLbl);
		adrKncPnl.add(adresaKancTxt);

		// Broj licne
		JPanel brLicPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel brLicLbl = new JLabel("Broj lične karte:");
		brLicLbl.setPreferredSize(dim);

		brLicneTxt = new JTextField();
		brLicneTxt.setPreferredSize(dim2);

		brLicPnl.add(brLicLbl);
		brLicPnl.add(brLicneTxt);

		// Zvanje (cb)
		JPanel zvanjePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel zvanjeLbl = new JLabel("Izaberite zvanje:");
		zvanjeLbl.setPreferredSize(dim);

		String[] zvanja = { "REDOVNI_PROFESOR", "VANREDNI_PROFESOR", "DOCENT" };
		zvanjeCb = new JComboBox<String>(zvanja);
		zvanjeCb.setPreferredSize(dim2);

		zvanjePnl.add(zvanjeLbl);
		zvanjePnl.add(zvanjeCb);

		// Godine staza
		JPanel godPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel godLbl = new JLabel("Godine staža:");
		godLbl.setPreferredSize(dim);

		godineStazaTxt = new JTextField();
		godineStazaTxt.setPreferredSize(dim2);

		godPnl.add(godLbl);
		godPnl.add(godineStazaTxt);

		// Btni
		JPanel btnPnl = new JPanel();
		okBtn = new JButton("Potvrda");
		okBtn.setEnabled(false);

		JButton cancleBtn = new JButton("Odustani");

		btnPnl.add(okBtn);
		btnPnl.add(cancleBtn);

		// Txt field listeneri
		dodajFocusListener(adresaKancTxt);
		dodajFocusListener(adresaTxt);
		dodajFocusListener(brLicneTxt);
		dodajFocusListener(eMailTxt);
		dodajFocusListener(godineStazaTxt);
		dodajFocusListener(imeTxt);
		dodajFocusListener(prezimeTxt);
		dodajFocusListener(telTxt);
		dodajFocusListener(datumTxt);

		// Izmena ******
		int rowSelectedIndex = MyFrame.getTabelaProfesora().getSelectedRow();
		if (tipA == 'i' && rowSelectedIndex >= 0) {
			Profesor p = BazaProfesora.getInstance().getRow(rowSelectedIndex);

			imeTxt.setText(p.getIme());
			prezimeTxt.setText(p.getPrezime());
			datumTxt.setText(p.getDatumRodjenja().format(DateTimeFormatter.ofPattern("d.M.yyyy")));
			adresaTxt.setText(p.getAdresaStanovanja().toString());
			telTxt.setText(p.getKontaktTelefon());
			eMailTxt.setText(p.geteMailAdresa());
			adresaKancTxt.setText(p.getAdresaKancelarije().toString());
			brLicneTxt.setText(Integer.toString(p.getBrojLicneKarte()));
			trenutniBrojLicneKarte = p.getBrojLicneKarte();

			int zvanjeIndex = 0;

			if (p.getZvanje() == Zvanje.REDOVNI_PROFESOR)
				zvanjeIndex = 0;
			if (p.getZvanje() == Zvanje.VANREDNI_PROFESOR)
				zvanjeIndex = 1;
			if (p.getZvanje() == Zvanje.VANREDNI_PROFESOR)
				zvanjeIndex = 2;
			zvanjeCb.setSelectedIndex(zvanjeIndex);
			godineStazaTxt.setText(Integer.toString(p.getGodineStaza()));
		}

		// Btn action liseneri
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okBtn.setEnabled(proveraUpis(tipA));
				if (proveraUpis(tipA)) {

					String prezime = prezimeTxt.getText().trim();
					String ime = imeTxt.getText().trim();
					String kontaktTelefon = telTxt.getText();
					String eMailAdresa = eMailTxt.getText().trim();
					int brojLicneKarte = Integer.parseInt(brLicneTxt.getText());
					int godineStaza = Integer.parseInt(godineStazaTxt.getText());
					Zvanje zvanje = Zvanje.REDOVNI_PROFESOR;
					if (zvanjeCb.getSelectedIndex() == 0)
						zvanje = Zvanje.REDOVNI_PROFESOR;
					if (zvanjeCb.getSelectedIndex() == 1)
						zvanje = Zvanje.VANREDNI_PROFESOR;
					if (zvanjeCb.getSelectedIndex() == 2)
						zvanje = Zvanje.DOCENT;
					String[] deoAdr = adresaTxt.getText().split(",");
					Adresa adresaStanovanja = new Adresa(deoAdr[0].trim(), deoAdr[1].trim(), deoAdr[2].trim(),
							deoAdr[3].trim());
					String[] deoAdrKan = adresaKancTxt.getText().split(",");
					Adresa adresaKancelarije = new Adresa(deoAdrKan[0].trim(), deoAdrKan[1].trim(), deoAdrKan[2].trim(),
							deoAdrKan[3].trim());

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
					LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);

					if (tipA == 'u') {
						BazaProfesora.getInstance().dodajProfesor(prezime, ime, datumRodj, adresaStanovanja,
								kontaktTelefon, eMailAdresa, adresaKancelarije, brojLicneKarte, zvanje, godineStaza,
								null);
					} else if (tipA == 'i') {
						BazaProfesora.getInstance().izmeniProfesor(prezime, ime, datumRodj, adresaStanovanja,
								kontaktTelefon, eMailAdresa, adresaKancelarije, brojLicneKarte, zvanje, godineStaza,
								null, trenutniBrojLicneKarte);
					}

					MyFrame.getInstance().azurirajPrikazProfesora();
					dispose();
				} else {

				}

			}
		});

		cancleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		centerPanel.add(imePnl);
		centerPanel.add(przPnl);
		centerPanel.add(datPnl);
		centerPanel.add(adrPnl);
		centerPanel.add(brLicPnl);
		centerPanel.add(godPnl);
		centerPanel.add(mailPnl);
		centerPanel.add(adrKncPnl);
		centerPanel.add(telPnl);
		centerPanel.add(zvanjePnl);
		centerPanel.add(btnPnl);

		if (tipA == 'i') {
			proferosTabbed = new JTabbedPane();
			proferosTabbed.addTab("Informacije", centerPanel);
			JPanel panInfo = new JPanel();
			panInfo.setBackground(Color.green);
			proferosTabbed.addTab("Predmeti", panInfo);
			this.add(proferosTabbed);

		} else
			this.add(centerPanel);
	}

	private boolean proveraUpis(char tipA) {

		if (imeTxt.getText().isBlank()) {
			return false;
		}
		if (prezimeTxt.getText().isBlank()) {
			return false;
		}
		if (telTxt.getText().isBlank()) {
			return false;
		}
		if (!eMailTxt.getText().matches("[^ ]+[.][^ ]+@[^ ]+[.][^ ]+")) {
			return false;
		}
		if (!godineStazaTxt.getText().matches("[0-9]+")) {
			return false;
		}
		if (!datumTxt.getText().matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}")) {
			return false;
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
				LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);
				if (datumRodj.isAfter(LocalDate.now())) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		if (!brLicneTxt.getText().matches("[0-9]{9}")) {
			return false;
		}

		if (tipA == 'u' && existsByLicna(Integer.parseInt(brLicneTxt.getText()))) {
			return false;
		}

		if (tipA == 'i' && !(Integer.parseInt(brLicneTxt.getText()) == trenutniBrojLicneKarte)) {
			if (existsByLicna(Integer.parseInt(brLicneTxt.getText())))
				return false;
		}
		if (!adresaTxt.getText().matches(".+,[0-9]+[a-zA-Z]?,.+,.+")) {
			return false;
		}
		if (!adresaKancTxt.getText().matches(".+,[0-9]+,.+,.+")) {
			return false;
		}

		return true;
	}

	private void dodajFocusListener(JTextField txt) {
		txt.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				okBtn.setEnabled(proveraUpis(tipAk));

			}

			@Override
			public void focusLost(FocusEvent e) {
				okBtn.setEnabled(proveraUpis(tipAk));

			}

		});

		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tipAk));

			}

			@Override
			public void keyPressed(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tipAk));
			}

			@Override
			public void keyReleased(KeyEvent e) {
				okBtn.setEnabled(proveraUpis(tipAk));

			}

		});
	}

	private boolean existsByLicna(int licna) {
		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if (p.getBrojLicneKarte() == licna)
				return true;
		}
		return false;
	}

}