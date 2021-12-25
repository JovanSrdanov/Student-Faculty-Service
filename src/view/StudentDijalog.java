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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Adresa;
import model.BazaStudenata;
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

	public StudentDijalog(Frame owner, String title, boolean modal, char t) {
		super(owner, title, modal);
		setSize(600, 400);
		setLocationRelativeTo(owner);
		tip = t;

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
		JLabel datLbl = new JLabel("Datum rodjenja (DD/MM/GGGG):");
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
		JLabel brojIndexaLbl = new JLabel("Broj indexa (xx-yyy-zzzz) :");
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
		///////////////////////////////////////////////////////////////////////////////////////////////////
		int rowSelectedIndex = MyFrame.getTabelaStduenti().getSelectedRow();
		if (tip == 'i' && rowSelectedIndex >= 0) {
			Student s = BazaStudenata.getInstance().getRow(rowSelectedIndex);
			prezimeTxt.setText(s.getPrezime());
			imeTxt.setText(s.getIme());
			datumTxt.setText(s.getDatumRodjenja().format(DateTimeFormatter.ofPattern("d/M/yyyy")));

			adresaTxt.setText(s.getAdresaStanovanja().toString());

			telTxt.setText(Integer.toString(s.getKontaktTelefon()));
			eMailTxt.setText(s.geteMailAdresa());
			brojIndexaTxt.setText(s.getBrojIndexa());
			brojIndexaTxt.setEditable(false);
			godinaUpisaTxt.setText(Integer.toString(s.getGodinaUpisa()));
			godinaStudijaCB.setSelectedIndex(s.getTrenutnaGodinaStudija() - 1);
			int statusIndex = 0;
			if (s.getStatus() == Status.BUDŽET)
				statusIndex = 0;
			else
				statusIndex = 1;

			nacinFinansiranjaCB.setSelectedIndex(statusIndex);

		}

		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okBtn.setEnabled(proveraUpis(tip));
				if (proveraUpis(tip)) {
					String ime = imeTxt.getText();
					String prezime = prezimeTxt.getText();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
					LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);
					String[] deoAdr = adresaTxt.getText().split(",");
					Adresa adresaStanovanja = new Adresa(deoAdr[0], Integer.parseInt(deoAdr[1]), deoAdr[2], deoAdr[3]);
					int kontaktTelefon = Integer.parseInt(telTxt.getText());
					String eMailAdresa = eMailTxt.getText();
					String brIndexa = brojIndexaTxt.getText();
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
								kontaktTelefon, eMailAdresa, brIndexa, godinaUpisa, godinaStudija, s);

					}

					MyFrame.getInstance().azurirajPrikazProfesora(null, 1);
					dispose();
				}

			}
		});

		///////////////////////////////////////////////////////////////////////////////////////////////////

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

		this.add(centerPanel);

	}

	private boolean proveraUpis(char tipA) {
		if(tip=='u' && existsByIndex(brojIndexaTxt.getText()))
			return false;
		
		if(imeTxt.getText().isBlank()) {
			return false;
		}
		if(prezimeTxt.getText().isBlank()) {
			return false;
		}
		if(!telTxt.getText().matches("[0-9]+")) {
			return false;
		}
		if(!eMailTxt.getText().matches(".+@.+[.].+")) {
			return false;
		}
		if(!adresaTxt.getText().matches(".+,[0-9]+,.+,.+")) {
			return false;
		}
		if(!datumTxt.getText().matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}")) {
			return false;
		}
		else {
			try{    
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
				LocalDate datumRodj = LocalDate.parse(datumTxt.getText(), formatter);
				if(datumRodj.isAfter(LocalDate.now())) {
					return false;
				}
				}catch(Exception e){
					return false;
				}   
		}
		if(!brojIndexaTxt.getText().matches("[a-z]{2}-[1-9][0-9]{0,3}-[1-9][0-9]{3}")) {
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

}
